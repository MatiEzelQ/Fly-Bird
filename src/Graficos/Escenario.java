package Graficos;

import Principal.Ventana;

public class Escenario extends Sprite {

private static Escenario escenario;
	
	public Escenario(String ruta,int x,int y,int altura,int anchura){
		super(ruta,x,y,altura,anchura);
	}


	public static Escenario getInstance(){
		if(escenario == null){
			escenario = new Escenario("/Users/MatiEzelQ/Documents/Java SE/Personal/2DGame/ImagenesFlappy/Escenario.png",0,0,Ventana.ALTURA,Ventana.ANCHO);
		}	
		return escenario;
	}

	

	
}
