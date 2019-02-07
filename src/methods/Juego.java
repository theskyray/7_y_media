package methods;

import java.util.Scanner;

public class Juego {

	public Scanner sc =  new Scanner (System.in);

	private int numJugadores;
	
	Baraja baraja = new Baraja();
	public Jugador [] jugadores = new Jugador [numJugadores];

	public Juego(int numJugadores) {
		
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador ();
		}
		
	}
	
	//Se elige al ganador
	public int ganador() {
		int l = 0;
		float maxPuntuacion = 0;
		for (int k = 0; k < jugadores.length; k++) {
			if (jugadores[k].getSePasa() == false) {
				if (maxPuntuacion == 0) {
					l = k;
					maxPuntuacion = jugadores[k].puntuacion();
				}
				else {
					if (maxPuntuacion < jugadores[k].puntuacion()) {
						l = k;
						maxPuntuacion = jugadores[k].puntuacion();
					}
				}
			}
		}
		return l;
	}
	
	//Puntuación máxima
	public float maxPuntuacion() {
		float maxPuntuacion = 0;
		for (int k = 0; k < jugadores.length; k++) {
			if (jugadores[k].getSePasa() == false) {
				if (maxPuntuacion == 0) {
					maxPuntuacion = jugadores[k].puntuacion();
				}
				else {
					if (maxPuntuacion < jugadores[k].puntuacion()) {
						maxPuntuacion = jugadores[k].puntuacion();
					}
				}
			}
		}
		return maxPuntuacion;

	}
	
}
