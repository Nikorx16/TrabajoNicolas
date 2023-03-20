package com.example.glovoandroid.lst_filtros.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_filtros.LstFiltroContract;
import com.example.glovoandroid.lst_filtros.model.LstFiltrosModel;

import java.util.ArrayList;

public class LstFiltrosPresenter implements LstFiltroContract.Presenter {
    private LstFiltrosModel lstFiltrosModel;
    private LstFiltroContract.View view;

    public LstFiltrosPresenter(LstFiltroContract.View view){
        this.view = view;
        this.lstFiltrosModel = new LstFiltrosModel();
    }

    @Override
    public void lstRestaurant(String filtro) {
        lstFiltrosModel.lstRestaurantWS(filtro, new LstFiltroContract.Model.onLstRestaurantListener() {
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
