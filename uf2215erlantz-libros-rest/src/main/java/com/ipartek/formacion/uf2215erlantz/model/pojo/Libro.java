package com.ipartek.formacion.uf2215erlantz.model.pojo;

public class Libro {
	
	private int id;
	private String nombre;
	private Autor autor;
	
	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.autor = new Autor();
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + "]";
	}
	
}
