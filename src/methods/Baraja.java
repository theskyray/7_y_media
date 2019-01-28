package methods;

public class Baraja {

	private Carta carta;
	private Carta baraja[] = new Carta [40];
	
	public Baraja () {
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				baraja[k] = new Carta (i, j);
				k++;
			}
		}
	}
	
	public void sacarCarta() {
		int i = (int) (Math.random()*40);
		while (baraja[i].isCartaEnBaraja() == false) {
			i = (int) (Math.random()*40);
		}
		baraja[i].setCartaEnBaraja(false);
	}
	
	
	

}
