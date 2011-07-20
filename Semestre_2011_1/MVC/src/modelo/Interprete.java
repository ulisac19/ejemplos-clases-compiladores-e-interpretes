/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Interprete extends Figura {

    private int ancho;
    private String lenguaje_final;
    private String lenguaje_fuente;

    public Interprete(Point posicion, int ancho) {
        super();
        this.descripcion = "Interprete";
        this.posicion = posicion;
        this.ancho = ancho;
        this.seleccionada = false;  //Deberia estar en el constructor pero por simplicidad
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean dentroFigura(Point p) {
        int difX = Math.abs(p.x - (posicion.x + (ancho / 2)));
        int difY = Math.abs(p.y - ((posicion.y + (ancho))));

        return ((difX < ancho / 2) && (difY < ancho));
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(this.getX(), this.getY(), ancho, ancho * 2);
        if (this.getSeleccionada()) {
            g.setColor(Color.MAGENTA);
            g.fillRect(this.getX(), this.getY(), ancho, ancho * 2);
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
