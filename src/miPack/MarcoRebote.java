package miPack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class MarcoRebote extends JFrame {

	public MarcoRebote() {

		setBounds(600, 300, 811, 509);

		setTitle("Rebotes");

		lamina = new LaminaPelota();
		lamina.setBackground(Color.WHITE);

		getContentPane().add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();
		
		arrancar1 = new JButton("Hilo 1");
		arrancar1.setBackground(Color.ORANGE);
		arrancar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});

		laminaBotones.add(arrancar1);
		
		arrancar2 = new JButton("Hilo 2");
		arrancar2.setBackground(Color.ORANGE);
		arrancar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});

		laminaBotones.add(arrancar2);
		
		arrancar3 = new JButton("Hilo 3");
		arrancar3.setBackground(Color.ORANGE);
		arrancar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});

		laminaBotones.add(arrancar3);
		
		detener1 = new JButton("detener 1");
		detener1.setBackground(Color.ORANGE);
		detener1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});

		laminaBotones.add(detener1);
		
		detener2 = new JButton("detener 2");
		detener2.setBackground(Color.ORANGE);
		detener2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});

		laminaBotones.add(detener2);
		
		detener3 = new JButton("detener 3");
		detener3.setBackground(Color.ORANGE);
		detener3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});

		laminaBotones.add(detener3);
//		ponerBoton(laminaBotones, "Dale!", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				comienza_el_juego();
//			}
//
//		});
//
//		ponerBoton(laminaBotones, "Salir", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				System.exit(0);
//
//			}
//
//		});
//		
//		ponerBoton(laminaBotones, "Detener", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				detener();
//
//			}
//
//		});

		getContentPane().add(laminaBotones, BorderLayout.SOUTH);
	}

	// Ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

	// Añade pelota y la bota 1000 veces

	public void comienza_el_juego(ActionEvent e) {

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		Runnable r = new PelotaHilos(pelota, lamina);
		
		if (e.getSource().equals(arrancar1)) {
			t1 = new Thread(r);
			t1.start();
		} else if (e.getSource().equals(arrancar2)) {
			t2 = new Thread(r);
			t2.start();
		} else {
			t3 = new Thread(r);
			t3.start();
		}
		

	}
	
	public void detener(ActionEvent e) {
		// t.stop(); is deprecated
		
		if (e.getSource().equals(detener1)) {
			t1.interrupt();
		} else if (e.getSource().equals(detener2)) {
			t2.interrupt();
		} else {
			t3.interrupt();
		}
	}

	private LaminaPelota lamina;
	private Thread t1;
	private Thread t2;
	private Thread t3;
	
	private JButton arrancar1, arrancar2, arrancar3;
	private JButton detener1, detener2, detener3;
}
