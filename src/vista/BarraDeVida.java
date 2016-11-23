package vista;

import javafx.scene.control.ProgressBar;
import modelo.algomones.AlgoMon;

public class BarraDeVida extends ProgressBar {
	private AlgoMon algomon;
	
	public BarraDeVida(AlgoMon algomon){
		super();
		this.algomon = algomon;
		this.actualizar();
	}
	
	public void actualizar(){
		this.setProgress(((double)algomon.getVida()/(double)algomon.getVidaOriginal()));
	}
}
