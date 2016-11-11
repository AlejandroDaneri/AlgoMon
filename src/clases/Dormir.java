package clases;

public class Dormir implements Accion {

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		atacado.setEstadoEfimero(new Dormido());		
	}

}
