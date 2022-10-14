package com.example.ASM_MOB.model;

import java.util.ArrayList;

public class MonHoc {
    private String code;
    private String name;
    private String teacher;
    private int isRegister;
    private ArrayList<ThongTin> listTT;

    public MonHoc(String code, String name, String teacher, int isRegister, ArrayList<ThongTin> listTT) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.isRegister = isRegister;
        this.listTT = listTT;
    }

    public MonHoc(String code, String name, String teacher) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
    }

    public int getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(int isRegister) {
        this.isRegister = isRegister;
    }

    public MonHoc(String code, String name, String teacher, int isRegister) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.isRegister = isRegister;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
