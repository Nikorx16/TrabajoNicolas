package com.example.glovoandroid.lst_puntuacion.model;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_puntuacion.LstPuntuacionContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LstPuntuacionModel implements LstPuntuacionContract.Model {
    @Override
    public void lstRestaurantWS(Restaurante restaurante, onLstRestaurantListener onLstRestaurantListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Restaurante>> call = apiService.getPuntuacion();
        call.enqueue(new Callback<ArrayList<Restaurante>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurante>> call, Response<ArrayList<Restaurante>> response) {
                ArrayList<Restaurante> listaRestaurante = response.body();
                onLstRestaurantListener.onSuccess(listaRestaurante);
            }

            @Override
            public void onFailure(Call<ArrayList<Restaurante>> call, Throwable t) {
                    onLstRestaurantListener.onFailure(t.getMessage());
            }
        });

    }

}
