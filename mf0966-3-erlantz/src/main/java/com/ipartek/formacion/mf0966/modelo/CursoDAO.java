package com.ipartek.formacion.mf0966.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ipartek.formacion.mf0966.modelo.pojo.Curso;
import com.ipartek.formacion.mf0966.modelo.pojo.Valoracion;

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

		String sql = "SELECT c.id 'id_curso', c.nombre 'nombre_curso', c.finicio 'inicio', c.ffin 'fin', c.horas 'horas', c.id_profesor 'profesor', v.id 'id_valoracion', v.comentario 'comentario', v.nota 'nota', v.id_usuario 'id_usuario', v.id_curso 'curso' FROM curso c, valoraciones v where v.id_curso=c.id ORDER BY c.id asc LIMIT 500;";

		HashMap<Integer, Curso> mapCursos = new HashMap<Integer, Curso>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			LOG.trace(pst);

			while (rs.next()) {

				if (!mapCursos.containsKey(rs.getInt("id_curso"))) {

					mapCursos.put(rs.getInt("id_curso"), mapper(rs));

				} else {

					mapCursos.get(rs.getInt("id_curso")).getValoraciones().add(mapperValoracion(rs));

				}

			}

		} catch (Exception e) {
			LOG.error(e);
		}

		Collection<Curso> coleccionCursos = mapCursos.values();

		ArrayList<Curso> resultado = new ArrayList<Curso>(coleccionCursos);

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
		c.setHoras(rs.getInt("horas"));
		c.setIdProfesor(rs.getInt("profesor"));
		c.setFinicio(rs.getString("inicio"));
		c.setFfin(rs.getString("fin"));

		return c;
	}
	
	/**
	 * Utilidad para mapear una Valoracion
	 *
	 * @param rs ResulSet
	 * @return Habilidad
	 * @throws SQLException
	 */
	private Valoracion mapperValoracion(ResultSet rs) throws SQLException {

		Valoracion v = new Valoracion();
		v.setId(rs.getInt("id_valoracion"));
		v.setComentario(rs.getString("comentario"));
		v.setNota(rs.getInt("nota"));
		v.setIdUsuario(rs.getInt("id_usuario"));
		v.setIdCurso(rs.getInt("curso"));

		return v;
	}
	
}
