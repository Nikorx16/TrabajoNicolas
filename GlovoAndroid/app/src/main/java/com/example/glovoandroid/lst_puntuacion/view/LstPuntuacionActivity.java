package com.example.glovoandroid.lst_puntuacion.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_puntuacion.LstPuntuacionContract;
import com.example.glovoandroid.lst_puntuacion.presenter.LstPuntuacionPresenter;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantAdapter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;

public class LstPuntuacionActivity extends AppCompatActivity implements LstPuntuacionContract.View {
    private LstPuntuacionPresenter lstRestaurantAdapter;
    private LstPuntuacionPresenter lstPuntuacionPresenter;
    private RecyclerView recyclerView;
    private ApiClient apiClient = new ApiClient();


  /*  public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.regresar:
                miIntent=new Intent(getBaseContext(), MainActivity.class);
                startActivity(miIntent);
                break;

        }

    }
*/
    /*private TextView idRestaurante;
    private TextView nombreRestaurante;
    private TextView direccionRestaurante;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnt_restaurant);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        initPresenter();
        initData();

    }

    public void initPresenter(){
        lstPuntuacionPresenter = new LstPuntuacionPresenter(this);
    }
    public void initData(){
        lstPuntuacionPresenter.lstRestaurant(null); //SELECT * FROM SIMPSON
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
