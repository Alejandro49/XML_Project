package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import com.sun.tools.javac.Main;

import pojos.Equipo;
import pojos.Liga;
import xml.LigaXML;

public class PanelControl {
	
	LigaXML ligaXML = new LigaXML();

	Scanner reader;
	
	public void cargarPanel() {
		
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Importar liga");
		System.out.println("2.- Exportar liga");
		System.out.println("3.- Crear liga");
		System.out.println("4.- Mostrar equipos de la liga");
		System.out.println("8.- Consulta XQuery");
		System.out.println("12.- Salir");
		System.out.println();
		System.out.println("Escriba el número de la opción que quiere ejecutar");
		
		int opcion = 0;
		
		do {			
			  try {
				reader = new Scanner(System.in);
			    opcion = reader.nextInt();
			    ejecutarOpcion(opcion);
			  } catch (InputMismatchException ime){
			    System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
			    reader.next();
			  }
			} while (opcion>0 && opcion<13);
		
	}
	
	public void ejecutarOpcion(int opcion) {
		
		switch(opcion) {
		case 1: //Importar liga
			   System.out.println("Importando liga del archivo ./xml/liga.xml");
			   try {
				ligaXML.importarLiga();
				System.out.println("Liga importada con éxito");
				System.out.println("Elija la opción 3 para ver los equipos que conforman la liga");
				esperar(2);
			   } catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Se ha producido un error inesperado");
				esperar(1);
			   }		   
		break;
		case 2: // Exportar liga
			System.out.println("Exportando liga al archivo ./xml/liga.xml");
			try {
				ligaXML.exportarLiga(ligaXML.getLiga());
				System.out.println("Liga exportada con éxito");
				esperar(2);
			   } catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Se ha producido un error inesperado");
				esperar(1);
			   } catch (IllegalArgumentException e) {
				   System.out.println("Liga actualmente inexistente, importala primero, o añade equipos por consola");
				   esperar(2);
			   }
			   
		break;
		
		case 3: //Crear liga
			Liga liga = new Liga(); //liga vacía inicialmente
			System.out.println("Inserte los equipos de forma manual");
			esperar(2);
			Scanner lectorEquipos;
			String respuesta = "";
			do {
				System.out.println("Introduzca los datos del nuevo equipo:");
				lectorEquipos = new Scanner(System.in);
				System.out.println("Introduce nombre del equipo:");
				String nombre =  lectorEquipos.nextLine();
				System.out.println("Introduce nombre del pais:");
				String pais =  lectorEquipos.nextLine();
				System.out.println("Introduce el número de títulos del equipo:");
				int titulos =  lectorEquipos.nextInt();
				System.out.println("Introduce nombre del entrenador del equipo:");
				String entrenador =  lectorEquipos.nextLine();
				System.out.println("Introduce nombre del presidente del equipo:");
				String presidente =  lectorEquipos.nextLine();
				Equipo equipoCreado = new Equipo(nombre,pais,titulos,entrenador,presidente);
				System.out.println("Equipo que acabas de crear:");
				System.out.println(equipoCreado);
				esperar(3);
				System.out.println("Pulse ok para añadirlo a la liga");
				String confirmacion = lectorEquipos.nextLine();
				if (confirmacion == "ok") {
					liga.addEquipo(equipoCreado);
					System.out.println("Equipo añadido a la liga");
				}
				System.out.println("Escriba \"no\" para finalizar la insercion de equipos o cualquier otra tecla para seguir añadiendo equipos ");
				respuesta = lectorEquipos.nextLine();
			} while (respuesta != "no");
			lectorEquipos.close();
			System.out.println("Creacion de la liga completada");
			esperar(2);
			ligaXML.setLiga(liga);
			
		break;
		
		case 4: // Mostrar equipos
			System.out.println("Mostrando los equipos de la liga:");
			esperar(2);
			try {
				ligaXML.getLiga().mostrarLiga();
			} catch (NullPointerException e) {
				System.out.println("Liga vacía, debes importarla o crearla primero");
				esperar(2);
			}
		break;
		case 8: // Consulta XQuery
			System.out.println("Elija una opción a continuación");
			System.out.println("1- Usar un documento xquery para hacer una consulta");
			System.out.println("2- Usar una consulta xquery predefinida");
			Scanner lecturaXQuery = new Scanner(System.in);
			int opcionXQuery = lecturaXQuery.nextInt();
			esperar(1);
			if (opcionXQuery == 1) {
				
			}
			else if (opcionXQuery == 2) {
				System.out.println("Escoge una consulta predefinida");
				System.out.println("1- Mostrar todos los equipos ordenados por número de títulos ganados");
				System.out.println("2- Nombre del presidente del Real Madrid");
				System.out.println("3- Todos los entrenadores de Francia");
			}
			break;
		case 12:
			System.exit(0);
		break;
		}
		
		cargarPanel();
		
	}
	
	
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	

}
