package com.ipartek.formacion.mf0966.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.mf0966.modelo.pojo.Curso;

public class CursoDAO implements IDAO<Curso>{

	private final static Logger LOG = LogManager.getLogger(CursoDAO.class);
	private static CursoDAO INSTANCE;

	private CursoDAO() {
		super();
	}

	public static CursoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursoDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Curso> getAll() {

		LOG.debug("Entra en getAll");
		
		ArrayList<Curso> resultado = new ArrayList<Curso>();

		String sql = "SELECT c.id 'id_curso', c.nombre 'nombre_curso' FROM curso c ORDER BY c.id asc LIMIT 500;";

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

	@Override
	public Curso getById(int id) {
		
		LOG.debug("Entra en getbyId");
		
		String sql = "SELECT c.id 'id_curso', c.nombre 'nombre_curso' FROM curso c WHERE c.id = ? ORDER BY c.id asc LIMIT 500;";
		Curso resultado = null;
		
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
	public Curso delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(int id, Curso pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso create(Curso pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Utilidad para mapear un ResultSet a un Curso
	 *
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Curso mapper(ResultSet rs) throws SQLException {

		Curso c = new Curso();
		c.setId(rs.getInt("id_curso"));
		c.setNombre(rs.getString("nombre_curso"));

		return c;
	}
	
}
