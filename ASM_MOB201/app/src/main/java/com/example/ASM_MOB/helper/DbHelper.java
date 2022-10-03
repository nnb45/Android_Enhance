package com.example.ASM_MOB.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "DANGKYMONHOC", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbNguoiDung = "CREATE TABLE NGUOIDUNG(id integer primary key autoincrement, username text, password text, name text)";
        sqLiteDatabase.execSQL(dbNguoiDung);

        String dbMonHoc = "CREATE TABLE MONHOC(code text primary key, name text, teacher text)";
        sqLiteDatabase.execSQL(dbMonHoc);

        String dbThongTin = "CREATE TABLE THONGTIN(id integer primary key autoincrement, code text, data text, address text)";
        sqLiteDatabase.execSQL(dbThongTin);

        String dbDangKy = "CREATE TABLE DANGKY(id integer, code text)";
        sqLiteDatabase.execSQL(dbDangKy);

        String insNguoiDung = "INSERT INTO NGUOIDUNG VALUES(1,'baongoc','ngoc4503','Bảo Ngọc'),(2,'tridinh','123456','Trí Định'),(3,'tuyetnhung','nhung123','Tuyết Nhung')";
        sqLiteDatabase.execSQL(insNguoiDung);

        String insThongTin = "INSERT INTO MONHOC VALUES('MOB201','Android Nâng Cao','Nguyễn Trí Định'),('MOB306','React Native','Trần Anh Hùng'),('MOB2041','Dự Án Mẫu','Nguyễn Trí Định')";
        sqLiteDatabase.execSQL(insThongTin);

        String insMonHoc = "INSERT INTO THONGTIN VALUES(1, 'MOB201', 'Ca 2 - 19/09/2022', 'T1011'),(2, 'MOB201', 'Ca 2 - 21/09/2022', 'T1011'),(3, 'MOB201', 'Ca 2 - 23/09/2022', 'T1011'),(4, 'MOB306', 'Ca 5 - 20/09/2022', 'F204'),(5, 'MOB306', 'Ca 5 - 22/09/2022', 'F204'),(6, 'MOB2041', 'Ca 1 - 20/09/2022', 'Online - https://meet.google.com/rku-beuk-wqu')";
        sqLiteDatabase.execSQL(insMonHoc);

        String insDangKy = "INSERT INTO DANGKY VALUES(1,'MOB201'),(1,'MOB306'),(2,'MOB306')";
        sqLiteDatabase.execSQL(insDangKy);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i!= i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MONHOC");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THONGTIN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DANGKY");
            onCreate(sqLiteDatabase);
        }
    }
}
