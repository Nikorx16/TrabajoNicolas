package com.example.glovoandroid.lst_ficha.view;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaController;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_votar.view.LstVotarActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

    public class LstFichaAdapter extends RecyclerView.Adapter<LstFichaAdapter.ViewHolder> {
    private ArrayList<Restaurante> dataset;
    private Context mContext;
    private EditText editText;

    public LstFichaAdapter(Context mContext, ArrayList<Restaurante> lstRestaurantes){
        this.dataset = lstRestaurantes;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_restaurant_todo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = dataset.get(position);
        holder.idRestaurante.setText(String.valueOf(r.getID_RESTAURANTE()));
        holder.nombreRestaurante.setText(r.getNOMBRE());
        holder.tipoRestaurante.setText(r.getTIPO());
        holder.ventasRestaurante.setText(String.valueOf(r.getVENTAS()));
        holder.puntuacionRestaurante.setText(String.valueOf(r.getPUNTUACION()));
        Picasso.get().load(r.getIMAGEN()).into(holder.imagenRestaurante);
        holder.escribir.getText();
        holder.buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent= new Intent(v.getContext() , LstVotarActivity.class);
                String nombre=r.getNOMBRE();
                //editText=v.findViewById(R.id.Puntuar);
                String num= String.valueOf(holder.escribir.getText());
                //String num="7";
                //String comanda=nombre+"-"+num;
                // String nombre=v.findViewById(R.id.NOMBRE);
                miIntent.putExtra("String_I_Need",nombre);
                miIntent.putExtra("String_U",num);
                //miIntent.putExtra("String_I_Need",v.findViewById(R.id.NOMBRE).toString());
                miIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(miIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idRestaurante;
        private TextView nombreRestaurante;
        private TextView tipoRestaurante;
        private TextView ventasRestaurante;
        private TextView puntuacionRestaurante;
        private ImageView imagenRestaurante;
        Button buton;
        private EditText escribir;


        public ViewHolder(View itemView) {
            super(itemView);

            idRestaurante = itemView.findViewById(R.id.ID_RESTAURANTE);
            nombreRestaurante = itemView.findViewById(R.id.NOMBRE);
            tipoRestaurante = itemView.findViewById(R.id.TIPO);
            ventasRestaurante = itemView.findViewById(R.id.VENTAS);
            puntuacionRestaurante = itemView.findViewById(R.id.PUNTUACION);
            imagenRestaurante=(ImageView)itemView.findViewById(R.id.IMAGEN);
            buton=(Button) itemView.findViewById(R.id.button);
            escribir=(EditText) itemView.findViewById(R.id.Puntuar);

        }
    }
    public void adicionarListaRestaurante(ArrayList<Restaurante> lstRestaurant) {
        //dataset.addAll(lstRestaurant);
        //notifyDataSetChanged();
    }

}
