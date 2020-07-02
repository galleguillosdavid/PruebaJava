package tablero.jframe;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaDos extends JFrame {
JPanel ventana = new JPanel();

public Ventana() {
	Toolkit pantalla = Toolkit.getDefault
}


	public VentanaDos() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public VentanaDos(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public VentanaDos(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public VentanaDos(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
