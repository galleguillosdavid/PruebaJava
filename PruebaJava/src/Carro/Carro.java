package Carro;

public class Carro {
	int cantidadocupantes;
	String fecha;
	char[] posicionX;
	char[] posicionY;
	int x,y;
	public Carro(int cantidadocupantes, String fecha, char[] posicionX, char[] posicionY) {
		super();
		this.cantidadocupantes = cantidadocupantes;
		this.fecha = fecha;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public Carro(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Carro(char[] posicionX, char[] posicionY) {}

}
