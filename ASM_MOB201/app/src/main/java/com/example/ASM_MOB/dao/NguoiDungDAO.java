package com.example.ASM_MOB.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ASM_MOB.helper.DbHelper;

public class NguoiDungDAO {
    DbHelper dbHelper;
    SharedPreferences sharedPreferences;

    public NguoiDungDAO(Context context){
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences("THONGTIN", Context.MODE_PRIVATE);
    }
    // kiem tra thong tin dang nhap
    public boolean kiemTraDangNhap(String user, String pass){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password = ?", new String[]{user, pass});
        if(cursor.getCount() !=0){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("id", cursor.getInt(0));
            editor.apply();
            return true;
        }
        return false;
    }
}
