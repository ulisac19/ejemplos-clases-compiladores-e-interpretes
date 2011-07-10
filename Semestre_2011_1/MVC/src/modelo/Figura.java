package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {

    protected Point posicion;
    protected boolean seleccionada;
    protected String descripcion;
    protected String var[];

    public abstract boolean dentroFigura(Point p);

    public abstract void dibujar(Graphics g);

    public abstract String getDescripcion();

    public abstract String[] getlenguajes();

    public abstract String get1lenguaje(int pos);

    public abstract void setlenguajes(String [] vari);

    public void eliminar() throws Throwable {
        this.posicion = new Point(5000, 5000);

    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;

    }

    public int getX() {
        return posicion.x;
    }

    public int getY() {
        return posicion.y;
    }

    Point getPosicion() {
        return posicion;
    }

    public boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean sel) {
        seleccionada = sel;
    }
}
