package clases;

import excepciones.AtaquesAgotadosException;

public class Fogonazo extends Ataque {

	private ProveedorDeEstado estadoAQuemado = new EstadoAQuemado();

	public Fogonazo() {
		super("Fogonazo",2,4,Tipo.FUEGO);
	}
		public void atacar(AlgoMon atacante, AlgoMon atacado) throws AtaquesAgotadosException{
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
		atacado.recibirNuevoEstadoPersistente(estadoAQuemado.crearEstado());
		this.reducirCantidadDeAtaque();
	}

}
