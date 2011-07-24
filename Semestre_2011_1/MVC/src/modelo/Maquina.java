package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Maquina extends Figura {

    private int ancho;
    private String lenguaje_final = "";

    public Maquina(Point posicion, int ancho) {
        super();
        this.descripcion = "Maquina";
        this.posicion = posicion;
        this.ancho = ancho;
        this.seleccionada = false;  //Deberia estar en el constructor de figura pero por simplicidad
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
    public boolean dentroFigura(Point p) {

        int difX = Math.abs(p.x - (posicion.x + (ancho / 2)));
        int difY = Math.abs(p.y - (posicion.y + (ancho / 4)));
        return ((difX < ancho / 2) && (difY < ancho / 4));
    }

    @Override
    public void dibujar(Graphics g) {

        int xpuntos[] = new int[5];
        int ypuntos[] = new int[5];

        ypuntos[0] = this.getY();
        ypuntos[1] = this.getY() + ancho / 2;
        ypuntos[2] = this.getY() + 2 * ancho;
        ypuntos[3] = this.getY() + ancho / 2;
        ypuntos[4] = this.getY();

        xpuntos[0] = this.getX();
        xpuntos[1] = this.getX();
        xpuntos[2] = this.getX() + ancho / 2;
        xpuntos[3] = this.getX() + ancho;
        xpuntos[4] = this.getX() + ancho;

        g.setColor(Color.ORANGE);
        g.fillPolygon(xpuntos, ypuntos, 5);
        g.setColor(Color.BLACK);
        g.drawString(lenguaje_final, this.getX() + 13, this.getY() + 17);
    }

    @Override
    public String[] getlenguajes() {
        return this.var;
    }

    @Override
    public void setlenguajes(String[] vari) {
        this.var = vari;
        lenguaje_final = vari[0];
    }

    @Override
    public String get1lenguaje(int pos) {
        return this.var[pos];
    }
}
