package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Compilador extends Figura {

    private int ancho;
    private String lenguaje_final = "";
    private String lenguaje_fuente = "";
    private String lenguaje_base = "";

    public String getLenguaje_base() {
        return lenguaje_base;
    }

    public String getLenguaje_final() {
        return lenguaje_final;
    }

    public String getLenguaje_fuente() {
        return lenguaje_fuente;
    }

    public Compilador(Point posicion, int ancho) {
        super();
        this.descripcion = "Compilador";
        this.posicion = posicion;
        this.ancho = ancho;
        this.seleccionada = false;  //Deberia estar en el constructor pero por simplicidad
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAncho() {
        return ancho;
    }

    @Override
    //Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
    public boolean dentroFigura(Point p) {
        int difX = Math.abs(p.x - (posicion.x + (ancho / 2)));
        int difY = Math.abs(p.y - (posicion.y + (ancho / 2)));

        int difX1 = Math.abs(p.x - ((posicion.x - ancho) + (ancho / 2)));
        int difY1 = Math.abs(p.y - (posicion.y + (ancho / 2)));

        int difX2 = Math.abs(p.x - ((posicion.x + ancho) + (ancho / 2)));
        int difY2 = Math.abs(p.y - (posicion.y + (ancho / 2)));

        int difX3 = Math.abs(p.x - (posicion.x + (ancho / 2)));
        int difY3 = Math.abs(p.y - ((posicion.y + ancho) + (ancho / 2)));
        return (((difX3 < ancho / 2) && (difY3 < ancho / 2)) || ((difX2 < ancho / 2) && (difY2 < ancho / 2)) || ((difX < ancho / 2) && (difY < ancho / 2)) || ((difX1 < ancho / 2) && (difY1 < ancho / 2)));
    }

    @Override
    public void dibujar(Graphics g) {
        int xpuntos[] = new int[8];
        int ypuntos[] = new int[8];

        xpuntos[0] = this.getX() - ancho;
        xpuntos[1] = this.getX() - ancho;
        xpuntos[2] = this.getX();
        xpuntos[3] = this.getX();
        xpuntos[4] = this.getX() + ancho;
        xpuntos[5] = this.getX() + ancho;
        xpuntos[6] = this.getX() + 2 * ancho;
        xpuntos[7] = this.getX() + 2 * ancho;

        ypuntos[0] = this.getY();
        ypuntos[1] = this.getY() + ancho;
        ypuntos[2] = this.getY() + ancho;
        ypuntos[3] = this.getY() + 2 * ancho;
        ypuntos[4] = this.getY() + 2 * ancho;
        ypuntos[5] = this.getY() + ancho;
        ypuntos[6] = this.getY() + ancho;
        ypuntos[7] = this.getY();

        g.setColor(Color.BLUE);
        g.fillPolygon(xpuntos, ypuntos, 8);
        g.setColor(Color.BLACK);
        g.drawString(lenguaje_fuente, this.getX()-30, this.getY()+23);
        g.drawString(lenguaje_final, this.getX()+45, this.getY()+23);
        g.drawString(lenguaje_base, this.getX()+7, this.getY()+70);
    }

    @Override
    public String[] getlenguajes() {
        return this.var;
    }

    @Override
    public void setlenguajes(String[] vari) {
        this.var = vari;
        lenguaje_final = vari[1];
        lenguaje_fuente = vari[0];
        lenguaje_base =   vari[2];
    }

    @Override
    public String get1lenguaje(int pos) {
        return this.var[pos];
    }
}
