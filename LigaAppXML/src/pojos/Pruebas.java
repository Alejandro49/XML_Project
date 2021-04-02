package pojos;

public class Pruebas {
	
	public static void main(String[] args) {
		// probando metodo equals
		Equipo equipo1 = new Equipo();
		equipo1.setNombre("Madrid");
		Equipo equipo2 = new Equipo();
		equipo2.setNombre("Madrid");
		
		Equipo equipo3 = new Equipo();
		equipo3.setNombre("Mierda");
		Equipo equipo4 = new Equipo();
		
		if (equipo1.equals(equipo2)) {
			System.out.println("Funciona bien");
		} else {
			System.out.println("La has cagado");
		}
				
		if ((equipo1 == equipo1) == true) {
			System.out.println("Test de identidad 2 correcto");
		}
		
		if (equipo1.equals(equipo3)) {
			System.out.println("La has cagado");
		} else {
			System.out.println("Funciona bien");
		}
		
		if (equipo1.equals(equipo4) == false) {
			System.out.println("Correcto");
		}
		
		if (equipo1.equals(null) == false) {
			System.out.println("Metodo equals infalible");
		}
		
		if (equipo1.equals(equipo1)) {
			System.out.println(" Metodo equals acabado");
		}
		
	}

}
