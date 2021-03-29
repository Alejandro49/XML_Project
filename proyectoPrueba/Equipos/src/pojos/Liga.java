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
	private ArrayList<Equipo> Equipo;
	
	public Liga() {
		super();
		Equipo = new ArrayList<>();
	}

	public ArrayList<Equipo> getEquipo() {
		return Equipo;
	}

	public void setEquipo(ArrayList<Equipo> Equipo) {
		this.Equipo = Equipo;
	}
	
	public void addEquipo(Equipo e) {
		if(!Equipo.contains(e))
			Equipo.add(e);
	}
	
	public void removeEquipo(Equipo e) {
		Equipo.remove(e);
	}
}
