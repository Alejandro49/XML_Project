package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import modelo.*;

public class TestXML_simple {
        public static void main(String[] args) throws JAXBException, IOException {
                Equipo e = new Equipo();
                e.setNombre("Bayern de Múnich");
                e.setPais("Alemania");
                e.setEntrenador("Hans-Dieter Flick");
                e.setPresidente("Herbert Hainer");
                e.setTitulos(78);
               
                marshalling(e);
                //unMarshalling();
        }

        private static void marshalling(Equipo e) throws JAXBException {

                // Creamos el JAXBContext
                JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
                // Creamos el JAXBMarshaller
                Marshaller jaxbM = jaxbC.createMarshaller();
                // Formateo bonito
                jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE Equipo SYSTEM \"equipos.dtd\">");
                jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
                // Escribiendo en un fichero
                File XMLfile = new File("./xml/Equipo_1.xml");
                jaxbM.marshal(e, XMLfile);
        }

        private static void unMarshalling() throws JAXBException {
                // Creamos el JAXBContext
                JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
                // Creamos el JAXBMarshaller
                Unmarshaller jaxbU = jaxbC.createUnmarshaller();
                // Leyendo un fichero
                File XMLfile = new File("./xml/equipo_2.xml");
                // Creando el objeto
                Equipo e1 = (Equipo) jaxbU.unmarshal(XMLfile);
                // Escribiendo por pantalla el objeto
                System.out.println(e1);
        }

}