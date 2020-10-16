package model;

import java.util.Date;

public class Pedido {

    String id, nombre;
    int numero;
    Date currentTime;


    public Pedido(String nombre, int numero, Date currentTime) {
        super();
        this.nombre = nombre;
        this.numero = numero;
        this.currentTime = currentTime;
    
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Date getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }



}
