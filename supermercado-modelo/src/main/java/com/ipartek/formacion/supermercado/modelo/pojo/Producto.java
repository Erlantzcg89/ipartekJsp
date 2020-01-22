package com.ipartek.formacion.supermercado.modelo.pojo;

import java.sql.Timestamp;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Producto {

	public static final int DESCUENTO_MIN = 0;
	public static final int DESCUENTO_MAX = 100;

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 150, message = "tiene que tener entre 2 y 150 caracteres")
	private String nombre;

	@NotNull
	@Min(0)
	@Digits(integer = 6, fraction = 2, message = "no puede tener más de 2 decimales")
	private float precio;

	@Pattern(regexp = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)", message = "debe ser una URL valida")
	private String imagen;

	@Size(min = 2, max = 150, message = "tiene que tener entre 2 y 150 caracteres")
	@NotBlank
	private String descripcion;

	@NotNull
	@Range(min = 0, max = 100, message = "debe estar entre 0 y 100")
	private int descuento;

	@NotNull
	private Timestamp fechaCreacion;

	private Timestamp fechaModificacion;

	private Timestamp fechaEliminacion;

	@NotNull
	private Usuario usuario;

	@NotNull
	private Categoria categoria;
	
	private int validado;
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "https://image.flaticon.com/icons/png/512/372/372627.png";
		this.descripcion = "";
		this.descuento = DESCUENTO_MIN;
		fechaCreacion = null;
		fechaModificacion = null;
		fechaEliminacion = null;
		this.usuario = new Usuario();
		this.categoria = new Categoria();
		this.validado = 0;
	}

	public Producto(int id, String nombre, float precio, String imagen, String descripcion, int descuento,
			Timestamp fechaCreacion, Timestamp fechaModificacion, Timestamp fechaEliminacion, Usuario usuario, 
			Categoria categoria, int validado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEliminacion = fechaEliminacion;
		this.usuario = usuario;
		this.categoria = categoria;
		this.validado = validado;
	}

	public Producto(String nombre, float precio, String imagen, String descripcion, int descuento,
			Timestamp fechaCreacion, Timestamp fechaModificacion, Timestamp fechaEliminacion, Usuario usuario, Categoria categoria, int validado) {
		super();
		this.id = 0;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEliminacion = fechaEliminacion;
		this.usuario = usuario;
		this.categoria = categoria;
		this.validado = validado;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public int getValidado() {
		return validado;
	}

	public void setValidado(int validado) {
		this.validado = validado;
	}

	public float getPrecioDescuento() {

		float resultado = (this.precio * (100 - this.descuento)) / 100;

		return resultado;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", descuento=" + descuento + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", fechaEliminacion=" + fechaEliminacion + ", usuario="
				+ usuario + ", categoria=" + categoria + ", validado=" + validado + "]";
	}

}
