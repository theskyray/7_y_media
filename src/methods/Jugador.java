package methods;

import methods.Baraja;

public class Jugador {

	private Carta [] mano = new Carta [14];
	private boolean sePlanta;
	
	public Jugador() {

		mano[0] = Baraja.sacarCarta();
		sePlanta = false;
		
	}
	
	public String toString() {
		
		String cadena = "Las cartas del jugador son:\n";
		
		for (int i = 0; mano[i] != null; i++) {
			cadena = cadena + "\t" + mano[i].toString() + "\n";
		}
		return cadena;
	}
	
	//Método para plantarse
	public void plantarse() {
		this.sePlanta = true;
	}
	
	//Método para pedir carta
	public void pedirCarta() {
		int i;
		int j;
		for (i = 0;mano[i] != null; i++) {
		}
		
		mano[i] = Baraja.sacarCarta();
	}
	
}
