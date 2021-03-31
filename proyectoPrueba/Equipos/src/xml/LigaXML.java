package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pojos.Liga;


public class LigaXML {
	
	private Liga liga;
	
	public void importarLiga() throws JAXBException {
		//unMarshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		// Leyendo un fichero
		File XMLfile = new File("./xml/liga.xml");
		// Creando el objeto
		liga = (Liga) jaxbU.unmarshal(XMLfile);
		// Escribiendo por pantalla el objeto
	}
	
	public void exportarLiga(Liga liga) throws JAXBException {
		//Marshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		// Escribiendo en un fichero
		File XMLfile = new File("./xml/liga.xml");
		jaxbM.marshal(liga, XMLfile);

	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	
	
	

}