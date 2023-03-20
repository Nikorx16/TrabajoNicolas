/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.RestauranteDAO;
import entidad.Restaurante;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class RestauranteAction implements dao.Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {

            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    
    private String findAll(HttpServletRequest request, 
                                HttpServletResponse response) {
        //int idPelicula = 0;
        RestauranteDAO restDao = new RestauranteDAO();
        //Restaurante rest = new Restaurante();
        //String sinopsis = request.getParameter("SINOPSIS");
        
        String tipo = request.getParameter("TIPO");
        /*if(request.getParameter("ID_PELICULA")!=null){
            idPelicula = Integer.parseInt(request.
                    getParameter("ID_PELICULA"));
        }*/
       /* if(sinopsis!=null && sinopsis.length()>0){
            rest.setSinopsis(sinopsis);
        }
        if(idPelicula>0){
            rest.setId(idPelicula);
        }*/
        ArrayList<Restaurante> lstRest = restDao.findAllB(tipo);
        return Restaurante.fromArrayListToJson(lstRest);
        //return Pelicula.toCadena(peliculas.get(0));

    }
    
}
