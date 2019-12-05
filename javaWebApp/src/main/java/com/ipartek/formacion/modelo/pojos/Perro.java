package com.ipartek.formacion.modelo.pojos;

public class Perro {
	
	private int id;
	private String nombre;
	private String foto;
	
		
	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.foto = "https://images.squarespace-cdn.com/content/v1/5a8abbee6f4ca301c2d1b962/1527808340868-GRA08XX79G20DUND6H9I/ke17ZwdGBToddI8pDm48kGuaBMmARhKtUmXCE1pY_k1Zw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZUJFbgE-7XRK3dMEBRBhUpzGBwVodEh3vUCb_FH6fADYhlZwvRiPtE8wFqmckfQo9hcWrJuBgPcO-nCQUzImAEM/Logo+Pipper+RECORTADA.jpg";
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
