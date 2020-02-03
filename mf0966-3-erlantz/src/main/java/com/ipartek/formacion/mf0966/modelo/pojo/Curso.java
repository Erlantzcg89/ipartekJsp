package com.ipartek.formacion.mf0966.modelo.pojo;

public class Curso {
	
	private int id;
	private String nombre;
	private String finicio;
	private String ffin;
	private int horas;
	private int idProfesor;
	
	public Curso() {
		super();
		this.id = 0;
		this.nombre = "";
		this.finicio = "";
		this.ffin = "";
		this.horas = 0;
		this.idProfesor = 0;
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

	public String getFinicio() {
		return finicio;
	}

	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	public String getFfin() {
		return ffin;
	}

	public void setFfin(String ffin) {
		this.ffin = ffin;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", finicio=" + finicio + ", ffin=" + ffin + ", horas=" + horas
				+ ", idProfesor=" + idProfesor + "]";
	}
	
	

}
