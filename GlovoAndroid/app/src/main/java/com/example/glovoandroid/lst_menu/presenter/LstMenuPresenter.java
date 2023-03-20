package com.example.glovoandroid.lst_menu.presenter;

import com.example.glovoandroid.entities.Menu;
import com.example.glovoandroid.lst_menu.LstMenuContract;
import com.example.glovoandroid.lst_menu.model.LstMenuModel;

import java.util.ArrayList;

/*
public class LstMenuPresenter implements LstMenuContract.Presenter {
    private LstMenuModel lstMenuModel;
    private LstMenuContract.View view;

    public LstMenuPresenter(LstMenuContract.View view){
        this.view = view;
        this.lstMenuModel = new LstMenuModel();
    }

    @Override
    public void lstMenus(Menu menu) {
        lstMenuModel.lstMenuWS(null, new LstMenuContract.Model.onLstMenuListener(){
                @Override
                public void onSuccess(ArrayList<Menu> lstMenu) {

                    if(lstMenu!=null && lstMenu.size()>0){
                        view.onSuccessLstMenus(lstMenu);

                    }else{
                        view.onSuccessLstMenus(lstMenu);
                    }
                }

                @Override
                public void onFailure(String err) {
                    view.onFailureLstMenus(err);
                }
            });
    }
}
*/
