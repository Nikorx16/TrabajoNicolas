/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author S2-PC00
 */
public class Menu {
    private int id_Menu;
    private String nombre;
    private int id_Restaurante;
    private String imagen;

    public Menu() {

    }

    public Menu(int id_Restaurante, String nombre,int id_Menu,String imagen) {
        this.id_Menu = id_Restaurante;
        this.nombre = nombre;
        this.id_Restaurante=id_Menu;
        this.imagen=imagen;
    }

    public int getId_Menu() {
        return id_Menu;
    }

    public void setId_Menu(int id_Menu) {
        this.id_Menu = id_Menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_Restaurante() {
        return id_Restaurante;
    }

    public void setId_Restaurante(int id_Restaurante) {
        this.id_Restaurante = id_Restaurante;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
     public static String fromArrayListToJson(ArrayList<Menu> lstMenu) {
        String resp = "[";
        for (Menu menu : lstMenu) {
            resp += "{"
                    + "\"ID_MENU\":\"" + menu.getId_Menu()+ "\", "
                    + "\"NOMBREM\":\"" + menu.getNombre() + "\","
                    + "\"ID_RESTAURANTE\":\"" + menu.getId_Restaurante()+ "\", "
                     + "\"IMAGEN\":\"" + menu.getImagen()+ "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }
}
