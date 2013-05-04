/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class LieferantTyp {
    private int nummer;
    private String name;
    private AdresseTyp adresse;
    
    private LieferantTyp(){
        
    }

    public LieferantTyp(int nummer, String name, AdresseTyp adresse) {
        this.nummer = nummer;
        this.name = name;
        this.adresse = adresse;
    }

    public int getNummer() {
        return nummer;
    }



    public String getName() {
        return name;
    }

 

    public AdresseTyp getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseTyp adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.nummer;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.adresse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LieferantTyp other = (LieferantTyp) obj;
        if (this.nummer != other.nummer) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LieferantTyp{" + "nummer=" + nummer + ", name=" + name + ", adresse=" + adresse + '}';
    }
    
    
}
