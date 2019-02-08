package methods;

import methods.Baraja;

public class Jugador {

	private Carta [] mano = new Carta [14];
	private boolean sePlanta;
	private boolean sePasa;
	private boolean ganador;
	
	public Jugador() {

		mano[0] = Baraja.sacarCarta();
		sePlanta = false;
		sePasa = false;
		ganador = false;
		
	}
	
	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}
	
	public boolean isGanador() {
		return ganador;
	}
	
	public boolean getSePlanta() {
		return sePlanta;
	}
	
	public boolean getSePasa() {
		return sePasa;
	}
	
	public void setSePasa(boolean sePasa) {
		this.sePasa = sePasa;
	}
	
	public String toString() {
		
		String cadena = "Las cartas del jugador son:\n\n";
		
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
	public Carta pedirCarta() {
		int i;
		int j;
		for (i = 0;mano[i] != null; i++) {
		}
		
		return mano[i] = Baraja.sacarCarta();
	}
	
	//Método para contar la puntuación del jugador
	public float puntuacion() {
		float puntos = 0;
		
		for (int i = 0; mano[i] != null; i++) {
			
			if (mano[i].getValor() > 6) {
				puntos = (float) (puntos + 0.5);
			}
			
			else {
				puntos = puntos + (mano[i].getValor() + 1);
			}
			
		}
		
		return puntos;
	}
	
	
	
	//IA del jugador 1 (Máquina)
	public float decision(float maxPuntuacion, int i) {
		
		float probabilidad = 0;
		float desventaja = 0;
		
		if (maxPuntuacion > this.puntuacion() || i == 0) {
			desventaja = 20;
		}
		
			if (this.puntuacion() == 0.5) {
				probabilidad = (float) (100 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 1.0) {
				probabilidad = (float) (88 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 1.5) {
				probabilidad = (float) (79 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 2) {
				probabilidad = (float) (76 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			

			if (this.puntuacion() == 2.5) {
				probabilidad = (float) (65 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 3) {
				probabilidad = (float) (63 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 3.5) {
				probabilidad = (float) (54 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 4) {
				probabilidad = (float) (51 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 4.5) {
				probabilidad = (float) (42 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 5) {
				probabilidad = (float) (36 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 5.5) {
				probabilidad = (float) (26 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 6) {
				probabilidad = (float) (22 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 6.5) {
				probabilidad = (float) (14 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			
			if (this.puntuacion() == 7) {
				probabilidad = (float) (13 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
			if (this.puntuacion() == 7.5) {
				probabilidad = (float) (0 - (0.25 * (40 - Baraja.getCartasRestantes())) + desventaja);
			}
		return probabilidad;
		
	}
	
	public boolean iaRoba(float maxPuntuacion, int i) {
		
		boolean resp = false;
		
		if (this.decision(maxPuntuacion, i) >= 50) {
			this.pedirCarta();
			if (this.puntuacion() > 7.5) {
				resp = true;
				System.out.println("me pazé eje :3");
				setSePasa(true);
				}
			
			else {
				resp = false;
			}
			
		}
		
		else {
			this.sePlanta = true;
			resp = true;
		}
		
		return resp;

	}
	
	
}
