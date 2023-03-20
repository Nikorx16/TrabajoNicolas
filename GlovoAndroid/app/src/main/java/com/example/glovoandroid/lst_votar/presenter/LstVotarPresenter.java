package com.example.glovoandroid.lst_votar.presenter;

import com.example.glovoandroid.entities.Restaurante;

import com.example.glovoandroid.lst_votar.LstVotarContract;
import com.example.glovoandroid.lst_votar.model.LstVotarModel;

import java.util.ArrayList;

public class LstVotarPresenter implements LstVotarContract.Presenter {
    private LstVotarModel lstVotarModel;
    private LstVotarContract.View view;

    public LstVotarPresenter(LstVotarContract.View view){
        this.view = view;
        this.lstVotarModel = new LstVotarModel();
    }

    @Override
    public void lstRestaurant(String nombre,String num) {
        lstVotarModel.lstRestaurantWS(nombre,num, new LstVotarContract.Model.onLstRestaurantListener() {
            @Override
            public void onSuccess(ArrayList<Restaurante> lstRestaurante) {
                if(lstRestaurante!=null && lstRestaurante.size()>0){
                    view.onSuccessLstRestaurant(lstRestaurante);

                }else{
                    view.onSuccessLstRestaurant(lstRestaurante);
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureLstRestaurant(err);
            }
        });
    }
}


