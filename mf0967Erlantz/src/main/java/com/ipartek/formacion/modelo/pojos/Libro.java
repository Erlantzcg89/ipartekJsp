package com.ipartek.formacion.modelo.pojos;

public class Libro {
	
	private int id;
	private String nombre;
	private Double precio;
	private int descuento;
	private String autor;
	private String imagen;
	
	public Libro(int id, String nombre, Double precio, int descuento, String autor, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.imagen = imagen;
	}

	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0.00;
		this.descuento = 0;
		this.autor = "";
		this.imagen = "";
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", imagen=" + imagen + "]";
	}

	
	
	
		

}
