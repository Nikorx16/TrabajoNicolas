package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("ID_MENU")
    private int ID_MENU;

    @SerializedName("ID_RESTAURANTE")
    private int ID_RESTAURANTE;

    @SerializedName("NOMBREM")
    private String NOMBREM;

    @SerializedName("IMAGEN")
    private String IMAGEN;

    public Menu() {
    }

    public Menu(int ID_MENU, int ID_RESTAURANTE, String NOMBREM, String IMAGEN) {
        this.ID_MENU = ID_MENU;
        this.ID_RESTAURANTE = ID_RESTAURANTE;
        this.NOMBREM = NOMBREM;
        this.IMAGEN = IMAGEN;
    }

    public int getID_MENU() {
        return ID_MENU;
    }

    public void setID_MENU(int ID_MENU) {
        this.ID_MENU = ID_MENU;
    }

    public int getID_RESTAURANTE() {
        return ID_RESTAURANTE;
    }

    public void setID_RESTAURANTE(int ID_RESTAURANTE) {
        this.ID_RESTAURANTE = ID_RESTAURANTE;
    }

    public String getNOMBREM() {
        return NOMBREM;
    }

    public void setNOMBREM(String NOMBREM) {
        this.NOMBREM = NOMBREM;
    }

    public String getIMAGEN() {
        return IMAGEN;
    }

    public void setIMAGEN(String IMAGEN) {
        this.IMAGEN = IMAGEN;
    }
}
