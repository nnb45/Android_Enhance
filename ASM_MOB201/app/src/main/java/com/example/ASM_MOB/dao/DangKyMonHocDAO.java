package com.example.ASM_MOB.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ASM_MOB.helper.DbHelper;
import com.example.ASM_MOB.model.MonHoc;
import com.example.ASM_MOB.model.ThongTin;

import java.util.ArrayList;

public class DangKyMonHocDAO {
    private DbHelper dbHelper;
    private String name;
    private String techer;


    public DangKyMonHocDAO(Context context){
        dbHelper = new DbHelper(context);
    }
    //lay danh sach mon hoc
    public ArrayList<MonHoc> getDSMonHoc(int id){
        ArrayList<MonHoc> list = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT mh.code, mh.name, mh.teacher, dk.id FROM MONHOC mh LEFT JOIN DANGKY dk ON mh.code = dk.code AND dk.id = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() !=0){
            cursor.moveToFirst();
            do{
                list.add(new MonHoc(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    // dang ky mon hoc
    public boolean dangKyMonHoc(int id, String code){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("code", code);
        long check = sqLiteDatabase.insert("DANGKY", null, contentValues);
        if(check == -1)
            return false;
        return true;

    }
//    public boolean huyDangKyMonHoc(int id, String code) {
//        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        long check = sqLiteDatabase.insert("DANGKY", null, new String[]{String.valueOf(id), code});
//        if(check == -1)
//            return false;
//        return true;
//    }

//    public ArrayList<ThongTin> getThongTinMonHoc(String code){
//        ArrayList<ThongTin> list = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT date, address FROM THONGTIN WHERE");
//
//        return list;
//    }
}
