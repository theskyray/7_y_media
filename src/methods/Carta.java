package methods;

public class Carta {
	
	private int Palo;
	private int Valor;
	private boolean CartaEnBaraja;
	
	public Carta(int Palo,  int Valor) {
		this.Palo = Palo;
		this.Valor = Valor;
		boolean CartaEnBaraja = true;
	}
	
	//GET & SET PALO
	public int setPalo() {
		return Palo;
	}
	public void getPalo (int nuevoPalo) {
		this.Palo = nuevoPalo;
	}
	
	//GET & SET VALOR
	public int setValor() {
		return Valor;
	}
	public void getValor (int nuevoValor) {
		this.Valor = nuevoValor;
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
		String cadena = new String ("Valor del palo = " + this.Palo + " valor de la carta = "
							+ this.Valor + " valor de CartaEnBaraja = " + this.CartaEnBaraja);
		return cadena;
	}
}
