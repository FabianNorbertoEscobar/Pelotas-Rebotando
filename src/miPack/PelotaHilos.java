package miPack;

import java.awt.Component;

public class PelotaHilos implements Runnable {

	public PelotaHilos(Pelota pelota, Component componente) {
		this.pelota = pelota;
		this.componente = componente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/* for (int i = 1; i <= 5000; i++) { */

		//while (!Thread.interrupted()) 
		
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());

			componente.paint(componente.getGraphics());

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}

	}

	private Pelota pelota;
	private Component componente;
}
