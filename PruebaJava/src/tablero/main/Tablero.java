package tablero.main;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Carro.Caguano;
import Carro.Carro;
import Carro.Huevo;
import Carro.Kromi;
import Carro.Trupalla;

public class Tablero extends JFrame {
	// Creacion de atributos Carros

	private final static long serialVersionUID = (long) 2.0;
	private JPanel jPanel1 = new JPanel();
	private JButton boton1 = new JButton();
	private JButton boton2 = new JButton();
	private JButton boton3 = new JButton();
	private JButton boton4 = new JButton();
	private JButton boton5 = new JButton();
	private JButton boton6 = new JButton();
	private JButton boton7 = new JButton();
	private String mensaje = "";
	private int total = 0;
	private int filas = 17;
	private int columnas = 17;
	private int trupallaT = 10;
	private int guanacoC = 5;
	private int MicroK = 3;
	private int mu = 0;
	private int ru = 0;
	private int instalartrupallasT = 0;
	private int instalarguanacoC = 0;
	private int instalarMicroK = 0;
	private int contadorJuego = 1;
	private int contadorhuevo = 0;
	private int contadorguanacoC = 0;
	private int contadorpatrullasT = 0;
	private int contadorMicroK = 0;
	private int activerecurso = 0;
	private int desbloqueados = 0;
	private int contadormultiplicador = 0;
	ArrayList<Carro> listaCarros = new ArrayList<Carro>(18);// listas
	ArrayList<Huevo> listaLanzaHuevo = new ArrayList<Huevo>();// listas
	public JButton metroCuadrado[][] = new JButton[filas][columnas];// tablero
	public String[][] mensajeClik = new String[filas][columnas]; // tablero por defecto

