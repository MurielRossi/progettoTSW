package com.muriel.storytelling.model;

import java.io.Serializable;

public class ReactionModel implements Serializable {
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

    public ReactionModel(int idStoria, String emailUtente) {
        this.idStoria = idStoria;
        this.emailUtente = emailUtente;
    }

    public ReactionModel() {
    }

    @Override
    public boolean equals(Object o) {
        ReactionModel reaction = (ReactionModel) o;
        return idStoria == reaction.idStoria && emailUtente.equals(reaction.emailUtente);
    }


    private int idStoria;
    private String emailUtente;
}