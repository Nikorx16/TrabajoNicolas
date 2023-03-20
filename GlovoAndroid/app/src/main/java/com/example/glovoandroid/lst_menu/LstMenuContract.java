package com.example.glovoandroid.lst_menu;

import com.example.glovoandroid.entities.Menu;

import java.util.ArrayList;

public interface LstMenuContract {
    public interface View {
        void onSuccessLstMenus(ArrayList<Menu> lstMenu);

        void onFailureLstMenus(String err);
    }

    public interface Presenter {
        //Listado de los 10 restaurantes con más ventas.
        void lstMenus(Menu menu);
    }

    public interface Model {
        interface onLstMenuListener {

            static void onSuccess() {
                onSuccess();
            }

            /*
                       static void onSuccess(ArrayList<Menu> lstMenu) {

                       }

                       void onSuccess(ArrayList<Menu> lstMenu);

                       static void onFailure(String err) {

                       }

                       void onFailure(String err);
                   }*/
            void lstMenuWS(Menu menu, onLstMenuListener onLstMenuListener);

        }
    }
}
