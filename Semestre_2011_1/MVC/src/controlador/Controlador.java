package controlador;

import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.Compilador;

import vista.Vista;
import modelo.Maquina;
import modelo.Figura;
import modelo.Interprete;
import modelo.Modelo;
import modelo.Programa;

public final class Controlador {

    class escuchador extends java.awt.event.MouseAdapter {

        public void mouseClicked(java.awt.event.MouseEvent e) {
            v = new String[n];
            if (n == 1) {
                if (lfuente.getText().compareTo("") == 0) {
                    v[0] = lfinal.getText();
                } else {
                    v[0] = lfuente.getText();
                }
            }
            if (n > 1) {
                v[0] = lfuente.getText();
                v[1] = lfinal.getText();
            }
            if (n == 3) {
                v[2] = lbase.getText();
            }
            seleccionada = getActual();
            seleccionada.setlenguajes(v);
            for (int i = 0; i < v.length; i++) {
                System.out.println(seleccionada.get1lenguaje(i));

            }
            lfuente.setText("");
            lfinal.setText("");
            lbase.setText("");
            System.out.println("Aceptó");

            


            pane.setVisible(false);
        }
    }

    private Modelo modelo;
    private Vista vista;
    private Figura seleccionada, f1, f2, f3, f4, f5, f6, actual;
    private JFrame frame;
    private int seleccion;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private boolean band;
    JDialog pane;
    JLabel tit, lfuent, lfina, lbas;
    JTextField lfuente, lfinal, lbase;
    JButton aceptar, cancelar;
    private int n = 0;
    String v[];

