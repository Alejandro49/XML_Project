package menu;

import java.io.IOException;
import java.util.Scanner;
import pojos.*;

import javax.xml.bind.JAXBException;

public class interfaz {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("1.- Exportar todos los equipos de futbol");
		System.out.println("2.- Importar todos los equipos de futbol");
		System.out.println("3.- Elegir un equipo y exportarlo");
		System.out.println("4.- Importar un único equipo");
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
	    try (Scanner in = new Scanner(System.in)) {
			int opcion = in.nextInt();
			System.out.println("Elegida opción "+opcion);
			
			switch(opcion) {
				case 1:
					   System.out.println("Exportando archivo");
					   try {
							xml.TestXML_simple.main(args);
					   } catch (JAXBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					   } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					   }
				break;
				case 2:
					   System.out.println("Introduzca el nombre del archivo que desea importar:");
				       Scanner entradaArchivo = new Scanner(System.in);
			           String nombreArchivo = entradaArchivo.nextLine();
			           
			           System.out.println("Importando "+nombreArchivo);
				break;
				case 3:
					   System.out.println("Introduzca el nombre del equipo que desea exportar:");
					   break;
				case 4:
					   System.out.println("Introduzca el nombre del equipo que desea importar:");
				       break;
				case 5:
					   System.out.println("Introduzca el nombre del archivo XML que desea validar:");
				       break;
				case 6:;
					   break;
				case 7:;
					   break;
				case 8:;
					   break;
				case 9:;
					   break;
				case 10:
						Scanner lecturaConsola = new Scanner(System.in);
						System.out.println("Introduce nombre del equipo:");
						String nombre =  lecturaConsola.nextLine();
						System.out.println("Introduce nombre del pais:");
						String pais =  lecturaConsola.nextLine();
						System.out.println("Introduce el número de títulos del equipo:");
						int titulos =  lecturaConsola.nextInt();
						System.out.println("Introduce nombre del entrenador del equipo:");
						String entrenador =  lecturaConsola.nextLine();
						System.out.println("Introduce nombre del presidente del equipo:");
						String presidente =  lecturaConsola.nextLine();
						Equipo equipoGenerado = new Equipo(nombre,pais,titulos,entrenador,presidente);
					    // aqui se debería de añadir el quipo metido por consola a la lista de equipos
						break;
				case 11:;
				break;
				case 12:;
				break;
				default:
			}
		}
	}

}

