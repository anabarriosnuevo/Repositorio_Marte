/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.explorador.marte.test;

import co.edu.unbosque.swii.marte.exploradormarte.Marte;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author E205-1
 */
public class MarteTest {
    
    @Test
    public void deberiaConfiurarLaCoordenadaMaxima(){
        Marte m=new Marte(10,10);
        Assert.assertEquals(10, m.getX());
        Assert.assertEquals(10, m.getY());
    }
    /**
     * @autor Ana Maria
     * 
     */
   @Test(expectedExceptions = IllegalArgumentException.class)
   public void noDebeRecibirValoresNegativosEnElConstructor(){
       Marte m = new Marte(-2, -1);
   }
}
