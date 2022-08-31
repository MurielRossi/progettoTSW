package model;

import java.io.Serializable;



public class Reaction implements Serializable {
    public int getIdStoria() {
        return idStoria;
    }

    public void setIdStoria(int idStoria) {
        this.idStoria = idStoria;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }



    @Override
    public boolean equals(Object o) {
        Reaction reaction = (Reaction) o;
        return idStoria == reaction.idStoria && emailUtente.equals(reaction.emailUtente);
    }


    private int idStoria;
    private String emailUtente;
}