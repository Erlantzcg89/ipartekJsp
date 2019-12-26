package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.db.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Producto;
import com.ipartek.formacion.modelo.pojos.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private final static Logger LOG = Logger.getLogger(UsuarioDAO.class);

	private static UsuarioDAO INSTANCE;

	private static final String SQL_GET_ALL = "SELECT id, nombre, contrasenia FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID ="SELECT id, nombre FROM usuario WHERE id = ? ;"; 
	private static final String SQL_GET_INSERT ="INSERT INTO usuario ( nombre) VALUES ( ? );";
	private static final String SQL_GET_UPDATE ="UPDATE usuario SET nombre = ? WHERE id = ? ;";
	private static final String SQL_DELETE ="DELETE FROM usuario WHERE id = ? ;";
	private static final String SQL_EXIST = "SELECT id, nombre, contrasenia FROM usuario WHERE nombre = ? AND contrasenia = ? ;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Usuario> getAll() {		
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				
				LOG.debug(pst);
				
				Usuario u = new Usuario();
				u.setId( rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setContrasenia(rs.getString("contrasenia"));
				lista.add(u);

			}

		} catch (SQLException e) {
			LOG.error(e);
		}

		return lista;
	}

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(int id, Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario create(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario exist(String nombre, String contrasenia) {
		Usuario resul = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXIST);) {

			// sustituyo los parametros preparados
			pst.setString(1, nombre);
			pst.setString(2, contrasenia);
			LOG.debug(pst);

			// ejecuto la consulta
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					// mapear del rs al pojo
					resul = new Usuario();
					resul.setId(rs.getInt("id"));
					resul.setNombre(rs.getString("nombre"));
					resul.setContrasenia(rs.getString("contrasenia"));
				}
			}

		} catch (SQLException e) {
			LOG.error(e);
		}

		return resul;
	}

}
