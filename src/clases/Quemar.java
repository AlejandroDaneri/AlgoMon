package clases;

public class Quemar implements Accion {

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		atacado.setEstadoPersistente(new Quemado());
	}

}
