package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.sun.tools.javac.Main;

import pojos.Equipo;
import pojos.Liga;
import xml.CheckDTD;
import xml.LigaXML;
import xml.LigaXPath;

public class PanelControl {
	
	LigaXML ligaXML = new LigaXML();
	
	CheckDTD validadorDTD;
	LigaXPath xpath = new LigaXPath();
	
	Scanner sc1;
	Scanner sc2;
	Scanner sc3;
	Scanner sc4;
	Scanner sc5;
	Scanner sc6;
	Scanner sc7;
	
	public void cargarPanel() { //sc1
		
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Inicializar liga predefinida");
		System.out.println("2.- Importar liga");
		System.out.println("3.- Exportar liga");
		System.out.println("4.- Crear liga");
		System.out.println("5.- Mostrar equipos de la liga");
		System.out.println("6.- Añadir equipo a la liga");
		System.out.println("7.- Borrar equipo de la liga");
		System.out.println("8.- Importar Equipo desde xml");
		System.out.println("9.- Exportar equipo a xml");
		System.out.println("10.- Validar liga con DTD");
		System.out.println("11.- Consultas XPath");
		System.out.println("12.- Consultas XQuery");
		System.out.println("13.- Salir");
		System.out.println();
		System.out.println("Escriba el número de la opción que quiere ejecutar");
		
		int opcion = 0;
		try {
			sc1 = new Scanner(System.in);
			opcion = sc1.nextInt();
			
		} catch (InputMismatchException ime){
			System.out.println("Debes introducir un número entero. Vuelve a intentarlo");
			esperar(2);
		}
		
		if (opcion>0 && opcion<14) {
			ejecutarOpcion(opcion);
		} else {
			System.out.println("Opción incorrecta. Vuelva a intentarlo");
			cargarPanel();
		}
		
	}
	
	public void ejecutarOpcion(int opcion) { //sc2
		
		switch(opcion) {
		case 1:
			inicializarLigaPredefinida();
		break;
		case 2: //Importar liga
			unmarshallLiga();		   
		break;
		case 3: // Exportar liga
			marshallLiga();
		break;
		case 4: //Crear liga
			crearLiga();
		break;
		case 5: // Mostrar equipos
			System.out.println("Mostrando los equipos de la liga:");
			esperar(2);
			try {
				ligaXML.getLiga().mostrarLiga();
			} catch (NullPointerException e) {
				System.out.println("Liga vacía, debes importarla o crearla primero");
				esperar(2);
			}
		break;
		case 6: // Añadir equipo manualmente
			if (ligaXML.getLiga() == null) {
				System.out.println("Liga inexistente, debes crearla o importarla primero para poder añadir equipos");
				esperar(2);
			} else {
				ligaXML.getLiga().leerEquipoDeTeclado();
			}
		break;
		case 7: // Borrar equipo mediante su nombre // sc6
			borrarEquipo();
		break;
		case 8: 
			unMarhallEquipo();
		break;
		case 9:
			marshallEquipo();
		break;
		case 10:
			validarLigaConDTD();
		break;
		case 11:
			consultasXPath();
		break;
		case 12: // Consulta XQuery
			//consultaXQuery();
			break;
		case 13:
			System.exit(0);
		break;
		}
		
		cargarPanel();
		
	}

	private void consultasXPath() {
		System.out.println("Seleccione una opción, las consultas se ejecutan sobre ./xml/ligaPredefinida.xml");
		System.out.println("1- Consultas XPath predefinidas");
		System.out.println("2- Insertar consulta propia (Seguir formato XPath)");
		System.out.println("3- Volver al menu principal");
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		try {
			opcion = sc.nextInt();
		} catch (InputMismatchException ime){
			System.out.println("Debes introducir un número entero. Vuelve a intentarlo");
			esperar(2);
			return;
		}
		
		if (opcion == 1) {
			try {
				xpath.xPathPredefinidas();
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion == 2) {
			System.out.println("Escriba a continuación la sentencia XPath que quiere ejecutar sobre ligaPredefinida.xml:");
			Scanner sc1 = new Scanner(System.in);
			String sentencia = sc1.nextLine();
			try {
				xpath.ejecutarXPath(sentencia);
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error de formato, volviendo al menu principal");
				esperar(2);
				return;
			}
		} else if (opcion == 3) {
			return;
		} else {
			System.out.println("Opcion incorrecta");
			esperar(2);
			return;
		}	
	}
	


	/*private void consultaXQuery() {
		System.out.println("Elija una opción a continuación");
		System.out.println("1- Usar un documento xquery para hacer una consulta");
		System.out.println("2- Usar una consulta xquery predefinida");
		Scanner sc8 = new Scanner(System.in);
		int opcionXQuery = sc8.nextInt();
		esperar(1);
		if (opcionXQuery == 1) {
			do {
				System.out.println("Introduce el nombre del documento que va a usar:")
				String nombreDocumento = sc8.nextLine();
			}while(nombreDocumento == "");
			
			
		}
		else if (opcionXQuery == 2) {
			System.out.println("Escoge una consulta predefinida");
			System.out.println("1- Mostrar todos los equipos ordenados por número de títulos ganados");
			System.out.println("2- Nombre del presidente del Real Madrid");
			System.out.println("3- Todos los entrenadores de Francia");
		}
	}
	*/
	
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
		Liga liga = new Liga(); //liga vacía inicialmente
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
			System.out.println("Escriba \"ok\" para añadirlo a la liga");
			String confirmacion = sc2.nextLine();
			if (confirmacion.equals("ok")) {
				liga.addEquipo(equipoCreado);
				System.out.println("Equipo añadido a la liga");
			}
			System.out.println("Escriba \"no\" para finalizar la insercion de equipos o cualquier otra tecla para seguir añadiendo equipos ");
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
			System.out.println("Ese equipo no está en la liga");
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
	}
	
	private void unmarshallLiga() { //sc7
		sc7 = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero de la liga a importar (debe de estar dentro de ./xml/Nombre_Fichero.xml)");
		String nombreFichero = sc7.nextLine();
		try {
			ligaXML.importarLiga(nombreFichero);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			return;
		} catch (IllegalArgumentException ex) {
			System.out.println("No se ha encontrado el archivo");
			esperar(2);
			return;
		}
		
		System.out.println("Liga importada correctamente");
		esperar(2);
	}
	
	

	private void inicializarLigaPredefinida() {
		System.out.println("Importando liga del archivo ./xml/ligaPredefinida.xml");
		   try {
			ligaXML.importarLigaPredefinida();
			System.out.println("Liga importada con éxito");
			System.out.println("Elija la opción Mostrar para ver los equipos que conforman la liga");
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
				System.out.println("Introduce el nº de títulos del equipo: ");
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
