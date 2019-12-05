package com.ipartek.formacion.model.pojo;

public class Articulo {

	private int id;
	private int idCategoria;
	private int idSubcategoria;
	private String fecha;
	private String categoria;
	private String subcategoria;
	private String titulo;
	private String cuerpo;

	public Articulo() {
		super();
		this.id = 0;
		this.idCategoria = 0;
		this.idSubcategoria = 0;
		this.fecha = "";
		this.categoria = "";
		this.subcategoria = "";
		this.titulo = "";
		this.cuerpo = "";
	}

	public Articulo(int id, int idCategoria, int idSubcategoria, String fecha, String categoria, String subcategoria,
			String titulo, String cuerpo) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.idSubcategoria = idSubcategoria;
		this.fecha = fecha;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}
}
