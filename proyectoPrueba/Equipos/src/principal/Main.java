package principal;

import java.util.Scanner;

import menu.PanelControl;

public class Main {
	
	private static PanelControl panel = new PanelControl();
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la liga de las estrellas... cargando panel de control");
		esperar(3);
		panel.cargarPanel();
		
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   

}
