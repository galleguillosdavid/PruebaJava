package Carro;

import java.util.Arrays;

public class Caguano extends Carro {
	char[] posicionX;
	char[] posicionY;
	public final static int alcancetiro = 100;
	public final static String colorconfeti = "Verde";

	public Caguano(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY) {
		super(cantidadocupantes, fecha, posicionX, posicionY);

	}

	public Caguano(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY, char[] posicionX2,
			char[] posicionY2, int alcancetiro, String colorconfeti) {
		super(cantidadocupantes, fecha, posicionX, posicionY);
		posicionX = posicionX2;
		posicionY = posicionY2;
	}

	public Caguano(char[] posicionX, char[] posicionY) {
		super(posicionX, posicionY);

	}

	public Caguano(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "Caguano [posicionX=" + Arrays.toString(posicionX) + ", posicionY=" + Arrays.toString(posicionY)
				+ ", alcancetiro=" + alcancetiro + ", colorconfeti=" + colorconfeti + "]";
	}

}
