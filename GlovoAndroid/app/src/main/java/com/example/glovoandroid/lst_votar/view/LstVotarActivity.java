package com.example.glovoandroid.lst_votar.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_ficha.view.LstFichaActivity;
import com.example.glovoandroid.lst_filtros.LstFiltroContract;
import com.example.glovoandroid.lst_filtros.presenter.LstFiltrosPresenter;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantActivity;
import com.example.glovoandroid.lst_votar.LstVotarContract;
import com.example.glovoandroid.lst_votar.presenter.LstVotarPresenter;

import java.util.ArrayList;

public class LstVotarActivity extends AppCompatActivity implements LstVotarContract.View {


    private LstVotarPresenter lstVotarPresenter;
    private RecyclerView recyclerView;
    private Button btnObtenerDatos;
    private Spinner comboNum;

         @Override
    protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_vtr_restaurant);
             String comanda;
             String nombre = null;
             String num=null;
             Bundle extras = getIntent().getExtras();
             if(extras == null) {
                 comanda= null;
             } else {
                 //comanda= extras.getString("String_I_Need");
                 nombre=extras.getString("String_I_Need");
                 num=extras.getString("String_U");
             }
             /*comboNum = findViewById(R.id.SpinnerNum);
             btnObtenerDatos = findViewById(R.id.btnObtenerDatos);*/
/*
             String[] parts = comanda.split("-");
             String nombre = parts[0]; //obtiene: 19
             String num= parts[1]; //obtiene: 19-A*/
             initComponents();
             initPresenter();
             initData(nombre,num);
             //Intent miIntent= new  Intent(getBaseContext(), LstFichaActivity.class);
             //miIntent.putExtra("String_I_Need",nombre);
             //startActivity(miIntent);
         }
  /*  public void onObtenerDatosClick() {
        lstVotarPresenter.onObtenerDatosClick();
    }*/

    public void initComponents(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerVtr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        /*comboNum = findViewById(R.id.SpinnerNum);
        ArrayAdapter<CharSequence> adapternum = ArrayAdapter.createFromResource(this,R.array.votar, android.R.layout.simple_spinner_item);
        comboNum.setAdapter(adapternum);*/


    }



    public void initPresenter(){
        lstVotarPresenter = new LstVotarPresenter((LstVotarContract.View) this);
    }

    public void initData(String nombre, String num){ lstVotarPresenter.lstRestaurant(nombre,num);
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        LstVotarAdapter adapter = new LstVotarAdapter(getBaseContext(),lstRestaurant);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }

/*

    @Override
    public String getOpcion1Seleccionada() {
        return comboNec.getSelectedItem().toString();
    }

    @Override
    public String getOpcion2Seleccionada() {
        return comboNum.getSelectedItem().toString();
    }

*/

}