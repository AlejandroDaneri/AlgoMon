package clases;

import java.util.List;

import excepciones.AtaqueInvalidoException;
import excepciones.AtaquesAgotadosException;

public abstract class AlgoMon {
	
	private int vida;
	private List<Ataque> ataques;
	private Tipo tipo;
	private Estados estados;
	
	public AlgoMon(int vida, List<Ataque> ataques, Tipo tipo){
		this.setVida(vida);
		this.setAtaques(ataques);
		this.setTipo(tipo);
		this.setEstados(new Estados());
	}
	
	public void atacar(AlgoMon otro, String ataqueName) throws AtaquesAgotadosException{
		if(!this.tieneAtaque(ataqueName)) throw new AtaqueInvalidoException();
		if(!this.puedeAtacar()) return;
		for(Ataque ataque: ataques){
			if(ataque.equals(ataqueName)){
				ataque.atacar(this, otro);
			}
		}
	}
	
	private boolean puedeAtacar() {
		return this.getEstados().puedeAtacar();
	}

	public boolean tieneAtaque(String nombre) {
		boolean tiene = false;
		for(Ataque ataque: ataques){
			if(ataque.equals(nombre)) tiene = true;
		}
		return tiene;
	}
	
	public void disminuirVida(int puntos){
		this.setVida(this.getVida() - puntos);
	}
	
	public void nuevoTurno(){
		this.getEstados().nuevoTurno(this);
	}
	
	public void nuevoTurnoNoActivo(){
		this.getEstadoPersistente().nuevoTurno(this);
	}
	
	public Estado getEstadoPersistente(){
		return this.getEstados().getEstadoPersistente();
	}
	
	public void setEstadoEfimero(Estado estadoEfimero){
		this.getEstados().setEstadoEfimero(estadoEfimero);
	}
	
	public void setEstadoPersistente(Estado estadoPersistente){
		this.getEstados().setEstadoPersistente(estadoPersistente);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	

	public List<Ataque> getAtaques() {
		return ataques;
	}

	public void setAtaques(List<Ataque> ataques) {
		this.ataques = ataques;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	public boolean estaMuerto(){
		return this.getVida() <= 0;
	}
	
	public abstract String getNombre();

	public abstract int obtenerVidaOriginal();

}