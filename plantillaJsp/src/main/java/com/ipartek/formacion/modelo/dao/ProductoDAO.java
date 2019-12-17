package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojos.Producto;

public class ProductoDAO implements IDAO<Producto>{
	
	
	// patron singleton
	private static ProductoDAO INSTANCE;
	private ArrayList<Producto> registros;
	public static int indice = 25;
	
	private ProductoDAO() {
		super();
		
		registros = new ArrayList<Producto>();
	}
	
	public synchronized static ProductoDAO getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		Producto resul = null;
		
		registros.add(pojo);
		
		return resul;
	}
	
	@Override
	public List<Producto> getAll() {

		return registros;
	}

	@Override
	public Producto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
