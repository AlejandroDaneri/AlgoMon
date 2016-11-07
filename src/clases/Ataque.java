package clases;

import excepciones.AtaquesAgotadosException;

public abstract class Ataque {
	
	private String nombre;
	private int potencia;
	private int cantidad;
	private Tipo tipo;
		
	public Ataque(String nombre, int potencia, int cantidad, Tipo tipo){
		this.setNombre(nombre);
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
	}
	
	public void atacar(AlgoMon atacante, AlgoMon atacado) throws AtaquesAgotadosException{
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
		(this.cantidad)--;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
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
	
	public boolean equals(String nombre){
		return this.nombre.equals(nombre);
	}
}
