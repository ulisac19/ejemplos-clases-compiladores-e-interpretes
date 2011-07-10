package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Programa extends Figura {

    private int ancho;

    public String getLenguaje_fuente() {
        return lenguaje_fuente;
    }

    public void setLenguaje_fuente(String lenguaje_fuente) {
        this.lenguaje_fuente = lenguaje_fuente;
    }
    private String lenguaje_fuente;
    
    public int getAncho() {
        return ancho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getRadio() {
        return radio;
    }
    private int radio;

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Programa(Point posicion, int ancho) {
        this.descripcion = "Programa";
        this.posicion = posicion;
        this.ancho = ancho;
        this.radio = (int) (ancho * 0.75);
        this.seleccionada = false;  //Deberia estar en el constructor pero por simplicidad
    }

    @Override
    public boolean dentroFigura(Point p) {
        boolean bandera = false;

        int difX = Math.abs(p.x - (posicion.x + (ancho / 2)));
        int difY = Math.abs(p.y - ((posicion.y + (ancho))));

        if (radio >= Math.sqrt(Math.pow(p.x - (posicion.x + ancho / 2), 2) + Math.pow(p.y - (posicion.y - radio / 2), 2))) {
            bandera = true;
        }

        return (bandera || ((difX < ancho / 2) && (difY < ancho)));
    }

    @Override
    public void dibujar(Graphics g) {

        g.setColor(Color.yellow);
        g.fillRect(this.getX(), this.getY(), ancho, ancho * 2);
        g.fillOval(this.getX() - (int) (ancho * .25), this.getY() - ancho, this.radio * 2, this.radio * 2);
        if (this.getSeleccionada()) {
            g.setColor(Color.black);
            g.fillRect(this.getX(), this.getY(), ancho, ancho * 2);
            g.fillOval(this.getX() - (int) (ancho * .25), this.getY() - ancho, this.radio * 2, this.radio * 2);
        }
    }

    @Override
    public String[] getlenguajes() {
        return this.var;
    }

    @Override
    public void setlenguajes(String[] vari) {
        this.var = new String[vari.length];
        this.var = vari;
    }

    @Override
    public String get1lenguaje(int pos) {
        return this.var[pos];
    }
}
