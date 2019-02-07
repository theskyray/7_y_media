package methods;

public class Carta {
	
	private int palo;
	private int valor;
	private boolean CartaEnBaraja;
	
	public Carta(int Palo,  int Valor) {
		this.palo = Palo;
		this.valor = Valor;
		this.CartaEnBaraja = true;
	}
	
	//GET & SET PALO
	public int setPalo() {
		return palo;
	}
	public void getPalo (int nuevoPalo) {
		this.palo = nuevoPalo;
	}
	
	//GET & SET VALOR

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	//GET & SET CARTAENBARAJA
	public void setCartaEnBaraja(boolean cartaEnBaraja) {
		this.CartaEnBaraja = cartaEnBaraja;
	}
	public void getCartaEnBaraja (boolean nuevoCartaEnBaraja) {
		this.CartaEnBaraja = nuevoCartaEnBaraja;
	}
	
	//TOSTRING
	public String toString() {
		String cadena = new String (Valor.values()[this.valor] + " de "
							+ Palo.values()[this.palo]);
		return cadena;
	}
	
	//Carta en baraja
	public boolean isCartaEnBaraja() {
		return CartaEnBaraja;
	}
	
}
