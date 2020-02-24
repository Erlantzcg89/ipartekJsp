package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO implements IDAO<Usuario>{
	
	private final static Logger LOG = LogManager.getLogger(UsuarioDAO.class);
	
	public Usuario getLogin(Usuario usuario){
		
		String sql = "Select id, nombre, password from usuarios where nombre=? and password=?;";
		
		Usuario resul = null;
		
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());

			LOG.trace(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

						resul = mapperUsuario(rs);

				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}// 

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	public Usuario update(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario create(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Usuario mapperUsuario(ResultSet rs) throws SQLException {

		Usuario u = new Usuario();

		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setPassword(rs.getString("password"));

		return u;
	}// mapperUsuario

}
