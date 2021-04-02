package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import com.sun.tools.javac.Main;

import pojos.Equipo;
import pojos.Liga;
import xml.CheckDTD;
import xml.LigaXML;

public class PanelControl {
	
	LigaXML ligaXML = new LigaXML();
	
	CheckDTD validadorDTD;
	
	Scanner sc1;
	Scanner sc2;
	Scanner sc3;
	Scanner sc4;
	Scanner sc5;
	Scanner sc6;
	
	public void cargarPanel() { //sc1
		
		System.out.println("�Que desea hacer?");
		System.out.println("1.- Importar liga");
		System.out.println("2.- Exportar liga");
		System.out.println("3.- Crear liga");
		System.out.println("4.- Mostrar equipos de la liga");
		System.out.println("5.- A�adir equipo a la liga");
		System.out.println("6.- Borrar equipo de la liga");
		System.out.println("7.- Importar Equipo desde xml");
		System.out.println("8.- Exportar equipo a xml");
		System.out.println("9.- Validar liga con DTD");
		System.out.println("10.- Consulta XQuery");
		System.out.println("12.- Salir");
		System.out.println();
		System.out.println("Escriba el n�mero de la opci�n que quiere ejecutar");
		
		int opcion = 0;
		try {
			sc1 = new Scanner(System.in);
			opcion = sc1.nextInt();
			
		} catch (InputMismatchException ime){
			System.out.println("Debes introducir un n�mero entero. Vuelve a intentarlo");
			esperar(2);
		}
		
		if (opcion>0 && opcion<13) {
			ejecutarOpcion(opcion);
		} else {
			System.out.println("Opci�n incorrecta. Vuelva a intentarlo");
			cargarPanel();
		}
		
	}
	
	public void ejecutarOpcion(int opcion) { //sc2
		
		switch(opcion) {
		case 1: //Importar liga
			unMarshallLiga();		   
		break;
		case 2: // Exportar liga
			marshallLiga();
		break;
		case 3: //Crear liga
			crearLiga();
		break;
		case 4: // Mostrar equipos
			System.out.println("Mostrando los equipos de la liga:");
			esperar(2);
			try {
				ligaXML.getLiga().mostrarLiga();
			} catch (NullPointerException e) {
				System.out.println("Liga vac�a, debes importarla o crearla primero");
				esperar(2);
			}
		break;
		case 5: // A�adir equipo manualmente
			if (ligaXML.getLiga() == null) {
				System.out.println("Liga inexistente, debes crearla o importarla primero para poder a�adir equipos");
				esperar(2);
			} else {
				ligaXML.getLiga().leerEquipoDeTeclado();
			}
		break;
		case 6: // Borrar equipo mediante su nombre // sc6
			borrarEquipo();
		break;
		case 7: 
			unMarhallEquipo();
		break;
		case 8:
			marshallEquipo();
		break;
		case 9:
			validarLigaConDTD();
		break;
		case 10: // Consulta XQuery
			consultaXQuery();
			break;
		case 12:
			System.exit(0);
		break;
		}
		
		cargarPanel();
		
	}

	private void consultaXQuery() {
		System.out.println("Elija una opci�n a continuaci�n");
		System.out.println("1- Usar un documento xquery para hacer una consulta");
		System.out.println("2- Usar una consulta xquery predefinida");
		Scanner sc8 = new Scanner(System.in);
		int opcionXQuery = sc8.nextInt();
		esperar(1);
		if (opcionXQuery == 1) {
			do {
				System.out.println("Introduce el nombre del documento que va a usar:")
				String nombreDocumento = sc8.nextLine();
			}while(nombreDocumento == "")
			
			
		}
		else if (opcionXQuery == 2) {
			System.out.println("Escoge una consulta predefinida");
			System.out.println("1- Mostrar todos los equipos ordenados por n�mero de t�tulos ganados");
			System.out.println("2- Nombre del presidente del Real Madrid");
			System.out.println("3- Todos los entrenadores de Francia");
		}
	}
	
	
	private void borrarEquipo() {
		if (ligaXML.getLiga() == null) {
			System.out.println("Liga inexistente.");
			esperar(2);
		} else {
			sc6 = new Scanner(System.in);
			System.out.println("Introduzca el nombre del equipo a borrar");
			String nombre = sc6.nextLine();
			boolean borrado = ligaXML.getLiga().removeEquipo(nombre);
			if (borrado==true) {
				System.out.println("Equipo eliminado correctamente");
				esperar(2);
			} else {
				System.out.println("No existe un equipo con ese nombre en la liga");
				esperar(2);
			}
		}
	}

	private void validarLigaConDTD() {
		System.out.println("Introduzca el documento xml a validar por DTD liga.dtd");
		System.out.println("El documento debe de estar en la carpeta ./xml/archivo.xml");
		System.out.println("Puede escribir si lo desea nuestro archivo por defecto para dtd. Escriba \"ligaDTD.xml\" para validar"
				+ " nuestra liga por defecto");
		validadorDTD = new CheckDTD();
		sc5 = new Scanner(System.in);
		String nombreArchivo = sc5.nextLine();
		validadorDTD.validarLiga(nombreArchivo);
		esperar(3);
	}

