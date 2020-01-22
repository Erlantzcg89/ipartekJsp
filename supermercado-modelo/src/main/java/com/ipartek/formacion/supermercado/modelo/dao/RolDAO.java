package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Rol;

public class RolDAO implements IDAO<Rol>{

	private final static Logger LOG = LogManager.getLogger(RolDAO.class);

	private static RolDAO INSTANCE = null;

	private static final String SQL_GET_ALL = " SELECT r.id AS 'id_rol', r.nombre  AS 'nombre_rol'"
												+ " FROM rol AS r";	
	private static final String SQL_GET_BY_ID = " SELECT r.id AS 'id_rol', r.nombre  AS 'nombre_rol'"
												+ " FROM rol AS r" 
												+ " WHERE r.id = ?;";

	/*
	 * private static final String SQL_INSERT =
	 * "INSERT INTO usuario (nombre, contrasenia, email, imagen, fecha_creacion,id_rol) VALUES ( ? , ?, ?, ?, CURRENT_TIMESTAMP(),?);"
	 * ; private static final String SQL_UPDATE =
	 * "UPDATE usuario SET nombre= ?, contrasenia= ?, imagen=?, email=? WHERE id = ?;"
	 * ; private static final String SQL_DELETE =
	 * "DELETE FROM usuario WHERE id = ?;"; private static final String
	 * SQL_DELETE_LOGICO =
	 * "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?;";
	 */
	
	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

		return INSTANCE;

	}

	private Rol mapper(ResultSet rs) throws SQLException {

		Rol resultado = new Rol();
		resultado.setId(rs.getInt("id_rol"));
		resultado.setNombre(rs.getString("nombre_rol"));

		return resultado;
	}

	/**
	 * Compruab si existe el usuario en la base datos, lo busca por su nombre y
	 * conetrseña
	 * 
	 * @param nombre
	 * @param contrasenia
	 * @return Usuario con datos si existe, null en caso de no existir
	 */

	public ArrayList<Rol> getAll() {

		ArrayList<Rol> lista = new ArrayList<Rol>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Rol getById(int id) {
		Rol resul = new Rol();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					resul = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Rol delete(int id) {
		Rol resultado = null;

		/*try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_LOGICO);) {

			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			}

		} catch (Exception e) {
			LOG.error(e);
		}*/

		return resultado;
	}

	public Rol deleteFinal(int id) {
		Rol resultado = null;

		/*try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			Rol usuarioBorrar = getById(id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = usuarioBorrar;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/

		return resultado;
	}

	@Override
	public Rol update(int id, Rol pojo) throws Exception {
		Rol resultado = null;
		/*try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pojo = sanitizar(pojo);

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setString(3, pojo.getEmail());
			pst.setString(4, pojo.getImagen());
			pst.setInt(5, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			}
		}*/
		return resultado;
	}

	@Override
	public Rol create(Rol pojo) throws Exception {
		/*try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pojo = sanitizar(pojo);

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setString(3, pojo.getEmail());
			pst.setString(4, pojo.getImagen());
			pst.setInt(5, pojo.getRol().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}*/

		return pojo;
	}

}