package menu;

import java.util.Scanner;

public class interfaz {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1.- Exportar toda la lista de equipos");
		System.out.println("2.- Importar toda la lista de equipos");
		System.out.println("3.- Elegir un equipo y exportarlo");
		System.out.println("4.- Importar un equipo");
		System.out.println("5.- Validar un archivo XML de un equipo");
		System.out.println("6.- Escribir una sentencia XPath y ejecutarla");
		System.out.println("7.- Escoger sentencias XPath predefinas");
		System.out.println("8.- Escribir el nombre de un fichero con una consulta XQuery y ejecutarla");
		System.out.println("9.- Ejecutar sentencias predefinidas XQuery");
	    System.out.println("10.- Añadir un equipo a la lista de equipos manualmente");
	    System.out.println("11.- Inicializar lista de equipos");
	    System.out.println("12.- Listar equipos");
	    System.out.println("");
	    System.out.println("Elige una opcion:");
	    Scanner in = new Scanner(System.in);
	    
	    int opcion = in.nextInt();
	    System.out.println("Elegida opción "+opcion);
	}

}

