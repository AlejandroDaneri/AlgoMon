package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Partida;
import vista.contenedores.ContenedorPelea;
import vista.contenedores.Escena;

public class BotonEmpezarEventHandler extends BotonHandler {

    private Stage stage;
    private Jugador jugador1;
    private Jugador jugador2;

    public BotonEmpezarEventHandler(Stage stage, Jugador jugador1, Jugador jugador2) {
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Partida partida = new Partida(jugador1,jugador2);
        
        boolean listoParaEmpezar = validarJugadorListo(jugador1);
        listoParaEmpezar &= validarJugadorListo(jugador2);


        if (listoParaEmpezar) {
            ContenedorPelea contenedorPelea = new ContenedorPelea(stage);
            Escena escenaPelea = new Escena(contenedorPelea,stage);
            contenedorPelea.inicializarPelea(partida);

            boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
            ((ContenedorPelea) escenaPelea.getRoot()).inicializarPelea(partida);
            stage.hide();
            stage.setScene(escenaPelea);
            stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
            stage.show();
        }
    }

    private boolean validarJugadorListo(Jugador jugador) {
        //if (jugador.getListaDeAlgomones().size() ==0) {
        if (jugador.getListaDeAlgomones().size() != 3){ //para probar les conviene comentar esta y poner la de arriba
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Algomones sin elegir");
            alert.setHeaderText(jugador.getNombre() + ": Faltan elegir algomones");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