	private void crearLiga() {
		Liga liga = new Liga(); //liga vac�a inicialmente
		System.out.println("Inserte los equipos de forma manual");
		esperar(2);
		String respuesta = "";
		do {
			sc2 = new Scanner(System.in);
			System.out.println("Introduzca los datos del nuevo equipo:");
			System.out.println("Introduce nombre del equipo:");
			String nombre =  sc2.nextLine();
			System.out.println("Introduce nombre del pais:");
			String pais =  sc2.nextLine();
			int titulos = titulosEquipo();
			System.out.println("Introduce nombre del entrenador del equipo:");
			String entrenador =  sc2.nextLine();
			System.out.println("Introduce nombre del presidente del equipo:");
			String presidente =  sc2.nextLine();
			Equipo equipoCreado = new Equipo(nombre,pais,titulos,entrenador,presidente);
			System.out.println("Equipo que acabas de crear:");
			System.out.println(equipoCreado);
			esperar(3);
			System.out.println("Escriba \"ok\" para a�adirlo a la liga");
			String confirmacion = sc2.nextLine();
			if (confirmacion.equals("ok")) {
				liga.addEquipo(equipoCreado);
				System.out.println("Equipo a�adido a la liga");
			}
			System.out.println("Escriba \"no\" para finalizar la insercion de equipos o cualquier otra tecla para seguir a�adiendo equipos ");
			respuesta = sc2.nextLine();
		} while (respuesta.equals("no") == false);
		System.out.println("Creacion de la liga completada");
		esperar(2);
		ligaXML.setLiga(liga);
	}
	
	private void marshallEquipo() { //sc4
		sc4 = new Scanner(System.in);
		System.out.println("Introduzca el nombre exacto del equipo que quieres exportar");
		String nombre = sc4.nextLine();
		Equipo eq = new Equipo();
		eq.setNombre(nombre);
		try {
			eq = ligaXML.getLiga().getEquipo(eq);
		} catch (NullPointerException ex) {
			System.out.println("Error, liga inexistente, importala o creala primero");
			esperar(2);
			return;
		}
		if (eq == null) {
			System.out.println("Ese equipo no est� en la liga");
			esperar(2);
		} else {
			try {
				ligaXML.exportarEquipo(eq);
				String mensaje = "Equipo exportado a ./xml/" + eq.getNombre() + ".xml";
				System.out.println(mensaje);
				esperar(2);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}

	private boolean unMarhallEquipo() {
		Equipo equipo = new Equipo();
		sc3 = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero a importar (debe de estar dentro de ./xml/Nombre_Fichero.xml");
		String nombreFichero = sc3.nextLine();
		try {
			equipo = ligaXML.importarEquipo(nombreFichero);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			return false;
		} catch (IllegalArgumentException ex) {
			System.out.println("No se ha encontrado el archivo");
			esperar(2);
			return false;
		}
		if (ligaXML.getLiga() == null) {
			Liga liga2 = new Liga();
			liga2.addEquipo(equipo);
			ligaXML.setLiga(liga2);
		} else { 
			ligaXML.getLiga().addEquipo(equipo);
		}
		System.out.println("Se ha importado el equipo correctamente, seleccione la opcion mostrar para verlo");
		esperar(2);
		return true;
	}

	private void marshallLiga() {
		System.out.println("Exportando liga al archivo ./xml/ligaExportada.xml");
		try {
			ligaXML.exportarLiga(ligaXML.getLiga());
			System.out.println("Liga exportada con �xito");
			esperar(2);
		   } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			esperar(1);
		   } catch (IllegalArgumentException e) {
			   System.out.println("Liga actualmente inexistente, importala primero, o a�ade equipos por consola");
			   esperar(2);
		   }
	}
	
	

	private void unMarshallLiga() {
		System.out.println("Importando liga del archivo ./xml/liga.xml");
		   try {
			ligaXML.importarLiga();
			System.out.println("Liga importada con �xito");
			System.out.println("Elija la opci�n Mostrar para ver los equipos que conforman la liga");
			esperar(2);
		   } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			esperar(1);
		   }
		   
	}
	
	
	
	private int titulosEquipo() {
		int titulos = -1;
		Scanner lectorTitulos;
		do {
			try {
				lectorTitulos = new Scanner(System.in);
				System.out.println("Introduce el n� de t�tulos del equipo: ");
				titulos = lectorTitulos.nextInt();
			} catch (InputMismatchException ime){
				System.out.println("Debes introducir un numero entero carapan, no veas lo que cuesta gestionar excepciones...");
				esperar(2);
			}
			
		} while (titulos<0);
		
		return titulos;
	}

	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	

}