package com.example.ASM_MOB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.ASM_MOB.adapter.DangKiMonHocAdapter;
import com.example.ASM_MOB.model.MonHoc;
import com.example.ASM_MOB.service.DKMonHocService;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    RecyclerView recyclerRegisterCourse;
    int id;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        recyclerRegisterCourse = findViewById(R.id.recyclerRegisterCourse);
        intentFilter = new IntentFilter();
        intentFilter.addAction("DSMonHoc");

        // id cua user
        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", -1);

        Intent intent = new Intent(RegisterActivity.this, DKMonHocService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtras(bundle);
        startService(intent);
    }
    private void loadData(ArrayList<MonHoc> list){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerRegisterCourse.setLayoutManager(linearLayoutManager);
        DangKiMonHocAdapter adapter = new DangKiMonHocAdapter(this, list, id);
        recyclerRegisterCourse.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcast, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myBroadcast);
    }

    private BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "DSMonHoc":
                    Bundle bundle = intent.getExtras();
                    ArrayList<MonHoc> list = (ArrayList<MonHoc>) bundle.getSerializable("list");
                    loadData(list);
                    break;
            }
        }
    };



}