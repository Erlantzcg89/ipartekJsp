package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojos.Libro;

public class LibroDAO implements IDAO<Libro> {

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

		Libro libro = null;

		for (Libro l : registros) {

			if (l.getId() == id) {

				registros.remove(l);
				break;

			}
		}

		return libro;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {

		Libro libro = null;
		
		int contador = 0;

		for (Libro l : registros) {

			if (l.getId() == id) {

				registros.set(contador, pojo);
				break;

			}
			contador++;
		}

		return libro;
	}

}
