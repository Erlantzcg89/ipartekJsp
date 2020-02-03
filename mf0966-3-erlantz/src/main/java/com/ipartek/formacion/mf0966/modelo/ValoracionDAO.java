package com.ipartek.formacion.mf0966.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.mf0966.modelo.pojo.Curso;
import com.ipartek.formacion.mf0966.modelo.pojo.Valoracion;

public class ValoracionDAO implements IDAO<Valoracion> {

	private final static Logger LOG = LogManager.getLogger(ValoracionDAO.class);
	private static ValoracionDAO INSTANCE;

	private ValoracionDAO() {
		super();
	}

	public static ValoracionDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ValoracionDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Valoracion> getAll() {

		LOG.debug("Entra en getAll");

		ArrayList<Valoracion> resultado = new ArrayList<Valoracion>();

		String sql = "SELECT v.id 'id_valoracion', v.comentario 'comentario', v.nota 'nota', v.id_usuario 'id_usuario', v.id_curso 'id_curso' FROM valoraciones v ORDER BY v.id asc LIMIT 500;";

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
	public Valoracion getById(int id) {

		LOG.debug("Entra en getbyId");

		String sql = "SELECT v.id 'id_valoracion', v.comentario 'comentario', v.nota 'nota', v.id_usuario 'id_usuario', v.id_curso 'id_curso' FROM valoraciones v WHERE v.id = ? ORDER BY v.id asc LIMIT 500;";
		Valoracion resultado = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					resultado = mapper(rs);

				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return resultado;
	}

	@Override
	public Valoracion delete(int id) throws Exception {
		
		String sql = "DELETE FROM valoraciones WHERE id = ?;";
		
		Valoracion resul = getById(id);

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();

			if(affectedRows == 1) {
				LOG.info("Valoracion borrado");
			} else {
				LOG.info("pon un where en el delete");
				resul = null;
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	@Override
	public Valoracion update(int id, Valoracion pojo) throws Exception {

		String sql = "update valoraciones set nota = ?, comentario = ?, id_usuario = ?, id_curso = ? where id = ?;";
		
		Valoracion resul = null;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS )
				){
			pst.setInt(1, pojo.getNota());
			pst.setString(2, pojo.getComentario());
			pst.setInt(3, pojo.getIdUsuario());
			pst.setInt(4, pojo.getIdCurso());
			
			int affectedRows = pst.executeUpdate();
			if(affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();

				resul = pojo;
				rs.next();
				resul.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		
		return resul;

	}

	@Override
	public Valoracion create(Valoracion pojo) throws Exception {
		
		String sql = "INSERT INTO valoraciones(nota, comentario, id_usuario, id_curso) VALUES (?, ?, ?, ?);";
		
		Valoracion resul = null;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS )
				){
			pst.setInt(1, pojo.getNota());
			pst.setString(2, pojo.getComentario());
			pst.setInt(3, pojo.getIdUsuario());
			pst.setInt(4, pojo.getIdCurso());
			
			int affectedRows = pst.executeUpdate();
			if(affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();

				resul = pojo;
				rs.next();
				resul.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		
		return resul;
	}

	/**
	 * Utilidad para mapear un ResultSet a un Curso
	 *
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Valoracion mapper(ResultSet rs) throws SQLException {

		Valoracion v = new Valoracion();
		v.setId(rs.getInt("id_valoracion"));
		v.setComentario(rs.getString("comentario"));
		v.setNota(rs.getInt("nota"));
		v.setIdUsuario(rs.getInt("id_usuario"));
		v.setIdCurso(rs.getInt("id_curso"));

		return v;
	}

}
