package com.example.ASM_MOB.adapter;

import static android.R.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ASM_MOB.R;
import com.example.ASM_MOB.RegisterActivity;
import com.example.ASM_MOB.model.MonHoc;
import com.example.ASM_MOB.model.ThongTin;
import com.example.ASM_MOB.service.DKMonHocService;
import com.example.ASM_MOB.service.RegisterCourseService;

import java.util.ArrayList;
import java.util.HashMap;

public class DangKiMonHocAdapter extends RecyclerView.Adapter<DangKiMonHocAdapter.ViewHolder>{
    private Context context;
    private ArrayList<MonHoc> list;
    private int id;
    private boolean isAll;

    public DangKiMonHocAdapter(Context context, ArrayList<MonHoc> list, int id, boolean isAll) {
        this.context = context;
        this.list = list;
        this.id = id;
        this.isAll = isAll;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_registercourse, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegisterActivity registerActivity = list.get(position);

//        holder.imgCourse.setImageResource(list.get(position).getImgID());
        holder.txtCode.setText(String.valueOf(list.get(position).getCode()));
        holder.txtName.setText(list.get(position).getName());
        holder.txtTeacher.setText(list.get(position).getTeacher());

        if(list.get(position).getIsRegister() == id){
            holder.btnRegisterItem.setText("Unregister Course");
            holder.btnRegisterItem.setBackgroundColor(Color.RED);
            holder.btnRegisterItem.setTextColor(Color.WHITE);
//            hide();

        }else {
            holder.btnRegisterItem.setText("Register Course");
            holder.btnRegisterItem.setBackgroundColor(Color.GREEN);
            holder.btnRegisterItem.setTextColor(Color.WHITE);
//            show();
        }
        holder.btnRegisterItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterCourseService.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                bundle.putString("code", list.get(holder.getAdapterPosition()).getCode());
                bundle.putInt("isRegister", list.get(holder.getAdapterPosition()).getIsRegister());
                bundle.putBoolean("isAll", isAll);
                intent.putExtras(bundle);
                context.startService(intent);
            }
        });
        holder.imvCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(list.get(holder.getAdapterPosition()).getListTT());
            }
        });
    }
//    // show/hide cardview cvCourse after click
//    private void show() {
//        CardView cvCourse = null;
//        cvCourse.findViewById(R.id.cvCourse);
//        cvCourse.setVisibility(View.VISIBLE);
//    }
//
//    private void hide() {
//        CardView cvCourse = null;
//        cvCourse.findViewById(R.id.cvCourse);
//        cvCourse.setVisibility(View.INVISIBLE);
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCode, txtName, txtTeacher;
        CardView cvCourse;
        Button btnRegisterItem;
        ImageView imvCourse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgCourse = itemView.findViewById(R.id.imgCourse);
            txtCode = itemView.findViewById(R.id.txtCode);
            txtName = itemView.findViewById(R.id.txtName);
            txtTeacher = itemView.findViewById(R.id.txtTeacher);
            btnRegisterItem = itemView.findViewById(R.id.btnRegisterItem);
            cvCourse = itemView.findViewById(R.id.cvCourse);
            imvCourse = itemView.findViewById(R.id.imvCourse);
        }

    }
    private void showDialog(ArrayList<ThongTin> list) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_thongtin, null);
        builder.setView(view);

        ListView listViewTT = view.findViewById(R.id.listViewTT);

        ArrayList<HashMap<String, Object>> listTT = new ArrayList<>();
        for (ThongTin tt : list) {
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("date", "Ngày học: " + tt.getDate());
            hs.put("address", "Địa điểm: " + tt.getAddress());
            listTT.add(hs);
        }
        SimpleAdapter adapter = new SimpleAdapter(context, listTT, android.R.layout.simple_list_item_2, new String[]{"date", "address"},
                new int[]{android.R.id.text1, android.R.id.text2});

        listViewTT.setAdapter(adapter);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}