package clases;

public class ChuparVida implements Accion {
	
	private int potencia = 15;

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		double multiplicador = atacante.getTipo().obtenerMultiplicador(atacado.getTipo());
		
		int vidaAumentada = (int)(atacante.getVida() + potencia * multiplicador * 0.3);
		
		if( vidaAumentada > atacante.obtenerVidaOriginal() ) atacante.setVida(atacante.obtenerVidaOriginal());
		else atacante.setVida(vidaAumentada);
	}

}
