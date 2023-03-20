package com.example.glovoandroid.lst_ficha.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_ficha.LstFichaContract;
import com.example.glovoandroid.lst_ficha.presenter.LstFichaPresenter;
import com.example.glovoandroid.lst_filtros.LstFiltroContract;
import com.example.glovoandroid.lst_filtros.presenter.LstFiltrosPresenter;

import java.util.ArrayList;

public class LstFichaActivity extends AppCompatActivity implements LstFichaContract.View {
    private LstFichaAdapter lstFichaAdapter;
    private LstFichaPresenter lstFichaPresenter;
    private RecyclerView recyclerView;
    private Spinner comboNec;


         @Override
    protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_fch_restaurant);
             String Nombre;

                 Bundle extras = getIntent().getExtras();
                 if(extras == null) {
                     Nombre= null;
                 } else {
                     Nombre= extras.getString("String_I_Need");
                 }

             //= savedInstanceState.getString("nombre");
            //Inicializa
             initComponents();
                 //Declara
             initPresenter();
             //ejecutta la funcion del get
             initData(Nombre);

         }

    public void initComponents(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerFch);
        //pintar
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    public void initPresenter(){
        lstFichaPresenter = new LstFichaPresenter(this);
    }
    public void initData(String nombre){
        lstFichaPresenter.lstRestaurant(nombre);
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        LstFichaAdapter adapter = new LstFichaAdapter(getBaseContext(),lstRestaurant);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}