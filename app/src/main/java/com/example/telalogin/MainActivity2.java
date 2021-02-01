package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView nome_cadastro;
    private Button tela2_voltar;
    private Button tela2_final;
    DatabaseHelper db;
    private TextView Senha1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = new DatabaseHelper(this);
        //Loc.por Id do botão
        tela2_voltar = findViewById(R.id.tela2_voltar);
        tela2_final = findViewById(R.id.tela2_final);

        tela2_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nome_cadastro = (TextView) findViewById(R.id.nome_cadastro);
                String nome = nome_cadastro.getText().toString();
                TextView Senha1 = (TextView) findViewById(R.id.Senha1);
                String senha = Senha1.getText().toString();

                

                if (nome_cadastro.length() != 0) {
                   boolean chkmail = db.chkemail(nome);
                    if (chkmail==true){
                            if (senha.length() == 0){
                               alert("A senha vazia");
                            } else {
                                boolean insert = db.insert(nome, senha);
                                alert("Cadastro Concluido");
                            }
                    } else {
                        alert("Email já estar Cadastrado");
                    }
                }
                    else {
                        alert("Não permitido");
                }
            }
        });


        tela2_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}