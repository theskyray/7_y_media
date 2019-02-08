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
	public float decision(float maxPuntuacion) {
		
		float probabilidad = 0;
		float faltaPuntuacion = (float) (7.5 - this.puntuacion());
					
			if (faltaPuntuacion == 0.5) {
				probabilidad = (float) (0.075 * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 1.0) {
				probabilidad = (float) ((0.175) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 1.5) {
				probabilidad = (float) ((0.325) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 2) {
				probabilidad = (float) ((0.55) * Baraja.getCartasRestantes());
			}
			

			if (faltaPuntuacion == 2.5) {
				probabilidad = (float) (( 0.85) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 3) {
				probabilidad = (float) ((1.3) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 3.5) {
				probabilidad = (float) ((1.825) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 4) {
				probabilidad = (float) ((2.35) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 4.5) {
				probabilidad = (float) ((3.4) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 5) {
				probabilidad = (float) ((6.65) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 5.5) {
				probabilidad = (float) ((14.425) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 6) {
				probabilidad = (float) ((33.63) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 6.5) {
				probabilidad = (float) ((73.736) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 7) {
				probabilidad = (float) ((100) * Baraja.getCartasRestantes());
			}
		return probabilidad;
		
	}
	
	public boolean iaRoba(float maxPuntuacion) {
		
		boolean resp = false;
		
		if (this.decision(maxPuntuacion) >= 50) {
			this.pedirCarta();
			if (this.puntuacion() > 7.5) {
				resp = true;
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
