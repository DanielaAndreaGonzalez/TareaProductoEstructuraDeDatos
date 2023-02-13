package Logica;


import java.util.ArrayList;

import java.util.Scanner;



public class Tienda {
	
	static int codigo;
	static String nombre;
	static String descripcion;
	static String tipoProAux;
	static TipoProducto t;
	static ArrayList<Producto> lista = new ArrayList<Producto>();
	static ProductoServiceImpl servicioProducto = new ProductoServiceImpl();;
	
	static Scanner datos = new Scanner(System.in);
	
	public static void main(String [] args)
	{
		
		System.out.println("Tienda La Miranda");
		
		Producto producto = null;
		
		Scanner dato = new Scanner(System.in);
		int opcion = 3;
		boolean salir = false;
		
		
		while(!salir)
		{
			menu();
			opcion =dato.nextInt();
			switch(opcion)
			{
			case 1:
				
				codigo = leerEntero("Ingrese el codigo del producto");
				nombre=leerCadena("Ingrese el nombre del producto---");
				descripcion = leerCadena("Ingrese el descripcion del producto---");
				tipoProAux = leerCadena("Ingrese el tipo del producto (ABARROTES,LACTEOS,LEGUMBRES,ASEO)").toUpperCase();
				t = convertirTipoProducto(tipoProAux);
				producto = new Producto(codigo, nombre, descripcion, t);
				
				boolean var = servicioProducto.crearProducto(producto) ;
				imprimirMensaje((var==true)?"Producto creado con éxito" :"No se creó el producto"); 
				
				servicioProducto.addListaProductos(producto);
				boolean confirmar  = confirmar("¿Desea seguir en el menú? S - N");
				if(confirmar)
				{
					break;
				}else {
					salir=true;
				}
				
				
			case 2:
				codigo= leerEntero("Ingrese el codigo del producto a buscar");
				Producto productoEncontrado = servicioProducto.buscarProducto(codigo);
				System.out.println("Datos: ");
				System.out.println("Codigo: "+productoEncontrado.getCodigo());
				System.out.println("Nombre: "+productoEncontrado.getNombre());
				System.out.println("Descripcion: "+productoEncontrado.getDescripcion());
				System.out.println("tipo del producto: "+productoEncontrado.getTipoProducto());	
			
			    confirmar  = confirmar("¿Desea seguir en el menú? S - N");
				if(confirmar)
				{
					break;
				}else {
					salir=true;
				}	
			case 3:
				salir = true;
				System.out.println("Salió");
				break;
			default:
				System.out.println("Opción no existe solo 1,2,3");
			}		
		}	
	}
	

	public static TipoProducto convertirTipoProducto(String tipo) {
		
		TipoProducto tipoProduc = null;
		
		switch(tipo)
		{
		case "ASEO":
			tipoProduc=TipoProducto.ASEO;
			break;
		case "LACTEOS":
			tipoProduc= TipoProducto.LACTEOS;
			break;
		case "ABARROTES":
			tipoProduc = TipoProducto.ABARROTES;
			break;
		case "LEGUMBRES":
			tipoProduc = TipoProducto.LEGUMBRES;
			break;
		default:
			tipoProduc =  TipoProducto.LEGUMBRES;
			break;
		}
		
		return tipoProduc;
	}
	
	public static Producto buscarProducto(int codigo) {
		
		Producto productoEncontrado = null;
		for(Producto producto: servicioProducto.getListaProductos())
		{
			if(codigo == producto.getCodigo())
				productoEncontrado = producto;
		}
		
		return productoEncontrado;
	}
	
	public static  void menu()
	{
		System.out.println("***************** ");
		System.out.println("Presione 1. para crear el producto");
		System.out.println("Presione 2. para buscar producto");
		System.out.println("Presione 3. para salir del menú");
		
	}
	
	public static int leerEntero(String mensaje) {
		int numero =0;
		Scanner dato = new Scanner(System.in);
		System.out.print(mensaje);
		numero = dato.nextInt(); 
		return numero;
	}
	
	public static double leerDouble(String mensaje)
	{
		double numeroDouble = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);;
		numeroDouble = entrada.nextDouble();
		return numeroDouble;
	}
	public static String leerCadena(String mensaje)

	{
		String cadena = " ";
		Scanner entradaCadena = new Scanner(System.in);
		System.out.println(mensaje);
		cadena = entradaCadena.next();
		return cadena;
	}

	public static boolean confirmar(String mensaje)
	{
		boolean bandera = false;
		String cadena = " ";
		Scanner entradaBooleana = new Scanner(System.in);
		System.out.println(mensaje);
		cadena = entradaBooleana.next();
		if(cadena == "s"||  cadena.equals("S"))
		{
			bandera = true;	
		}else{
			bandera=false;
		}
		return bandera;
	}
	
	public static void imprimirMensaje(String mensaje)
	{
		System.out.println(mensaje);
	}
}
