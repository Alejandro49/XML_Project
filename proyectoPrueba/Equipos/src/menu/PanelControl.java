package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import com.sun.tools.javac.Main;

import pojos.Liga;
import xml.LigaXML;

public class PanelControl {
	
	LigaXML ligaXML = new LigaXML();
	Scanner reader;
	
	public void cargarPanel() {
		
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Importar liga");
		System.out.println("2.- Exportar liga");
		System.out.println("3.- Mostrar equipos de la liga");
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
		case 1:
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
		case 2:
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
		
		case 3:
			System.out.println("Mostrando los equipos de la liga:");
			esperar(2);
			try {
				ligaXML.getLiga().mostrarLiga();
			} catch (NullPointerException e) {
				System.out.println("Liga vacía, debes importarla primero");
				esperar(2);
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
