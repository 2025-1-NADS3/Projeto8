package com.exemplo.bancouni; 

  

import android.content.Intent; 

import android.os.Bundle; 

import android.view.View; 

import androidx.appcompat.app.AppCompatActivity; 

  

public class MainActivity extends AppCompatActivity { 

    @Override 

    protected void onCreate(Bundle savedInstanceState) { 

        super.onCreate(savedInstanceState); 

        setContentView(R.layout.activity_main); 

    } 

  

    public void irParaLogin(View view) { 

        startActivity(new Intent(this, LoginActivity.class)); 

    } 

  

    public void irParaCadastro(View view) { 

        startActivity(new Intent(this, CadastroActivity.class)); 

    } 

} 
