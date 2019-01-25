package methods;

public class Baraja {

	private Baraja baraja[] = new Baraja [40];
	
	public Baraja () {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				Carta carta = new Carta (i, j); 
			}
		}
	}

}
