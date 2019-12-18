package com.ipartek.formacion.modelo.pojos;

public class Libro {
	
	private int id;
	private String nombre;
	private Double precio;
	private int descuento;
	
	public Libro(int id, String nombre, Double precio, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
	}

	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0.00;
		this.descuento = 0;
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

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + "]";
	}
	
	
		

}
