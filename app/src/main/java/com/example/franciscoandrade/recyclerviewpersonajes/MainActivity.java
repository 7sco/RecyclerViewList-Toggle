package com.example.franciscoandrade.recyclerviewpersonajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listaPersonajes = new ArrayList<>();
//
//        recyclerPersonajes=findViewById(R.id.recyclerid);
//        //LinearLayout
//        //recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
//
//        //GridLayout
//        recyclerPersonajes.setLayoutManager(new GridLayoutManager(this, 3));
//
//        llenarPersonajes();
//
//        AdaptadorPersonajes adapter= new AdaptadorPersonajes(listaPersonajes);
//        recyclerPersonajes.setAdapter(adapter);

        construirRecycler();

    }

    private void llenarPersonajes() {
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
        listaPersonajes.add(new PersonajeVo("Homer", "Father", R.drawable.homer));
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnlist:
                Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.btngrid:
                Utilidades.visualizacion=Utilidades.GRID;
                break;
        }

        construirRecycler();

    }

    private void construirRecycler() {

        listaPersonajes = new ArrayList<>();

        recyclerPersonajes=findViewById(R.id.recyclerid);
        if (Utilidades.visualizacion == Utilidades.LIST){

            //LinearLayout
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        }
        else{
            //GridLayout
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this, Utilidades.GRID));
        }

        llenarPersonajes();

        AdaptadorPersonajes adapter= new AdaptadorPersonajes(listaPersonajes);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Sleccion: "+listaPersonajes.get
                        (recyclerPersonajes.getChildAdapterPosition(view))
                        .getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerPersonajes.setAdapter(adapter);
    }
}
