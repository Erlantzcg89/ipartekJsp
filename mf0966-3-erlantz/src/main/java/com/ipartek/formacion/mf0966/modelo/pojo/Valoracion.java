package com.ipartek.formacion.mf0966.modelo.pojo;

public class Valoracion {
	
	private int id;
	private int idUsuario;
	private int idCurso;
	private int nota;
	private String comentario;
	
	public Valoracion() {
		super();
		this.id = 0;
		this.idUsuario = 0;
		this.idCurso = 0;
		this.nota = 0;
		this.comentario = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", idUsuario=" + idUsuario + ", idCurso=" + idCurso + ", nota=" + nota
				+ ", comentario=" + comentario + "]";
	}

}
