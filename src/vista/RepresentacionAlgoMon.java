package vista;

import javafx.scene.image.Image;
import modelo.algomones.AlgoMon;
import modelo.ataques.*;
import modelo.estados.Estado;
import modelo.estados.EstadoNormal;
import modelo.estados.Quemado;

import java.util.ArrayList;
import java.util.List;

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
	private static String latigoCepa = "Latigo Cepa";
	
	
	private Image imagen;
	private Image tabla;
	private AlgoMon algomon;
	private String nombre;
	
	public RepresentacionAlgoMon(Image imagen, Image tabla, AlgoMon algomon, String nombre){
		setImagen(imagen);
		setAlgomon(algomon);
		setTabla(tabla);
		setNombre(nombre);
	}
	
	
	public List<String> getListaDeEstados(){
		ArrayList<String> lista = new ArrayList<String>();
		for(Estado estado : algomon.getListaDeEstados()){
			lista.add(this.getNombreDeEstado(estado));
		}
		return lista;
	}
	
	public String getNombreDeEstado(Estado estado){
		//modificar, la version anterior no funcionaba en contenedorPelea
		if(estado.getClass().equals((Quemado.class))) return quemado;
		if(estado.getClass().equals(EstadoNormal.class)) return normal;
		return dormido;
	}
	
	public String getNombreDeAtaque(Ataque ataque){
		if(ataque.equals(new AtaqueRapido())) return ataqueRapido;
		if(ataque.equals(new Brasas())) return brasas;
		if(ataque.equals(new Burbuja())) return burbuja;
		if(ataque.equals(new CanonDeAgua())) return canonDeAgua;
		if(ataque.equals(new Canto())) return canto;
		if(ataque.equals(new Chupavidas())) return chupaVidas;
		if(ataque.equals(new Fogonazo())) return fogonazo;
		return latigoCepa;
	}
	
	public Image getImagen() {
		return imagen;
	}
	private void setImagen(Image imagen) {
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
	private void setTabla(Image tabla) {
		this.tabla = tabla;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
