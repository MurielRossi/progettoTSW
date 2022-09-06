package com.muriel.storytelling.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class StoryModel implements Serializable
{
    private int id;
    private String username;
    private String contenuto;
    private int nReazioni;
    private LocalDate dataCreazione;


    @Override
    public boolean equals(Object o) {
        StoryModel story = (StoryModel) o;
        return id == story.id && nReazioni == story.nReazioni && username.equals(story.username) && contenuto.equals(story.contenuto) && Objects.equals(dataCreazione, story.dataCreazione);
    }


    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Integer getNReazioni() {
        return nReazioni;
    }

    public void setNReazioni(Integer nReazioni) {
        this.nReazioni = nReazioni;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StoryModel() {

    }

    public StoryModel(String username, String contenuto, int nReazioni, LocalDate dataCreazione) {
        this.username = username;
        this.contenuto = contenuto;
        this.nReazioni = nReazioni;
        this.dataCreazione = dataCreazione;
    }
}


