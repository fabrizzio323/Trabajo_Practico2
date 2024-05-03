package ar.edu.unju.fi.ejercicio4;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
    static Scanner sc = new Scanner(System.in);
	static int op;
    public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList();
        do {
        	op=menu();
        	switch (op) {
			case 1: System.out.println("***ALTA DE JUGADOR***");
			        limpiarBuffer();
        	        altaJugador(jugadores);
				break;
			case 2: 
			        if(jugadores.isEmpty()) {
			        	System.out.println("***ERROR LISTA VACIA***");
			        }else {
			        	System.out.println("***LISTA DE JUGADORES***");
			        	mostrarJugadores(jugadores);
			        }
				break;
			case 3: 
			        if(jugadores.isEmpty()) {
	        	       System.out.println("***ERROR LISTA VACIA***");
	                }else {
	                 System.out.println("***MODIFICAR POSICION***");
	        	     limpiarBuffer();
	        	     System.out.println("Ingrese nombre: ");
	        	     String nombre = sc.nextLine();
	        	     System.out.println("Ingrese apellido: ");
	        	     String apellido = sc.nextLine();
	        	     ModificarPosicion(jugadores, nombre, apellido);
	                }
			    break;
			case 4: 
		             if(jugadores.isEmpty()) {
	        	       System.out.println("***ERROR LISTA VACIA***");
	                  }else {
	                	 System.out.println("***ELIMINAR JUGADOR***");
	                	 limpiarBuffer();
	 	        	     System.out.println("Ingrese nombre: ");
	 	        	     String nombre = sc.nextLine();
	 	        	     System.out.println("Ingrese apellido: ");
	 	        	     String apellido = sc.nextLine();
	 	        	     eliminarJugador(jugadores, nombre, apellido);
	                  }	
			break;
			case 5: System.out.println("Finalizando programa...");
				break;
			default:System.out.println("***OPCION INVALIDA***");
				break;
			}
        }while(op!=5);
        System.out.println("Programa finalizado");
	}
    public static int menu() {
    	System.out.println("1 Alta jugador");
    	System.out.println("2 Mostrar todos los jugadores");
    	System.out.println("3 Modificar posicion");
    	System.out.println("4 Eliminar jugador");
    	System.out.println("5 Salir");
    	System.out.print("Elija opcion: ");
    	return op = sc.nextInt();
    }
    public static void altaJugador(ArrayList<Jugador> jugadores) {
    	System.out.print("Ingrese nombre: ");
    	String nombre = sc.nextLine();
    	System.out.print("Ingrese apellido: ");
    	String apellido = sc.nextLine();
    	LocalDate fechaNacimiento = validarFecha();
    	System.out.println("Ingrese nacionalidad: ");
    	String nacionalidad = sc.nextLine();
    	double peso = validarPeso();
    	double altura = validarAltura();
    	Posicion posicion= Posicion.values()[posiciones()-1];
    	jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, altura, peso, posicion));
    }
    public static void mostrarJugadores(ArrayList<Jugador> jugadores) {
    	for(Jugador j: jugadores) {
    		j.mostrarDatos();
    	}
    }
    public static void ModificarPosicion(ArrayList<Jugador> jugadores, String nombre, String apellido) {
    	Jugador encontrado = new Jugador();
    	boolean band = false;
    	for(Jugador j: jugadores) {
    		if(j.getNombre().equalsIgnoreCase(nombre) && j.getApellido().equalsIgnoreCase(apellido) == true) {
    			encontrado = j;
    			band = true;
    		}
    	}
    	if(band == true) {
    		encontrado.setPosicion(Posicion.values()[posiciones()-1]);
    		System.out.println("***POSICION MODIFICADA CON EXITO***");
    	}else {
    		System.out.println("***JUGADOR NO ENCONTRADO***");
    	}
    }
    public static void eliminarJugador(ArrayList<Jugador> jugadores, String nombre, String apellido) {
    	boolean band = false;
    	Iterator iterador = jugadores.iterator();
    	while(iterador.hasNext()) {
    		Jugador j = (Jugador)iterador.next();
    		if(j.getNombre().equalsIgnoreCase(nombre) && j.getApellido().equalsIgnoreCase(apellido) == true) {
    			iterador.remove();
    			band=true;
    		}
    	}
    	if(band == true) {
    		System.out.println("***JUGADOR ELIMINADO CON EXITO***");
    	}else {
    		System.out.println("***JUGADOR NO ENCONTRADO***");
    	}
    }
    public static LocalDate validarFecha() {
    	boolean fechaInvalida = false;
    	LocalDate fechaNacimiento=null;
    	do{
    	System.out.println("Ingrese fecha de nacimiento dd/mm/yyy: ");
    	String fecha = sc.nextLine();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
    	try {
			fechaNacimiento = LocalDate.parse(fecha, formatter);
			fechaInvalida=true;
		} catch (DateTimeParseException e) {
			System.err.println("Ingrese fecha en formato dd/mm/yyyy");
		}
    	}while(!(fechaInvalida));
    	return fechaNacimiento;
    }
    public static double validarPeso() {
    	boolean band=false;
    	String peso="";
    	double p=0;
    	while(!(band)) {
    		System.out.println("Ingrese peso: ");
    		peso=sc.nextLine();
    		try {
				p= Double.parseDouble(peso);
				band=true;
			} catch (Exception e) {
				System.out.println("Ingrese la \".\" para separar decimales");
			}    		}
    	return p;
    }
    public static double validarAltura() {
    	boolean band=false;
    	String altura="";
    	double a=0;
    	while(!(band)) {
    		System.out.println("Ingrese altura: ");
    		altura=sc.nextLine();
    		try {
				a= Double.parseDouble(altura);
				band=true;
			} catch (Exception e) {
				System.out.println("Ingrese la \".\" para separar decimales");
			}    		}
    	return a;
    }
    public static int posiciones() {
    	int opcion=0;
    	do {
    		System.out.println("Ingrese posicion");
    		System.out.println("1 DELATERO");
    		System.out.println("2 MEDIO");
    		System.out.println("3 DEFENSA");
    		System.out.println("4 ARQUERO");
    		System.out.print("Elija opcion: ");
    		opcion = sc.nextInt();
    		if(opcion < 1 || opcion > 4) {
    			System.err.println("Posicion invalida");
    		}
    	}while(opcion < 1 || opcion > 4);
    	return opcion;
    }
    public static void limpiarBuffer() {
    	sc.nextLine();
    }
}