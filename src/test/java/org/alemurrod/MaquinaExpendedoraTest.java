package org.alemurrod;

import org.junit.*;
import org.junit.Assert.*;
import java.lang.IllegalArgumentException;

public class MaquinaExpendedoraTest {
    
    @Test
    public void testCorriente(){
        
        //cuando la maquina se crea debe estar sin corriente por defecto
        MaquinaExpendedora me = new MaquinaExpendedora(50, 25);

        Assert.assertEquals(false, me.getCorriente());
    }

    @Test
    public void testEncenderMaquina(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 25);
        me.encender();
        Assert.assertEquals(true, me.getCorriente());
    }

    @Test
    public void testSacarGalletaConLaMaquinaApagada(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 10);

        me.sacarGalleta(1);

        //como está apagada, pues el dinero no se queda en la maquina, por eso lo igualo al dinero con el que se creó
        Assert.assertEquals(new Integer(10), me.getDinero());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSacarGalletaConDineroNegativo(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 10);
        me.encender();

        me.sacarGalleta(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSacarGalletaConDinero0(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 10);
        me.encender();

        me.sacarGalleta(0);
    }

    @Test
    public void testComprobarDineroRestante1(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 10);
        me.encender();

        me.sacarGalleta(1);
        me.sacarGalleta(1);

        Assert.assertEquals(new Integer(12), me.getDinero());
    }

    @Test
    public void testComprobarDineroRestante2(){
        
        MaquinaExpendedora me = new MaquinaExpendedora(50, 20);
        me.encender();

        me.sacarGalleta(10);

        Assert.assertEquals(new Integer(21), me.getDinero());
    }
}