package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PintarPedido {
	
	Pedido pedido; 
	int x,y, tama; 
	PApplet app;
	PImage fries, hotdog, ice, sand; 
	
	public PintarPedido(Pedido pedido, int x, int y, PApplet app) {
		super();
		this.pedido = pedido;
		this.x = x;
		this.y = y;
		this.app = app;
		fries = app.loadImage("img/fries.jpg"); 
		hotdog = app.loadImage("img/hotdog.jpg"); 
		ice = app.loadImage("img/ice.jpg"); 
		sand = app.loadImage("img/sand.jpg"); 
		tama = 100; 
	}
	
	public void pintar() {
		switch (pedido.nombre) {
		case "sandwich":
			app.image(sand, x, y, tama,tama);
			//app.text(pedido.getNombre(), x, y);
			break;
		case "perro":
			app.image(hotdog, x, y, tama,tama);
			//app.text(pedido.getNombre(), x, y);
			break;
		case "papas":
			app.image(fries, x, y, tama,tama);
			//app.text(pedido.getNombre(), x, y);
			break;
		case "helado":
			app.image(ice, x, y, tama,tama);
			//app.text(pedido.getNombre(), x, y);
			break;

		default:
			break;
		}
		
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getTama() {
		return tama;
	}

	public void setTama(int tama) {
		this.tama = tama;
	} 
	
	
	
	
	

}
