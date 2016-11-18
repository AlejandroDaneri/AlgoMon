package vista;

import clases.AlgoMon;
import clases.Bulbasaur;
import clases.Charmander;
import clases.Jigglypuff;
import clases.Rattata;
import clases.Squirtle;
import javafx.scene.image.Image;

public class FabricaDeRepresentaciones {
	
	public static String imagenCharmander = "file:src/vista/imagenes/Charmander.png";
	public static String imagenBulbasaur = "file:src/vista/imagenes/Bulbasaur.png";
	public static String imagenSquirtle = "file:src/vista/imagenes/Squirtle.png";
	public static String imagenRattata = "file:src/vista/imagenes/Rattata.png";
	public static String imagenJigglypuff = "file:src/vista/imagenes/Jigglypuff.png";
	public static String imagenChansey = "file:src/vista/imagenes/Chansey.png";
	
	public static String imagenTablaCharmander = "file:src/vista/imagenes/TCharmander.png";
	public static String imagenTablaBulbasaur = "file:src/vista/imagenes/TBulbasaur.png";
	public static String imagenTablaSquirtle = "file:src/vista/imagenes/TSquirtle.png";
	public static String imagenTablaRattata = "file:src/vista/imagenes/TRattata.png";
	public static String imagenTablaJigglypuff = "file:src/vista/imagenes/TJigglypuff.png";
	public static String imagenTablaChansey = "file:src/vista/imagenes/TChansey.png";
	
	public RepresentacionAlgoMon crearRepresentacion(AlgoMon algomon){
		if(algomon.equals(new Charmander())) return new RepresentacionAlgoMon(new Image(imagenCharmander),new Image(imagenTablaCharmander),algomon);
		if(algomon.equals(new Squirtle())) return new RepresentacionAlgoMon(new Image(imagenSquirtle),new Image(imagenTablaSquirtle),algomon);
		if(algomon.equals(new Bulbasaur())) return new RepresentacionAlgoMon(new Image(imagenBulbasaur),new Image(imagenTablaBulbasaur),algomon);
		if(algomon.equals(new Rattata())) return new RepresentacionAlgoMon(new Image(imagenRattata),new Image(imagenTablaRattata),algomon);
		if(algomon.equals(new Jigglypuff())) return new RepresentacionAlgoMon(new Image(imagenJigglypuff),new Image(imagenTablaJigglypuff),algomon);
		return new RepresentacionAlgoMon(new Image(imagenChansey),new Image(imagenTablaChansey),algomon);
	}
}
