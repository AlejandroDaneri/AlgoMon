package clases;

public class Dormir implements Accion {

	@Override
	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		atacado.setEstadoEfimero(new Dormido());		
	}

}
