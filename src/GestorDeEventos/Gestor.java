package GestorDeEventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Graficos.Bird;
import Principal.Ventana;

public class Gestor implements KeyListener{

	Bird bird = Bird.getInstance();

	@Override
	public void keyTyped(KeyEvent e) {
		
		if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyChar() == ' '){
			bird.setY(bird.getY()-bird.getVelocidad());
		}
		
		/*else if(e.getKeyChar() == 's'){
			bird.setY(bird.getY()+bird.getVelocidad());
		}else if(e.getKeyChar() == 'd'){
			bird.setX(bird.getX()+bird.getVelocidad());
		}else if(e.getKeyChar() == 'a'){
			bird.setX(bird.getX()-bird.getVelocidad());
		}*/

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	


	
	
	
	
}
