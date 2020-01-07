package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.el.ELException;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public class ProductoDAO implements IDAO<Producto> {
	
	private static ProductoDAO INSTANCE;
		
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM producto ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID ="SELECT id, nombre FROM producto WHERE id = ? ;"; 
	private static final String SQL_GET_INSERT ="INSERT INTO producto ( nombre) VALUES ( ? );";
	private static final String SQL_GET_UPDATE ="UPDATE producto SET nombre = ? WHERE id = ? ;";
	private static final String SQL_DELETE ="DELETE FROM producto WHERE id = ? ;";
	
		
	
	private ProductoDAO() {		
		super();			
	}
	
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
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
				
				Producto p = new Producto();
				p.setId( rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				lista.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Producto getById(int id) {
		
		Producto registro = null;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
				) {
			
			// sustituyo parametros en la SQL, en este caso 1º ? por id			
			pst.setInt(1, id);
			
			//ejecuto la consulta
			try( ResultSet rs = pst.executeQuery() ){

				while (rs.next()) {
					
					registro = new Producto();
					registro.setId( rs.getInt("id"));
					registro.setNombre(rs.getString("nombre"));
						
				}
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		Producto registro = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setInt(1, id);			
			
			registro = this.getById(id); //recuperar
			
			
			int affectedRows = pst.executeUpdate();  //eliminar
			if (affectedRows != 1) {
				registro = null;
				throw new Exception("No se puede eliminar " + registro);
			}

		}
		return registro;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, id);
			
			int affectedRows = pst.executeUpdate();  // lanza una excepcion si nombre repetido
			if (affectedRows == 1) {
				pojo.setId(id);				
			}else {
				throw new Exception("No se encontro registro para id=" + id);
			}

		}
		return pojo;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement( SQL_GET_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());			

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

	
	
}
