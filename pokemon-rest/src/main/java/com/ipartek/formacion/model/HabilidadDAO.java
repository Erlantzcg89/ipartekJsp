package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.model.pojo.Habilidad;

public class HabilidadDAO implements IDAO<Habilidad> {
	
	private final static Logger LOG = LogManager.getLogger(HabilidadDAO.class);
	private static HabilidadDAO INSTANCE;

	String filtroNombre = "AND p.nombre LIKE CONCAT('%', ?, '%')";

	private HabilidadDAO() {
		super();
	}

	public static HabilidadDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new HabilidadDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Habilidad> getAll() {

		LOG.debug("Entra en getAll");

		String sql = "SELECT id, nombre FROM habilidades ORDER BY id ASC LIMIT 500;";
		ArrayList<Habilidad> resultado = new ArrayList<Habilidad>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			LOG.trace(pst);

			while (rs.next()) {
					
					resultado.add(mapperHabilidad(rs));

			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}
	
	public List<Habilidad> getAllNombre(String nombre) {

		LOG.debug("Entra en getAllNombre");

		String sql = "";
		ArrayList<Habilidad> resultado = new ArrayList<Habilidad>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, nombre);

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					resultado.add(mapperHabilidad(rs));

				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Habilidad getById(int id) {

		LOG.debug("Entra en getbyId");

		String sql = "";

		Habilidad resul = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

						resul = mapperHabilidad(rs);

				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;

	}

	@Override
	public Habilidad delete(int id) throws Exception {
		
		LOG.debug("Entra en delete");

		String sql= "DELETE FROM habilidades WHERE id = ?;";
		
		Habilidad resultado = getById(id);

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
	public Habilidad update(int id, Habilidad pojo) throws Exception {
		
		LOG.debug("Entra en update");

		String sql = "UPDATE habilidades SET nombre = ? WHERE id = ?";
		
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
	

	@Override
	public Habilidad create(Habilidad pojo) throws Exception {
		
		LOG.debug("Entra en create");

		String sql = "INSERT INTO habilidades (nombre) VALUES (?);";
		
		Habilidad resultado = null;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS )
				){
			
			pst.setString(1, pojo.getNombre());
			
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();

				resultado = pojo;
				rs.next();
				resultado.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		
		return resultado;
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
		h.setId(rs.getInt("id"));
		h.setNombre(rs.getString("nombre"));

		return h;
	}

}
