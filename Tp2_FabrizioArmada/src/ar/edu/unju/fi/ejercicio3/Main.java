package ar.edu.unju.fi.ejercicio3;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
       Provincia[] provincias = Provincia.values();
       for(Provincia p: provincias) {
    	   System.out.println("Provincia: " + p);
    	   System.out.println("Poblacion: " + p.getCantidadPoblacion());
    	   System.out.println("Superficie: " + p.getSuperficie() + " km^2");
    	   System.out.println("Densidad poblacional: " + p.densidad());
    	   System.out.println("********************************");
       }
	}

}

