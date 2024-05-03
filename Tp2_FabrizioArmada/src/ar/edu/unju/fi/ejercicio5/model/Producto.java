package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.enumerados.categoria; 
import ar.edu.unju.fi.ejercicio5.enumerados.origenFabricacion;

public class Producto {
	String codigo;
    String descripcion;
    Double precioUnitario;
    categoria categorias; 
    origenFabricacion origen;
    boolean stock;
    
    public Producto() {
		
	}

	public Producto(String codigo, String descripcion, Double precioUnitario, categoria categorias,
			origenFabricacion origen, boolean stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.categorias = categorias;
		this.origen = origen;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(categoria categorias) {
		this.categorias = categorias;
	}

	public origenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(origenFabricacion origen) {
		this.origen = origen;
	}
	public boolean getStock() {
		return stock;
	}

	public void setPrecioUnitario(boolean stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", categorias=" + categorias + ", origen=" + origen + ", stock=" + stock + "]";
	}
    
    
}
