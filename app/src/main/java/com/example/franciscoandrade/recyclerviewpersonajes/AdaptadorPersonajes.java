package com.example.franciscoandrade.recyclerviewpersonajes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by franciscoandrade on 11/15/17.
 */

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes> implements View.OnClickListener {

    ArrayList<PersonajeVo> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;


        if(Utilidades.visualizacion==Utilidades.LIST){
        //View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personajes, null, false);
            layout=R.layout.item_list_personajes;
        }
        else{
            layout=R.layout.item_grid_personajes;
        }


        View view= LayoutInflater.from(parent.getContext()).inflate(layout, null, false);


        view.setOnClickListener(this);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {

        holder.etiNombre.setText(listaPersonajes.get(position).getNombre());

        //holder.etiInformacion.setText(listaPersonajes.get(position).getInfo());
        if(Utilidades.visualizacion==Utilidades.LIST){
            holder.etiInformacion.setText(listaPersonajes.get(position).getInfo());

        }

        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }


    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {
        TextView etiNombre, etiInformacion;
        ImageView foto;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);
            etiNombre       = itemView.findViewById(R.id.idNombre);
            if(Utilidades.visualizacion==Utilidades.LIST){

                etiInformacion  = itemView.findViewById(R.id.idInfo);
            }

            //etiInformacion  = itemView.findViewById(R.id.idInfo);
            foto            = itemView.findViewById(R.id.idImage);

        }
    }
}
