package Graficos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.Ventana;

public class Bird extends Sprite {
	
	private static Bird bird;
	
	private int velocidadFinal = 20;
	
	//P = m • g
	private Bird(String ruta,int x,int y,int altura,int anchura){
		super(ruta,x,y,altura,anchura);
		

	}

	public static Bird getInstance(){
		
		if(bird == null){
			bird = new Bird("/Users/MatiDaneri/Documents/ImagenesFlappy/Personaje1.png",Ventana.ANCHO/6,Ventana.ALTURA/2,20,20);
		}
		
		return bird;
	}

	
	
	
	//getters-seettters
	public int getVelocidad() {
		return velocidadFinal;
	}
	public void setVelocidad(int velocidad) {
		this.velocidadFinal = velocidad;
	}
	

	
}
