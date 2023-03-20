package com.example.glovoandroid.lst_votar.model;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_filtros.LstFiltroContract;
import com.example.glovoandroid.lst_votar.LstVotarContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LstVotarModel implements LstVotarContract.Model {
    @Override
    public void lstRestaurantWS(String comanda, String num, onLstRestaurantListener onLstRestaurantListener) {
       ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
       Call<ArrayList<Restaurante>> call = apiService.getVotarRestaurante(comanda,num);
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
