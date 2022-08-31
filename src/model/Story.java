package model;

public class Story implements Serializable
{
    private int id;
    private String username;
    private String contenuto;
    private int nReazioni;
    private LocalDate dataCreazione;


    @Override
    public boolean equals(Object o) {
        Storia storia = (Storia) o;
        return id == storia.id && nReazioni == storia.nReazioni && username.equals(storia.username) && contenuto.equals(storia.contenuto) && Objects.equals(dataCreazione, storia.dataCreazione);
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

    public Storia(){

    }

}


