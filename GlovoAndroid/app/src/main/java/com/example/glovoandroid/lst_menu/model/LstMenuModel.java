package com.example.glovoandroid.lst_menu.model;

import com.example.glovoandroid.entities.Menu;
import com.example.glovoandroid.lst_menu.LstMenuContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LstMenuModel implements LstMenuContract.Model {


   /* @Override
    public void lstMenuWS(Menu menu, onLstMenuListener onLstMenusListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Menu>> call = apiService.getMenu();
        call.enqueue(new Callback<ArrayList<Menu>>() {
            @Override
            public void onResponse(Call<ArrayList<Menu>> call, Response<ArrayList<Menu>> response) {
                ArrayList<Menu> listaMenu = response.body();
                onLstMenuListener.onSuccess(listaMenu);
            }

            @Override
            public void onFailure(Call<ArrayList<Menu>> call, Throwable t) {
                onLstMenuListener.onFailure(t.getMessage());
            }
        });
    }

*/
}
