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
public class Libro {
    
    ///Attributi
    private String titolo, autore;
    private int nPagine;
    private static double costoPagina = 0.05;
    public final double COSTO_FISSO = 5.5;
    
    ///Costruttori
    public Libro() {
        setTitolo(titolo);
        setAutore(autore);
        setNumeroPagine(nPagine);
    }
    public Libro(Libro libro) {
        setTitolo(libro.getTitolo());
        setAutore(libro.getAutore());
        setNumeroPagine(libro.getNumeroPagine());
    }
    
    ///Getter
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public int getNumeroPagine() {
        return nPagine;
    }
    public static double getCostoPagina() {
        return costoPagina;
    }
    
    ///Setter
    public void setTitolo(String titolo) {
        this.titolo=titolo;
    }
    public void setAutore(String autore) {
        this.autore=autore;
    }
    public void setNumeroPagine(int numeroPagine) {
        nPagine=numeroPagine;
    }
    public static void setCostoPagina(double costoPagina) {
        Libro.costoPagina=costoPagina;
    }
    
    public double Prezzo()
    {
       double p;
     p=COSTO_FISSO+costoPagina*getNumeroPagine();
      return p;

    }
    
    ///Altri metodi
    /*public double getPrezzo() {
        return (COSTO_FISSO > costoPagina*nPagine)? COSTO_FISSO : costoPagina*nPagine;
    }*/
    
    public String toString()
    {
        String s;
        s="titolo: "+getTitolo()+", autore: "+getAutore()+", pagine: "+getNumeroPagine();
        return s;
    }

}
