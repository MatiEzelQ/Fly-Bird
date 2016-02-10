package ThreadPajaro;

import Graficos.Bird;
import Gravedad.Gravedad;

public class MovimientoPajaro extends Thread {

	static boolean enFuncionamiento = true;
	private boolean cambiarImagen = false;
	private int segundoXMillis = 1000;
	
	Bird bird = Bird.getInstance();
	
	public void run() {
		long tiempo = System.currentTimeMillis();
		final int segundo = 1000;
		
		
		while(enFuncionamiento){
	
			if(cambiarImagen){
				bird.setImage("/Users/MatiEzelQ/Documents/Java SE/Personal/2DGame/ImagenesFlappy/Personaje1.png");
				try {
					sleep(175);
				} catch (InterruptedException e) {
					System.out.println("Error en el sleep");
				}
				cambiarImagen = false;
			}else{
				bird.setImage("/Users/MatiEzelQ/Documents/Java SE/Personal/2DGame/ImagenesFlappy/Personaje2.png");
				try {
					sleep(175);
				} catch (InterruptedException e) {
					System.out.println("Error en el sleep");
				}
				cambiarImagen = true;
			}
			
			
			
		}
	
	}
	
	
	public static boolean getEnFuncionamiento() {
		return enFuncionamiento;
	}
	public static void setEnFuncionamiento(boolean enFuncionamientoo) {
		enFuncionamiento = enFuncionamientoo;
	}

	
	
	
	
	
	
}
