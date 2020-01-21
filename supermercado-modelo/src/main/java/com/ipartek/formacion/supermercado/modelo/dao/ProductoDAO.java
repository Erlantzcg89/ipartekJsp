package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.dao.interfaces.IProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class ProductoDAO implements IProductoDAO {

	private final static Logger LOG = Logger.getLogger(ProductoDAO.class);

	private static ProductoDAO INSTANCE;

	private static final String SQL_GET_ALL = "SELECT p.id 'id_producto', p.nombre 'nombre_producto', p.imagen 'imagen_producto', c.id 'id_categoria', c.nombre 'nombre_categoria', u.id 'id_usuario', u.nombre 'nombre_usuario' FROM producto p, usuario u, categoria c WHERE p.id_usuario = u.id and p.id_categoria = c.id ORDER BY p.id DESC LIMIT 500;";

	private static final String SQL_GET_ALL_BY_USER = "SELECT p.id 'id_producto', p.nombre 'nombre_producto', u.id 'id_usuario', u.nombre 'nombre_usuario' "
			+ " FROM producto p, usuario u " + " WHERE p.id_usuario = u.id AND u.id = ? "
			+ " ORDER BY p.id DESC LIMIT 500;";
	
	private static final String SQL_GET_ALL_BY_CATEGORIA = "SELECT p.id 'id_producto', p.nombre 'nombre_producto', p.imagen 'imagen_producto', c.id 'id_categoria', c.nombre 'nombre_categoria', u.id 'id_usuario', u.nombre 'nombre_usuario' FROM producto p, usuario u, categoria c WHERE p.id_usuario = u.id and p.id_categoria = c.id having id_categoria = 1 ORDER BY p.id DESC LIMIT 500;";

	private static final String SQL_GET_BY_ID = "SELECT p.id 'id_producto', p.nombre 'nombre_producto', u.id 'id_usuario', u.nombre 'nombre_usuario' "
			+ " FROM producto p, usuario u " + " WHERE p.id_usuario = u.id AND p.id= ? "
			+ " ORDER BY p.id DESC LIMIT 500;";

	private static final String SQL_GET_BY_ID_BY_USER = "SELECT p.id 'id_producto', p.nombre 'nombre_producto', u.id 'id_usuario', u.nombre 'nombre_usuario' "
			+ " FROM producto p, usuario u " + " WHERE p.id_usuario = u.id AND p.id= ? AND u.id = ? "
			+ " ORDER BY p.id DESC LIMIT 500;";

	private static final String SQL_GET_INSERT = "INSERT INTO `producto` (`nombre`, `id_usuario`) VALUES (?, ?);";
	private static final String SQL_GET_UPDATE = "UPDATE `producto` SET `nombre`= ? , `id_usuario`= ? WHERE `id`= ? ;";
	private static final String SQL_GET_UPDATE_BY_USER = "UPDATE `producto` SET `nombre`= ? , `id_usuario`= ? WHERE `id`= ? AND id_usuario = ?;";

	private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ? ;";
	private static final String SQL_DELETE_BY_USER = "DELETE FROM producto WHERE id = ? AND id_usuario = ? ;";

	private ProductoDAO() {
		super();
	}

	public static synchronized ProductoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Producto> getAll() {

		ArrayList<Producto> lista = new ArrayList<Producto>();

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

	public List<Producto> getAllByUser(int idUsuario) {

		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_CATEGORIA);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Producto> getAllByCategoria(int idCategoria) {

		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_CATEGORIA);) {

			pst.setInt(1, idCategoria);
			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					lista.add(mapper(rs));
				}
			} // executeQuery

		} catch (SQLException e) {
			LOG.error(e);
		}

		return lista;
	}

	@Override
	public Producto getById(int id) {

		Producto p = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {

			// sustituyo parametros en la SQL, en este caso 1º ? por id
			pst.setInt(1, id);

			// ejecuto la consulta
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					p = mapper(rs);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException {
		Producto p = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID_BY_USER);) {

			// sustituyo parametros en la SQL, en este caso 1º ? por id
			pst.setInt(1, idProducto);
			pst.setInt(2, idUsuario);

			LOG.debug(pst);
			// ejecuto la consulta
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					p = mapper(rs);
				} else {
					LOG.warn("No se encuentra producto");
					throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
				}
			}

		} catch (SQLException e) {
			throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
		}

		return p;
	}

	@Override
	public Producto delete(int id) throws Exception {

		Producto registro = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setInt(1, id);

			registro = this.getById(id); // recuperar

			int affectedRows = pst.executeUpdate(); // eliminar
			if (affectedRows != 1) {
				registro = null;
				throw new Exception("No se puede eliminar " + registro);
			}

		}
		return registro;
	}

	@Override
	public Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException {

		Producto registro = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_USER)) {

			pst.setInt(1, idProducto);
			pst.setInt(2, idUsuario);

			registro = this.getById(idProducto); // recuperar

			LOG.debug(pst);

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				LOG.debug("registro eliminado");

			} else {

				LOG.warn("No te pertenece producto al usuario");
				throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);

			}

		} catch (SQLException e) {
			throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
		}
		return registro;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getUsuario().getId());
			pst.setInt(3, id);

			int affectedRows = pst.executeUpdate(); // lanza una excepcion si nombre repetido
			if (affectedRows == 1) {
				pojo.setId(id);
			} else {
				throw new Exception("No se encontro registro para id=" + id);
			}

		}
		return pojo;
	}

	@Override
	public Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws SQLException, ProductoException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_UPDATE_BY_USER)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getUsuario().getId());
			pst.setInt(3, idProducto);
			pst.setInt(4, idUsuario);

			LOG.debug(pst);

			int affectedRows = pst.executeUpdate(); // lanza una excepcion si nombre repetido
			if (affectedRows == 1) {
				LOG.debug("producto modificado");
				pojo.setId(idProducto);
			} else {
				LOG.warn("No le pertence el producto");
				throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
			}
		} catch (SQLException e) {

			LOG.debug("ya existe el nombre del producto");
			throw e;
		}
		return pojo;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getUsuario().getId());

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

	/**
	 * Utilidad para mapear un ResultSet a un Producto
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Producto mapper(ResultSet rs) throws SQLException {

		Producto p = new Producto();
		p.setId(rs.getInt("id_producto"));
		p.setNombre(rs.getString("nombre_producto"));
		p.setImagen(rs.getString("imagen_producto"));

		Usuario u = new Usuario();
		u.setId(rs.getInt("id_usuario"));
		u.setNombre(rs.getString("nombre_usuario"));
		p.setUsuario(u);
		
		Categoria c = new Categoria();
		c.setId(rs.getInt("id_categoria"));
		c.setNombre(rs.getString("nombre_categoria"));
		p.setCategoria(c);

		return p;
	}

}
