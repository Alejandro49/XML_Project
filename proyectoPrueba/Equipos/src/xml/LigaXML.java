package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pojos.Liga;


public class LigaXML {
	
	public Liga importarLiga() throws JAXBException {
		//unMarshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		// Leyendo un fichero
		File XMLfile = new File("./xml/liga.xml");
		// Creando el objeto
		Liga liga = (Liga) jaxbU.unmarshal(XMLfile);
		// Escribiendo por pantalla el objeto
		return liga;
	}
	
	

}
