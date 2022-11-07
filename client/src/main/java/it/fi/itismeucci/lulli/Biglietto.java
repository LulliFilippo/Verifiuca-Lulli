package it.fi.itismeucci.lulli;

public class Biglietto {
    private int id;
    private String posto;


    public Biglietto() {
    }

    public Biglietto(int id, String posto) {
        this.id = id;
        this.posto = posto;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosto() {
        return this.posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

}
