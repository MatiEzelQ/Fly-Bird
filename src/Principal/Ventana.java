package Principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GestorDeEventos.Gestor;
import Graficos.Bird;
import Graficos.Escenario;
import Graficos.Sprite;
import Graficos.Tubos;
import Gravedad.Gravedad;
import ThreadPajaro.MovimientoPajaro;


public class Ventana extends JPanel implements Runnable{

	JButton iniciar;
	
	protected final String TITULO = "Flappy Birds";
	public final static int ALTURA = 400;
	public final static int ANCHO = 800;
	
	public long comienzoTiempo;
	
	protected boolean enFuncionamiento = false;
	
	protected JFrame ventana;

	MovimientoPajaro movimientoPajaro = new MovimientoPajaro();
	protected Thread threadPrincipal;

	Sprite bird;
	Sprite tuboUp;
	Sprite tuboDown;
	Sprite escenario;
	private int auxiliarTubo = ANCHO;//se usa en el método run, para ir moviendo el tubo del ancho hacia la izq.
	private int auxiliarAltoTubo = (int)(Math.random()*175);
	
	public Ventana() {
		ventana = new JFrame();
		ventana.setBounds(0,0,ANCHO,ALTURA);
		ventana.setTitle(TITULO);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setFocusable(true);//así el keyListener funka.
		
		//Boton---------Inicio.
		iniciar = new JButton("Iniciar");
		iniciar.setLocation(ANCHO/2,ALTURA/2);
		iniciar.setVisible(true);
		iniciar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				iniciar.setVisible(false);
				iniciar();
			}
		});
		
		add(iniciar);
		
		//Listener-----------
		
		ventana.addKeyListener(new Gestor());
		
		//LAMINA---------
		this.setBounds(0,0,ANCHO,ALTURA);
		ventana.add(this);
		
		//THREAD--------
		threadPrincipal = new Thread(this,"Graficos");
		movimientoPajaro.start();
		//Sprites----------
		cargarSprites();
		
		
		
		ventana.setVisible(true);
	}

	
	public synchronized void iniciar(){
		enFuncionamiento = true;
		
		threadPrincipal.start();
	}
	
	public synchronized void detener(){
		enFuncionamiento = false;
		
		try{
			threadPrincipal.join();
		}catch(Exception e){
			System.out.println("Error en join threadPrincipal");
		}
	}
	
	public void cargarSprites(){
		//tuboUp = new Tubos("/Users/MatiDaneri/Documents/ImagenesFlappy/Tubo1.png",0,0,150,40);
		//bird = new Bird("/Users/MatiDaneri/Documents/ImagenesFlappy/Personaje1.png",0,0,150,40);
		//escenario = new Sprite("/Users/MatiDaneri/Documents/ImagenesFlappy/Escenario.png",0,0,ALTURA,ANCHO);
		bird = Bird.getInstance();
		tuboDown  = new Tubos("/Users/MatiEzelQ/Documents/Java SE/Personal/2DGame/ImagenesFlappy/Tubo1.png",0,0,100,40);
		tuboUp = new Tubos("/Users/MatiEzelQ/Documents/Java SE/Personal/2DGame/ImagenesFlappy/Tubo2.png",0,0,100,40);
		escenario = Escenario.getInstance();


	}
	
	public void detectarColision(){
		Rectangle pajaro = new Rectangle(bird.getX(),bird.getY(),bird.getAncho(),bird.getAlto());
		Rectangle tuboDownC = new Rectangle(tuboDown.getX(),tuboDown.getY(),tuboDown.getAncho(),tuboDown.getAlto());
		Rectangle tuboUpC = new Rectangle(tuboUp.getX(),tuboUp.getY(),tuboUp.getAncho(),tuboUp.getAlto());

		if (pajaro.intersects(tuboDownC)) {
			bird.setY(bird.getY()-10);
		}

		if (pajaro.intersects(tuboUpC)) {
			bird.setY(bird.getY()-10);
		}

	}
	
	
	public void paintComponent(Graphics g) {
		//Fondo-------------
		for(int i=0;i<=ANCHO;i+=escenario.getAncho()){
			g.drawImage(escenario.getImage(), escenario.getX()+i, escenario.getY(),escenario.getAncho(),escenario.getAlto(),null);
		}
		//pajaro-----------
		g.drawImage(bird.getImage(), bird.getX(), bird.getY(), bird.getAlto(), bird.getAncho(), null);
		
		//tuboUp--------------
		tuboUp.setAlto(100);
		tuboDown.setAlto(100);
		tuboUp.setAncho(40);
		tuboDown.setAncho(40);
				
		dibujarTubos(g);
		
	}
	
	public void dibujarTubos(Graphics g){
		long nano = System.currentTimeMillis();
		final int nivel1Segundos = 1000;//1segundo-al comenzar tiene 0.9segundos para empezar digamos.Antes no dibuja.
		final int nivel2Segundos = 10000;//10s
		final int nivel3Segundos = 20000;
		final int nivel4Segundos = 30000;	
		
		
		
		if ((nano - comienzoTiempo) < nivel1Segundos ) {	
			//tiempo para prepararse.
			
		}else if ((nano - comienzoTiempo) < nivel2Segundos) {
			
			g.drawImage(tuboDown.getImage(), auxiliarTubo,ALTURA-auxiliarAltoTubo,tuboDown.getAncho(),auxiliarAltoTubo, null);
			g.drawImage(tuboUp.getImage(), auxiliarTubo,0,tuboUp.getAncho(),auxiliarAltoTubo, null);

		}else if  ((nano - comienzoTiempo) < nivel3Segundos) {
			
			g.drawImage(tuboDown.getImage(), auxiliarTubo,ALTURA-auxiliarAltoTubo,tuboDown.getAncho(),auxiliarAltoTubo, null);
			g.drawImage(tuboUp.getImage(), auxiliarTubo,0,tuboUp.getAncho(),auxiliarAltoTubo, null);

		}else if  ((nano - comienzoTiempo) < nivel4Segundos) {
			
			g.drawImage(tuboDown.getImage(), auxiliarTubo,ALTURA-auxiliarAltoTubo,tuboDown.getAncho(),auxiliarAltoTubo+100, null);
			g.drawImage(tuboUp.getImage(), auxiliarTubo,0,tuboUp.getAncho(),auxiliarAltoTubo+100, null);

		}

		
	}
	
	
	public void run() {
		comienzoTiempo = System.currentTimeMillis();//comienzoTiempo, inicio.(a que "hora" empezaste el juego)
		long tiempo = System.nanoTime();
		long tiempo2 = System.nanoTime();
		final int segundo = 1000000000 ;
		
		while(enFuncionamiento){
			long tiempoAux = System.nanoTime();
			
			if((tiempoAux - tiempo) > segundo/60){
				//Cada un segundo/20 ejecuta este código.
				Gravedad.gravity();//baja al pájaro x pixeles por (segundo/20)

			//	auxiliarTubo -= 10;//cada 1segundo/60, el tubo se mueve -10pixeles
				
				tiempo = System.nanoTime();
			}
			
			//TUBERIAS-MOVIMIENTO
			if((tiempoAux - tiempo2) > segundo/20){
				auxiliarTubo -= 10;//cada 1segundo/60, el tubo se mueve -10pixeles

				if (auxiliarTubo == -10){
					auxiliarTubo = ANCHO;
				}

				//Controla colision de pajaro y tuberias
				detectarColision();

				tiempo2 = System.nanoTime();
			}
			
			
			repaint();
		}



		
	}//run
	
	
	
	
	
}
