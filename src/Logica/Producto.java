package Logica;

import java.util.ArrayList;

/**
 * 
 * @author GonzalezHDanielaA
 * @since 11/02/2023
 */

public class Producto {
	
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private TipoProducto tipoProducto;
	private ArrayList<Producto> listaProductos;
	
	
	public Producto()
	{
		
	}
	
	
	public Producto(int codigo, String nombre, String descripcion, TipoProducto tipoProducto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoProducto = tipoProducto;
		this.listaProductos = new ArrayList<Producto>();
	}

	public int getCodigo() {
		return codigo;
	}
	  
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoProducto="
				+ tipoProducto + "]";
	}
}
