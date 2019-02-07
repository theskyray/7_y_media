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
	public void decision(float maxPuntuacion) {
		
		float probabilidad = 0;
		float faltaPuntuacion = (float) (7.5 - this.puntuacion());
		
		if (this.puntuacion() < maxPuntuacion) {
			
			if (faltaPuntuacion == 0.5) {
				probabilidad = (float) (0.075 * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 1.0) {
				probabilidad = (float) ((0.075*2 + 0.025) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 1.5) {
				probabilidad = (float) ((0.075*3 + (0.025 + 0.075)) * Baraja.getCartasRestantes());
			}
			
			if (faltaPuntuacion == 2) {
				probabilidad = (float) ((0.075*4 + (0.025 + (0.075*2)) + (0.025*2) ) * Baraja.getCartasRestantes());
			}
			

			if (faltaPuntuacion == 2.5) {
				probabilidad = (float) ((0.075*5 + (0.025 + (0.075*3)) + ((0.025*2) + 0.075 ) + (0.025*2 + 0.075) ) * Baraja.getCartasRestantes());
			}
			
			
		}
		
	}
	
	
	
	
}
