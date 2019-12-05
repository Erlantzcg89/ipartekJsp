package com.ipartek.formacion.pojos;

public class Perro {

	private int id;
	private String nombre;
	private String foto;

	public Perro(int id, String nombre, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
	}

	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.foto = "https://picsum.photos/id/237/200/300";
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
