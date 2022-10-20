package com.example.ASM_MOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ASM_MOB.service.KiemTraDangNhapService;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity<callbackManager> extends AppCompatActivity {

    IntentFilter intentFilter;
    CallbackManager callbackManager;
    LoginButton btnFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPass = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);

//        btnFacebook = findViewById(R.id.btnFacebook);
//        callbackManager = CallbackManager.Factory.create();
//        //check người dùng đã đăng nhập trước đó hay chưa?
//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
//        if (isLoggedIn) {
//            getUserProfile(accessToken);
//            Toast.makeText(this, "Đã đăng nhập", Toast.LENGTH_SHORT).show();
//        }


        intentFilter = new IntentFilter();
        intentFilter.addAction("kiemTraDangNhap");
        intentFilter.addAction("");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();

                Intent intent = new Intent(LoginActivity.this, KiemTraDangNhapService.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("pass", pass);
                intent.putExtras(bundle);
                startService(intent);

            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcast, intentFilter);
    }

    public BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "kiemTraDangNhap":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check");
                    if(check){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else {
                        Toast.makeText(context, "Sign in failed!", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };
}