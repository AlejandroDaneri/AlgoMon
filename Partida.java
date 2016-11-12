package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Partida {
	
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Iterator<Jugador> iter;
	private int indiceTurno;

	public Partida(int indiceTurno) {
		Jugador jugadorAuxiliar1 = new Jugador();
		Jugador jugadorAuxiliar2 = new Jugador();
		this.definirOrdenDeLosJugadores(jugadorAuxiliar1, jugadorAuxiliar2);
		this.iter = jugadores.iterator();
	}

	private void definirOrdenDeLosJugadores(Jugador jugadorAuxiliar1,
			Jugador jugadorAuxiliar2) {
		ArrayList<Jugador> listaDeJugadores = new ArrayList<Jugador>();
		listaDeJugadores.add(jugadorAuxiliar1);
		listaDeJugadores.add(jugadorAuxiliar2);
		Random random = new Random();
		int index = random.nextInt(listaDeJugadores.size());
		this.jugadores.add(0, listaDeJugadores.get(index));
		if (index % 2 == 0) {
			this.jugadores.add(1, listaDeJugadores.get(1));
		}
		else this.jugadores.add(1, listaDeJugadores.get(0));
	}
	
	public void nuevoTurno() {
		if (iter.hasNext()) {
			iter.next().nuevoTurno();
		}
		else {
			this.iter = jugadores.iterator();
			iter.next().nuevoTurno();
		}		
	}
	
	public void recibirAlgomones(ArrayList<AlgoMon> algomonesJugador1,
			ArrayList<AlgoMon> algomonesJugador2) {
		this.getListaDeJugadores().get(0).setListaDeAlgomones(algomonesJugador1);
		this.getListaDeJugadores().get(1).setListaDeAlgomones(algomonesJugador2);	
	}
	
	private ArrayList<Jugador> getListaDeJugadores() {
	return jugadores;
	}
	
}