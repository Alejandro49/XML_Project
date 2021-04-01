package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Liga")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liga implements Serializable{

	private static final long serialVersionUID = -47891006084131330L;
	
	
	@XmlElement(name = "Equipo")
	private ArrayList<Equipo> liga;
	
	public Liga() {
		super();
		liga = new ArrayList<>();
	}
	
	
	public void addEquipo(Equipo e) {
		if(!liga.contains(e))
			liga.add(e);
	}
	
	public void removeEquipo(Equipo e) {
		liga.remove(e);
	}
	
	public void mostrarLiga() {
		if (liga == null || liga.isEmpty()) {
			System.out.println("Liga vacía, debes importarla o crearla primero");
			esperar(2);
		}
		for (Equipo equipo: liga) {
			esperar(1);
			System.out.println(equipo);
		}
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	public ArrayList<Equipo> getLiga() {
		return liga;
	}

	public void setLiga(ArrayList<Equipo> liga) {
		this.liga = liga;
	}
}
