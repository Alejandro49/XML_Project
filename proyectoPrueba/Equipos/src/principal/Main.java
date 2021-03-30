package principal;

import java.util.Scanner;

import menu.PanelControl;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la liga de las estrellas... cargando panel de control");
		esperar(3);
		PanelControl.desplegarOpciones();
		
		
		 try (Scanner in = new Scanner(System.in)) {
				int opcion = in.nextInt();
				System.out.println("Elegida opción " + opcion);	
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
