package com.ipartek.formacion.supermercado.modelo.pojo;

public class Rol {
	public static final int ROL_USUARIO = 1;
	public static final int ROL_ADMINISTRADOR = 2;
	
	private int id;
	private String nombre;
	
	public Rol() {
		super();
		this.id = ROL_USUARIO;
		this.nombre = "usuario";
	}

	public Rol(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
