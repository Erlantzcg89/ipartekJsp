package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;

public class CategoriaDAO implements ICategoriaDAO {

	private final static Logger LOG = Logger.getLogger(CategoriaDAO.class);

	private static CategoriaDAO INSTANCE;

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Categoria> getAll() {
		LOG.trace("recuperar todas las categorias");
		List<Categoria> registros = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_getall() }");) {

			LOG.debug(cs);

			try (ResultSet rs = cs.executeQuery()) {
				// TODO mapper para vosotros
				while (rs.next()) {
					Categoria c = new Categoria();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					registros.add(c);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return registros;
	}

	@Override
	public Categoria getById(int id) {
		LOG.trace("recuperar 1 categoria por id");
		Categoria registro = new Categoria();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_getbyid(?) }");) {
			
			// parametro de entrada
						cs.setInt(1, id);
						
						LOG.debug(cs);
						

			try (ResultSet rs = cs.executeQuery()) {
				// TODO mapper para vosotros
				while (rs.next()) {

					registro.setId(rs.getInt("id"));
					registro.setNombre(rs.getString("nombre"));
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return registro;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		LOG.trace("borrar 1 categoria por id");
		Categoria registro = new Categoria();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_delete(?) }");) {
			
			// parametro de entrada
						cs.setInt(1, id);
						
						LOG.debug(cs);
						

			try (ResultSet rs = cs.executeQuery()) {
				// TODO mapper para vosotros
				while (rs.next()) {

					registro.setId(rs.getInt("id"));
					registro.setNombre(rs.getString("nombre"));
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return registro;
	}

	@Override
	public Categoria update(int id, Categoria pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria create(Categoria pojo) throws Exception {
		LOG.trace("insertar nueva categoria " + pojo);
		Categoria registro = pojo;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_insert(?,?) }");) {

			// parametro de entrada
			cs.setString(1, pojo.getNombre());
			
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			
			LOG.debug(cs);
			
			//ejecutamos el procedimiento almacenado
			cs.executeUpdate();
			
			pojo.setId(cs.getInt(2));


		} catch (Exception e) {
			LOG.error(e);
		}
		
		return registro;
	}

}
