package com.example.bancouni; 

  

import android.content.Intent; 

import android.os.Bundle; 

import android.view.View; 

import android.widget.Button; 

  

import androidx.appcompat.app.AppCompatActivity; 

  

public class MainActivity extends AppCompatActivity { 

  

    Button btnLogin, btnCadastro; 

  

    @Override 

    protected void onCreate(Bundle savedInstanceState) { 

        super.onCreate(savedInstanceState); 

        setContentView(R.layout.activity_main); 

  

        btnLogin = findViewById(R.id.btnLogin); 

        btnCadastro = findViewById(R.id.btnCadastro); 

  

        btnLogin.setOnClickListener(new View.OnClickListener() { 

            @Override 

            public void onClick(View view) { 

                Intent intent = new Intent(MainActivity.this, LoginActivity.class); 

                startActivity(intent); 

            } 

        }); 

  

        btnCadastro.setOnClickListener(new View.OnClickListener() { 

            @Override 

            public void onClick(View v) { 

                Intent intent = new Intent(MainActivity.this, CadastroActivity.class); 

                startActivity(intent); 

            } 

        }); 

  

    } 

} 
