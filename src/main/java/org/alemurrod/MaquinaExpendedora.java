package org.alemurrod;
import java.lang.IllegalArgumentException;

public class MaquinaExpendedora {

	Integer galletas;
	Integer dinero; //dinero actualmente dentro de la maquina
	boolean corriente; //corriente electrica

	public MaquinaExpendedora(Integer galletas, Integer dinero){

		this.galletas = galletas;
		this.dinero = dinero;
		this.corriente = false; //cuando se crea, siempre apagada
	}

	public Integer getGalletas(){
		return this.galletas;
	}

	public Integer getDinero(){
		return this.dinero;
	}

	public boolean getCorriente(){
		return this.corriente;
	}

	public void encender(){
		this.corriente = true;
	}

	// TODO public String sacarGalleta(Integer dinero){

	public String toString(){
		return "Maquina Expendedora - Modelo JGKR 3000. Número de galletas: "+getGalletas()+". Cambio actual: "+getDinero()+" euros.";
	}
}