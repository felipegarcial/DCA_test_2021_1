import processing.core.PApplet;

public class Cuadrado {

	private int posX, posY, tamX, tamY;
	private int direction;
	private boolean isMov;
	private PApplet app;

	public Cuadrado(int posX, int posY, int tamX, int tamY,PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
		isMov = true;
		this.app = app;
		direction = 1;
	}
	
	public void drawRect(){
		app.rect(posX,posY,tamX,tamY);
		mov();
	}

	private void mov() {
		if (isMov) {
			posY += (2*direction);
		}
	}

	public void setDirection(int direction) {
		this.direction = direction; 
	}
	
	public void setMov(boolean isMov) {
		this.isMov = isMov;
	}
	
	public boolean isMov() {
		return isMov;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getTamX() {
		return tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public int getDirection() {
		return direction;
	}


}
