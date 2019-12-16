package com.ipartek.formacion.supermercado.modelo.pojo;

public class Producto {
	
	private int id;
	private String nombre;
	private double precio;
	private String imagen;
	private String description;
	private int descuento;
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "img/vodka.jpg";
		this.description = "";
		this.descuento = 0;
	}
	
	

	public Producto(int id, String nombre, double precio, String imagen, String description, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.description = description;
		this.descuento = descuento;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public double getPrecioDescuento() {
		
		Double precioDescuento = null;
		
		precioDescuento = (this.precio) - (this.precio * this.descuento / 100);
		
		return precioDescuento;
		
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen
				+ ", description=" + description + ", descuento=" + descuento + "]";
	}
	
}
