package ar.edu.unju.fi.ejercicio1.model;

import ar.edu.unju.fi.ejercicio1.enumerados.categoria; 
import ar.edu.unju.fi.ejercicio1.enumerados.origenFabricacion;

public class Producto {
      String codigo;
      String descripcion;
      Double precioUnitario;
      categoria categorias;
      origenFabricacion origen;
      
      public Producto() {
		
	}

	public Producto(String codigo, String descripcion, Double precioUnitario, categoria categorias,
			origenFabricacion origen) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.categorias = categorias;
		this.origen = origen;
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
      public void mostrarDatos() {
    	  System.out.println("Codigo: " + codigo);
    	  System.out.println("Descripcion: " + descripcion);
    	  System.out.println("Precio Unitario: " + precioUnitario);
    	  System.out.println("Categoria: " + categorias);
          System.out.println("Origen de fabricacion: " + origen);
      }
}