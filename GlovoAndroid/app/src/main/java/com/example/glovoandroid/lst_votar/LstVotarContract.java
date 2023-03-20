package com.example.glovoandroid.lst_votar;

import com.example.glovoandroid.entities.Restaurante;

import java.util.ArrayList;

public interface LstVotarContract {
    public interface View{
        void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant);
        void onFailureLstRestaurant(String err);
    }
   public interface Presenter{
       //String getOpcion2Seleccionada();

       //String getOpcion1Seleccionada();
        //Listado de los 10 restaurantes con más ventas.
       void lstRestaurant(String nombre, String num);
   }
   public interface Model{
        interface onLstRestaurantListener{
            void onSuccess(ArrayList<Restaurante> lstRestaurante);
            void onFailure(String err);
        }
    void lstRestaurantWS(String nombre, String num, onLstRestaurantListener onLstRestaurantListener);
   }
}
