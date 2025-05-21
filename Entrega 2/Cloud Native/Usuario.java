package com.exemplo.bancouni; 

  

import android.content.ContentValues; 

import android.content.Context; 

import android.database.Cursor; 

import android.database.sqlite.SQLiteDatabase; 

  

public class UsuarioDAO { 

    private MeuBancoDeDados dbHelper; 

  

    public UsuarioDAO(Context context) { 

        dbHelper = new MeuBancoDeDados(context); 

    } 

  

    public boolean inserirUsuario(String email, String usuario, String senha) { 

        SQLiteDatabase db = dbHelper.getWritableDatabase(); 

        ContentValues valores = new ContentValues(); 

        valores.put("email", email); 

        valores.put("usuario", usuario); 

        valores.put("senha", senha); 

  

        long resultado = db.insert("usuarios", null, valores); 

        db.close(); 

        return resultado != -1; 

    } 

  

    public boolean validarLogin(String usuario, String senha) { 

        SQLiteDatabase db = dbHelper.getReadableDatabase(); 

        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE (email = ? OR usuario = ?) AND senha = ?", new String[]{usuario, usuario, senha}); 

        boolean sucesso = cursor.moveToFirst(); 

        cursor.close(); 

        db.close(); 

        return sucesso; 

    } 

} 
