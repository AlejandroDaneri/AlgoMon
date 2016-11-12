package clases;

import java.util.concurrent.ThreadLocalRandom;

public class Partida2 {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private int turnos;
	
	public Partida2(String nombre1, String nombre2) {
		Jugador jugador1 = new Jugador(0,nombre1);
		Jugador jugador2 = new Jugador(1,nombre2);
		this.setTurnos();
		this.setOrdenJugadores();
	}
	
	public void setTurnos() {
		this.turnos = 0;
	}
	
	public int getTurnos() {
		return turnos;
	}
	
	public void setOrdenJugadores() {
		int random = ThreadLocalRandom.current().nextInt(1, 3); // Genera num aleatorio entre 1 y 2.
		if(random == 1)
	}
	
	public void jugarPartida() {
		while(!this.juegoTerminado()) {
		    jugarTurnoActual();
		    turnos ++;
		    jugarTurnoActual();
		}
	}
	
	public boolean juegoTerminado(){
		return this.jugador1.cantidadAlgomones() == 0 || this.jugador2.cantidadAlgomones() == 0;
	}
}
