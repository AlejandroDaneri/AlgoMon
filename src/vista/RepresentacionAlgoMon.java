package vista;

import java.util.ArrayList;
import java.util.List;

import clases.AlgoMon;
import clases.Ataque;
import clases.AtaqueRapido;
import clases.Brasas;
import clases.Burbuja;
import clases.CanonDeAgua;
import clases.Canto;
import clases.Chupavidas;
import clases.Estado;
import clases.EstadoNormal;
import clases.Fogonazo;
import clases.Quemado;
import javafx.scene.image.Image;

public class RepresentacionAlgoMon {
	
	private static String quemado = "Quemado";
	private static String dormido = "Dormido";
	private static String normal = "Normal";
	
	
	private static String ataqueRapido = "Ataque Rapido";
	private static String brasas = "Brasas";
	private static String burbuja = "Burbuja";
	private static String canonDeAgua = "Canon de Agua";
	private static String canto = "Canto";
	private static String chupaVidas = "Chupavidas";
	private static String fogonazo = "Fogonazo";
	
	
	private Image imagen;
	private Image tabla;
	private AlgoMon algomon;
	
	public RepresentacionAlgoMon(Image imagen, Image tabla, AlgoMon algomon){
		this.setImagen(imagen);
		this.setAlgomon(algomon);
		this.setTabla(tabla);
	}
	
	public List<String> getListaDeEstados(){
		List<String> lista = new ArrayList<String>();
		for(Estado estado : this.algomon.getListaDeEstados()){
			lista.add(this.getNombreDeEstado(estado));
		}
		return lista;
	}
	
	public String getNombreDeEstado(Estado estado){
		if(estado.equals(new Quemado())) return quemado;
		if(estado.equals(new EstadoNormal())) return normal;
		return dormido;
	}
	
	public List<String> getListaDeAtaques(){
		List<String> lista = new ArrayList<String>();
		for(Ataque ataque : this.algomon.getAtaques()){
			lista.add(this.getNombreDeAtaque(ataque));
		}
		return lista;
	}
	
	public String getNombreDeAtaque(Ataque ataque){
		if(ataque.equals(new AtaqueRapido())) return ataqueRapido;
		if(ataque.equals(new Brasas())) return brasas;
		if(ataque.equals(new Burbuja())) return burbuja;
		if(ataque.equals(new CanonDeAgua())) return canonDeAgua;
		if(ataque.equals(new Canto())) return canto;
		if(ataque.equals(new Chupavidas())) return chupaVidas;
		if(ataque.equals(new Fogonazo())) return fogonazo;
		return dormido;
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
