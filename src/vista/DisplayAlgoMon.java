package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Jugador;

public class DisplayAlgoMon extends VBox {
	
	private RepresentacionAlgoMon representacion;
	private Label estados;
	private Label vidaActual;
	private BarraDeVida barraDeVida;
	private Jugador jugador;
	private static boolean primerJugador=true;
	
	public DisplayAlgoMon(RepresentacionAlgoMon representacion, Jugador jugador){
		this.representacion = representacion;
		this.setJugador(jugador);
		
		Label nombreDelAlgomon = new Label(representacion.getNombre()); 
		nombreDelAlgomon.setAlignment(Pos.CENTER);
		nombreDelAlgomon.setTextAlignment(TextAlignment.CENTER);
		nombreDelAlgomon.setFont(Font.font("Cambria", FontWeight.BOLD, 25));
		nombreDelAlgomon.setTextFill(Color.WHITE);

		this.barraDeVida = new BarraDeVida(representacion.getAlgomon());
		
		Label vidaActual = new Label(representacion.getAlgomon().getVida() + "/" 
		+ representacion.getAlgomon().getVidaOriginal());
		vidaActual.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
		vidaActual.setTextFill(Color.WHITE);
		this.vidaActual = vidaActual;
		
		String estadosParaVisualizar = "Estados: <" + this.representacion.getListaDeEstados().get(0) + ", " +
		this.representacion.getListaDeEstados().get(1) + ">";
		Label estados = new Label(estadosParaVisualizar);
		estados.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
		estados.setTextFill(Color.WHITE);
		this.estados = estados;
		
		ImageView imagen = new ImageView(representacion.getImagen());
		girarImagen(imagen);
		imagen.setFitWidth(250);
		imagen.setFitHeight(250);

		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(40,10,0,10));
		this.getChildren().addAll(nombreDelAlgomon,this.barraDeVida, vidaActual, imagen, this.estados);
	}

	private void girarImagen(ImageView imagen) {
		if (primerJugador) imagen.setScaleX(-1);
		primerJugador =false;
	}

	private void actualizarEstados(){
		this.getChildren().remove(this.estados);
		String estadosParaVisualizar = "Estados: < " + this.representacion.getListaDeEstados().get(0) + ", " +
		this.representacion.getListaDeEstados().get(1) + " >";
		
		Label estados = new Label(estadosParaVisualizar);
		estados.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		estados.setTextFill(Color.WHITE);
		this.estados = estados;
		this.getChildren().add(this.estados);		
	}
	
	public void actualizarVidaActual(){
		this.getChildren().remove(this.vidaActual);
		Label vidaActual = new Label(representacion.getAlgomon().getVida() + "/" 
		+ representacion.getAlgomon().getVidaOriginal());
		vidaActual.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		vidaActual.setTextFill(Color.WHITE);
		this.vidaActual = vidaActual;
		ImageView estados = (ImageView)this.getChildren().get(2);
		Label imagen = (Label)this.getChildren().get(3);
		this.getChildren().removeAll(imagen, estados);
		this.getChildren().addAll(this.vidaActual, imagen, estados);
	}
	
	public void actualizar(){
		this.barraDeVida.actualizar();
		this.actualizarVidaActual();
		this.actualizarEstados();
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(40,10,0,10));

	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
