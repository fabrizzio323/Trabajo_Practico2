package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.enumerados.categoria;
import ar.edu.unju.fi.ejercicio5.enumerados.origenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static byte op;
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList();
		precargaProductos(productos);
		do {
			op=menu();
			switch (op) {
			case 1:
				disponibles(productos);
				break;
			case 2: noDisponibles(productos);
				break;
			case 3: incrementarPrecio(productos);
				break;
			case 4: mostrarElectroHogaresDisponibles(productos);
				break;
			case 5: ordenDescendente(productos);
				break;
			case 6: mayuscula(productos);
				break;
			case 7: System.out.println("Finalizando programa...");
				break;
			default: System.out.println("OPCION INVALIDA");
				break;
			}
		}while(op!=7);
		System.out.println("Programa finalizado");

	}
   public static void precargaProductos(ArrayList<Producto> productos) {
	   productos.add(new Producto("T14", "Teclado mecanico", 54213.0, categoria.INFORMATICA, origenFabricacion.BRASIL, true));
   	productos.add(new Producto("A787", "Auriculares RGB", 45213.0, categoria.INFORMATICA, origenFabricacion.ARGENTINA, false));
   	productos.add(new Producto("P878", "Procesador i9 intel", 954458.53, categoria.INFORMATICA, origenFabricacion.ARGENTINA, true));
   	productos.add(new Producto("U78", "Usb 16Gb", 7854.0, categoria.INFORMATICA, origenFabricacion.CHINA, true));
   	productos.add(new Producto("S47", "Disco SSD 248Gb", 35265.02, categoria.INFORMATICA, origenFabricacion.URUGUAY, false));
   	productos.add(new Producto("P88", "Procesador Ryzen 9 AMD", 984458.53, categoria.INFORMATICA, origenFabricacion.ARGENTINA, true));
   	productos.add(new Producto("T4", "Teclado Hyper x", 58213.0, categoria.INFORMATICA, origenFabricacion.BRASIL, true));
   	productos.add(new Producto("A87", "Auriculares RGB ryzer", 48213.0, categoria.INFORMATICA, origenFabricacion.ARGENTINA, true));
   	productos.add(new Producto("P8", "Procesador i7 intel", 457187.53, categoria.INFORMATICA, origenFabricacion.CHINA, false));
   	productos.add(new Producto("U7", "Usb 32Gb", 16854.0, categoria.INFORMATICA, origenFabricacion.CHINA, false));
   	productos.add(new Producto("H47", "Disco HDD 1T", 53265.02, categoria.INFORMATICA, origenFabricacion.CHINA, true));
   	productos.add(new Producto("P88", "Microondas Samsung", 784458.53, categoria.ELECTROHOGAR, origenFabricacion.CHINA, true));
   	productos.add(new Producto("H7", "Lavarropa Samsung", 864854.0, categoria.ELECTROHOGAR, origenFabricacion.CHINA, true));
   	productos.add(new Producto("H4", "Equipo de musica Sony", 532465.02, categoria.ELECTROHOGAR, origenFabricacion.CHINA, false));
   	productos.add(new Producto("H88", "Equipo de musica Samsung", 654458.53, categoria.ELECTROHOGAR, origenFabricacion.CHINA, false));
   }
   public static byte menu() {
	   byte op=0;
	   try {
		System.out.println("****************************************");
		System.out.println("1 Mostrar productos disponibles");
		System.out.println("2 Mostrar productos no disponibles");
		System.out.println("3 Incrementar precios en un 20%");
		System.out.println("4 Mostrar productos electro hogar disponibles");
		System.out.println("5 Ordenar productos por precio en forma descendente");
		System.out.println("6 Mostrar los productos con nombres en mayusculas");
		System.out.println("7 Salir");
		System.out.println("****************************************");
		System.out.print("Elija una opcion: ");
		op=sc.nextByte();
	} catch (Exception e) {
		System.err.println("Ingrese numeros para la opcion");
		sc.nextLine();
	}
	   return op;
   }
   public static void disponibles(ArrayList<Producto> productos) {
	   Consumer<Producto> mostrarProductos = p->System.out.println(p);
       productos.forEach(mostrarProductos);
   }
   public static void noDisponibles(ArrayList<Producto> productos) {
	   Predicate<Producto> filtrarNoDisponibles = x -> !x.getStock();
	   productos.stream().filter(filtrarNoDisponibles).forEach(System.out::println);
   }
   public static void incrementarPrecio(ArrayList<Producto> productos) {
	   Function<Producto, Producto> funcionIncremento = (p)->{
		   double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.2f);
		   p.setPrecioUnitario(resultado);
		   return p;
	   };
	   List<Producto> productosIncrementados = new ArrayList<>();
	   productosIncrementados = productos.stream().map(funcionIncremento).collect(Collectors.toList());
	   productosIncrementados.forEach(System.out::println);
   }
   public static void ordenDescendente(ArrayList<Producto> productos) {
	   System.out.println("--------- Precios ordenados ---------");
	   productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
	   productos.forEach(x -> System.out.println(x));
   }
   public static void mostrarElectroHogaresDisponibles(ArrayList<Producto> productos) {
	   Predicate<Producto> categoriaEstado = (e) -> e.getStock()==true && e.getCategorias().equals(e.getCategorias().ELECTROHOGAR);
	   productos.stream().filter(categoriaEstado).forEach(System.out::println);
   }
   public static void mayuscula(ArrayList<Producto> productos) {
	   Function<Producto, Producto> aMayusculas = producto -> {
           Producto productoConMayusculas = new Producto(producto.getCodigo(),producto.getDescripcion().toUpperCase(),producto.getPrecioUnitario(),producto.getCategorias(),producto.getOrigen(),producto.getStock());
           return productoConMayusculas;
       };

       System.out.println("Productos con nombres en mayúsculas:");
       productos.stream().map(aMayusculas).forEach(System.out::println);
   }
}
