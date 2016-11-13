package clases;

import excepciones.AtaquesAgotadosException;

public abstract class Ataque {
	
	private String nombre;
	private int potencia;
	private int cantidad;
	private Tipo tipo;
	private Accion accion;
		
	public Ataque(String nombre, int potencia, int cantidad, Tipo tipo, Accion accion){
		this.setNombre(nombre);
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
		this.setAccion(accion);
	}
	
	public Ataque(String nombre, int potencia, int cantidad, Tipo tipo){
		this.setNombre(nombre);
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
		this.setAccion(new AccionNula());
	}
	
	public void atacar(AlgoMon atacante, AlgoMon atacado) throws AtaquesAgotadosException{
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		this.getAccion().actuar(atacante, atacado);
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
		this.reducirCantidadDeAtaque();
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
	
	public void reducirCantidadDeAtaque() {
		(this.cantidad)--;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	
	public abstract int cantidadInicial();
	
	public void aumentarAtaque(int aumento){
		int cantidadAumentada = this.getCantidad() + aumento;
		if( cantidadAumentada > this.cantidadInicial() ) this.setCantidad(this.cantidadInicial());
		else this.setCantidad(cantidadAumentada);
	}
}
