package com.example.glovoandroid.lst_filtros.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_filtros.LstFiltroContract;
import com.example.glovoandroid.lst_filtros.presenter.LstFiltrosPresenter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LstFiltrosActivity extends AppCompatActivity implements LstFiltroContract.View {
    private LstFiltroAdapter lstFiltroAdapter;
    private LstFiltrosPresenter lstRestPresenter;
    private RecyclerView recyclerView;
    private Spinner comboNec;



         @Override
    protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_ftr_restaurant);
             initComponents();
             initPresenter();
             //initData();
         }

    public void initComponents(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerFltr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        comboNec = (Spinner) findViewById(R.id.SpinnerNec);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.filtros, android.R.layout.simple_spinner_item);
        comboNec.setAdapter(adapter);

        comboNec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(adapterView.getContext(),"Seleccionado: " + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                initData(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void initPresenter(){
        lstRestPresenter = new LstFiltrosPresenter(this);
    }
    public void initData(String filtro){
        lstRestPresenter.lstRestaurant(filtro);
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        LstFiltroAdapter adapter = new LstFiltroAdapter(getBaseContext(),lstRestaurant);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}