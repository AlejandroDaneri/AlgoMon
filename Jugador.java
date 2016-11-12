package clases;

import java.util.ArrayList;
import excepciones.AlgoMonInexistenteException;
import excepciones.CantidadMaximaAlgoMonesException;

public class Jugador {
	
	private static int cantMaxAlgomones = 3;
	private String nombre;
	private int indiceTurno;
	private ArrayList<AlgoMon> algomones;
	private AlgoMon algomonActivo;
	//private ArrayList<Elemento> elementos;
	
	public Jugador(int indice,String nombre) {
		this.setNombre(nombre);
		this.setIndiceTurno(indice);
		this.algomones = new ArrayList<AlgoMon>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public AlgoMon getAlgomonActivo() {
		return algomonActivo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void actualizarEstados() {
		for(AlgoMon algomon: algomones) {
			algomon.nuevoTurno();
		}
	}
	
	public ArrayList<AlgoMon> getListaDeAlgomones() {
		return this.algomones;
	}
	
	public void setIndiceTurno(int indice){
		this.indiceTurno = indice;
	}
	
	public int getIndiceTurno() {
		return indiceTurno;
	}
	
	public int cantidadAlgomones(){
		return this.algomones.size();
	}
	
	public void agregarAlgomon(AlgoMon algomon) {
		if (algomones.size() >= cantMaxAlgomones) throw new CantidadMaximaAlgoMonesException();
		if (algomones.size() == 0) this.setAlgomonActivo(algomon);
		algomones.add(algomon);
	}
	
	public void cambiarDeAlgoMon(String algomon) {
		if(!this.tieneAlgomon(algomon)) throw new AlgoMonInexistenteException();
		for(AlgoMon algomonUser: algomones){
			if(algomonUser.getNombre().equals(algomon) && !algomonUser.estaMuerto()) this.setAlgomonActivo(algomonUser);
		}
	}
	
	public void setAlgomonActivo(AlgoMon algomon) {
		this.algomonActivo = algomon;
	}
	
	public boolean tieneAlgomon(String algomon) {
		boolean tiene = false;
		for(AlgoMon algomonUser: algomones){
			if(algomonUser.getNombre().equals(algomon)) tiene = true;
		}
		return tiene;
	}
	
	public AlgoMon primeraEleccion(){
		return this.algomones.get(0);
	}
	
	public boolean perdio(){
		for(AlgoMon algomon: algomones){
			if(!algomon.estaMuerto()) return false;
		}
		return true;
	}
	
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
	
}