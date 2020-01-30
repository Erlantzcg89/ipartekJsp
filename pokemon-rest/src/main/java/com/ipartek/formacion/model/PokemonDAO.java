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

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' from pokemons p, habilidades h, pokemons_habilidades ph WHERE ph.id_pokemon=p.id AND ph.id_habilidad=h.id order by p.id desc limit 500;";
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

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' from pokemons p, habilidades h, pokemons_habilidades ph WHERE ph.id_pokemon=p.id AND ph.id_habilidad=h.id AND p.nombre LIKE CONCAT('%', ?, '%') order by p.id desc limit 500;";
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

		String sql = "SELECT p.id AS 'id_pokemon', p.nombre AS 'nombre_pokemon', h.id AS 'id_habilidad', h.nombre AS 'nombre_habilidad' from pokemons p, habilidades h, pokemons_habilidades ph WHERE ph.id_pokemon=p.id AND ph.id_habilidad=h.id and p.id= ? order by p.id desc limit 500;";
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

		LOG.debug("Entra en deleteFinal");

		String sql = "DELETE FROM pokemons WHERE id = ?;";
		Pokemon resultado = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, id);

			Pokemon productoBorrar = getById(id);

			LOG.debug("Ejecuta la query: " + pst.toString());

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = productoBorrar;
			} else {
				LOG.error("Delete incorrecto, ha afectado a mas de un producto");
			}

		} catch (Exception e) {
			LOG.error(e);
			throw e;
		}

		return resultado;

	}

	@Override
	public Pokemon update(int id, Pokemon pojo) throws Exception {

		LOG.debug("Entra en update");

		// TODO query
		String sql = "UPDATE pokemons SET nombre= ?, imagen=?, precio=?, descuento=?, descripcion=?, fecha_modificacion=CURRENT_TIMESTAMP(), id_usuario=?, id_categoria=?, validado=? WHERE id = ?;";
		Pokemon resultado = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
//			pst.setString(2, pojo.ge());
//			pst.setFloat(3, pojo.getPrecio());
//			pst.setInt(4, pojo.getDescuento());
//			pst.setString(5, pojo.getDescripcion());
//			pst.setInt(6, pojo.getUsuario().getId());
//			pst.setInt(7, pojo.getCategoria().getId());
//			pst.setInt(8, pojo.getValidado());
//			pst.setInt(9, id);

			LOG.debug(pst);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			} else {
				LOG.fatal("El update esta mal, ha afectado a mas de un producto");
			}
		}
		return resultado;

	}

	@Override
	public Pokemon create(Pokemon pojo) throws Exception {

		LOG.debug("Entra en create");

		// TODO query
		String sql = "INSERT INTO producto (id, nombre, imagen, precio, descuento, descripcion, fecha_creacion, id_usuario, id_categoria) VALUES ( ? , ?, ?, ?, ?, ?, CURRENT_TIMESTAMP(), ?,?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setInt(1, pojo.getId());
			pst.setString(2, pojo.getNombre());
//			pst.setString(3, pojo.getImagen());
//			pst.setFloat(4, pojo.getPrecio());
//			pst.setInt(5, pojo.getDescuento());
//			pst.setString(6, pojo.getDescripcion());
//			pst.setInt(7, pojo.getUsuario().getId());
//			pst.setInt(8, pojo.getCategoria().getId());

			LOG.debug("Ejecuta la query: " + pst.toString());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}
			}

		}

		return pojo;

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
