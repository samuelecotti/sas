/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria2;
import eccezioni.EccezionePosizioneNonVuota;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.*;

/**
 *
 * @author cotti
 */
public class main {
    public static void main(String[] args) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota, EccezionePosizioneVuota 
    {
        
        String[] vociMenu=new String[10];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Scaffale s1=new Scaffale();
        Libro libro;
        int esitoOperazione,ripiano,posizione;
        String nomeFile="libriScaffale.txt";
        
        
        vociMenu[0]="Esci";
        vociMenu[1]="Aggiungi Libro";
        vociMenu[2]="Visualizza Libro";
        vociMenu[3]="Rimuovi Libro";
        vociMenu[4]="Ottieni i titoli dei libri di un autore";
        vociMenu[5]="Visualizza tutti i libri di uno scaffale";
        vociMenu[6]="Visualizza elenco alfabetico libri";
        vociMenu[7]="Visualizza elenco libri ordinati per prezzo";
        vociMenu[8]="Visualizza elenco libri ordinati per autore in ordine alfabetico";
        vociMenu[9]="Salva libri su file";
        
        Menu menu=new Menu(vociMenu);
        
        do{
            try
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("L'applicazione verrà terminata.");
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 1:
                    {
                        libro=new Libro();
                        System.out.println("Titolo-->");
                        libro.setTitolo(tastiera.nextLine());
                        System.out.println("Autore-->");
                        libro.setAutore(tastiera.nextLine());
                        System.out.println("Numero pagine-->");
                        libro.setNumeroPagine(tastiera.nextInt());
                        System.out.println("Ripiano-->");
                        ripiano=tastiera.nextInt();
                        System.out.println("Posizione-->");
                        posizione=tastiera.nextInt();

                        try
                        {
                            s1.setLibro(libro, ripiano, posizione);
                            System.out.println("Inserimento eseguito correttamente.");
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        catch(EccezionePosizioneNonVuota e2)
                        {
                            System.out.println(e2.toString());
                        }

                        System.out.println("Premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Ripiano-->");
                        ripiano=tastiera.nextInt();
                        System.out.println("Posizione-->");
                        posizione=tastiera.nextInt();

                        try
                        {
                           libro=s1.getLibro(ripiano, posizione);

                            if(libro==null)
                                System.out.println("nessun libro presente in questa posizione.");
                            else
                                System.out.println(libro.toString()); 
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }



                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Ripiano-->");
                        ripiano=tastiera.nextInt();
                        System.out.println("Posizione-->");
                        posizione=tastiera.nextInt();
                        try
                        {
                            s1.rimuoviLibro(ripiano, posizione);
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        catch(EccezionePosizioneVuota e2)
                        {
                            System.out.println(e2.toString());
                        }

                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 4:
                    {
                        String[] elencoTitoli;
                        String autore;

                        System.out.println("Autore-->");
                        autore=tastiera.nextLine();
                        try
                        {
                            elencoTitoli=s1.elencoTitoliAutore(autore);
                            if(elencoTitoli==null)
                            System.out.println("Nessun libro presente dell' autore "+autore);
                            else
                            {
                                for(int i=0;i<elencoTitoli.length;i++)
                                    System.out.println(elencoTitoli[i]);
                            }
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }







                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 5:
                    {
                        System.out.println(s1.toString());
                    }
                    case 6:
                    {
                        try
                        {
                            System.out.println(s1.elencoAlfabeticoLibri());
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }

                        break;
                    }
                    case 7:
                    {
                        Libro[] elencoLibri;
                        try
                        {
                            elencoLibri=s1.elencoLibriOrdinatiPrezzo();
                            for(int i=0;i<elencoLibri.length;i++)
                            {
                                System.out.println(elencoLibri[i].toString()+" prezzo: € "+elencoLibri[i].Prezzo());
                            }
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        break;
                    }
                    case 8:
                    {
                        Libro[] elencoLibri;
                        try
                        {
                           elencoLibri=s1.elencoLibriAlfabeticoAutoreTitolo();
                            for(int i=0;i<elencoLibri.length;i++)
                            {
                                System.out.println(elencoLibri[i].toString()+" prezzo: € "+elencoLibri[i].Prezzo());
                            } 
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }

                        break;
                    }
                    case 9:
                    {
                        try
                        {
                            s1.salvaLibri(nomeFile);
                            System.out.println("Salvataggio avvenuto correttamente.");
                        }
                        catch(IOException e1)
                        {
                            System.out.println("Impossibile accedere ai file. i libri non sono stati salvati");
                        }
                        catch(EccezionePosizioneNonValida | FileException e2)
                        {
                            System.out.println(e2.toString());
                        }
                        
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
            
        }while(sceltaUtente!=0);
        
        
        
    
        
        
        
        
        
        
        
        
        
        
        /*
        Libro l1=new Libro("Il signore degli anelli: la compagnia dell'anello","J. R. R. Tolkien",800);
        Libro l2=new Libro("Harry Potter e la camera dei segreti","J. K. Rowling",700);
        Libro l3=new Libro("Lo hobbit:un viaggio inaspettato", "J. R. R. Tolkien",600);
        Libro l4=new Libro("La fattoria degli animali","George Orwell",200);
        
        Libro[] elencoLibri=new Libro[4];
        
        elencoLibri[0]=l1;
        elencoLibri[1]=l2;
        elencoLibri[2]=l3;
        elencoLibri[3]=l4;
        
        
        Mensola m1=new Mensola(elencoLibri);
        Libro libro;
        for(int i=0;i<m1.getMaxVolumi();i++)
        {
            if (m1.getVolume(i)!=null)
            {
                libro=m1.getVolume(i);
                System.out.println(libro.toString());
            }
        }
        Scaffale s1=new Scaffale();
        
        /*
        s1.setLibro(l1, 0, 0);
        s1.setLibro(l2, 1, 1);
        s1.setLibro(l3, 2, 1);
        s1.setLibro(l4, 2, 10);
       */
        
        
        /*
        //test inserimeto libro
        int inserimentoOk;
        inserimentoOk=s1.setLibro(l1, 0, 10);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
        inserimentoOk=s1.setLibro(l2, 0, 0);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
        //Libro l4=new Libro("la divina commedia", "Dante",700);
          inserimentoOk=s1.setLibro(l4, 1, 2);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
        inserimentoOk=s1.setLibro(l3, 10, 0);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
        inserimentoOk=s1.setLibro(l3, 0, 20);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
         inserimentoOk=s1.setLibro(l3, 0, 10);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
         inserimentoOk=s1.setLibro(l3, 1, 0);
        if (inserimentoOk==0)
            System.out.println("Inserimento ok");
        else if(inserimentoOk==-1)
            System.out.println("Posizione non valida");
        else if(inserimentoOk==-2)
            System.out.println("Posizione occupata");
        else if(inserimentoOk==-3)
            System.out.println("Ripiano non valido");
        
        //test eliminazione
        
        int eliminazioneOk;
        eliminazioneOk=s1.rimuoviLibro(2,9);
        if (eliminazioneOk==0)
            System.out.println("eliminazione ok");
        else if(eliminazioneOk==-1)
            System.out.println("Posizione non valida");
        else if(eliminazioneOk==-2)
            System.out.println("Posizione già vuota");
        else if(eliminazioneOk==-3)
            System.out.println("Ripiano non valido");
        
        eliminazioneOk=s1.rimuoviLibro(9,9);
        if (eliminazioneOk==0)
            System.out.println("eliminazione ok");
        else if(eliminazioneOk==-1)
            System.out.println("Posizione non valida");
        else if(eliminazioneOk==-2)
            System.out.println("Posizione già vuota");
        else if(eliminazioneOk==-3)
            System.out.println("Ripiano non valido");
        
        eliminazioneOk=s1.rimuoviLibro(2,18);
        if (eliminazioneOk==0)
            System.out.println("eliminazione ok");
        else if(eliminazioneOk==-1)
            System.out.println("Posizione non valida");
        else if(eliminazioneOk==-2)
            System.out.println("Posizione già vuota");
        else if(eliminazioneOk==-3)
            System.out.println("Ripiano non valido");
        
        eliminazioneOk=s1.rimuoviLibro(0,0);
        if (eliminazioneOk==0)
            System.out.println("eliminazione ok");
        else if(eliminazioneOk==-1)
            System.out.println("Posizione non valida");
        else if(eliminazioneOk==-2)
            System.out.println("Posizione già vuota");
        else if(eliminazioneOk==-3)
            System.out.println("Ripiano non valido");
        
        String[] elencoTitoliAutore;
        elencoTitoliAutore=s1.elencoTitoliAutore("J. R. R. Tolkien");
        
        
        if(elencoTitoliAutore==null)
            System.out.println("Nessun libro presente per questo autore");
        else
        {
            for(int i=0;i<elencoTitoliAutore.length;i++)
                 System.out.println(elencoTitoliAutore[i]);
                
        }
        
        //ciclo per visualizzare i libri presenti
        
        for (int i=0;i<s1.getNumRipiani();i++)
        {
            for(int j=0;j<s1.getNumMaxLibri(i);j++)
            {
                if(s1.getLibro(i, j)!=null)
                {
                    libro=s1.getLibro(i, j);
                    System.out.println("Ripiano: "+i+" Posizione: "+j+" "+libro.toString());
                }
            }
        }
        */
    }
    }

