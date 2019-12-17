package com.ipartek.formacion.modelo.pojos;

public class Producto {
	
	private int id;
	private String nombre;
	
	public Producto(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
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

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	

}
