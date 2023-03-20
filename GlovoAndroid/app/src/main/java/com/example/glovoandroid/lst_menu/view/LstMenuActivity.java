package com.example.glovoandroid.lst_menu.view;

/*
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.MainActivity;
import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Menu;
import com.example.glovoandroid.lst_menu.LstMenuContract;
import com.example.glovoandroid.lst_menu.presenter.LstMenuPresenter;
import com.example.glovoandroid.lst_puntuacion.LstPuntuacionContract;
import com.example.glovoandroid.lst_puntuacion.presenter.LstPuntuacionPresenter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;
*/

/*
public class LstMenuActivity extends AppCompatActivity implements LstMenuContract.View {
    private LstMenuAdapter lstMenuAdapter;
    private LstMenuPresenter lstMenuPresenter;
    private RecyclerView recyclerView;
    private ApiClient apiClient = new ApiClient();


    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.regresar:
                miIntent=new Intent(getBaseContext(), MainActivity.class);
                startActivity(miIntent);
                break;

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_restaurant);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        initPresenter();
        initData();

    }

    public void initPresenter(){
        lstMenuPresenter = new LstMenuPresenter(this);
    }
    public void initData(){
        lstMenuPresenter.lstMenus(null) ; //SELECT * FROM SIMPSON
    }

    @Override
    public void onSuccessLstMenus(ArrayList<Menu> lstMenu) {
        LstMenuAdapter adapter = new LstMenuAdapter(getBaseContext(),lstMenu);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstMenus(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }


}
*/
