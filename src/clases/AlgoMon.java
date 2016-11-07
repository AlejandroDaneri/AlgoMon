package clases;

import java.util.List;

import excepciones.AtaqueInvalidoException;
import excepciones.AtaquesAgotadosException;

public abstract class AlgoMon {
	private int vida;
	private List<Ataque> ataques;
	private Tipo tipo;
	
	public AlgoMon(int vida, List<Ataque> ataques, Tipo tipo){
		this.setVida(vida);
		this.setAtaques(ataques);
		this.setTipo(tipo);
	}
	
	public void atacar(AlgoMon otro, String ataqueName) throws AtaquesAgotadosException{
		if(!this.tieneAtaque(ataqueName)) throw new AtaqueInvalidoException();
		for(Ataque ataque: ataques){
			if(ataque.equals(ataqueName)){
				ataque.atacar(this, otro);
			}
		}
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
}
