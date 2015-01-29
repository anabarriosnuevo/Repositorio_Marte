/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.unbosque.swii.marte.exploradormarte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.IIOException;

/**
 *
 * @author E205-1
 */
public class Lector {
    
    File archivoJuego;
    
    BufferedReader br;
    
    String limiteSuperior;
    String lineaOrientacion;
    String lineaComandos;
    public Lector(){
        
        
    }
    
    public Lector(String archivo) throws FileNotFoundException {
        this.archivoJuego=new File(archivo);
        if(!archivoJuego.exists()){
            noExiste(archivo);
        }else{
            FileInputStream fin=new FileInputStream(archivoJuego);
            InputStreamReader isr=new InputStreamReader(fin);
            br=new BufferedReader(isr);
        }
    }
    
    
    public Posicion getLimiteSuperior() throws IOException {
        if(limiteSuperior==null)
            limiteSuperior=br.readLine().trim();
        String x[]=limiteSuperior.split(" ");
        try {
        Integer.parseInt(x[0]);
        Integer.parseInt(x[1]);
        }catch (NumberFormatException nfe) {
            
             return null;
        }
    
       return new Posicion(new Integer(x[0]),new Integer(x[1]));
    }
    
    public Posicion getOrientacion() throws IOException {
        String x[]=lineaOrientacion.split(" ");
        Posicion p=new Posicion(new Integer(x[0]),new Integer(x[1]));
        p.setOrientacion(Orientacion.valueOf(x[2]));
        return p;
    }
    
    public String getComandos() throws IOException {
        return this.lineaComandos;
    }
    
    
    public boolean readNextExplorador() throws IOException{
        getLimiteSuperior();
        lineaOrientacion=br.readLine();
        if(lineaOrientacion==null)
            return false;
        lineaComandos=br.readLine().trim();
        return true;
    }
    /**
     *
     * @author david Romero 29/01/2015
     * Metodo que comprueba que No existe el archivo
     */
    public void noExiste(String archivo)  {
        this.archivoJuego = new File(archivo);
        
        if(!archivoJuego.exists())
        {
            System.out.println("El fichero no existe");
        }
        
    }
    
}






