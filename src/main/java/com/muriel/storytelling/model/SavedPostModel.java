package com.muriel.storytelling.model;

public class SavedPostModel //in salva post, se l'utente è loggato, deve salvare il carrello sul database
{
    private int idStoria;
    private String email;

    public int getIdStoria() {
        return idStoria;
    }

    public void setIdStoria(int idStoria) {
        this.idStoria = idStoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SavedPostModel() {
    }

    public SavedPostModel(int idStoria, String email) {
        this.idStoria = idStoria;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SavedPostModel{" +
                "idStoria=" + idStoria +
                ", email='" + email + '\'' +
                '}';
    }
}
