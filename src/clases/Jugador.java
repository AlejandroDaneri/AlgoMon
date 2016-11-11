package clases;

import java.util.ArrayList;

import excepciones.AtaquesAgotadosException;

public class Jugador {

	private ArrayList<AlgoMon> listaDeAlgomones;
//	private int algomonActivo;
	
	public void nuevoTurno() {
		for(AlgoMon algomon: listaDeAlgomones) {
			algomon.nuevoTurno();
		}
	}
	
	public void setListaDeAlgomones(ArrayList<AlgoMon> lista) {
		this.listaDeAlgomones = lista;
	}
	
	public ArrayList<AlgoMon> getListaDeAlgomones() {
		return this.listaDeAlgomones;
	}
	
//	public void cambiarDeAlgoMon() {
//		if (algomonActivo == 2) algomonActivo = 0;
//		else algomonActivo++;
//	}
	
//	public void atacarConAlgomonActivo(AlgoMon oponente, String ataqueName) {
//		try {
//			this.getListaDeAlgomones().get(this.getAlgomonActivo()).atacar(oponente, ataqueName);
//		} catch (AtaquesAgotadosException e) {
//			// TODO Auto-generated catch block
//		}
//	}
	
//	public void aplicarElementoAlAlgomonActivo() {
//		
//	}

//	private int getAlgomonActivo() {
//		return this.algomonActivo;
//	}
	
}
