package com.test.alodoktertes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.alodoktertes.activity.HomeActivity;
import com.test.alodoktertes.utils.PrefManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailEdt,passEdt;
    Button loginBtn;
    private PrefManager pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdt = findViewById(R.id.email);
        passEdt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
        pref = new PrefManager(this);
        if (pref.getIsLogin()){
            Intent i = new Intent(this, HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }

    private void checkUserValidation(){
        String email = emailEdt.getText().toString().trim();
        String pass = passEdt.getText().toString().trim();
        if (email.equals("admin") && pass.equals("123456")){
            pref.setIsLogin(true);
            Intent i = new Intent(this, HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else {
            Toast.makeText(this,"Failed login",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if (emailEdt.getText().toString().trim().isEmpty()
                        || passEdt.getText().toString().trim().isEmpty())
                    Toast.makeText(this,"Email and pass is required",
                            Toast.LENGTH_LONG).show();
                else
                    checkUserValidation();
            break;
        }
    }
}