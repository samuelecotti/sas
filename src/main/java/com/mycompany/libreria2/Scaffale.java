/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria2;
import eccezioni.*;
import file.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotti
 */
public class Scaffale {
    //attributi
    private Mensola[] ripiani;
    private static final int NUM_RIPIANI=5;
    
    /**
     *Costruttore classe scaffale
     * Consente di istanziare un nuovo scaffale
     * costituito da NUM_RIPIANI ripiani vuoti
     */
    public Scaffale()
    {
        ripiani=new Mensola[NUM_RIPIANI];
        
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
        }
    }

    /**
     * Costruttore di copia. consente di istanziare un nuovo scaffale
     * copia dello scaffale passato come parametro
     * 
     * @param s Lo scaffale di cui creare la copia
     */
    public Scaffale(Scaffale s) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota
    {
         ripiani=new Mensola[NUM_RIPIANI];
         
         Libro l;
         for(int i=0;i<getNumRipiani();i++)
         {
             ripiani[i]=new Mensola();
             for(int j=0;j<ripiani[i].getMaxVolumi();j++)
             {
                 if(s.getLibro(i, j)!=null)
                 {
                     l=s.getLibro(i, j);
                     setLibro(l, i, j);
                 }
             }
         }
    }
    
    public Mensola getRipiano(int ripiano) throws EccezionePosizioneNonValida
    {
        Mensola m;
        
        try
        {
            m=new Mensola(ripiani[ripiano]);
            return m;
        }
        catch(ArrayIndexOutOfBoundsException e1) 
        {
            throw new EccezionePosizioneNonValida(ripiano, 0);
        }
        
        
        
        
        
    }
    

    /**
     *Consente di inserire un libro nello scaffale.
     * @param libro libro da inserire nello scaffale
     * @param ripiano ripiano in cui inserire il libro
     * @param posizione la posizione all'interno del ripiano in cui inserire il libro
     * @return  0: se l'inserimento è andato a buon fine<br>
     *         -1: se la posizione inserita non è valida(minore di 0 o superiore alla posizione massima in un oggetto di classe mensola)<br>
     *         -2: se la posizione è già occupata da  un altro  libro<br>
     *         -3: se il ripiano non è valido(se il ripiano è minore di  0 o superiore a NUM_RIPIANI)
     */
    public void setLibro(Libro libro,int ripiano,int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota
    {
        int inserimentoOk;
        
        try
        {
            inserimentoOk=ripiani[ripiano].setVolume(libro, posizione);
            if(inserimentoOk==-1)
                throw new EccezionePosizioneNonValida(ripiano,posizione);
            else if(inserimentoOk==-2)
                throw new EccezionePosizioneNonVuota(ripiano,posizione);
            
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(ripiano,posizione);
        }
        
    }
    
    /**
     *
     * @param ripiano
     * @param posizione
     * @return
     */
    public Libro getLibro(int ripiano,int posizione) throws EccezionePosizioneNonValida
    {
        try
        {
            return(ripiani[ripiano].getVolume(posizione));
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(ripiano, posizione);
        }
        
    }
    
    /**
     *
     * @param ripiano
     * @param posizione
     * @return
     */
    public int rimuoviLibro(int ripiano,int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        int rimozioneOk;
        
        try
        {
            rimozioneOk=ripiani[ripiano].delVolume(posizione);
            if(rimozioneOk==-1)
                throw new EccezionePosizioneNonValida(ripiano, posizione);
            else if(rimozioneOk==-2)
                throw new EccezionePosizioneVuota(ripiano, posizione);
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(ripiano, posizione);
        }
        
        if(ripiano<0 || ripiano>=NUM_RIPIANI)
            return -3;
        
        if(rimozioneOk>=0)
            return 0;
        else
            return rimozioneOk;
   
    }
    
    /**
     *
     * @return
     */
    public static int getNumRipiani()
    {
        return NUM_RIPIANI;
    }
    
    /**
     *
     * @return
     */
    public int getNumLibri()
    {
        int numLibri=0;
        for(int i=0;i<getNumRipiani();i++)
        {
            numLibri+=ripiani[i].getNumVolumi();
        }
        return numLibri;
    }
    
    /**
     *
     * @param ripiano
     * @return
     */
    public int getNumLibri(int ripiano) throws EccezionePosizioneNonValida
    {
        try
        {
            return ripiani[ripiano].getNumVolumi();
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(ripiano, 0);
        }
        
    }
    
    /**
     *
     * @param ripiano
     * @return
     */
    public int getNumMaxLibri(int ripiano) throws EccezionePosizioneNonValida
    {
        try
        {
            return ripiani[ripiano].getMaxVolumi();
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(ripiano, 0);
        }
        
    }
    
    /**
     *
     * @param autore
     * @return
     */
    public String[] elencoTitoliAutore(String autore) throws EccezionePosizioneNonValida
    {
       int numeroLibriAutore=0;
       Libro libro;
       
       //numero libri autore presenti
       for(int i=0;i<getNumRipiani();i++)
        {
             for(int j=0;j<ripiani[i].getMaxVolumi();j++)
             {
                 if(getLibro(i, j)!=null)
                 {
                     libro=getLibro(i, j);
                     if(libro.getAutore().equalsIgnoreCase(autore))
                         numeroLibriAutore++;
                 }
             }
        }
       if (numeroLibriAutore==0)
           return null;
       
       
       int posizioneTitolo=0;
       //assegno ad ogni elemento dell'arrey il titolo del libro
       String[] elencoTitoliAutore=new String[numeroLibriAutore];
      
       
       
       for(int i=0;i<getNumRipiani();i++)
        {
             for(int j=0;j<ripiani[i].getMaxVolumi();j++)
             {
                 if(getLibro(i, j)!=null)
                 {
                     libro=getLibro(i, j);
                     if(libro.getAutore().equalsIgnoreCase(autore))
                     {
                         elencoTitoliAutore[posizioneTitolo]=libro.getTitolo();
                         posizioneTitolo++;
                     }
                 }
             }
        }
       return elencoTitoliAutore;
    } 
    
    public  String toString()
    {
        String s="";
        if(getNumLibri()==0)
        {
            s="nessun libro presente";
        }
        else
        {
            Libro libro;
        for(int i=0;i<getNumRipiani();i++)
        {
            s=s+"Ripiano "+i+"\n";
            for(int j=0;j<ripiani[i].getMaxVolumi();j++)
            {
                try 
                {
                    if(getLibro(i, j)!=null)
                    {
                        libro=getLibro(i, j);
                        s=s+j+" --> "+getLibro(i, j)+"\n";
                    }
                }
                catch (EccezionePosizioneNonValida e1) 
                {
                    
                    
                }
                
            }
            
        }
        }
            
        return s;
    }
    
    /**
     *
     * @return
     */
    public  String elencoAlfabeticoLibri() throws EccezionePosizioneNonValida
    {
        String s="";
        String elencoLibri[]=new String[getNumLibri()];
        int c=0;
        
        if(getNumLibri()==0)
        {
            s="nessun libro presente";
        }
        else
        {
            Libro libro;
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<ripiani[i].getMaxVolumi();j++)
            {
                if(getLibro(i, j)!=null)
                {
                    libro=getLibro(i, j);
                    elencoLibri[c]=libro.getTitolo()+" --> mensola: "+i+" posizione: "+j;
                    c++;
                }
                
            }
            
        }
        elencoLibri=Ordinatore.selectionSortCrescente(elencoLibri);
        for(int i=0;i<elencoLibri.length;i++)
        {
            s=s+elencoLibri[i]+"\n";
        }
        
        }
            
        return s;
    }
    
    //restituisce un array di libri ordinati in base al preezzo

    /**
     *
     * @return
     */
    public Libro[] elencoLibriOrdinatiPrezzo() throws EccezionePosizioneNonValida
    {
        Libro[] elencoLibri=new Libro[getNumLibri()];
        Libro libro;
        int c=0;
        
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            for(int j=0;j<ripiani[i].getMaxVolumi();j++)
            {
                libro=getLibro(i, j);
                if(libro!=null)
                {
                    elencoLibri[c]=libro;
                    c++;
                }
            }
        }
        
        elencoLibri=Ordinatore.selectionSortLibriPrezzoCrescente(elencoLibri);
        
        return elencoLibri;
        
    }
    
    //restituisce un array di libri ordinati in all'autore e al titolo

    /**
     *
     * @return
     */
    public Libro[] elencoLibriAlfabeticoAutoreTitolo() throws EccezionePosizioneNonValida
    {
        Libro[] elencoLibri=new Libro[getNumLibri()];
        Libro libro;
        int c=0;
        
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            for(int j=0;j<ripiani[i].getMaxVolumi();j++)
            {
                libro=getLibro(i, j);
                if(libro!=null)
                {
                    elencoLibri[c]=libro;
                    c++;
                }
            }
        }
        
        elencoLibri=Ordinatore.selectionSortAlfabeticoAutoreTitolo(elencoLibri);
        
        return elencoLibri;
        
    }
    
    public void salvaLibri(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile, 'W');
        Libro libro;
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            for(int j=0;j<ripiani[i].getMaxVolumi();j++)
            {
                libro=getLibro(i,j);
                if(libro!=null)
                {
                    f1.toFile(i+";"+j+";"+libro.getTitolo()+";"+libro.getAutore()+";"+libro.getNumeroPagine()+";");
                }
            }
                
            
        }
        f1.close();
    }
}
