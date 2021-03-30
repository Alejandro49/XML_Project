package menu;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import pojos.Liga;
import xml.LigaXML;

public class PanelControl {
	
	LigaXML ligaXML = new LigaXML();
	Liga liga;
	
	public void desplegarOpciones() {
		
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Importar liga");
		System.out.println("2.- Exportar liga");
		System.out.println();
		System.out.println("Escriba el número de la opción que quiere ejecutar");
	}
	
	public void ejecutarOpcion(int opcion) {
		
		switch(opcion) {
		case 1:
			   System.out.println("Importando liga...");
			   try {
				liga = ligaXML.importarLiga();
				System.out.println("Liga importada con éxito");
				System.out.println("Elija la opción 3 para ver los equipos que conforman la liga");
				esperar(2);
				desplegarOpciones();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Se ha producido un error inesperado");
				System.out.println("Redirigiendo al panel de control");
				esperar(1);
				desplegarOpciones();
			}
			   
		break;
		case 2:
			   System.out.println("Introduzca el nombre del archivo que desea importar:");
		       Scanner entradaArchivo = new Scanner(System.in);
	           String nombreArchivo = entradaArchivo.nextLine();
	           
	           System.out.println("Importando "+nombreArchivo);
		break;
		
		}
		
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	

}
