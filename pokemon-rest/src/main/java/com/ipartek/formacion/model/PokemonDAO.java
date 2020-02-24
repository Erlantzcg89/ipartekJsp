package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.model.pojo.Habilidad;
import com.ipartek.formacion.model.pojo.Pokemon;

public class PokemonDAO implements IDAO<Pokemon> {

	private final static Logger LOG = LogManager.getLogger(PokemonDAO.class);
	private static PokemonDAO INSTANCE;

	String filtroNombre = "AND p.nombre LIKE CONCAT('%', ?, '%')";

	private PokemonDAO() {
		super();
	}

	public static PokemonDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PokemonDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Pokemon> getAll() {

		LOG.debug("Entra en getAll");

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' FROM (pokemons_habilidades ph INNER JOIN habilidades h ON ph.id_habilidad=h.id) RIGHT JOIN pokemons p ON ph.id_pokemon=p.id order by p.id desc limit 500;";
		HashMap<Integer, Pokemon> mapPokemons = new HashMap<Integer, Pokemon>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			LOG.trace(pst);

			while (rs.next()) {

				if (!mapPokemons.containsKey(rs.getInt("id_pokemon"))) {

					mapPokemons.put(rs.getInt("id_pokemon"), mapperPokemon(rs));

				} else {

					mapPokemons.get(rs.getInt("id_pokemon")).getHabilidades().add(mapperHabilidad(rs));

				}

			}

		} catch (Exception e) {
			LOG.error(e);
		}

		Collection<Pokemon> coleccionPokemons = mapPokemons.values();

		ArrayList<Pokemon> resultado = new ArrayList<Pokemon>(coleccionPokemons);

		return resultado;
	}

	public List<Pokemon> getAllNombre(String nombre) {

		LOG.debug("Entra en getAllNombre");

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' FROM (pokemons_habilidades ph INNER JOIN habilidades h ON ph.id_habilidad=h.id) RIGHT JOIN pokemons p ON ph.id_pokemon=p.id where p.nombre LIKE CONCAT('%', ?, '%') order by p.id desc limit 500;";
		HashMap<Integer, Pokemon> mapPokemons = new HashMap<Integer, Pokemon>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, nombre);

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					if (!mapPokemons.containsKey(rs.getInt("id_pokemon"))) {

						mapPokemons.put(rs.getInt("id_pokemon"), mapperPokemon(rs));

					} else {

						mapPokemons.get(rs.getInt("id_pokemon")).getHabilidades().add(mapperHabilidad(rs));

					}

				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		Collection<Pokemon> coleccionPokemons = mapPokemons.values();

		ArrayList<Pokemon> resultado = new ArrayList<Pokemon>(coleccionPokemons);

		return resultado;
	}

	@Override
	public Pokemon getById(int id) {

		LOG.debug("Entra en getbyId");

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' FROM (pokemons_habilidades ph INNER JOIN habilidades h ON ph.id_habilidad=h.id) RIGHT JOIN pokemons p ON ph.id_pokemon=p.id where p.id= ? order by p.id desc limit 500;";
		;
		Pokemon resul = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					if (resul == null) {

						resul = mapperPokemon(rs);

					} else {

						resul.getHabilidades().add(mapperHabilidad(rs));

					}

				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;

	}

	@Override
	public Pokemon delete(int id) throws Exception {
		
		LOG.debug("Entra en delete");

		String sql= "DELETE FROM pokemons WHERE id = ?;";
		
		Pokemon resultado = getById(id);

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();

			if(affectedRows == 1) {
				LOG.info("Elemento borrado");
			} else {
				LOG.error("Error, se han borrado más de un elemnto");
				resultado = null;
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resultado;
	}

	@Override
	public Pokemon update(int id, Pokemon pojo) throws Exception {
		
		LOG.debug("Entra en update");

		String sql = "UPDATE pokemons SET nombre = ? WHERE id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, id);
			
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				LOG.trace("Update realizado");
			} else {
				LOG.error("Error se han actualizado más de una fila");
			}
		} catch (Exception e) {
			LOG.error(e);
			throw e;
		}
		
		return pojo;

	}
	
	// update atómico
	

	@Override
	public Pokemon create(Pokemon pojo) throws Exception {
		
		LOG.debug("Entra en create");

		String sqlPokemon = "INSERT INTO pokemons (nombre) VALUES (?);";
		String sqlHabilidad = "INSERT INTO pokemons_habilidades (id_pokemon, id_habilidad) VALUES (?,?);";
		
	    Pokemon resul = null;
	    Connection con = null;
	    try{
	        con = ConnectionManager.getConnection();
	        con.setAutoCommit(false);
	        PreparedStatement pstPokemon = con.prepareStatement(sqlPokemon, Statement.RETURN_GENERATED_KEYS );
	        
	        pstPokemon.setString(1, pojo.getNombre());
	        
			LOG.trace(pstPokemon);
	        
	        int affectedRows = pstPokemon.executeUpdate();
	        if(affectedRows == 1) {
	            ResultSet rs = pstPokemon.getGeneratedKeys();

	            resul = pojo;
	            rs.next();
	            // id generada
	            resul.setId(rs.getInt(1));
	            
	        	ArrayList<Habilidad> habilidades = (ArrayList<Habilidad>) pojo.getHabilidades();
	        	for(Habilidad h : habilidades){
	        
	        		PreparedStatement pstHabilidad = con.prepareStatement(sqlHabilidad);
	        		
	        		pstHabilidad.setInt(1, resul.getId());
	        		pstHabilidad.setInt(2, h.getId());
	        		
	    			LOG.trace(pstHabilidad);
	        		
	        		pstHabilidad.executeUpdate();
	        
	        	}
	            
	            con.commit();
	        }
	    } catch (Exception e) {
	        con.rollback();
	        throw e;
	    } finally {
	        if(con != null) {
	            con.close();
	        }
	    }
	    return resul;
	}

	/**
	 * Utilidad para mapear un Pokemon
	 *
	 * @param rs ResulSet
	 * @return Pokemon
	 * @throws SQLException
	 */
	private Pokemon mapperPokemon(ResultSet rs) throws SQLException {

		Pokemon p = new Pokemon();

		p.setId(rs.getInt("id_pokemon"));
		p.setNombre(rs.getString("nombre_pokemon"));
		p.getHabilidades().add(mapperHabilidad(rs));

		return p;
	}

	/**
	 * Utilidad para mapear una Habilidad
	 *
	 * @param rs ResulSet
	 * @return Habilidad
	 * @throws SQLException
	 */
	private Habilidad mapperHabilidad(ResultSet rs) throws SQLException {

		Habilidad h = new Habilidad();
		h.setId(rs.getInt("id_habilidad"));
		h.setNombre(rs.getString("nombre_habilidad"));

		return h;
	}

}
