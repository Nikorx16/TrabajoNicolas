package com.example.glovoandroid.utils;

import com.example.glovoandroid.entities.Menu;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.RestauranteRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("filtr_usu/api")
    Call<ArrayList<Restaurante>> getRestaurante();
    @GET("filtr_usu/punt")
    Call<ArrayList<Restaurante>> getPuntuacion();
    @GET("filtr_usu/menu")
    Call<ArrayList<Menu>> getMenu();
    @GET("filtr_usu/filtr_usu/{tipo}")
    Call<ArrayList<Restaurante>> getFiltroRestaurante(@Path("tipo") String tipo);

    @GET("filtr_usu/filtr_fch/{nombre}")
    Call<ArrayList<Restaurante>> getFichaRestaurante(@Path("nombre") String nombre);

    @GET("filtr_usu/filtr_vt/{nombre}/{num}")
    Call<ArrayList<Restaurante>> getVotarRestaurante(@Path("nombre") String nombre, @Path("num") String num);


}
