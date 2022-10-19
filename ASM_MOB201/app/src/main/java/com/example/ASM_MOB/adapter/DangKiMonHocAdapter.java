package com.example.ASM_MOB.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ASM_MOB.R;
import com.example.ASM_MOB.RegisterActivity;
import com.example.ASM_MOB.model.MonHoc;

import java.util.ArrayList;

public class DangKiMonHocAdapter extends RecyclerView.Adapter<DangKiMonHocAdapter.ViewHolder>{
    private Context context;
    private ArrayList<MonHoc> list;
    private int id;


    public DangKiMonHocAdapter(Context context, ArrayList<MonHoc> list, int id) {
        this.context = context;
        this.list = list;
        this.id = id;
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
        }else {
            holder.btnRegisterItem.setText("Register Course");
            holder.btnRegisterItem.setBackgroundColor(Color.GREEN);
            holder.btnRegisterItem.setTextColor(Color.WHITE);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCode, txtName, txtTeacher;
//        ImageView imgCourse;
        Button btnRegisterItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgCourse = itemView.findViewById(R.id.imgCourse);
            txtCode = itemView.findViewById(R.id.txtCode);
            txtName = itemView.findViewById(R.id.txtName);
            txtTeacher = itemView.findViewById(R.id.txtTeacher);
            btnRegisterItem = itemView.findViewById(R.id.btnRegisterItem);
        }
    }
}
