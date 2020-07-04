package Carro;

import java.util.Arrays;
import java.util.Random;

public class Trupalla extends Carro {
	char[] posicionX;
	char[] posicionY;
	int x, y;
	Random random = new Random();
	int armadura = random.nextInt(5);
	String persona = "";

	public Trupalla(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY) {
		super(cantidadocupantes, fecha, posicionX, posicionY);
	}

	public Trupalla(int x, int y) {
		super(x, y);
	}

	public Trupalla(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY, char[] posicionX2,
			char[] posicionY2, int armadura, String persona) {
		super(cantidadocupantes, fecha, posicionX, posicionY);
		posicionX = posicionX2;
		posicionY = posicionY2;
		this.armadura = armadura;
		this.persona = persona;
	}

	public Trupalla(char[] posicionX, char[] posicionY) {
		super(posicionX, posicionY);
	}

	@Override
	public String toString() {
		return "Trupalla [posicionX=" + Arrays.toString(posicionX) + ", posicionY=" + Arrays.toString(posicionY)
				+ ", random=" + random + ", armadura=" + armadura + ", persona=" + persona + "]";
	}

}
