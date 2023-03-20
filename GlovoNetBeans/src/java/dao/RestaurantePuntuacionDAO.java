/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Restaurante;
import interfacesDAO.SQLTools;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import motores.MotorMySQL;

/**
 *
 * @author S2-PC00
 */
public class RestaurantePuntuacionDAO {
    private SQLTools miMotor = null;
    private static final String SELECT_ALL ="SELECT * FROM restaurante ORDER by restaurante.Puntuacion DESC LIMIT 10";
    public RestaurantePuntuacionDAO() {
        this.miMotor = new MotorMySQL();
    }
     public ArrayList<Restaurante> findAllP(Restaurante bean) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Restaurante> lstRestaurantes = null;
        try {
            this.miMotor.connect();
           
            sql_final = SELECT_ALL + sql_filtro;
            
            ResultSet resultset = this.miMotor.executeQuery(sql_final);

            if (resultset != null) {
                lstRestaurantes = new ArrayList();

                while (resultset.next()) {
                    Restaurante entidad = new Restaurante();
                    entidad.setID_RESTAURANTE(resultset.getInt(1));
                    entidad.setNOMBRE(resultset.getString(2));
                    entidad.setTIPO(resultset.getString(3));
                    entidad.setVENTAS(resultset.getInt(4));
                    entidad.setPUNTUACION(resultset.getInt(5));
                    entidad.setIMAGEN(resultset.getString(6));
                    lstRestaurantes.add(entidad);
                }
            }
            this.miMotor.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(RestaurantePuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstRestaurantes;
    }
}
