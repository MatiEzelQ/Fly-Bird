package Graficos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {

	protected int x;
	protected int y;
	protected int ancho;
	protected int alto;
	
	protected BufferedImage image;
	
	public Sprite(String ruta,int x,int y,int altura,int anchura){
		cargarImagenes(ruta);
		
		this.x = x;
		this.y = y;
		this.ancho = anchura;
		this.alto = altura;
		
	}
	
	public void eliminarImg(int pos){
		//eliminar img
	}
		
	public void cargarImagenes(String ruta){
		try {
			image = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			System.out.println("Error al cargar la imagen");
		}
	}
	
	
	
	
	
	
	//GETTERS-SETTERS-----------
	public BufferedImage getImage(){
		return image;
	}
	public void setImage(String ruta){
		try {
			image = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			System.out.println("Error al cargar la imagen");
		}
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
}
