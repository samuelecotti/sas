/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author cotti
 */
public class EccezionePosizioneNonValida extends Exception
{
    private int ripiano;
    private int posizione;
    
    public EccezionePosizioneNonValida(int ripiano,int posizione)
    {
        this.ripiano=ripiano;
        this.posizione=posizione;
    }
    
    public int getRipiano()
    {
        return ripiano;
    }
    
    public int getPosizione()
    {
        return posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="la posizione ripiano: "+getRipiano()+" posizione: "+getPosizione()+" non è valida.";
        return s;
    }
    
    
}
