package Gravedad;

import Graficos.Bird;

public class Gravedad {

	static Bird bird = Bird.getInstance();

	private static int gravedad = 1;
	
	//Gravedad = 9,8metros por segundo
	//osea, nesecito saber metros y segundos hago por delta.
	
	public static void gravity(){
		//por segundo ya lo ejecuto en el método run con un if.
		bird.setY(bird.getY()+gravedad);
	}
	
}
