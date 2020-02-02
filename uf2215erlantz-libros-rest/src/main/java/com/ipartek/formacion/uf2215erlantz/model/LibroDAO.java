package com.ipartek.formacion.uf2215erlantz.model;

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

import com.ipartek.formacion.uf2215erlantz.model.pojo.Autor;
import com.ipartek.formacion.uf2215erlantz.model.pojo.Libro;

public class LibroDAO implements IDAO<Libro>{
	
	private final static Logger LOG = LogManager.getLogger(LibroDAO.class);
	private static LibroDAO INSTANCE;

	private LibroDAO() {
		super();
	}

	public static LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {

		LOG.debug("Entra en getAll");
		
		ArrayList<Libro> resultado = new ArrayList<Libro>();

		String sql = "SELECT l.id 'id_libro', l.nombre 'nombre_libro', a.id 'id_autor', a.nombre 'nombre_autor' FROM libros l, autores a WHERE l.id_autor=a.id order by l.id desc limit 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			LOG.trace(pst);

			while (rs.next()) {

				resultado.add(mapper(rs));

			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	public List<Libro> getAllNombre(String nombre) {

		LOG.debug("Entra en getAllNombre");

		ArrayList<Libro> resultado = new ArrayList<Libro>();
		
		String sql = "SELECT l.id 'id_libro', l.nombre 'nombre_libro', a.id 'id_autor', a.nombre 'nombre_autor' FROM libros l, autores a WHERE l.id_autor=a.id AND l.nombre LIKE CONCAT('%', ?, '%') order by l.id desc limit 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, nombre);

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					
					resultado.add(mapper(rs));

				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Libro getById(int id) {
		
		LOG.debug("Entra en getbyId");
		
		String sql = "SELECT l.id 'id_libro', l.nombre 'nombre_libro', a.id 'id_autor', a.nombre 'nombre_autor' FROM libros l, autores a WHERE l.id_autor=a.id AND l.id= ? order by l.id desc limit 500;";
		Libro resultado = null;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				) {
			
			pst.setInt(1, id);
			
			try(ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					
					resultado = mapper(rs);

				}
			}

		}catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Libro delete(int id) throws Exception {
		
		LOG.debug("Entra en delete");

		String sql= "DELETE FROM libros WHERE id = ?;";
		
		Libro resultado = getById(id);

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();

			if(affectedRows == 1) {
				LOG.info("Libro borrado");
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
	public Libro update(int id, Libro pojo) throws Exception {
		
		LOG.debug("Entra en update");

		String sql = "UPDATE libros SET nombre = ? WHERE id = ?";
		
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
	public Libro create(Libro pojo) throws Exception {
		
		LOG.debug("Entra en create");

		String sql = "INSERT INTO libros (nombre) VALUES (?);";
		
		Libro resultado = null;
		
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
	 * Utilidad para mapear un ResultSet a un Libro
	 *
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Libro mapper(ResultSet rs) throws SQLException {

		Libro l = new Libro();
		l.setId(rs.getInt("id_libro"));
		l.setNombre(rs.getString("nombre_libro"));

		Autor a = new Autor();
		a.setId(rs.getInt("id_autor"));
		a.setNombre(rs.getString("nombre_autor"));
		
		l.setAutor(a);

		return l;
	}

}
