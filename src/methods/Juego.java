package methods;

public class Juego {

	private int numJugadores;
	
	Baraja baraja = new Baraja();
	public Jugador [] jugadores;

	public Juego(int numJugadores) {
		
		jugadores = new Jugador [numJugadores];
		
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador ();
		}
		
	}
	
	//Se elige al ganador
	public int ganador() {
		int l = 0, cont = 0, k = 0;
		float maxPuntuacion = 0;
		for (k = 0; k < jugadores.length; k++) {
			if (jugadores[k].getSePasa() == false) {
				if (k == 0) {
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
			
			else {
				cont++;
			}
			
		}
		
		if (cont == k) {
			l = -1;
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
