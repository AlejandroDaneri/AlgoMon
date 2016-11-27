package vista;

import javafx.scene.image.Image;
import modelo.algomones.*;

public class FabricaDeRepresentaciones {
	
	private static Image imagenCharmander = new Image("file:src/vista/imagenes/Charmander.png");
	private static Image imagenBulbasaur = new Image("file:src/vista/imagenes/Bulbasaur.png");
	private static Image imagenSquirtle = new Image("file:src/vista/imagenes/Squirtle.png");
	private static Image imagenRattata = new Image("file:src/vista/imagenes/Rattata.png");
	private static Image imagenJigglypuff = new Image("file:src/vista/imagenes/Jigglypuff.png");
	private static Image imagenChansey = new Image("file:src/vista/imagenes/Chansey.png");
	
	private static Image imagenTablaCharmander = new Image("file:src/vista/imagenes/TCharmander.png");
	private static Image imagenTablaBulbasaur = new Image("file:src/vista/imagenes/TBulbasaur.png");
	private static Image imagenTablaSquirtle = new Image("file:src/vista/imagenes/TSquirtle.png");
	private static Image imagenTablaRattata = new Image("file:src/vista/imagenes/TRattata.png");
	private static Image imagenTablaJigglypuff = new Image("file:src/vista/imagenes/TJigglypuff.png");
	private static Image imagenTablaChansey = new Image("file:src/vista/imagenes/TChansey.png");
/*
	private static String nombreCharmander = "Charmander";
	private static String nombreBulbasaur = "Bulbasaur";
	private static String nombreSquirtle = "Squirtle";
	private static String nombreRattata = "Rattata";
	private static String nombreJigglypuff = "Jigglypuff";
	private static String nombreChansey = "Chansey";
	*/
	
	public RepresentacionAlgoMon crearRepresentacion(AlgoMon algomon){
		if(algomon.equals(new Charmander()))
			return new RepresentacionAlgoMon(imagenCharmander,imagenTablaCharmander,algomon,"Charmander");

		if(algomon.equals(new Squirtle()))
			return new RepresentacionAlgoMon(imagenSquirtle,imagenTablaSquirtle,algomon,"Squirtle");

		if(algomon.equals(new Bulbasaur()))
			return new RepresentacionAlgoMon(imagenBulbasaur,imagenTablaBulbasaur,algomon,"Bulbasaur");

		if(algomon.equals(new Rattata()))
			return new RepresentacionAlgoMon(imagenRattata,imagenTablaRattata,algomon,"Rattata");

		if(algomon.equals(new Jigglypuff()))
			return new RepresentacionAlgoMon(imagenJigglypuff,imagenTablaJigglypuff,algomon,"Jigglypuff");

		return new RepresentacionAlgoMon(imagenChansey,imagenTablaChansey,algomon,"Chansey");
	}
}
