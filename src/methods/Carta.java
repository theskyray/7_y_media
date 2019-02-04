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
	public int setValor() {
		return valor;
	}
	public void getValor (int nuevoValor) {
		this.valor = nuevoValor;
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
		String cadena = new String ("La carta es el " + Valor.values()[this.valor] + " de "
							+ Palo.values()[this.palo] + "; valor de CartaEnBaraja = " + this.CartaEnBaraja);
		return cadena;
	}
	
	//Carta en baraja
	public boolean isCartaEnBaraja() {
		return CartaEnBaraja;
	}
	
}
