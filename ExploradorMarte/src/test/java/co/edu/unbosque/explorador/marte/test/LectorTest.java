/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.unbosque.explorador.marte.test;

import co.edu.unbosque.swii.marte.exploradormarte.Lector;
import co.edu.unbosque.swii.marte.exploradormarte.Orientacion;
import co.edu.unbosque.swii.marte.exploradormarte.Posicion;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author E205-1
 */
public class LectorTest {
    
    // String archivo = "D:/SemestreVIII/IngeSofII/juego.txt";
    String archivo = "C:/Users/Andres/Desktop/exploradores2.txt";
    
    @Test
    public void probarLecturaPrimerLinea() throws IOException{
        Lector l=new Lector(archivo);
        Posicion limite=l.getLimiteSuperior();
        Assert.assertTrue(limite.getX()>0);
        Assert.assertTrue(limite.getY()>0);
    }
    
    @Test
    public void pruebaLaConstruccionDelLector() throws FileNotFoundException{
        Lector l=new Lector(archivo);
    }
    
    @Test
    public void pruebaleerOrientacion() throws FileNotFoundException, IOException{
        Lector l=new Lector(archivo);
        l.readNextExplorador();
        Posicion p=l.getOrientacion();
        Assert.assertEquals(p.getX(),2);
        Assert.assertEquals(p.getY(),2);
        Assert.assertEquals(p.getOrientacion(), Orientacion.N);
    }
    
    @Test
    public void pruebaleerComandos() throws FileNotFoundException, IOException{
        Lector l=new Lector(archivo);
        l.readNextExplorador();
        String s=l.getComandos();
        Assert.assertEquals(s,"IAIIAAA");
    }
    
    
    /**
     *
     * @author David Romero 29/01/2015
     * Metodo que verifica si existe o no el archivo
     */
    @Test
    public void noExisteArchivo() throws FileNotFoundException, IOException{
        Lector leer = new Lector(archivo);
    }
    
    /**
     *
     * @author David Romero 29/01/2015
     * Metodo que verifica si existe un string en la primera linea del documento
     */
    @Test
    public void probarEntero() throws IOException{
        Lector l=new Lector(archivo);
        Posicion limite=l.getLimiteSuperior();
    }
    
    
}
