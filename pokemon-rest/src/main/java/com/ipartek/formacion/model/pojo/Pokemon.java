package com.ipartek.formacion.model.pojo;

import java.util.HashMap;

public class Pokemon {
	
	private int id;
	private String nombre;
	HashMap <Integer, Habilidad> habilidades;

	public Pokemon() {
		super();
		this.id = 0;
		this.nombre = "";
		this.habilidades = new HashMap <Integer, Habilidad> ();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<Integer, Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(HashMap<Integer, Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", habilidades=" + habilidades + "]";
	}
	
}
