package com.example.cesaro.cloudfirestore;

public class Disco {

    String nameA;
    String artistaA;
    String duracionA;
    String urlImage;

    public Disco(String nameA, String artistaA, String duracionA, String urlImage) {
        this.nameA = nameA;
        this.artistaA = artistaA;
        this.duracionA = duracionA;
        this.urlImage = urlImage;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getArtistaA() {
        return artistaA;
    }

    public void setArtistaA(String artistaA) {
        this.artistaA = artistaA;
    }

    public String getDuracionA() {
        return duracionA;
    }

    public void setDuracionA(String duracionA) {
        this.duracionA = duracionA;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}

