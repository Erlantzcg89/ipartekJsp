package com.ipartek.formacion.pojos;

public class Usuario {
	
	private int id;
	private String nombre;
	private String password;
	private String ip;
	
	public Usuario(int id, String nombre, String password, String ip) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.ip = ip;
	}
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.ip = "";
	}
	
	
	


}
