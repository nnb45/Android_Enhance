package com.example.ASM_MOB.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ASM_MOB.BuildConfig;
import com.example.ASM_MOB.R;
import com.example.ASM_MOB.model.MonHoc;

import java.util.ArrayList;

public class DangKiMonHocAdapter extends RecyclerView.Adapter<DangKiMonHocAdapter.ViewHolder>{
    private Context context;
    private ArrayList<MonHoc> list;


    public DangKiMonHocAdapter(Context context, ArrayList<MonHoc> list) {
        this.context = context;
        this.list = list;
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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCode, txtName, txtTeacher;
        Button btnRegisterItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
