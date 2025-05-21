package com.exemplo.bancouni; 

  

import android.content.Context; 

import android.database.sqlite.SQLiteDatabase; 

import android.database.sqlite.SQLiteOpenHelper; 

  

public class MeuBancoDeDados extends SQLiteOpenHelper { 

    private static final String NOME_BANCO = "bancouni.db"; 

    private static final int VERSAO = 1; 

  

    public MeuBancoDeDados(Context context) { 

        super(context, NOME_BANCO, null, VERSAO); 

    } 

  

    @Override 

    public void onCreate(SQLiteDatabase db) { 

        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, usuario TEXT, senha TEXT)"); 

    } 

  

    @Override 

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 

        db.execSQL("DROP TABLE IF EXISTS usuarios"); 

        onCreate(db); 

    } 

} 
