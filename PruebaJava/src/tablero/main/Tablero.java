package tablero.main;
import Carro.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Tablero extends JFrame{
	// Creacion de atributos Carros
	 
	   private final static long serialVersionUID = (long) 1.1;
	   private JPanel jPanel1 = new JPanel();
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
	   
	// listas
	ArrayList<Carro> listaCarros = new ArrayList<Carro>(18);
	ArrayList<Huevo> listaLanzaHuevo = new ArrayList<Huevo>();
	
	//tablero
	public JButton metroCuadrado[][] = new JButton[filas][columnas];
	public String[][] mensajeClik = new String[filas][columnas]; //tablero por defecto


	public Tablero() { //constructor vacio
		try {
		MostrarMatriz();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		}

	//public void CrearCarro() {
		
		//lista de carros creados
		
		//instalarCromiK();
		//instalarPacoT();
		//instalarZorrilloC();
		//getListaCarros();
	//}
	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		}

	// Suma y mensajes variados

	public void showTextTop(int i, int z) { // mensaje superior del jpanel
	metroCuadrado[i][z].setText(mensajeClik[i][z]);
	metroCuadrado[i][z].setEnabled(false);

	if (mensajeClik[i][z] == "") { //falla intento
	metroCuadrado[i][z].setEnabled(false);
	mensaje = "casi intentalo denuevo";
	} else {

	if (metroCuadrado[i][z].getText() == "T") { //le da a trupalla
	total = total + 1; //suma puntaje
	mensaje = "Trupalla derrotada, ¡Sigue asi!"; //mensaje en titulo
	jButton2.setText("1 Punto");
	this.setTitle(mensaje + " Total " + total + " Puntos");
	}
	if (metroCuadrado[i][z].getText() == "C") { // le da a caguano
	total = total + 2; // puntaje
	mensaje = "Una parte de un Caguano, ¡Sigue asi!"; // mensaje
	jButton2.setText("2 Puntos");
	this.setTitle(mensaje + " Total " + total + " Puntos");
	if (metroCuadrado[i + 1][z].getText() == "C" || metroCuadrado[i - 1][z].getText() == "C") {
	mensaje = "Caguano derrotado 2 puntos, mas 7 extra.";
	total = total + 7;
	jButton2.setText("7 Puntos");
	this.setTitle(mensaje + " Total " + total + " Puntos");
	}
	}

	if (metroCuadrado[i][z].getText() == "K") { // le da a kromi
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
	jButton1.setText("Abatiste a los malhechores , Felicitaciones");
	}
	
	public void LanzarHuevo() {

		}
		
	private void MostrarMatriz() throws Exception { // inicio del panel 

		this.getContentPane().setLayout(null); // traemos y seteamos el panel
		this.setSize(new Dimension(526, 579)); //tamanio
		this.setTitle("Angry Eggs"); // titulo del juego

		jPanel1.setBounds(new Rectangle(0, 0, 527, 580)); // bordes
		jPanel1.setLayout(null); // sin layout
//configuracion boton 1
		jButton1.setText("Reinicio"); 
		jButton1.setBounds(new Rectangle(00, 510, 170, 30));
		jButton1.setFont(new Font("Tahoma", 0, 12));
		jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
//configuracion boton 2
		jButton2.setText("Total");
		jButton2.setBounds(new Rectangle(170, 510, 170, 30));
		jButton2.setFont(new Font("Tahoma", 0, 12));
		jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
//configuracion boton 3
		jButton3.setText("Rendirse");
		jButton3.setBounds(new Rectangle(340, 510, 170, 30));
		jButton3.setFont(new Font("Tahoma", 0, 12));
		jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
//lector de acciones boton1 
		jButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		jButton1_actionPerformed(e);
		}
		});
//lector de acciones boton2
		jButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent f) {
		jButton2_actionPerformed(f);
		}
		});
//lector de acciones boton3
		jButton3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent g) {
		jButton3_actionPerformed(g);
		}
		});
//agregamos los botones al panel
		getContentPane().add(jButton1, null);
		getContentPane().add(jButton2, null);
		getContentPane().add(jButton3, null);
		getContentPane().add(jPanel1, null);
