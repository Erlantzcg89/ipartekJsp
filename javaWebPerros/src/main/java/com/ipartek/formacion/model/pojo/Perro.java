package com.ipartek.formacion.model.pojo;

public class Perro {
	private int id;
	private String nombre;
	private String raza;
	private String foto;

	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.raza = "";
		this.foto = "https://source.unsplash.com/100x100/?dog";
	}

	public Perro(int id, String nombre, String raza, String url) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.foto = url;
	}

	public Perro(String nombre, String raza) {
		this();
		this.nombre = nombre;
		this.raza = raza;
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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", foto=" + foto + "]";
	}

}
