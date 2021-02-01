package com.example.telalogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "BancoDeDados.db", null, 1);
    }

    @Override
    //crinado a tabela usuario(user)
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
        db.execSQL("Create table produto(nome text primary key, preço text)");
    }

    //drop da tabela user(caso queira)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists produto");
    }
    //inserir no database

    //Inserir na tabela produto
    public Boolean insert1 (String nome, String preço) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("preço", preço);
        long ins = db.insert("produto",null, contentValues);
        if (ins == -1)
            return false;
            else return true;

    }


    //inserir tabela user
    public boolean insert (String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins ==-1) return false;
        else return true;
    }
       //checar se o email já existi no banco (if email exists)
        public boolean chkemail (String email) {
        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from user where email= ?", new String[]{email});
            if (cursor.getCount()>0) {
                return false;
            } else return true;
        }

       //checar se o email e senha já existi no banco
        public boolean emailpassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email= ? and password=?", new String[]{email, password});
        if (cursor.getCount()>0) {
            return true;
        } else {
            return  false;
        }
    }
}
