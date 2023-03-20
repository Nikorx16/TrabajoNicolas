package com.example.glovoandroid.lst_menu.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Menu;
import com.example.glovoandroid.entities.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
public class LstMenuAdapter extends RecyclerView.Adapter<LstMenuAdapter.ViewHolder> {
    private ArrayList<Menu> dataset;
    private Context mContext;

    public LstMenuAdapter(Context mContext, ArrayList<Menu> lstMenu){
        this.dataset = lstMenu;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_menu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Menu r = dataset.get(position);
        holder.idMenu.setText(String.valueOf(r.getID_MENU()));
        holder.idRestaurante.setText(String.valueOf(r.getID_RESTAURANTE()));
        holder.nombreMenu.setText(r.getNOMBREM());
        Picasso.get().load(r.getIMAGEN()).into(holder.imagenMenu);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idMenu;
        private TextView idRestaurante;
        private TextView nombreMenu;
        private ImageView imagenMenu;



        public ViewHolder(View itemView) {
            super(itemView);


            idMenu = itemView.findViewById(R.id.ID_MENU);
            idRestaurante = itemView.findViewById(R.id.ID_RESTAURANTE);
            nombreMenu = itemView.findViewById(R.id.NOMBREM);
            imagenMenu=(ImageView)itemView.findViewById(R.id.IMAGEN);
        }
    }
    public void adicionarListaRestaurante(ArrayList<Restaurante> lstRestaurant) {
        //dataset.addAll(lstRestaurant);
        //notifyDataSetChanged();
    }

}
*/
