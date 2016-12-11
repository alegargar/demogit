package org.alemurrod;
import java.lang.IllegalArgumentException;

public class MaquinaExpendedora {

	Integer galletas;
	Integer dinero; //cambio actual en la maquina expendedora 
	boolean corriente; //corriente electrica

	public MaquinaExpendedora(Integer galletas, Integer dinero){
		
		checkGalletas(galletas);
		checkDinero(dinero);

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

	public String sacarGalleta(Integer dinero){
		
		if (dinero <= 0 ) {
			throw new IllegalArgumentException("Inserte una cantidad mayor a 0.");
		}

		String res = "";

		if(!getCorriente()){
			res = "La máquina actualmente está apagada.";
		}else{
			if (galletas == 0) {
				res = "No quedan galletas. Lo siento.";
			}else{
				if (dinero < 1) {
				res = "Una galleta vale 1 euro. No se acepta menos.";
				}else{

					Integer cambio = dinero - 1;

					if (cambio > getDinero()) {
						res = "Lo siento, no te puedo dar la galleta por que no tengo cambio para devolverte. Cambio actual: "+getDinero()+" euros.";
					}else{
						this.dinero = getDinero() + (dinero - cambio);
						res = "Aquí tiene su galleta. Le devuelvo su cambio: "+cambio+" euros.";
						res += ". Para tu información, mi cambio actual es de: "+getDinero()+" euros.";
					}
				}
			}
		}
		return res;
	}

	public String toString(){
		return "Maquina Expendedora - Modelo JGKR 3000. Número de galletas: "+getGalletas()+". Cambio actual: "+getDinero()+" euros.";
	}


	//Checks
	public void checkGalletas(Integer galletas){
		if (galletas < 0 ) {
			throw new IllegalArgumentException("Las galletas no pueden ser negativas.");
		}
	}
	
	public void checkDinero(Integer dinero){
		if (dinero < 0 ) {
			throw new IllegalArgumentException("El dinero no puede ser negativo.");
		}	
	}
}