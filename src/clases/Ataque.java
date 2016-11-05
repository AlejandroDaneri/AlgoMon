package clases;

import excepciones.AtaquesAgotadosException;

public abstract class Ataque {

	private int potencia;
	private int cantidad;
	private Tipo tipo;
		
	public Ataque(int potencia, int cantidad, Tipo tipo){
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
	}
	
	public void atacar(AlgoMon atacante, AlgoMon atacado){
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
