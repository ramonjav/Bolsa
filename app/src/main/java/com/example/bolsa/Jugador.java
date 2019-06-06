package com.example.bolsa;

import java.util.HashMap;

public class Jugador {

    private final float INICAL = 1000;

    private float capital;
    private String nombre;
    private HashMap<Accion, Integer> acciones;

    public Jugador(float capital, String nombre, HashMap<Accion, Integer> acciones) {
        this.capital = this.INICAL;
        this.nombre = nombre;
        this.acciones = acciones;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<Accion, Integer> getAcciones() {
        return acciones;
    }

    public void setAcciones(HashMap<Accion, Integer> acciones) {
        this.acciones = acciones;
    }
}
