package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.AtaqueInvalidoException;
import excepciones.AtaquesAgotadosException;

public abstract class AlgoMon {
	
	private int vida;
	private List<Ataque> ataques;
	private Tipo tipo;
	private Estados estados;
	
	public AlgoMon(int vida, Tipo tipo){
		this.setAtaques(new ArrayList<Ataque>());
		this.setVida(vida);
		this.setAtaques(ataques);
		this.setTipo(tipo);
		this.setEstados(new Estados());
	}
	
	public void atacar(AlgoMon otro, Ataque otroAtaque) throws AtaquesAgotadosException{
		if(!this.tieneAtaque(otroAtaque)) throw new AtaqueInvalidoException();
		if(!this.puedeAtacar()) return;
		for(Ataque ataque: ataques){
			if(ataque.equals(otroAtaque)){
				ataque.atacar(this, otro);
			}
		}
	}
	
	public boolean puedeAtacar() {
		return this.getEstados().puedeAtacar();
	}

	public boolean tieneAtaque(Ataque unAtaque) {
		boolean tiene = false;
		for(Ataque ataque: ataques){
			if(ataque.getClass().equals(unAtaque.getClass())) tiene = true;
		}
		return tiene;
	}
	
	public void disminuirVida(int puntos){
		this.setVida(this.getVida() - puntos);
	}
	
	public void aumentarVida(int puntos){
		int vidaAumentada = this.getVida() + puntos;
		if( vidaAumentada > this.obtenerVidaOriginal() ) this.setVida(this.obtenerVidaOriginal());
		else this.setVida(vidaAumentada);
	}
	
	public void nuevoTurno(){
		this.getEstados().nuevoTurno(this);
	}
	
	public boolean equals(AlgoMon otroAlgoMon){
		return this.getClass().equals(otroAlgoMon.getClass());
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
	
	public void agregarAtaque(Ataque unAtaque) {
		this.ataques.add(unAtaque);
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
	
	public List<Estado> getListaDeEstados(){
		return estados.getListaDeEstados();
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	public boolean estaMuerto(){
		return this.getVida() <= 0;
	}
	
	public abstract int obtenerVidaOriginal();

}