	public Tablero() { // Agarra excepciones y las muestra
		try {
			MostrarMatriz();

		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(null, message)
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
	}

	// Suma y mensajes variados

	public void mensajeSuperior(int i, int z) {
		metroCuadrado[i][z].setText(mensajeClik[i][z]);
		metroCuadrado[i][z].setEnabled(false);

		if (mensajeClik[i][z] == "H") { // falla intento
			metroCuadrado[i][z].setEnabled(false);
			mensaje = "Casi. Intentalo denuevo";
			this.setTitle(mensaje + " Total " + total + " Puntos");
		} else {

			if (metroCuadrado[i][z].getText() == "T") { // le da a trupalla
				total = total + 1; // suma puntaje
				mensaje = "Trupalla derrotada, ¡Sigue asi!"; // mensaje en titulo
				boton2.setText("1 Punto");
				this.setTitle(mensaje + " Total " + total + " Puntos");
				contadorpatrullasT++;

			}
			if (metroCuadrado[i][z].getText() == "C") { // le da a caguano
				total = total + 2; // puntaje
				mensaje = "Una parte de un Caguano, ¡Sigue asi!"; // mensaje
				boton2.setText("2 Puntos");
				this.setTitle(mensaje + " Total " + total + " Puntos");

				if (metroCuadrado[i + 1][z].getText() == "C" || metroCuadrado[i - 1][z].getText() == "C") {
					mensaje = "Caguano derrotado 2 puntos, mas 7 extra.";
					total = total + 7;
					boton2.setText("7 Puntos");
					this.setTitle(mensaje + " Total " + total + " Puntos");
					contadorguanacoC++;

				}
			}

			if (metroCuadrado[i][z].getText() == "K") { // le da a kromi
				mensaje = "Una parte de una Kromi, ¡Sigue asi!";
				total = total + 3;
				boton2.setText("3 Puntos");
				this.setTitle(mensaje + " Total " + total + " Puntos");
				if (metroCuadrado[i][z + 1].getText() == "K" && metroCuadrado[i][z - 1].getText() == "K"
						|| metroCuadrado[i][z + 2].getText() == "K" || metroCuadrado[i][z - 2].getText() == "K") {
					mensajekromi();
				}

//				if (z=14 && metroCuadrado[i][z - 1].getText() == "K" && metroCuadrado[i][z - 2].getText() == "K"){mensajekromi();};
//				if (z>13 && z>3)
//				if (z=2
//				if (z=1
//				if (

			}
		}

		if (contadorMicroK > 2 && contadorguanacoC > 4 && contadorpatrullasT > 8) {
			finalGame();
		}
	}

	public void mensajekromi() {
		mensaje = "Kromi derrotada 3 puntos, mas 10 extra.";
		total = total + 10;
		boton2.setText("10 Puntos");
		this.setTitle(mensaje + " Total " + total + " Puntos");
		contadorMicroK++;
	}

	// Fin ganar
	public void finalGame() {

		this.setTitle("Eres nombrado ''Awake Emerito'' ");
		boton1.setText("El Pueblo");
		boton2.setText("Se levantó");
		boton3.setText("Que huevos!!!");
		JOptionPane.showConfirmDialog(boton1, "Felicidades has ganado, ¿Reiniciar?");

	}

	public void LanzarHuevo() {

	}

	private void MostrarMatriz() throws Exception { // inicio del panel

		this.getContentPane().setLayout(null); // traemos y seteamos el panel
		this.setSize(new Dimension(696, 579)); // tamanio
		this.setTitle("Angry Eggs"); // titulo del juego

		jPanel1.setBounds(new Rectangle(0, 0, 527, 580)); // bordes
		jPanel1.setLayout(null); // sin layout

		// configuracion boton 1
		boton1.setText("Reinicio");
		boton1.setBounds(new Rectangle(00, 510, 170, 30));
		boton1.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 2
		boton2.setText("Total");
		boton2.setBounds(new Rectangle(170, 510, 170, 30));
		boton2.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 3
		boton3.setText("Rendirse");
		boton3.setBounds(new Rectangle(340, 510, 170, 30));
		boton3.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 4
		boton4.setText("Huevos");
		boton4.setBounds(new Rectangle(510, 0, 170, 170));
		boton4.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 5
		boton5.setText("Carros");
		boton5.setBounds(new Rectangle(510, 170, 170, 170));
		boton5.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 6
		boton6.setText("Caguanos");
		boton6.setBounds(new Rectangle(510, 340, 170, 170));
		boton6.setHorizontalTextPosition(SwingConstants.CENTER);

		// configuracion boton 7
		boton7.setText("lanzar 10");
		boton7.setBounds(new Rectangle(510, 510, 170, 30));
		boton7.setHorizontalTextPosition(SwingConstants.CENTER);

		// lector de acciones boton1
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton1_actionPerformed(e);
			}
		});
		// lector de acciones boton2
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				boton2_actionPerformed(f);
			}
		});
		// lector de acciones boton3
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				boton3_actionPerformed(g);
			}
		});
		// lector de acciones boton7
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				boton7_actionPerformed(k);
			}
		});
		
		// agregamos los botones y carros al panel
		getContentPane().add(boton1, null);
		getContentPane().add(boton2, null);
		getContentPane().add(boton3, null);
		getContentPane().add(boton4, null);
		getContentPane().add(boton5, null);
		getContentPane().add(boton6, null);
		getContentPane().add(boton7, null);
		getContentPane().add(jPanel1, null);
		cargarTablero();
		instalartrupallaT();
		instalarCromiK();
		instalarguanacoC();
		setVisible(true);
		cordenadametroCuadrado();
	}

//respuesta al apretar boton1 = reinicio Juego
	private void boton1_actionPerformed(ActionEvent e) {
		for (int i = 1; i < filas - 1; i++) {
			for (int z = 1; z < columnas - 1; z++) {
				mensajeClik[i][z] = "H"; // setea por defecto la casilla con H
				metroCuadrado[i][z].setEnabled(true);
				metroCuadrado[i][z].setText("");
			}
		}
		instalartrupallaT();
		instalarguanacoC();
		instalarCromiK();
		this.setTitle("Angry Eggs");
		this.setTitle("... A la carga!!!");
		activerecurso = 1;
	}

