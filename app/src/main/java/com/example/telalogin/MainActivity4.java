package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    public TextView nomes2;
    public Button filtro5;
    public TextView filtro3;
    public RecyclerView listaView;
    ArrayList<String> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        filtro5 = findViewById(R.id.filtro5);
        TextView nomes2 = (TextView) findViewById(R.id.nomes2);
        listaView = findViewById(R.id.listaView);


        //configurar adpter




        //configurar recyclerview






        ArrayList<String>Lista = new ArrayList();
        Lista.add("R$ 10,00 - Coca-Cola");
        Lista.add("R$ 5,00 - Pastel de Carne");
        Lista.add("R$ 10,00 - Pizza");



                TextView filtro3 = (TextView) findViewById(R.id.filtro3);
                String nome = filtro3.getText().toString();
                listaView = (RecyclerView) findViewById(R.id.listaView);
                produtos = new ArrayList();
                produtos.add("R$ 10,00 - Coca-Cola");
                produtos.add("R$ 5,00 - Pastel de Carne");
                produtos.add("R$ 10,00 - Pizza");




                RecyclerView.Adapter adapter;



                //adapter
                adapter = new AdapterProduto(produtos);

                //configurar o recycle
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                listaView.setLayoutManager(layoutManager);
                listaView.setHasFixedSize(true);
                listaView.setAdapter(adapter);






    }

}
