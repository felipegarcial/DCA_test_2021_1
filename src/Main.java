
import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {

	private ArrayList<Cuadrado> listaCuadrados;
	private Cuadrado cuadradito;

	public Main() {
	}

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		listaCuadrados = new ArrayList<Cuadrado>();
		// cuadradito = new Cuadrado(200, 100, 50, 50, this);
		rectMode(CENTER);
		frameRate(60);
	}

	public void draw() {
		background(255);
		initRects();
		rects();
		removeRects();
		// cuadradito.drawRect();
	}

	public void mousePressed() {
		clickRects();
	}

	private void initRects() {
		if (frameCount == 60) {
			int tam = (int) random(30, 60);
			int posX = (int) random(50, 750);
			listaCuadrados.add(new Cuadrado(posX, -50, tam, tam, this));
			System.out.println(listaCuadrados.size());
			frameCount = 0;
		}
	}
		
	private void rects() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			drawRects(listaCuadrados.get(i));
			//-----------
			bounce(listaCuadrados.get(i));
		}
	}
	
	private void drawRects(Cuadrado cuadrado) {
		cuadrado.drawRect();
	}
	
	private void bounce(Cuadrado cuadrado) {
		if(cuadrado.getPosY() >= height - (cuadrado.getTamY()/2)) {
			cuadrado.setDirection(-1);
		}
	}
	
	//Cambio git
	private void removeRects() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			if(listaCuadrados.get(i).getPosY() < -listaCuadrados.get(i).getTamY()/2 &&
					listaCuadrados.get(i).getDirection()==-1) {
				listaCuadrados.remove(i);
			}
		}
	}

	private void clickRects() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			if (mouseX > (listaCuadrados.get(i).getPosX() - (listaCuadrados.get(i).getTamX() / 2))
					&& mouseX < (listaCuadrados.get(i).getPosX() + (listaCuadrados.get(i).getTamX() / 2))
					&& mouseY > (listaCuadrados.get(i).getPosY() - (listaCuadrados.get(i).getTamY() / 2))
					&& mouseY < (listaCuadrados.get(i).getPosY() + (listaCuadrados.get(i).getTamY() / 2))) {
				listaCuadrados.get(i).setMov(!listaCuadrados.get(i).isMov());
			}
		}
	}
}
