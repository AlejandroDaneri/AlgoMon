package clases;

import java.util.concurrent.ThreadLocalRandom;

import excepciones.AtaquesAgotadosException;

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
	
	public Partida() {
		this.setOrdenJugadores();
		this.setTurnos();
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
	
	public String nombreGanador(){
		if(jugador1.perdio()) return jugador2.getNombre();
		return jugador1.getNombre();
	}
	
	public Jugador jugadorActual(){
		if(this.turnoActual == this.jugador1.getIndiceTurno()) return jugador1;
		return jugador2;
	}
	
	public Jugador jugadorOponente(){
		if(this.turnoActual != this.jugador1.getIndiceTurno()) return jugador1;
		return jugador2;
	}
	
	public void jugarTurnoActual(Ataque ataque) throws AtaquesAgotadosException{
		Jugador jugadorActual = jugadorActual();
		jugadorActual.atacar(this.jugadorOponente().getAlgomonActivo(), ataque);
		this.nextTurno();
		turnos++;
	}
	
	public void jugarTurnoActual(AlgoMon algomon){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.cambiarDeAlgoMon(algomon);
		this.nextTurno();
		turnos++;
	}
	
	public void jugarTurnoActual(Elemento elemento){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.aplicarElemento(elemento);
		this.nextTurno();
		turnos++;
	}
	
	public boolean juegoTerminado(){
		return this.jugador1.perdio() || this.jugador2.perdio();
	}
	
	public void nextTurno(){
		turnoActual = (turnoActual + 1) % 2;
	}
	
	public void agregarAlgomon(AlgoMon algomon){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.agregarAlgomon(algomon);
	}
}
