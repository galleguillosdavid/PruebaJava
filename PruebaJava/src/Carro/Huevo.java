package Carro;

import java.util.Arrays;

public class Huevo {
int ContadorHuevo =0;//contador de instancias
int total=0;//puntaje
char[] posicionX;
char[] posicionY;

	
	public Huevo(int contadorHuevo, int total, char[] posicionX, char[] posicionY) {
	super();
	ContadorHuevo = contadorHuevo;
	this.total = total;
	this.posicionX = posicionX;
	this.posicionY = posicionY;
	
}

	public int getContadorHuevo() {
		return ContadorHuevo;
	}

	public void setContadorHuevo(int contadorHuevo) {
		ContadorHuevo = contadorHuevo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Huevo [ContadorHuevo=" + ContadorHuevo + ", total=" + total + ", fila=" 
				+ ", columna="  + "]";
	}

	public Huevo() {
	}

}
