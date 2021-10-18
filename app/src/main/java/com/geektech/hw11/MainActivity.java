package com.geektech.hw11;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView greetings, tv_forgot_password, registration;
    private EditText username, password;
    private Button btn_go;
    //ActivityResultLauncher<Intent> activityStartResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult());
    //result ->()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        initListeners();
        Glide.with(this).load("https://media.wired.com/photos/5d09594a62bcb0c9752779d9/125:94/w_1994,h_1500,c_limit/Transpo_G70_TA-518126.jpg")
                .into(imageView);
    }

    private void initialization() {
        imageView = findViewById(R.id.imageView);
        greetings = findViewById(R.id.greetings);
        password = findViewById(R.id.Password);
        username = findViewById(R.id.Username);
        btn_go = findViewById(R.id.btn_go);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        registration = findViewById(R.id.registration);
    }



    private void initListeners() {
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() < 6) {
                    btn_go.setEnabled(false);
                    showToast("NE MENEE 6");
                } else btn_go.setEnabled(true);

            }
        });
        username.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_go.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1124);


            }
        });
        tv_forgot_password.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Очень печально");

            }
        });
        registration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("1124pro", "onActivityResult: "+resultCode);
        Log.d("1124pro", "onActivityResult: "+requestCode);
        Log.d("1124pro", "onActivityResult: "+data);
        if (resultCode == RESULT_OK && requestCode == 1124 && data != null) {
            greetings.setText(data.getStringExtra("key"));
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}