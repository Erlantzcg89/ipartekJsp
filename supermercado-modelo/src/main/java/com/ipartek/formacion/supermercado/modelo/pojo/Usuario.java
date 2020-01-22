package com.ipartek.formacion.supermercado.modelo.pojo;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 150, message = "tiene que tener entre 2 y 150 caracteres")
	private String nombre;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 150, message = "tiene que tener entre 2 y 150 caracteres")
	private String contrasenia;

	@NotNull
	private String email;

	@Pattern(regexp = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)", message = "debe ser una URL valida")
	private String imagen;

	@NotNull
	private Timestamp fechaCreacion;

	private Timestamp fechaModificacion;

	private Timestamp fechaEliminacion;
	
	@NotNull
	private Rol rol;

	public Usuario() {
		super();
		id = 0;
		nombre = "Default";
		contrasenia = "";
		email = "";
		imagen = "http://emser.es/wp-content/uploads/2016/08/usuario-sin-foto.png";
		fechaCreacion = null;
		fechaModificacion = null;
		fechaEliminacion = null;
		this.rol = new Rol();
	}

	public Usuario(int id, String nombre, String password, String email, String imagen, Timestamp fechaCreacion,
			Timestamp fechaModificacion, Timestamp fechaEliminacion, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenia = password;
		this.email = email;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEliminacion = fechaEliminacion;
		this.rol = rol;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Timestamp fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", email=" + email
				+ ", imagen=" + imagen + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", fechaEliminacion=" + fechaEliminacion + ", rol=" + rol.toString() + "]";
	}

}
