package com.example.glovoandroid.lst_restaurantes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_ficha.view.LstFichaActivity;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.presenter.LstRestaurantPresenter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;

public class LstRestaurantActivity extends AppCompatActivity implements LstRestaurantContract.View {
    private LstRestaurantAdapter lstRestaurantAdapter;
    private LstRestaurantPresenter lstRestPresenter;
    private RecyclerView recyclerView;
    private  ApiClient apiClient = new ApiClient();
    private Button buton;

   /* @SuppressLint("NonConstantResourceId")
    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.regresar:
                miIntent=new Intent(LstRestaurantActivity.this, MainActivity.class);
                break;

        }
        startActivity(miIntent);
    }*/


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_lst_restaurant);
        //setContentView(R.layout.item_restaurant);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

      /* buton = findViewById(R.id.buton);
       buton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               v.findViewById(R.id.NOMBRE);
               Intent miIntent= new Intent(getBaseContext(), LstFichaActivity.class);
               miIntent.putExtra("nombre",v.findViewById(R.id.NOMBRE).toString());
               startActivity(miIntent);
           }
       });*/
        initPresenter();
        initData();

    }
    public void initComponents(){
        buton =  findViewById(R.id.buton);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.findViewById(R.id.NOMBRE);
                Intent miIntent= new Intent(getBaseContext(), LstFichaActivity.class);
                miIntent.putExtra("nombre",v.findViewById(R.id.NOMBRE).toString());
                startActivity(miIntent);
            }
        });
    }

    public void initPresenter(){
        lstRestPresenter = new LstRestaurantPresenter(this);
    }
    public void initData(){
        lstRestPresenter.lstRestaurant(null); //SELECT * FROM SIMPSON
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        LstRestaurantAdapter adapter = new LstRestaurantAdapter(getBaseContext(),lstRestaurant);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}