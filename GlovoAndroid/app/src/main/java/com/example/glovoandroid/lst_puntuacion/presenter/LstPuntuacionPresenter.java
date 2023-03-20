package com.example.glovoandroid.lst_puntuacion.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_puntuacion.LstPuntuacionContract;
import com.example.glovoandroid.lst_puntuacion.model.LstPuntuacionModel;


import java.util.ArrayList;

public class LstPuntuacionPresenter implements LstPuntuacionContract.Presenter {
    private LstPuntuacionModel lstPuntuacionModel;
    private LstPuntuacionContract.View view;

    public LstPuntuacionPresenter(LstPuntuacionContract.View view){
        this.view = view;
        this.lstPuntuacionModel = new LstPuntuacionModel();
    }

    @Override
    public void lstRestaurant(Restaurante restaurante) {
        lstPuntuacionModel.lstRestaurantWS(null, new LstPuntuacionContract.Model.onLstRestaurantListener() {
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
