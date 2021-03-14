package pojos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "equipos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipos implements Serializable {
	

	@XmlAtribute
	private int pais;
	@XmlElement
	private String equipo;
	@XmlElement
	private String titulos;
	@XmlElement
	private String entrenador;
	@XmlElement
	private String presidente;

	 public Equipos() {
         super();
 }

    public Equipos(String pais, String equipo, String titulo, String entrenador, String presidente) {
	         super();
	         this.pais = pais;
	         this.equipo = equipo;
	         this.titulos = titulos;
	         this.entrenador = entrenador;
	         this.presidente = presidente;
	 }
	
	
    	 public String getPais() {
	         return pais;
	 }
	
	 public void setPais(String pais) {
	         this.pais = pais;
	 }

	  public String getEquipo() {
	         return equipo;
	 }
	
	 public void setEquipo(String equipo) {
	         this.equipo = equipo;
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
                return "Equipos [pais=" + pais + ", equipo=" + equipo + ", titulos=" + titulos + ", entrenador="
                                + entrenador + ", presidente=" + presidente + "]";
        }

}
