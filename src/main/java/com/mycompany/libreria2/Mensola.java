/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria2;

/**
 *
 * @author cotti
 */
public class Mensola {
   
     ///Attributi
    private Libro[] volumi;
    public static int MAX_VOLUMI = 15;
    
    ///Costruttori
    public Mensola() {
        volumi = new Libro[MAX_VOLUMI];
    }
    public Mensola(Mensola mensola) {
        
        for(int i=0; i<MAX_VOLUMI; i++) {
            volumi[i]=mensola.getVolume(i);
        }
    }
    
    
    public Mensola(Libro[] elencoLibri)
    {
        volumi = new Libro[MAX_VOLUMI];
        
        int numeroLibri=0;
      //se elenco libri e vuoto 
      if(elencoLibri.length==0)
          return;
      
      if(elencoLibri.length>getMaxVolumi())
          numeroLibri=getMaxVolumi();
      else
          numeroLibri=elencoLibri.length;
      
      for(int i=0;i<numeroLibri;i++)
      {
          if(elencoLibri[i]!=null)
          {
              volumi[i]=new Libro(elencoLibri[i]);
          }
      }
    }
    ///Getter
    public Libro getVolume(int posizione) 
    {
        /*if(posizione<0 || posizione>=MAX_VOLUMI)
            return null;
        if(volumi[posizione]==null)
            return null;*/
        try
        {
            return new Libro(volumi[posizione]);
        }
        /*catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
            return null;
        }*/
        catch(NullPointerException posizioneVuota)
        {
            return null;
        }
        
    }
    
    ///Setter
    public int setVolume(Libro libro, int posizione) {
        /*if      (posizione<0 || posizione>=MAX_VOLUMI)
            return -1;*/
        try
        {
            if (volumi[posizione]!=null)
            return -2;
        
            volumi[posizione] = new Libro(libro);
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
            return -1;
        }
        
        
    }
    
    ///Altri metodi
    public int delVolume(int posizione) {
        /*if      (posizione < 0 || posizione >= MAX_VOLUMI)
            return -1;*/
        
        try
        {
            if (volumi[posizione]==null)
            return -2;
        
            volumi[posizione] = null;
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException poszioneNonValida)
        {
            return -1;
        }
        
        
    }
    
    public static int getMaxVolumi()
    {
        return MAX_VOLUMI;
    }
    public int getNumVolumi() {
        int counter=0;
        for(int i=0; i<MAX_VOLUMI; i++) {
            if (volumi[i]!=null)
                counter++;
        }
        return counter;
    }
    public boolean presenzaTitolo(String titolo) {
        for (int i=0; i<MAX_VOLUMI; i++) {
            if (volumi[i] != null && titolo.equals(volumi[i].getTitolo()) == true)
                return true;
        }
        return false;
    }

}
