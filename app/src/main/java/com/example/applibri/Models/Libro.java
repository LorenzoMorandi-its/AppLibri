package com.example.applibri.Models;

public class Libro {

    private String titolo;
    private String autore;
    private String descrizione;
    private int pagine;


    public Libro(String titolo, String autore, String descrizione, int pagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.descrizione = descrizione;
        this.pagine = pagine;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }
}
