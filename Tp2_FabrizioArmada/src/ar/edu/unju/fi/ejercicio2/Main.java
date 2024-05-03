package ar.edu.unju.fi.ejercicio2;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Meses;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int op;
	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList();
		do {
			op=menu();
			switch (op) {
			case 1:
				   limpiarBuffer();
				   crearEfemeride(efemerides);
				break;
			case 2:
				     if(efemerides.isEmpty()) {
				    	 System.out.println("***ERROR LISTA VACIA***");
				    	 Espacio();
				     }else {
				    	 limpiarBuffer();
				    	 mostrarEfemerides(efemerides);
				     }
				break;
			case 3: 
				    if(efemerides.isEmpty()) {
				    	System.out.println("***ERROR LISTA VACIA***");
				    	Espacio();
				    }else {
				    limpiarBuffer();
				    System.out.print("Ingrese codigo: ");
				    String cod = sc.nextLine();
				    eliminarEfemeride(efemerides, cod);
				    }
				break;
			case 4: 
				     if(efemerides.isEmpty()) {
				    	 System.out.println("***ERROR LISTA VACIA***");
				    	 Espacio();
				     }else {
				    	 limpiarBuffer();
				    	 System.out.println("Ingrese codigo: ");
				    	 String cod = sc.nextLine();
				    	 modificarEfemeride(efemerides, cod);
				     }
				break;
			case 5: System.out.println("Finalizando programa...");
				break;
			default: System.out.println("***OPCION INVALIDA***");
				break;
			}
		}while(op!=5);
		System.out.println("Programa finalizado");

	}
	public static int menu() {
		System.out.println("1 Crear efemeride");
		System.out.println("2 Mostrar efemerides");
		System.out.println("3 Eliminar efemeride");
		System.out.println("4 Modificar efemeride");
		System.out.println("5 Salir");
		System.out.print("Elija una opcion: ");
		return op=sc.nextInt();
	}
	public static void crearEfemeride(ArrayList<Efemeride> efemerides) {
		System.out.print("Ingrese codigo: ");
		String codigo = sc.nextLine();
		int NumeroMes = validarMes();
		Meses mes = Meses.values()[NumeroMes-1];
		limpiarBuffer();
		System.out.print("Ingrese dia: ");
		String dia = sc.nextLine();
		System.out.print("Ingrese descripcion: ");
	    String descripcion = sc.nextLine();
	    efemerides.add(new Efemeride(codigo, mes, dia, descripcion));
	    System.out.println("***CREACION EXITOSA***");
	}
	public static void limpiarBuffer() {
		sc.nextLine();
	}
    public static int validarMes(){
        int mes=0;
        do {
    	System.out.print("Ingrese mes 1 al 12: ");
        mes=sc.nextInt();
        }while(mes < 1 || mes > 12);
        return mes;
    }
    public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
    	for(Efemeride i:efemerides) {
    		i.mostrarDatos();
    	}
    }
    public static void eliminarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
        Iterator iterador = efemerides.iterator();
    	boolean band=false;
        while(iterador.hasNext()) {
           Efemeride f = (Efemeride)iterador.next();
           if(f.getCodigo().equalsIgnoreCase(codigo)==true) {
   			iterador.remove();
   			band=true;
   		}
        }
    		
        if(band==true) {
        	System.out.println("***EFEMERIDE ELIMINADA***");
        }else {
        	System.out.println("***EFEMERIDE INEXISTENTE***");
        }
    }
    public static void Espacio() {
    	System.out.println("");
    }
    public static void modificarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
    	boolean band=false;
    	int nuevoMes=0;
    	Efemeride encontrado = new Efemeride(); 
    	for(Efemeride i: efemerides) {
    		if(i.getCodigo().equalsIgnoreCase(codigo)==true) {
    			band = true;
    			encontrado = i;
    		}
    	}
    	if(band==true) {
    		do {
    			op=menuModificar();
    			switch (op) {
				case 1:
					limpiarBuffer();
					nuevoMes=validarMes();
					encontrado.setMes(Meses.values()[nuevoMes-1]);
					System.out.println("***MES CAMBIADO CON EXITO***");
					Espacio();
					break;
				case 2:
					limpiarBuffer();
					System.out.print("Ingrese nuevo dia: ");
					encontrado.setDia(sc.nextLine());
					System.out.println("***DIA CAMBIADO CON EXITO***");
					Espacio();
					break;
				case 3: 
					limpiarBuffer();
					System.out.println("Ingrese nuevo detalle: ");
					encontrado.setDetalle(sc.nextLine());
					System.out.println("***DETALLE CAMBIADO CON EXITO***");
					Espacio();
					break;
				case 4:
					System.out.println("***Hasta la proxima***");
					Espacio();
					break;
				default: System.out.println("***OPCION INVALIDA***");
					break;
				}
    		}while(op!=4);
    	}else {
    		System.out.println("***EFEMERIDE INEXISTENTE***");
    	}
    }
    public static int menuModificar() {
    		System.out.println("1 Modificar mes");
    		System.out.println("2 Modificar dia");
    		System.out.println("3 Modificar detalle");
    		System.out.println("4 Salir"); 
    		System.out.print("Elija opcion: ");
    		op = sc.nextInt();
    	return op;
    }
   
}
