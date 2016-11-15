package clases;

import java.util.ArrayList;
import excepciones.AlgoMonInexistenteException;
import excepciones.AtaquesAgotadosException;
import excepciones.CantidadMaximaAlgoMonesException;

public class Jugador {
	
	private static int cantMaxAlgomones = 3;
	private String nombre;
	private int indiceTurno;
	private AlgoMon algomonActivo;
	private ArrayList<AlgoMon> algomones;
	private Elementos elementos;
	
	
	public Jugador(int indice,String nombre) {
		this.setNombre(nombre);
		this.setIndiceTurno(indice);
		this.algomones = new ArrayList<AlgoMon>();
		this.elementos = new Elementos();
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
		for(AlgoMon algomon: algomones){
			if(algomon == this.getAlgomonActivo()) continue;
			algomon.nuevoTurnoNoActivo();	// El turno no activo solo modifica los Estados Persistentes
		}
		algomonActivo.nuevoTurno();
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
			if(algomonUser.getClass().equals(algomon.getClass()) && !algomonUser.estaMuerto()) this.setAlgomonActivo(algomonUser);
		}
	}
	
	public void setAlgomonActivo(AlgoMon algomon) {
		this.algomonActivo = algomon;
	}
	
	public boolean tieneAlgomon(String algomon) {
		boolean tiene = false;
		for(AlgoMon algomonUser: algomones){
			if(algomonUser.getClass().equals(algomon.getClass())) tiene = true;
//			if(algomonUser.getNombre().equals(algomon)) tiene = true;
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
	
	public void atacar(AlgoMon oponente, String ataqueName) throws AtaquesAgotadosException {
		this.algomonActivo.atacar(oponente, ataqueName);	// La excepcion de AtaqueInvalido esta en atacar tmb
	}
	
	public void aplicarElemento(String elemento) {
		this.elementos.aplicar(elemento,this.algomonActivo);
	}
	
	public int vidaAlgomonActivo(){
		return algomonActivo.getVida();
	}
	
}