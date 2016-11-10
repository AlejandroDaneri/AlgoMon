package clases;

public class Quemado implements Estado {

	@Override
	public void nuevoTurno(AlgoMon algomon) {
		algomon.disminuirVida(algomon.obtenerVidaOriginal()/10);
	}

	@Override
	public boolean puedeAtacar() {
		return true;
	}

}
