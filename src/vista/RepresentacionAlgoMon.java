package vista;

import clases.AlgoMon;
import javafx.scene.image.Image;

public class RepresentacionAlgoMon {
	
	private Image imagen;
	private Image tabla;
	private AlgoMon algomon;
	
	public RepresentacionAlgoMon(Image imagen, Image tabla, AlgoMon algomon){
		this.setImagen(imagen);
		this.setAlgomon(algomon);
		this.setTabla(tabla);
	}
	
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public AlgoMon getAlgomon() {
		return algomon;
	}
	public void setAlgomon(AlgoMon algomon) {
		this.algomon = algomon;
	}
	public Image getTabla() {
		return tabla;
	}
	public void setTabla(Image tabla) {
		this.tabla = tabla;
	}
}
