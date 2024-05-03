package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Meses;

public class Efemeride {
    String codigo;
    Meses mes;
    String dia;
    String detalle;
    public Efemeride() {
		// TODO Auto-generated constructor stub
	}
	public Efemeride(String codigo, Meses mes, String dia, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Meses getMes() {
		return mes;
	}
	public void setMes(Meses mes) {
		this.mes = mes;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
    public void mostrarDatos() {
    	System.out.println("***************************");
    	System.out.println("Codigo: " + codigo);
    	System.out.println("Mes: " + mes);
    	System.out.println("Dia: " + this.dia);
    	System.out.println("Detalle: " + detalle);
    	System.out.println("***************************");
    }
}
