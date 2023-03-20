package com.example.glovoandroid.lst_ficha;

import com.example.glovoandroid.entities.Restaurante;

import java.util.ArrayList;

public interface LstFichaContract {
    public interface View{
        void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant);
        void onFailureLstRestaurant(String err);
    }
   public interface Presenter{
        //Listado de los 10 restaurantes con más ventas.
        void lstRestaurant(String nombre);
   }
   public interface Model{
        interface onLstRestaurantListener{
            void onSuccess(ArrayList<Restaurante> lstRestaurant);
            void onFailure(String err);
        }
    void lstRestaurantWS(String nombre, onLstRestaurantListener onLstRestaurantListener);
   }
}
