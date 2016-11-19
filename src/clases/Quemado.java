package clases;

public class Quemado implements Estado {

	
	public void nuevoTurno(AlgoMon algomon) {
		algomon.disminuirVida(algomon.getVidaOriginal()/10);
	}

	public boolean puedeAtacar() {
		return true;
	}

}
