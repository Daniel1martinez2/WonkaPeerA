package main;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

import events.OnMessageLister;
import model.Pedido;
import model.PintarPedido;
import processing.core.PApplet;
import processing.core.PImage;

public class WPeerA extends PApplet implements OnMessageLister{
	UDPConnection udp; 
	
	PintarPedido test; 
	ArrayList <Pedido> pedidos;
	ArrayList <PintarPedido> representados; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.WPeerA");

	}
	public void settings() {
		size(1000,500); 
	}

	public void setup() {
		pedidos = new ArrayList<Pedido>(); 
		representados = new ArrayList<PintarPedido>(); 
		udp = new UDPConnection();
		udp.start(); 
		udp.setObserver(this);
		Date actual = new Date();
		Pedido pido = new Pedido("alo", 1, actual ); 
		test = new PintarPedido(pido,0,0,this); 
		
	}

	public void draw() {
		background(0,255,255); 
		fill(0); 
		//test.pintar();
		for(int i = 0; i < representados.size(); i++) {
			representados.get(i).pintar();
		}

		
	}
	@Override
	public void onPedidoRecived(Pedido pos) {
		pedidos.add(pos); 
		representados.add(new PintarPedido(pos, pedidos.size()*100, 0, this)); 
		System.out.println(pedidos.size());	
	}
	public void mousePressed() {
		/*Date d = new Date(); 
		Pedido pa = new Pedido("alo", 4, d); 
		Gson gson = new Gson(); 
		String currentP = gson.toJson(pa); 
		 udp.sendMessage(currentP);*/
		 
		for(int i = 0; i < representados.size(); i++) {
			listo(mouseX, mouseY,representados.get(i) ); 
		}	
	}
	public void listo (int x, int y, PintarPedido p) {
		
		if (x >= p.getX() && x<=  p.getX()+p.getTama()
		//&& y >= p.getY() && x<=  p.getY()+p.getTama()
				
				){
			
			//System.out.println(">>>>>>>>>>>kqdshfñbqnálsfña´bfasihfóahfágsfhña´sgfñagf");
			
			int indexP = pedidos.indexOf(p.getPedido()); 
			Pedido pa = p.getPedido(); 
			Gson gson = new Gson(); 
			String currentP = gson.toJson(pa); 
			 udp.sendMessage(currentP);
			 
			pedidos.remove(p.getPedido()); 
		    representados.remove(p); 
		    System.out.println(indexP+"aaaaaa");
		   
			
		}
		
	}

}
