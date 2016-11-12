package clases;

import java.util.concurrent.ThreadLocalRandom;

public class Partida {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private int turnos;
	private int turnoActual;
	
	public Partida(String nombre1, String nombre2) {
		Jugador jugador1 = new Jugador(0,nombre1);	// el 0/1 representan un indice arbitrario de turnos
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
		this.turnoActual = random % 2;
	}
	
	public void jugarPartida() {
		while(!this.juegoTerminado()) {
		    jugarTurnoActual();
		    turnos ++;
		    jugarTurnoActual();
		}
		System.out.print(this.nombreGanador());
	}
	
	public String nombreGanador(){
		if(jugador1.perdio()) return jugador2.getNombre();
		return jugador1.getNombre();
	}
	
	public Jugador jugadorActual(){
		if(this.turnoActual == this.jugador1.getIndiceTurno()) return jugador1;
		return jugador2;
	}
	
	public void jugarTurnoActual(){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.jugarTurno();	// Se podria armar algo en jugador pero esto va para la vista.
		this.nextTurno();
	}
	
	public boolean juegoTerminado(){
		return this.jugador1.perdio() || this.jugador2.perdio();
	}
	
	public void nextTurno(){
		turnoActual = (turnoActual + 1) % 2;
	}
}