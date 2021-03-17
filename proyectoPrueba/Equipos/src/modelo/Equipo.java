package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "Equipo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"titulos", "entrenador", "presidente"})
public class Equipo  implements Serializable{

	private static final long serialVersionUID = -4723661295149279887L;
	
	@XmlAttribute
	private String nombre;
	@XmlAttribute
	private String pais;
	@XmlElement
	private String titulos;
	@XmlElement
	private String entrenador;
	@XmlElement
	private String presidente;
	
	
	public Equipo() {
		super();
	}
	
	public Equipo(String nombre, String pais, String titulos, String entrenador, String presidente) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.titulos = titulos;
		this.entrenador = entrenador;
		this.presidente = presidente;
	}

	public String getNombre() {
        return nombre;
	}

	public void setNombre(String nombre) {
	        this.nombre = nombre;
	}
	
	public String getPais() {
        return pais;
	}

	public void setPais(String pais) {
	        this.pais = pais;
	}
	
	 public String getTitulos() {
	        return titulos;
	}
	
	public void setTitulos(String titulos) {
	        this.titulos = titulos;
	}
	
	 public String getEntrenador() {
	        return entrenador;
	}
	
	public void setEntrenador(String pais) {
	        this.entrenador = entrenador;
	}
	
	
	 public String getPresidente() {
	        return entrenador;
	}
	
	public void setPresidente(String presidente) {
	        this.presidente = presidente;
	}
	@Override
	public String toString() {
		return "Equipo [Nombre=" + nombre + ", Pais=" + pais + ", Titulos=" + titulos + ", Entrenador="
				+ entrenador + ", Presidente=" + presidente + "]";
	}
}
