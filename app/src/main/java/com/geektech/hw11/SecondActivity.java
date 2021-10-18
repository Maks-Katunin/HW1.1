package com.geektech.hw11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editText, editText2, et_password, email, phone_number;
    //private Button btn_back;
    private TextView tv_edit_photo;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initsView();
        initListeners();
    }

    private void initListeners() {
        tv_edit_photo.setOnClickListener(view -> {


        });

    }


    /*private void initListeners() {
        btn_back.setOnClickListener(v -> {
            if (editText.getText() != null) {
                Intent intent = new Intent();
                intent.putExtra("key", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }*/

    private void initsView() {
        photo = findViewById(R.id.photo);
        tv_edit_photo = findViewById(R.id.tv_edit_photo);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        email = findViewById(R.id.email);
        phone_number = findViewById(R.id.phone_number);
        et_password = findViewById(R.id.et_password);
        //btn_back = findViewById(R.id.btn_back);
    }
}