//respuesta al apretar boton2
	private void boton2_actionPerformed(ActionEvent f) {

	}

//respuesta al apretar boton3
	private void boton3_actionPerformed(ActionEvent g) {
		for (int i = 1; i < filas - 1; i++) {
			for (int z = 1; z < columnas - 1; z++) {
				textometroCuadrado();
			}
		}
		total = 0;
		boton2.setText(" " + total + " Puntos");
		this.setTitle("Si te caes 1 vez, te levantas 2 !!!");
	}
	// respuesta al apretar boton7

	private void boton7_actionPerformed(ActionEvent k) {
		if (desbloqueados > 215) {
			boton7.setText("Sigue de a 1");
		} else {
			do {
				mu = (int) (Math.random() * 15 + 1);
				ru = (int) (Math.random() * 15 + 1);
				if (metroCuadrado[mu][ru].isEnabled() == true) {
					mensajeSuperior(mu, ru);
					mensajesbatalla();
					desbloqueados++;
					contadormultiplicador++;
				}

			} while (contadormultiplicador < 10);
			contadormultiplicador = 0;
		}
	}

	// —– Cada Evento llama al método pulsarBoton.

	// creamos los 289 de botones de 30 por 20px, en 17 filas x 17columnas
	public void cargarTablero() {
		for (int i = 0; i < filas; i++) {
			for (int z = 0; z < columnas; z++) {
				mensajeClik[i][z] = "H";
				metroCuadrado[i][z] = new JButton();
				jPanel1.add(metroCuadrado[i][z]);
				metroCuadrado[i][z].setBounds(i * 30, z * 30, 30, 30);// los botones se desplazan al crearse
				metroCuadrado[i][z].setMargin(new Insets(0, 0, 0, 0));
				// escuchar click, solo en los botones interiores de 15 por 15
				metroCuadrado[i][z].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent escucharClik) {
						for (int i = 1; i < filas - 1; i++) {
							for (int z = 1; z < columnas - 1; z++) {
								if (escucharClik.getSource() == metroCuadrado[i][z]) {
									mensajeSuperior(i, z);
									mensajesbatalla();
									desbloqueados++;
									// —– Cada Evento llama al método pulsarBoton.

								}
							}
						}
					}

				});

			}
		}
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	public ArrayList<Huevo> getListaLanzaHuevo() {
		return listaLanzaHuevo;
	}

	public void setListaLanzaHuevo(ArrayList<Huevo> listaLanzaHuevo) {
		this.listaLanzaHuevo = listaLanzaHuevo;
	}

	public void mensajesbatalla() {
		contadorhuevo++;
		boton4.setText("<html><center>BATALLA <br><html>" + (contadorJuego) + "<html><center> TOTAL PUNTOS: <br><html>"
				+ total + "<html><center><br>< Huevos lanzados:<br> <html>" + contadorhuevo);
		boton5.setText("<html><center>CARROS DESTRUIDOS <br> Trupallas derrotadas: <br><html>" + contadorpatrullasT
				+ "<html><center><br> Caguanos derrotados: <br><html>" + contadorguanacoC
				+ "<html><center><br> Kromis derrotadas: <br><html>" + contadorMicroK);
	}
	// —- Coloca los carros al azar desde su clase principal.

	public void instalartrupallaT() {
		double I = 0;
		double Z = 0;
		do {
			I = Math.random() * getfilas();
			Z = Math.random() * getcolumnas();
			int i = (int) I;
			int z = (int) Z;

			{
				if (mensajeClik[i][z] != ("T") && mensajeClik[i][z] != ("C") && mensajeClik[i][z] != ("K") && i > 0
						&& i < 16 && z > 0 && z < 16) {
					mensajeClik[i][z] = ("T");
					instalartrupallasT++;
					Trupalla trupalla = new Trupalla(i, z);
					listaCarros.add(trupalla);
				}
			}
		} while (instalartrupallasT < gettrupallaT());
	}

	public void settrupallaT(int trupallaT) {
		trupallaT = trupallaT;
	}

	public int gettrupallaT() {
		return trupallaT;
	}

	public void instalarguanacoC() {
		double I = 0;
		double Z = 0;
		do {
			I = Math.random() * getfilas();
			Z = Math.random() * getcolumnas();
			int i = (int) I;
			int z = (int) Z;

			{
				if (mensajeClik[i][z] != ("T") && mensajeClik[i][z] != ("C") && mensajeClik[i][z] != ("K") && i > 0
						&& i < 15 && z > 0 && z < 16) {
					mensajeClik[i][z] = ("C");
					mensajeClik[i + 1][z] = ("C");
					instalarguanacoC++;
					Caguano caguano = new Caguano(i, z);
					listaCarros.add(caguano);
				}
			}
		} while (instalarguanacoC < getguanacoC());
	}

	public void setZorriloC(int guanacoC) {
		guanacoC = guanacoC;
	}

	public int getguanacoC() {
		return guanacoC;
	}

	public void instalarCromiK() {
		double I = 0;
		double Z = 0;
		do {
			I = Math.random() * getfilas();
			Z = Math.random() * getcolumnas();
			int i = (int) I;
			int z = (int) Z;

			{
				if (mensajeClik[i][z] != ("T") && mensajeClik[i][z] != ("C") && mensajeClik[i][z] != ("K") && i > 0
						&& i < 16 && z > 0 && z < 14) {
					mensajeClik[i][z] = ("K");
					mensajeClik[i][z + 1] = ("K");
					mensajeClik[i][z + 2] = ("K");
					instalarMicroK++;
					Kromi kromi = new Kromi(i, z);
					listaCarros.add(kromi);
				}
			}
		} while (instalarMicroK < getMicroK());
	}

	public void setMicroK(int sMicroK) {
		MicroK = sMicroK;
	}

	public int getMicroK() {
		return MicroK;
	}

	public void setfilas(int sfilas) {
		filas = sfilas;
	}

	public int getfilas() {
		return filas;
	}

	public void setcolumnas(int scolumnas) {
		columnas = scolumnas;
	}

	public int getcolumnas() {
		return columnas;
	}

	public void setmensaje(String smensaje) {
		mensaje = smensaje;
	}

	public String getmensaje() {
		return mensaje;
	}

	public void settotal(int stotal) {
		total = stotal;
	}

	public int gettotal() {
		return total;
	}

	// —- Escribo las coordenada en los laterales.
	public void cordenadametroCuadrado() {
		for (int i = 0; i < filas; i++) {
			for (int z = 0; z < columnas; z++) {
				if (z == 0 && i > 0 && i < columnas - 1) {
					metroCuadrado[i][z].setText("" + i);
				}
				if (z == filas - 1 && i > 0 && i < columnas - 1) {
					metroCuadrado[i][z].setText("" + i);
				}
				if (i == 0 && z > 0 && z < filas - 1) {
					metroCuadrado[i][z].setText("" + z);
				}
				if (i == columnas - 1 && z > 0 && z < filas - 1) {
					metroCuadrado[i][z].setText("" + z);
				}
			}
		}
	}

	// —- Muestra el texto en todos los metroCuadrado cuando hay paco,zorrillo o
	// micro.
	public void textometroCuadrado() {
		if (activerecurso == 0) {
			for (int i = 1; i < filas - 1; i++) {
				for (int z = 1; z < columnas - 1; z++) {
					metroCuadrado[i][z].setText(mensajeClik[i][z]);
					metroCuadrado[i][z].setEnabled(false);
					boton1.setText("¿Reiniciar?");
					contadorJuego++;
				}
			}
			activerecurso = 1;
		}
	}
}
