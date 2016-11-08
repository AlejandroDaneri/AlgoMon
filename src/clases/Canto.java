package clases;

import excepciones.AtaquesAgotadosException;

public class Canto extends Ataque {
	
	private ProveedorDeEstado estadoADormido = new EstadoADormido();

	public Canto() {
		super("Canto",0, 6, Tipo.NORMAL);
	}
	
	public void atacar(AlgoMon atacante, AlgoMon atacado) throws AtaquesAgotadosException{
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
		atacado.recibirNuevoEstadoEfimero(estadoADormido.crearNuevoEstado());
		this.reducirCantidadDeAtaque();
	}

}
