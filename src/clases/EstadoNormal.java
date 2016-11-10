package clases;

public class EstadoNormal implements Estado {

	@Override
	public void nuevoTurno(AlgoMon algomon) {}

	@Override
	public boolean puedeAtacar() {
		return true;
	}

}