//cargamos el tablero y lo hacemos visible
		cargarTablero();
		instalarPacoT();
		instalarCromiK();
		instalarZorrilloC();
		setVisible(true);

// —- Los contornos no participan en el juego.
		cordenadametroCuadrado(); // le asigna numeros a los bordes para posiciones
		}
//respuesta al apretar boton1 = inicio Juego
		private void jButton1_actionPerformed(ActionEvent e) {
		for (int i = 1; i < filas - 1; i++) {
		for (int z = 1; z < columnas - 1; z++) {
		mensajeClik[i][z] = ""; //setea por defecto la casilla vacia
		metroCuadrado[i][z].setEnabled(true);
		metroCuadrado[i][z].setText("");
		}
		}
		instalarPacoT();
		instalarZorrilloC();
		instalarCromiK();
		this.setTitle("Angry Eggs");
		contadorJuego = contadorJuego + 1;
		jButton1.setText("Batalla " + contadorJuego);
		this.setTitle("... A la carga!!!");
		}
//respuesta al apretar boton2
		private void jButton2_actionPerformed(ActionEvent f) {
		}
//respuesta al apretar boton3
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
	public void cargarTablero() { // creamos tablero
			for (int i = 0; i < filas; i++) {
			for (int z = 0; z < columnas; z++) {
			mensajeClik[i][z] = "H";
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
	// —- Coloca el numero de bombas dependiendo el filas.

	public void instalarPacoT() {
	double I = 0;
	double Z = 0;
	int contadorpacosT = 0;
	do {
	I = Math.random() * getfilas();
	Z = Math.random() * getcolumnas();
	int i = (int) I;
	int z = (int) Z;
	Trupalla trupalla = new Trupalla(i,z);
	listaCarros.add(trupalla);
	{
	if (mensajeClik[i][z] != ("T") && i > 0 && i < 16 && z > 0 && z < 16) {
	mensajeClik[i][z] = ("T");
	contadorpacosT++;
	}
	}
	} while (contadorpacosT < getPacoT());
	}

	public void setPacoT(int sPacoT) {
	pacoT = sPacoT;
	}

	public int getPacoT() {
	return pacoT;
	}

	public void instalarZorrilloC() {
	double I = 0;
	double Z = 0;
	int contadorzorrilloC = 0;
	do {
	I = Math.random() * getfilas();
	Z = Math.random() * getcolumnas();
	int i = (int) I;
	int z = (int) Z;
	Caguano caguano = new Caguano(i,z);
	listaCarros.add(caguano);
	{
	if (mensajeClik[i][z] != ("T") && mensajeClik[i][z] != ("C") && i > 0 && i < 15 && z > 0
	&& z < 16) {
	mensajeClik[i][z] = ("C");
	mensajeClik[i + 1][z] = ("C");
	contadorzorrilloC++;
	}
	}
	} while (contadorzorrilloC < getzorrilloC());
	}

	public void setZorriloC(int sZorrilloC) {
	zorrilloC = sZorrilloC;
	}

	public int getzorrilloC() {
	return zorrilloC;
	}

	public void instalarCromiK() {
	double I = 0;
	double Z = 0;
	int contadorkromiK = 0;
	do {
	I = Math.random() * getfilas();
	Z = Math.random() * getcolumnas();
	int i = (int) I;
	int z = (int) Z;
	Kromi kromi = new Kromi(i,z);
	listaCarros.add(kromi);
	{
	if (mensajeClik[i][z] != ("T") && mensajeClik[i][z] != ("C") && mensajeClik[i][z] != ("K") && i > 0
	&& i < 16 && z > 0 && z < 14) {
	mensajeClik[i][z] = ("K");
	mensajeClik[i][z + 1] = ("K");
	mensajeClik[i][z + 2] = ("K");
	contadorkromiK++;
	}
	}
	} while (contadorkromiK < getkromiK());
	}

	public void setKromiK(int sKromiK) {
	kromiK = sKromiK;
	}

	public int getkromiK() {
	return kromiK;
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
	for (int i = 1; i < filas - 1; i++) {
	for (int z = 1; z < columnas - 1; z++) {
	metroCuadrado[i][z].setText(mensajeClik[i][z]);
	metroCuadrado[i][z].setEnabled(false);
	jButton1.setText("¿Reiniciar?");
	}
	}
	}

	
}
