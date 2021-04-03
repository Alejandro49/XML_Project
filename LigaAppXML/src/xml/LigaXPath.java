package xml;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class LigaXPath {
    
	private void ejecutarXPathPredefinida(int n_sentencia) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
    	
		//Construir el DOM
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document doc = builder.parse("./xml/ligaPredefinida.xml"); //org.w3c.dom.Document

    	//Crear XPath
    	XPathFactory xpathfactory = XPathFactory.newInstance();
    	XPath xpath = xpathfactory.newXPath();
    
    	
    	String sentencia1 = "//Equipo/data(@nombre)"; //Mostrar el nombre de todos los equipos
    	String sentencia2 = "//Equipo[@pais=\"España\"]/data(@nombre)"; // Mostrar el nombre de los equipos españoles
    	String sentencia3 = "//Equipo[titulos>50]/data(@nombre)"; // Mostrar el nombre de los equipos con más de 50 titulo
    	String sentencia4 = "//Equipo[@pais=\"Inglaterra\"]/entrenador/text()"; // Mostrar los entrenadores de los equipos ingleses
    	String sentencia5 = "//Equipo[@nombre=\"Real Madrid\"]/presidente/text()"; // Mostrar el presidente del Real Madrid
    	
    	String xPathtxt = "";
    	
    	switch (n_sentencia) {
    	case 1:
    		xPathtxt = sentencia1;
    	break;
    	case 2:
    		xPathtxt = sentencia2;
    	break;
    	case 3:
    		xPathtxt = sentencia3;
    	break;
    	case 4:
    		xPathtxt = sentencia4;
    	break;
    	case 5:
    		xPathtxt = sentencia5;
    	break;
    	}
    	
    	XPathExpression expr = xpath.compile(xPathtxt); //javax.xml.xpath.XPathExpression
    	Object result = expr.evaluate(doc, XPathConstants.NODESET);
    	NodeList nodes = (NodeList) result; //org.w3c.dom.NodeList
    	for (int i = 0; i < nodes.getLength(); i++) {
    		esperar(1);
    	    System.out.println(processNode(nodes.item(i)));
    	}
    	esperar(2);
	}
	
	public void ejecutarXPath(String sentencia) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
    	
		//Construir el DOM
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document doc = builder.parse("./xml/ligaPredefinida.xml"); //org.w3c.dom.Document

    	//Crear XPath
    	XPathFactory xpathfactory = XPathFactory.newInstance();
    	XPath xpath = xpathfactory.newXPath();
    
    	String xPathtxt = sentencia;
    	   	
    	XPathExpression expr = xpath.compile(xPathtxt); //javax.xml.xpath.XPathExpression
    	Object result = expr.evaluate(doc, XPathConstants.NODESET);
    	NodeList nodes = (NodeList) result; //org.w3c.dom.NodeList
    	for (int i = 0; i < nodes.getLength(); i++) {
    	    System.out.println(processNode(nodes.item(i)));
    	}
	}
	
    public static String processNode(Node node) {
        String data = "";
        if(node.hasChildNodes()) {
            data += node.getNodeName() + ": ";
            NodeList nodes = node.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                data += processNode(nodes.item(i));}
        } else {
            data += node.getNodeValue();}
        return data;
    }
    
    public void xPathPredefinidas() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
    	mostrarConsultasPredefinidas();
    	System.out.println("Escriba el nº de sentencia que quiere ejecutar");
    	Scanner sc = new Scanner(System.in);
    	int sentencia = 0;
    	try {
    		sentencia = sc.nextInt();
    	} catch (InputMismatchException ime){
			System.out.println("Debes introducir un número entero. Vuelve a intentarlo");
			esperar(2);
			xPathPredefinidas();
		}
    	sc.nextLine();
    	if (sentencia>0 && sentencia<6) {
    		ejecutarXPathPredefinida(sentencia);
    		esperar(3);
    	} else {
    		System.out.println("Opcion incorrecta");
    	}
    	System.out.println("Escriba \"ok\" para seguir ejecutando consultas XPath");
		String confirmacion = sc.nextLine();
		if (confirmacion.equals("ok")) {
			xPathPredefinidas();
		} else {
			return;
		}
    }
    
    
    private void mostrarConsultasPredefinidas() {
    	System.out.println("1º Consulta: Mostrar el nombre de todos los equipos");
    	System.out.println("2º Consulta: Mostrar el nombre de los equipos españoles");
    	System.out.println("3º Consulta: Mostrar el nombre de los equipos con más de 50 titulos");
    	System.out.println("4º Consulta: Mostrar los entrenadores de los equipos ingleses");
    	System.out.println("5º Consulta: Mostrar el presidente del Real Madrid");
    }
    
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   

}