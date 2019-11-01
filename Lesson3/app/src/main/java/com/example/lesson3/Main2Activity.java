package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btCreateAccount = findViewById(R.id.btCreateAccount);
        btCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextUserName = findViewById(R.id.edtUserNameSignUp);
                EditText editTextPassword = findViewById(R.id.edtPasswordSignUp);

                String userName = editTextUserName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                Intent intent = new Intent();
                intent.putExtra("User" , userName);
                intent.putExtra("pass" , password);

                setResult(MainActivity.RESULT_OK , intent);
                Toast.makeText(Main2Activity.this , "Đăng ký thành công" , Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
