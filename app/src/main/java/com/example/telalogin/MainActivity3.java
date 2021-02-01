package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private Button filtro;
    private TextView filtro2;
    private  Button BuscarProdutos;
    private Button cadProd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        filtro = findViewById(R.id.filtro);
        BuscarProdutos = findViewById(R.id.BuscarProdutos);
        cadProd = findViewById(R.id.cadProd);

        cadProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
            }
        });



        BuscarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });

        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtro2 = (TextView) findViewById(R.id.filtro2);
                String nome = filtro2.getText().toString();

                if (nome.length() == 0) {
                    alert("Espaço Vazio, digitar algo para filtrar");


                } else {
                    alert("Filtrado");
                    Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}