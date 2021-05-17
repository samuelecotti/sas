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
public class Ordinatore 
{
    public static void scambia(Libro v[],int posizione1,int posizione2) 
    {
        Libro c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(String v[],int posizione1,int posizione2) 
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(int v[],int posizione1,int posizione2) 
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    //Libro selection sort
    public static Libro[] selectionSortLibriPrezzoCrescente(Libro[] a)
    {
        Libro[] ordinato=new Libro[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].Prezzo()<ordinato[i].Prezzo())
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    //Sordina un array di libri in ordine alfabetico in base al titolloe e l'auotre
    public static Libro[] selectionSortAlfabeticoAutoreTitolo(Libro[] a)
    {
        Libro[] ordinato=new Libro[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getAutore().compareToIgnoreCase(ordinato[i].getAutore())<0 || (ordinato[j].getAutore().compareToIgnoreCase(ordinato[i].getAutore())==0 && ordinato[j].getTitolo().compareToIgnoreCase(ordinato[i].getTitolo())<0))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    //String selectionsort
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    //int selectionsort
    public static int[] selectionSortCrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    //int bubblesort crescente
    public static int[] bubbleSortCrescente(int a[])
    {
        int[] ordinato=new int[a.length];
        boolean scambioAvvenuto=true;
        
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do{
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i]>ordinato[i+1])
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
                    
                    
            }
            
        }while(scambioAvvenuto);
        
        return ordinato;
    }
    
    //string bubblesort crescente
    public static String[] bubbleSortCrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=true;
        
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do{
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])>0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
                    
                    
            }
            
        }while(scambioAvvenuto);
        
        return ordinato;
    }
    
    //int bubblesort decrescente
    public static int[] bubbleSortDecrescente(int a[])
    {
        int[] ordinato=new int[a.length];
        boolean scambioAvvenuto=true;
        
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do{
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i]<ordinato[i+1])
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
                    
                    
            }
            
        }while(scambioAvvenuto);
        
        return ordinato;
    }
    
    //string bubblesort decrescente 
    public static String[] bubbleSortDecrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=true;
        
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do{
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])<0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
                    
                    
            }
            
        }while(scambioAvvenuto);
        
        return ordinato;
    }
    
    
}
