package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        private Text usuario;
        private Button Login;
        private Button Criar;
        DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        //Loc.por Id do botão
        Login = findViewById(R.id.Login);
        Criar = findViewById(R.id.Criar);

        //Click para o botão Criar conta
        Criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamar outra Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        //Click para o botão login conta
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Loc. dos TextView por id na tela;
                TextView usuario = (TextView) findViewById(R.id.usuario);;
                TextView senha = (TextView) findViewById(R.id.senha);
               // ele salva o que eu digitar nas variaveis criadas
                String login = usuario.getText().toString();
                String senha1 = senha.getText().toString();

                boolean chkmailpass = db.emailpassword(login, senha1);


                if (chkmailpass==true) {

                    alert("Login Realizado");
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                } else {
                    alert("login ou senha incorreta");
                }

            }
        });
    }

    //Alert na tela;
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}