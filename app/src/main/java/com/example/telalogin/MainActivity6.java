package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    private TextView NomeProduto;
    private TextView preçoProduto;
    private Button CadastroProduto12;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        NomeProduto = (TextView) findViewById(R.id.NomeProduto);
        preçoProduto = (TextView) findViewById(R.id.preçoProduto);
        CadastroProduto12 = findViewById(R.id.CadastroProduto12);
        db = new DatabaseHelper(this);
        CadastroProduto12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome1 = NomeProduto.getText().toString();
                String preço1 = preçoProduto.getText().toString();

                if (nome1.isEmpty()) {
                    alert("nome esta vazio");
                } if (preço1.isEmpty()) {
                    alert("preço esta vazio");
                } else  {
                    boolean insert1 = db.insert1(nome1, preço1);
                    alert("produto cadastrado");
                }
            }
        });


    }
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}