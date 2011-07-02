package controlador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import modelo.Compilador;

import vista.Vista;
import modelo.Maquina;
import modelo.Figura;
import modelo.Interprete;
import modelo.Modelo;
import modelo.Programa;

public final class Controlador {

	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
        private JFrame frame;
        private  int seleccion;
        private JButton boton1;
        private JButton boton2;
        private JButton boton3;
        private JButton boton4;
        private JButton boton5;
        private JButton boton6;

	public Controlador(Modelo modelo, Vista vista,JFrame frame){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
                this.frame = frame;
                JMenuBar menu = new JMenuBar();
                menu = get_menu();
                this.frame.setJMenuBar(menu);
                this.seleccion = 0;



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

           boton1.addMouseListener( new java.awt.event.MouseAdapter()  {
                        public void mouseClicked( java.awt.event.MouseEvent e )
                        {
                            seleccion = 1;
                        }
                        });
           boton2.addMouseListener( new java.awt.event.MouseAdapter()  {
                        public void mouseClicked( java.awt.event.MouseEvent e )
                        {
                            seleccion = 2;
                        }
                        });
           boton3.addMouseListener( new java.awt.event.MouseAdapter()  {
                        public void mouseClicked( java.awt.event.MouseEvent e )
                        {
                            seleccion = 3;
                        }
                        });
           boton4.addMouseListener( new java.awt.event.MouseAdapter()  {
                        public void mouseClicked( java.awt.event.MouseEvent e )
                        {
                            seleccion = 4;
                        }
                        });
           boton6.addMouseListener( new java.awt.event.MouseAdapter()  {
                        public void mouseClicked( java.awt.event.MouseEvent e )
                        {
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

                this.frame.setLayout( new FlowLayout());
        }

	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}

	public void cambiarPosicion(Figura f, Point p){

		f.setPosicion(p);
	}

	public Vista getVista(){
		return vista;
	}

	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}

	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}

	public void eVmousePressed(MouseEvent ev) throws Throwable {
            if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			seleccionada=this.getFiguraEn(ev.getPoint());

                        if(null==seleccionada){

                            if(seleccion == 1){this.anyadirFigura(new Compilador(ev.getPoint(),40));}
                            if(seleccion == 2){this.anyadirFigura(new Maquina(ev.getPoint(),40));}
                            if(seleccion == 3){this.anyadirFigura(new Programa(ev.getPoint(),40));}
                            if(seleccion == 4){this.anyadirFigura(new Interprete(ev.getPoint(),40));}
                            
                        }else{
                        if(seleccion == 6){this.seleccionada.eliminar();  }
                        }

		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			//this.anyadirFigura(new Interprete(ev.getPoint(),40));
		System.out.println("nada");
                }else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			this.anyadirFigura(new Maquina(ev.getPoint(),40));
		}
		vista.repaint();

	}

	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){

			//El movimiento puede ser mas fluido recalculando el pto
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
                        boton1.setLocation(boton1.getX(), boton1.getY());
                boton1.setVisible(true);
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
		}
	
        }

        public JMenuBar get_menu()
        {

        
         JMenuBar menu = new JMenuBar();
                        final JMenu menu_cada = new JMenu("Insertar");
                        final JMenuItem compilador = new JMenuItem("Compilador");
                        final JMenuItem maquina = new JMenuItem("Maquina");
                        final JMenuItem programa = new JMenuItem("Programa");
                        final JMenuItem interprete = new JMenuItem("Interprete");
                        menu_cada.add(compilador);
                        menu_cada.add(maquina);
                        menu_cada.add(programa);
                        menu_cada.add(interprete);
                        menu_cada.addSeparator();
                        menu.add(menu_cada);
                        return menu;
        }

}
