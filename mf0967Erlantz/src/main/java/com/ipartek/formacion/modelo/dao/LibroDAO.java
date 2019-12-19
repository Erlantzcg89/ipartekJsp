package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojos.Libro;

public class LibroDAO implements IDAO<Libro>{
	
	
	// patron singleton
	private static LibroDAO INSTANCE;
	private ArrayList<Libro> registros;
	public static int indice = 25;
	
	private LibroDAO() {
		super();
		
		registros = new ArrayList<Libro>();
	}
	
	public synchronized static LibroDAO getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public Libro create(Libro pojo) throws Exception {
		Libro resul = null;
		
		registros.add(pojo);
		
		return resul;
	}
	
	@Override
	public List<Libro> getAll() {

		return registros;
	}

	@Override
	public Libro getById(int id) {

		return null;
	}

	@Override
	public Libro delete(int id) throws Exception {

		return null;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {

		return null;
	}
	
}
