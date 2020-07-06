package Carro;

import java.util.Arrays;

public class Kromi extends Carro {
	private final static String anio = "1999";
	private final static String marca = "Subus";
	char[] posicionX;
	char[] posicionY;
	int x, y;

	public Kromi(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY) {
		super(cantidadocupantes, fecha, posicionX, posicionY);
	}

	public Kromi(int x, int y) {
		super(x, y);

	}

	public char[] getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(char[] posicionX) {
		this.posicionX = posicionX;
	}

	public char[] getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(char[] posicionY) {
		this.posicionY = posicionY;
	}

	public static String getAnio() {
		return anio;
	}

	public static String getMarca() {
		return marca;
	}

	public Kromi(char[] posicionX, char[] posicionY) {
		super(posicionX, posicionY);
	}

	@Override
	public String toString() {
		return "Kromi [posicionX=" + Arrays.toString(posicionX) + ", posicionY=" + Arrays.toString(posicionY) + "]";
	}

}