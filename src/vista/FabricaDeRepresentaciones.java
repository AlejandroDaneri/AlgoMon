package vista;

import javafx.scene.image.Image;
import modelo.algomones.*;

public class FabricaDeRepresentaciones {
	
	public static String imagenCharmander = "file:src/vista/imagenes/gifs/charmander.gif";
	public static String imagenBulbasaur = "file:src/vista/imagenes/gifs/bulbasaur.gif";
	public static String imagenSquirtle = "file:src/vista/imagenes/gifs/squirtle.gif";
	public static String imagenRattata = "file:src/vista/imagenes/gifs/rattata.gif";
	public static String imagenJigglypuff = "file:src/vista/imagenes/gifs/jigglypuff.gif";
	public static String imagenChansey = "file:src/vista/imagenes/gifs/chansey.gif";
	
	public static String imagenTablaCharmander = "file:src/vista/imagenes/TCharmander.png";
	public static String imagenTablaBulbasaur = "file:src/vista/imagenes/TBulbasaur.png";
	public static String imagenTablaSquirtle = "file:src/vista/imagenes/TSquirtle.png";
	public static String imagenTablaRattata = "file:src/vista/imagenes/TRattata.png";
	public static String imagenTablaJigglypuff = "file:src/vista/imagenes/TJigglypuff.png";
	public static String imagenTablaChansey = "file:src/vista/imagenes/TChansey.png";
	
	public static String nombreCharmander = "Charmander";
	public static String nombreBulbasaur = "Bulbasaur";
	public static String nombreSquirtle = "Squirtle";
	public static String nombreRattata = "Rattata";
	public static String nombreJigglypuff = "Jigglypuff";
	public static String nombreChansey = "Chansey";
	
	
	public RepresentacionAlgoMon crearRepresentacion(AlgoMon algomon){
		if(algomon.equals(new Charmander())) return new RepresentacionAlgoMon(new Image(imagenCharmander),new Image(imagenTablaCharmander),algomon,nombreCharmander);
		if(algomon.equals(new Squirtle())) return new RepresentacionAlgoMon(new Image(imagenSquirtle),new Image(imagenTablaSquirtle),algomon,nombreSquirtle);
		if(algomon.equals(new Bulbasaur())) return new RepresentacionAlgoMon(new Image(imagenBulbasaur),new Image(imagenTablaBulbasaur),algomon,nombreBulbasaur);
		if(algomon.equals(new Rattata())) return new RepresentacionAlgoMon(new Image(imagenRattata),new Image(imagenTablaRattata),algomon,nombreRattata);
		if(algomon.equals(new Jigglypuff())) return new RepresentacionAlgoMon(new Image(imagenJigglypuff),new Image(imagenTablaJigglypuff),algomon,nombreJigglypuff);
		return new RepresentacionAlgoMon(new Image(imagenChansey),new Image(imagenTablaChansey),algomon,nombreChansey);
	}
}
