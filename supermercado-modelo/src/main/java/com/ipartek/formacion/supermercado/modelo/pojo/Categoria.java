package com.ipartek.formacion.supermercado.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Categoria {
	
	@NotNull
	private int id;
	
	@NotEmpty
	@Size(min = 1, max = 100)
	private String nombre;
	
	private String imagen;
	
	public Categoria() {
		super();
		this.id = 0;
		this.nombre = "";
		this.imagen = "https://img.icons8.com/nolan/64/update-tag.png";
	}

	public Categoria(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public Categoria clone() throws CloneNotSupportedException{
		Categoria c = (Categoria)super.clone();
		return c;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
}
