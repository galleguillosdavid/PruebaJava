package tablero.jframe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Visual extends JFrame {
	private final static long serialVersionUID = (long) 1.1;
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private String mensaje = "";
	private int total = 0;
	private int filas = 17;
	private int columnas = 17;
	private int pacoT = 10;
	private int zorrilloC = 5;
	private int kromiK = 3;
	private int contadorJuego = 1;
	public JButton metroCuadrado[][] = new JButton[filas][columnas];// botones x,y
	public String[][] Matriz = new String[filas][columnas]; // matriz

	public void cordenadametroCuadrado() { // coordenadas botones
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
		for (int i = 1; i < filas - 1; i++) {
			for (int z = 1; z < columnas - 1; z++) {
				metroCuadrado[i][z].setText(Matriz[i][z]);
				metroCuadrado[i][z].setEnabled(false);
				jButton1.setText("¿Reiniciar?");
			}
		}
	}

	// Suma y mensajes variados

	public void showTextTop(int i, int z) {
		metroCuadrado[i][z].setText(Matriz[i][z]);
		metroCuadrado[i][z].setEnabled(false);

		if (Matriz[i][z] == "") {
			metroCuadrado[i][z].setEnabled(false);
			mensaje = "casi intentalo denuevo";
		} else {

			if (metroCuadrado[i][z].getText() == "T") {
				total = total + 1;
				mensaje = "Trupalla derrotada, ¡Sigue asi!";
				jButton2.setText("1 Punto");
				this.setTitle(mensaje + " Total " + total + " Puntos");
			}
			if (metroCuadrado[i][z].getText() == "C") {
				total = total + 2;
				mensaje = "Una parte de un Caguano, ¡Sigue asi!";
				jButton2.setText("2 Puntos");
				this.setTitle(mensaje + " Total " + total + " Puntos");
				if (metroCuadrado[i + 1][z].getText() == "C" || metroCuadrado[i - 1][z].getText() == "C") {
					mensaje = "Caguano derrotado 2 puntos, mas 7 extra.";
					total = total + 7;
					jButton2.setText("7 Puntos");
					this.setTitle(mensaje + " Total " + total + " Puntos");
				}
			}

			if (metroCuadrado[i][z].getText() == "K") {
				mensaje = "Una parte de una Kromi, ¡Sigue asi!";
				total = total + 3;
				jButton2.setText("3 Puntos");
				this.setTitle(mensaje + " Total " + total + " Puntos");
				if (metroCuadrado[i][z + 2].getText() == "K" || metroCuadrado[i][z - 2].getText() == "K") {
					mensaje = "Kromi derrotada 3 puntos, mas 10 extra.";
					total = total + 10;
					jButton2.setText("10 Puntos");
					this.setTitle(mensaje + " Total " + total + " Puntos");
				}
			}

			if (total > 93) {
				finalGame();
			}
		}
	}

	// Fin ganar
	public void finalGame() {
		this.setTitle("Eres nombrado ''Awake Emerito'' ");
		jButton1.setText("Champeon");
	}

	private void jbInit() throws Exception {

		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(526, 579));
		this.setTitle("Angry Eggs");

		jPanel1.setBounds(new Rectangle(0, 0, 527, 580));
		jPanel1.setLayout(null);
		jPanel2.setBounds(new Rectangle(0, 0, 527, 580));
		jPanel2.setLayout(null);

		jButton1.setText("Reinicio");
		jButton1.setBounds(new Rectangle(00, 510, 170, 30));
		jButton1.setFont(new Font("Tahoma", 0, 12));
		jButton1.setHorizontalTextPosition(SwingConstants.CENTER);

		jButton2.setText("Total");
		jButton2.setBounds(new Rectangle(170, 510, 170, 30));
		jButton2.setFont(new Font("Tahoma", 0, 12));
		jButton2.setHorizontalTextPosition(SwingConstants.CENTER);

		jButton3.setText("Rendirse");
		jButton3.setBounds(new Rectangle(340, 510, 170, 30));
		jButton3.setFont(new Font("Tahoma", 0, 12));
		jButton3.setHorizontalTextPosition(SwingConstants.CENTER);

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				jButton2_actionPerformed(f);
			}
		});
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				jButton3_actionPerformed(g);
			}
		});
		getContentPane().add(jButton1, null);
		getContentPane().add(jButton2, null);
		getContentPane().add(jButton3, null);
		getContentPane().add(jPanel1, null);
		getContentPane().add(jPanel2, null);
		cargarTablero();

		setVisible(true);

		// —- Los contornos no participane en el juego.
		cordenadametroCuadrado();
	}

	private void jButton1_actionPerformed(ActionEvent e) {
		for (int i = 1; i < filas - 1; i++) {
			for (int z = 1; z < columnas - 1; z++) {
				Matriz[i][z] = "";
				metroCuadrado[i][z].setEnabled(true);
				metroCuadrado[i][z].setText("");
			}
		}

		this.setTitle("Angry Eggs");
		contadorJuego = contadorJuego + 1;
		jButton1.setText("Batalla " + contadorJuego);
		this.setTitle("... A la carga!!!");
	}

	private void jButton2_actionPerformed(ActionEvent f) {
	}

	private void jButton3_actionPerformed(ActionEvent g) {
		for (int i = 1; i < filas - 1; i++) {
			for (int z = 1; z < columnas - 1; z++) {
				textometroCuadrado();
			}
		}
		total = 0;
		jButton2.setText(" " + total + " Puntos");

		this.setTitle("Si te caes 1 vez, te levantas 2 !!!");
	}

	public void cargarTablero() {

		for (int i = 0; i < filas; i++) {
			for (int z = 0; z < columnas; z++) {
				Matriz[i][z] = "H";
				metroCuadrado[i][z] = new JButton();
				jPanel1.add(metroCuadrado[i][z]);
				metroCuadrado[i][z].setBounds(i * 30, z * 30, 30, 30);
				metroCuadrado[i][z].setMargin(new Insets(0, 0, 0, 0));
				metroCuadrado[i][z].setFont(new Font("Tahoma", 0, 13));

				// escuchar click

				metroCuadrado[i][z].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent escucharClik) {
						for (int i = 1; i < filas - 1; i++) {
							for (int z = 1; z < columnas - 1; z++) {
								if (escucharClik.getSource() == metroCuadrado[i][z]) {
									showTextTop(i, z);

									// —– Cada Evento llama al método pulsarBoton.
								}
							}
						}
					}
				});

			}
		}
	}

	public Visual() throws HeadlessException {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Visual(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Visual(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Visual(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
