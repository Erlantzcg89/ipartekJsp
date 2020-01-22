package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
//import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private final static Logger LOG = LogManager.getLogger(UsuarioDAO.class);
	
	private static UsuarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = " SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.contrasenia, u.email, u.imagen, u.fecha_creacion, u.fecha_eliminacion, u.id_rol, r.id AS 'id_rol', r.nombre  AS 'nombre_rol'" + 
												" FROM usuario AS u, rol AS r" + 
												" WHERE u.id_rol = r.id AND u.fecha_eliminacion IS NULL;";
	private static final String SQL_GET_ALL_BY_USER = " SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.contrasenia, u.email, u.imagen, u.fecha_creacion, u.fecha_eliminacion, u.id_rol, r.id AS 'id_rol', r.nombre  AS 'nombre_rol'" + 
													" FROM usuario AS u, rol AS r" + 
													" WHERE u.id_rol = r.id AND u.fecha_eliminacion IS NULL AND u.id = ?;";
	private static final String SQL_GET_BY_ID = " SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.contrasenia, u.email, u.imagen, u.fecha_creacion, u.fecha_eliminacion, u.id_rol, r.id AS 'id_rol', r.nombre  AS 'nombre_rol'" + 
													" FROM usuario AS u, rol AS r" + 
													" WHERE u.id_rol = r.id AND u.id = ? AND u.fecha_eliminacion IS NULL;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT id, nombre, contrasenia, email, imagen, fecha_creacion, fecha_eliminacion FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";
	private static final String SQL_EXISTE = " SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.contrasenia, u.email, u.imagen, u.fecha_creacion, u.fecha_eliminacion, u.id_rol, r.id AS 'id_rol', r.nombre  AS 'nombre_rol'" + 
												" FROM usuario AS u, rol AS r" + 
												" WHERE u.id_rol = r.id AND u.nombre = ? AND u.contrasenia = ? AND u.fecha_eliminacion IS NULL;";
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, contrasenia, email, imagen, fecha_creacion,id_rol) VALUES ( ? , ?, ?, ?, CURRENT_TIMESTAMP(),?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasenia= ?, imagen=?, email=?, fecha_modificacion = CURRENT_TIMESTAMP() WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private static final String SQL_DELETE_LOGICO = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;

	}
	
	private Usuario mapper(ResultSet rs) throws SQLException {

		Usuario resultado = new Usuario();
		resultado.setId(rs.getInt("id_usuario"));
		resultado.setNombre(rs.getString("nombre_usuario"));
		resultado.setContrasenia(rs.getString("contrasenia"));
		resultado.setEmail(rs.getString("email"));
		resultado.setImagen(rs.getString("imagen"));
		resultado.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		resultado.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
		resultado.setRol(new Rol(rs.getInt("id_rol"),rs.getString("nombre_rol")));

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
	
	@Override
	public Usuario exist(String nombre, String contrasenia) {
		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenia);
			LOG.debug(pst);

			// ejecutar sentencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					usuario = mapper(rs);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	public ArrayList<Usuario> getAllByUser(int id) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_USER)){
			
				pst.setInt(1, id);
				
				ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

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

	public ArrayList<Usuario> getAllByNombre(String nombre) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_NOMBRE);) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					lista.add(mapper(rs));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Usuario getById(int id) {
		Usuario resul = new Usuario();

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
	public Usuario delete(int id) {
		Usuario resultado = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_LOGICO);) {

			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}
	
	public Usuario deleteFinal(int id) {
		Usuario resultado = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			Usuario usuarioBorrar = getById(id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = usuarioBorrar;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Usuario update(int id, Usuario pojo) throws Exception {
		Usuario resultado = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {
			
			pojo = sanitizar(pojo);

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setString(3, pojo.getImagen());
			pst.setString(4, pojo.getEmail());
			pst.setInt(5, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			}
		}
		return resultado;
	}

	@Override
	public Usuario create(Usuario pojo) throws Exception {
		try (Connection con = ConnectionManager.getConnection();
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

		}

		return pojo;
	}

	private Usuario sanitizar(Usuario pojo) {
		Usuario resultado = pojo;

		resultado.setNombre(Jsoup.clean(pojo.getNombre(), Whitelist.none()));
		resultado.setEmail(Jsoup.clean(pojo.getEmail(), Whitelist.none()));
		resultado.setImagen(Jsoup.clean(pojo.getImagen(), Whitelist.none()));

		return resultado;
	}
	
}