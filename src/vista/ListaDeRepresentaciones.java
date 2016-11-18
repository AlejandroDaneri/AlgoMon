package vista;

import java.util.ArrayList;
import java.util.List;

import clases.Bulbasaur;
import clases.Chansey;
import clases.Charmander;
import clases.Jigglypuff;
import clases.Rattata;
import clases.Squirtle;
import javafx.scene.image.Image;

public class ListaDeRepresentaciones {
	
	private List<RepresentacionAlgoMon> lista;
	private int indice;
	
	public ListaDeRepresentaciones(){
		List<RepresentacionAlgoMon> lista = new ArrayList<RepresentacionAlgoMon>();
    	
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Charmander.png"), new Image("file:src/vista/imagenes/TCharmander.png"),new Charmander()));
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Bulbasaur.png"), new Image("file:src/vista/imagenes/TBulbasaur.png"),new Bulbasaur()));
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Squirtle.png"), new Image("file:src/vista/imagenes/TSquirtle.png"),new Squirtle()));
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Chansey.png"), new Image("file:src/vista/imagenes/TChansey.png"),new Chansey()));
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Jigglypuff.png"), new Image("file:src/vista/imagenes/TJigglypuff.png"),new Jigglypuff()));
    	lista.add(new RepresentacionAlgoMon(new Image("file:src/vista/imagenes/Rattata.png"), new Image("file:src/vista/imagenes/TRattata.png"),new Rattata()));
    	
    	this.setLista(lista);
    	this.setIndice(0);
	}
	
	public RepresentacionAlgoMon siguienteALaIzquierda(){
		this.setIndice(this.getIndice()-1);
		if(this.getIndice() < 0) this.setIndice(this.getLista().size() - 1);
		return this.getActual();
	}
	
	public RepresentacionAlgoMon siguienteALaDerecha(){
		this.setIndice(this.getIndice()+1);
		if(this.getIndice() > (this.getLista().size() - 1)) this.setIndice(0);
		return this.getActual();
	}
	
	public RepresentacionAlgoMon getActual(){
		return this.getLista().get(this.getIndice());
	}

	public List<RepresentacionAlgoMon> getLista() {
		return lista;
	}

	public void setLista(List<RepresentacionAlgoMon> lista) {
		this.lista = lista;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
}
