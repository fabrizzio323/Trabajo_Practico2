package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
   double montoPagado;
   LocalDate fechaDePago;
   
   public PagoEfectivo() {
	// TODO Auto-generated constructor stub
}


public PagoEfectivo(double montoPagado, LocalDate fechaDePago) {
	super();
	this.montoPagado = montoPagado;
	this.fechaDePago = fechaDePago;
}


public double getMontoPagado() {
	return montoPagado;
}


public void setMontoPagado(double montoPagado) {
	this.montoPagado = montoPagado;
}


public LocalDate getFechaDePago() {
	return fechaDePago;
}


public void setFechaDePago(LocalDate fechaDePago) {
	this.fechaDePago = fechaDePago;
}


@Override
public void realizarPago(double monto) {
	double descuento = monto * (10.0/100);
	setMontoPagado(getMontoPagado()-descuento);
	
}

@Override
public void imprimirRecibo() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	System.out.println("------ Efectivo ------");
	System.out.println("Fecha de pago: " + formatter.format(fechaDePago));
	System.out.println("Monto pagado: $" + montoPagado);
	
}
   
}
