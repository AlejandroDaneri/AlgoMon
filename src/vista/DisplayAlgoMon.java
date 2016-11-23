package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import vista.BarraDeVida;
import vista.RepresentacionAlgoMon;

public class DisplayAlgoMon extends VBox {
	private RepresentacionAlgoMon representacion;
	private Label estados;
	private BarraDeVida barraDeVida;
	
	public DisplayAlgoMon(RepresentacionAlgoMon representacion){
		super();
		this.representacion = representacion;
		
		Label nombreDelAlgomon = new Label(representacion.getNombre()); // ya no tenemos un metodo que nos devuelva el nombre del algomon, solucion provisoria
		nombreDelAlgomon.setAlignment(Pos.CENTER);
		nombreDelAlgomon.setTextAlignment(TextAlignment.CENTER);
		nombreDelAlgomon.setFont(Font.font("Cambria", 20));

		this.barraDeVida = new BarraDeVida(representacion.getAlgomon());
		
		this.actualizarEstados();
		
		ImageView imagen = new ImageView(representacion.getImagen());
		imagen.setFitWidth(250);
		imagen.setFitHeight(250);
		
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().addAll(imagen, nombreDelAlgomon,this.barraDeVida, this.estados);
	}
	
	private void actualizarEstados(){
		String estadosParaVisualizar = "Estados"+ ": " + this.representacion.getListaDeEstados().get(0) +", "+ this.representacion.getListaDeEstados().get(1);
		Label estados = new Label(estadosParaVisualizar);
		estados.setFont(Font.font("Cambria", 20));
		this.estados = estados;
	}
	
	public void actualizar(){
		this.barraDeVida.actualizar();
		this.actualizarEstados();
	}
}
