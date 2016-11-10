package clases;

public class Dormido implements Estado {
	
	private int turnos;
	
	public Dormido(){
		this.turnos = 3;
	}

	@Override
	public void nuevoTurno(AlgoMon algomon) {
		turnos--;
		if(turnos == 0){
			algomon.getEstados().setEstadoEfimero(new EstadoNormal());
		}
	}

	@Override
	public boolean puedeAtacar() {
		return false;
	}

}