    public Controlador(Modelo modelo, Vista vista, JFrame frame) {
        this.modelo = modelo;
        band = false;
        this.vista = vista;
        seleccionada = null;
        this.frame = frame;
        this.seleccion = 0;

        pane = new JDialog();
        pane.setTitle("Diagramas T");
        pane.setBounds(300, 250, 217, 165);
        pane.setResizable(false);
        pane.setVisible(false);
        pane.setLayout(null);

        tit = new JLabel("LENGUAJES DEL COMPILADOR:");
        lfuente = new JTextField();
        lfinal = new JTextField();
        lbase = new JTextField();
        lfuent = new JLabel("Lenguaje fuente");
        lfina = new JLabel("Lenguaje final");
        lbas = new JLabel("Lenguaje base");
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");

        tit.setBounds(15, 5, 200, 20);
        lfuente.setBounds(105, 28, 100, 20);
        lfinal.setBounds(105, 51, 100, 20);
        lbase.setBounds(105, 74, 100, 20);
        lfuent.setBounds(5, 28, 100, 20);
        lfina.setBounds(5, 51, 100, 20);
        lbas.setBounds(5, 74, 100, 20);
        aceptar.setBounds(10, 102, 90, 20);
        cancelar.setBounds(110, 102, 90, 20);

        pane.getContentPane().add(tit);
        pane.getContentPane().add(lfuente);
        pane.getContentPane().add(lfinal);
        pane.getContentPane().add(lbase);
        pane.getContentPane().add(lfuent);
        pane.getContentPane().add(lfina);
        pane.getContentPane().add(lbas);
        pane.getContentPane().add(aceptar);
        pane.getContentPane().add(cancelar);
        pane.repaint();

        aceptar.addMouseListener(new escuchador());

        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                lfuente.setText("");
                lfinal.setText("");
                lbase.setText("");
                pane.setVisible(false);
            }
        });

        boton1 = new javax.swing.JButton("Compilador");
        boton2 = new javax.swing.JButton("Maquina");
        boton3 = new javax.swing.JButton("Programa");
        boton4 = new javax.swing.JButton("Interprete");
        boton5 = new javax.swing.JButton("Play");
        boton6 = new javax.swing.JButton("Eliminar");

        boton1.setBounds(0, 0, 100, 30);
        boton2.setBounds(100, 0, 100, 30);
        boton3.setBounds(200, 0, 100, 30);
        boton4.setBounds(300, 0, 100, 30);
        boton5.setBounds(400, 0, 100, 30);
        boton5.setBounds(500, 0, 100, 30);

        boton1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 1;
            }
        });
        boton2.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 2;
            }
        });
        boton3.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 3;
            }
        });
        boton4.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 4;
            }
        });
        boton5.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 5;
            }
        });
        boton6.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent e) {
                seleccion = 6;
            }
        });

        this.frame.getContentPane().add(boton1);
        this.frame.getContentPane().add(boton2);
        this.frame.getContentPane().add(boton3);
        this.frame.getContentPane().add(boton4);
        this.frame.getContentPane().add(boton5);
        this.frame.getContentPane().add(boton6);

        this.boton1 = boton1;
        this.boton2 = boton2;
        this.boton3 = boton3;
        this.boton4 = boton4;
        this.boton5 = boton5;
        this.boton6 = boton6;

        this.frame.setLayout(new FlowLayout());
    }

    public void mostrarVentana(int tipo) {
        pane.setVisible(true);

        switch (tipo) {
            case 1:
                n = 3;
                tit.setText("LENGUAJES DEL COMPILADOR");
                break;
            case 2:
                n = 2;
                tit.setText("LENGUAJES DEL INTERPRETE");
                lbase.setVisible(false);
                lbas.setVisible(false);
                break;
            case 3:
                n = 1;
                tit.setText("LENGUAJE DE LA MÁQUINA");
                lbase.setVisible(false);
                lbas.setVisible(false);
                lfuente.setVisible(false);
                lfuent.setVisible(false);
                break;
            case 4:
                n = 1;
                tit.setText("LENGUAJE DEL PROGRAMA");
                lbase.setVisible(false);
                lbas.setVisible(false);
                lfinal.setVisible(false);
                lfina.setVisible(false);
                break;
        }
    }

    public Figura obtenerFigura(Point posicion) {
        ListIterator<Figura> it = modelo.getListado().listIterator();
        while (it.hasNext()) {
            Figura tmp = it.next();
            if (tmp.dentroFigura(posicion)) {
                tmp.setSeleccionada(true);
                return tmp;
            }
        }
        return null;
    }

    public void cambiarPosicion(Figura f, Point p) {

        f.setPosicion(p);
    }

    public Vista getVista() {
        return vista;
    }

    public void anyadirFigura(Figura f) {
        modelo.anyadirFigura(f);
    }

    public Figura getFiguraEn(Point p) {
        return modelo.getFiguraEn(p);
    }

    public void eVmousePressed(MouseEvent ev) throws Throwable {
        if (ev.getClickCount() == 2) {

            Point p = new Point();
            p = ev.getPoint();
            seleccionada = this.getFiguraEn(p);
            setActual(seleccionada);
            if (seleccionada != null) {
                System.out.println(seleccionada.getDescripcion());
                lfuente.setVisible(true);
                lfinal.setVisible(true);
                lbase.setVisible(true);
                lfuent.setVisible(true);
                lfina.setVisible(true);
                lbas.setVisible(true);
                
                if (seleccionada.getDescripcion().compareTo("Compilador") == 0) {
                    mostrarVentana(1);
                }
                if (seleccionada.getDescripcion().compareTo("Interprete") == 0) {
                    mostrarVentana(2);
                }
                if (seleccionada.getDescripcion().compareTo("Maquina") == 0) {
                    mostrarVentana(3);
                }
                if (seleccionada.getDescripcion().compareTo("Programa") == 0) {
                    mostrarVentana(4);
                }
            }

        } else {



            if (SwingUtilities.isLeftMouseButton(ev)) { 			//Click boton izquierdo selecciona figura
                Point p = new Point();
                p = ev.getPoint();
                seleccionada = this.getFiguraEn(p);
                //---------------------------------------------------------------
                f1 = this.obtenerFigura(new Point((int) p.getX(), (int) p.getY() - 30));
                f2 = this.obtenerFigura(new Point((int) p.getX() + 30, (int) p.getY()));
                f3 = this.obtenerFigura(new Point((int) p.getX(), (int) p.getY() + 30));
                f4 = this.obtenerFigura(new Point((int) p.getX() - 30, (int) p.getY()));

                f5 = this.obtenerFigura(new Point((int) p.getX() + 80, (int) p.getY() + 80));
                f6 = this.obtenerFigura(new Point((int) p.getX() - 40, (int) p.getY() + 80));
                //---------------------------------------------------------------
                if (null == seleccionada) {

                    if (seleccion == 1) {
                        if (f5 != null && f5.getDescripcion().compareTo("Compilador") == 0) {
                            this.anyadirFigura(new Compilador(new Point((int) f5.getX() - 85, (int) f5.getY() - 45), 40));
                        } else if (f6 != null && f6.getDescripcion().compareTo("Compilador") == 0) {
                            this.anyadirFigura(new Compilador(new Point((int) f6.getX() + 85, (int) f6.getY() - 45), 40));
                        } else {
                            this.anyadirFigura(new Compilador(p, 40));
                        }
                    }
                    if (seleccion == 2) {
                        if (f1 != null && ((f1.getDescripcion().compareTo("Compilador") == 0) || f1.getDescripcion().compareTo("Interprete") == 0)) {
                            this.anyadirFigura(new Maquina(new Point((int) f1.getX(), (int) f1.getY() + 85), 40));
                        } else {
                            this.anyadirFigura(new Maquina(p, 40));
                        }
                    }

                    if (seleccion == 3) {
                        if (f2 != null && (f2.getDescripcion().compareTo("Compilador") == 0)) {
                            this.anyadirFigura(new Programa(new Point((int) f2.getX() - 85, (int) f2.getY() - 40), 40));
                        } else if (f4 != null && (f4.getDescripcion().compareTo("Compilador") == 0)) {
                            this.anyadirFigura(new Programa(new Point((int) f4.getX() + 85, (int) f4.getY() - 40), 40));
                        } else {
                            this.anyadirFigura(new Programa(p, 40));
                        }
                    }

                    if (seleccion == 4) {

                        if (f1 != null) {
                            this.anyadirFigura(new Interprete(new Point((int) f1.getX(), (int) f1.getY() + 85), 40));
                        } else if (f3 != null) {
                            this.anyadirFigura(new Interprete(new Point((int) f3.getX(), (int) f3.getY() - 85), 40));
                        } else {
                            this.anyadirFigura(new Interprete(p, 40));
                        }

                    }

                } else {
                    if (seleccion == 6) {
                        this.seleccionada.eliminar();
                    }
                }
                //-----------------------------
                if (seleccion == 5) {
                }
                //-----------------------------

            } else if (SwingUtilities.isRightMouseButton(ev)) {		//click boton izquierdo añade figura tipo cuadrado
                //this.anyadirFigura(new Interprete(ev.getPoint(),40));
               seleccionada = this.getFiguraEn( ev.getPoint() );
              v = seleccionada.getlenguajes();
             if( v != null ){
               if(seleccionada.getDescripcion().compareTo("Compilador") == 0)
               {
                   System.out.println("Lenguaje Fuente: " + v[0] );
                   System.out.println("Lenguaje Final: " + v[1] );
                   System.out.println("Lenguaje Base: " + v[2] );
               }else if(seleccionada.getDescripcion().compareTo("Interprete") == 0)
               {
                   System.out.println("Lenguaje Fuente: " + v[0] );
                   System.out.println("Lenguaje Final: " + v[1] );
               }else if(seleccionada.getDescripcion().compareTo("Maquina") == 0)
               {
                     System.out.println("Lenguaje Final: " + v[0] );
               }else if(seleccionada.getDescripcion().compareTo("Programa") == 0)
               {
                     System.out.println("Lenguaje Fuente: " + v[0] );
               }

            }

            } else if (SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
            {
                this.anyadirFigura(new Maquina(ev.getPoint(), 40));
            }


            vista.repaint();
        }

    }

    public void eVmouseDragged(MouseEvent ev) {

        if (seleccionada != null) {
            //El movimiento puede ser mas fluido recalculando el pto
            this.cambiarPosicion(seleccionada, ev.getPoint());
            band = true;
            vista.repaint();
        }
    }

    public void eVmouseReleased(MouseEvent ev) {       

        Point p = new Point( ev.getX(), ev.getY() );
        //---------------------------------------------------------------
                f1 = this.obtenerFigura(new Point((int) p.getX(), (int) p.getY() - 30));
                f2 = this.obtenerFigura(new Point((int) p.getX() + 30, (int) p.getY()));
                f3 = this.obtenerFigura(new Point((int) p.getX(), (int) p.getY() + 30));
                f4 = this.obtenerFigura(new Point((int) p.getX() - 30, (int) p.getY()));

                f5 = this.obtenerFigura(new Point((int) p.getX() + 80, (int) p.getY() + 80));
                f6 = this.obtenerFigura(new Point((int) p.getX() - 40, (int) p.getY() + 80));
                //---------------------------------------------------------------
        vista.repaint();
        if (seleccionada != null) {
            seleccionada.setSeleccionada(false);
           
            //**************************************************
            //**************************************************
             if (seleccionada.getDescripcion().compareTo("Compilador") == 0) {
                        if (f5 != null && f5.getDescripcion().compareTo("Compilador") == 0) {
                            seleccionada.setPosicion(new Point((int) f5.getX() - 85, (int) f5.getY() - 45));
                        } else if (f6 != null && f6.getDescripcion().compareTo("Compilador") == 0) {
                            seleccionada.setPosicion((new Point((int) f6.getX() + 85, (int) f6.getY() - 45)));
                        }
                    }
                    if (seleccionada.getDescripcion().compareTo("Maquina") == 0) {
                        if (f1 != null && ((f1.getDescripcion().compareTo("Compilador") == 0) || f1.getDescripcion().compareTo("Interprete") == 0)) {
                            seleccionada.setPosicion(new Point((int) f1.getX(), (int) f1.getY() + 85));
                        }
                    }

                   if (seleccionada.getDescripcion().compareTo("Programa") == 0) {
                        if (f2 != null && (f2.getDescripcion().compareTo("Compilador") == 0)) {
                            seleccionada.setPosicion(new Point((int) f2.getX() - 85, (int) f2.getY() - 40));
                        } else if (f4 != null && (f4.getDescripcion().compareTo("Compilador") == 0)) {
                           seleccionada.setPosicion(new Point((int) f4.getX() + 85, (int) f4.getY() - 40));
                        }
                    }

                     if (seleccionada.getDescripcion().compareTo("Interprete") == 0) {

                        if (f1 != null) {
                            seleccionada.setPosicion(new Point((int) f1.getX(), (int) f1.getY() + 85));
                        } else if (f3 != null) {
                            seleccionada.setPosicion(new Point((int) f3.getX(), (int) f3.getY() - 85));
                        }

                    }

            //**************************************************
            //**************************************************
            seleccionada = null;
        }

    }

    public Figura getActual() {
        return actual;
    }

    public void setActual(Figura actual) {
        this.actual = actual;
    }

    public void mouseClicked(MouseEvent evt) {

        if (evt.getClickCount() == 1) {
            System.out.println("doble clikc");
        }
    }
}
