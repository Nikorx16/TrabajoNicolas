package com.example.glovoandroid.lst_ficha.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_ficha.LstFichaContract;
import com.example.glovoandroid.lst_ficha.model.LstFichaModel;

import java.util.ArrayList;

public class LstFichaPresenter implements LstFichaContract.Presenter {
    private LstFichaModel lstFichaModel;
    private LstFichaContract.View view;

    public LstFichaPresenter(LstFichaContract.View view){
        this.view = view;
        this.lstFichaModel = new LstFichaModel();
    }

    @Override
    public void lstRestaurant(String nombre) {
        lstFichaModel.lstRestaurantWS(nombre, new LstFichaContract.Model.onLstRestaurantListener() {
            @Override
            public void onSuccess(ArrayList<Restaurante> lstRestaurante) {
                if (lstRestaurante != null && lstRestaurante.size() > 0) {
                    view.onSuccessLstRestaurant(lstRestaurante);

                } else {
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
