package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;

public class CategoriaDAO implements ICategoriaDAO {

	private final static Logger LOG = LogManager.getLogger(CategoriaDAO.class);

	private static CategoriaDAO INSTANCE;

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {
		LOG.debug("Entra en getInstance");

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
			LOG.debug("Crea una nueva Instancia");
		}

		return INSTANCE;
	}

	private Categoria mapper(ResultSet rs) throws SQLException {
		LOG.debug("Entra en el mapper");

		Categoria c = new Categoria();

		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		c.setImagen(rs.getString("imagen"));

		c = sanitizar(c);

		LOG.debug("Devuelve la categoria mapeada: " + c.toString());

		return c;
	}

	private Categoria sanitizar(Categoria pojo) {
		LOG.debug("Entra en sanitizar");

		Categoria resultado = pojo;

		resultado.setNombre(Jsoup.clean(pojo.getNombre(), Whitelist.none()));
		resultado.setImagen(Jsoup.clean(pojo.getImagen(), Whitelist.none()));

		return resultado;
	}

	@Override
	public List<Categoria> getAll() {
		LOG.trace("recuperar todas las categorias");
		List<Categoria> resultado = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall( " { CALL pa_categoria_get_all() } ")) {

			LOG.debug("Ejecuta la query: " + cs.toString());

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					Categoria c = mapper(rs);
					resultado.add(c);
				}

			}

		} catch (SQLException e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Categoria getById(int id) {
		LOG.trace("Recuperar una categoria por su id: " + id);
		Categoria resultado = new Categoria();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{CALL pa_categoria_get_byid(?)}")) {
			cs.setInt(1, id);

			LOG.debug("Ejecuta la query: " + cs.toString());

			try (ResultSet rs = cs.executeQuery()) {
				if (rs.next()) {
					resultado = mapper(rs);
				}
			}
		} catch (SQLException e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		LOG.debug("Entra en delete");

		Categoria resultado = null;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{CALL pa_categoria_delete(?)}")) {

			cs.setInt(1, id);

			Categoria categoriaBorrar = getById(id);

			LOG.debug("Ejecuta la query: " + cs.toString());

			int affetedRows = cs.executeUpdate();
			if (affetedRows == 1) {
				resultado = categoriaBorrar;
			} else if(affetedRows == 0){
				LOG.fatal("El delete esta mal, no ha eliminado ninguna categoria");
			}else {
				LOG.fatal("El delete esta mal, ha eliminado mas de una categoria");
			}

		} catch (Exception e) {
			LOG.error(e);
			throw e;
		}

		return resultado;
	}

	@Override
	public Categoria update(int id, Categoria pojo) throws Exception {
		LOG.trace("Insertar nueva categoria: " + pojo.toString());
		Categoria resultado = pojo;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{CALL pa_categoria_update(?,?,?)}")) {

			cs.setInt(1, id);

			cs.setString(2, pojo.getNombre());
			cs.setString(3, pojo.getImagen());

			LOG.debug("Ejecuta la query: " + cs.toString());

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(id);
			} else if (affectedRows == 0) {
				LOG.fatal("El update esta mal, no ha afectado a ninguna categoria");
			} else {
				LOG.fatal("El update esta mal, ha afectado a mas de una categoria");
			}
		} catch (SQLException e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Categoria create(Categoria pojo) throws Exception {
		LOG.trace("Insertar nueva categoria: " + pojo.toString());
		Categoria resultado = pojo;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{CALL pa_categoria_insert(?,?,?)}")) {

			cs.setString(1, pojo.getNombre());
			cs.setString(3, pojo.getImagen());

			cs.registerOutParameter(2, java.sql.Types.INTEGER);

			LOG.debug("Ejecuta la query: " + cs.toString());

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resultado = getById(cs.getInt(2));
			} else if (affectedRows == 0) {
				LOG.fatal("El insert esta mal, no se ha creado ninguna categoria");
			} else {
				LOG.fatal("El insert esta mal, se ha creado a mas de una categoria");
			}

		} catch (SQLException e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return resultado;
	}

}
