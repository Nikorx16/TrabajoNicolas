package com.example.glovoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.glovoandroid.lst_ficha.view.LstFichaActivity;
import com.example.glovoandroid.lst_ficha.view.LstFichaAdapter;
import com.example.glovoandroid.lst_filtros.view.LstFiltrosActivity;
import com.example.glovoandroid.lst_puntuacion.view.LstPuntuacionActivity;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantActivity;
import com.example.glovoandroid.lst_votar.view.LstVotarActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
@SuppressLint("NonConstantResourceId")
public void onClick(View view){
    Intent miIntent=null;
        switch (view.getId()) {
            case R.id.vistalst:
                //miIntent = new Intent(MainActivity.this, LstRestaurantActivity.class);
                miIntent = new  Intent(getBaseContext(), LstRestaurantActivity.class);
                startActivity(miIntent);
                break;
    
            case R.id.vistapunt:
                miIntent=new Intent(getBaseContext(), LstPuntuacionActivity.class);
                startActivity(miIntent);
                break;
           case R.id.vistaflt:
                miIntent=new Intent(getBaseContext(), LstFiltrosActivity.class);
                startActivity(miIntent);
                break;
         /*   case R.id.vistafch:
                miIntent=new Intent(getBaseContext(), LstFichaActivity.class);
                startActivity(miIntent);
                break;*/
/*
            case R.id.vistavtr:
                miIntent=new Intent(getBaseContext(), LstVotarActivity.class);
                startActivity(miIntent);
                break;*/
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }



}

}