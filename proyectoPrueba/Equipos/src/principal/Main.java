package principal;

import java.util.Scanner;

import menu.PanelControl;

public class Main {
	
	static PanelControl panel = new PanelControl();
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la liga de las estrellas... cargando panel de control");
		esperar(3);
		panel.desplegarOpciones();
		int opcion;
		try (Scanner in = new Scanner(System.in)) {
				opcion = in.nextInt();
				System.out.println("Elegida opción " + opcion);	
				esperar(1);
		}
		
		panel.ejecutarOpcion(opcion);
		
		
		
		
		
		
		
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   

}
