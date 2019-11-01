package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSignUp = findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivityForResult(intent , 1999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1999) {
            if (resultCode == MainActivity.RESULT_OK) {
                Button btLogIn = findViewById(R.id.btLogin);

                final EditText edtUserName = findViewById(R.id.edtUserName);
                final EditText edtPassword = findViewById(R.id.edtPassword);

                final String userName = data.getStringExtra("User");
                final String pass = data.getStringExtra("password");

                btLogIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (userName.equals(edtUserName.getText().toString().trim()) && pass.equals(edtPassword.getText().toString().trim())) {
                            Toast.makeText(MainActivity.this , "Đăng nhập thành công" , Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(MainActivity.this , Main3Activity.class);
                            startActivity(intent2);
                        } else {
                            Toast.makeText(MainActivity.this , "Sai tài khoản hoặc mật khẩu" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(MainActivity.this , "Try again" , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "On Start ?");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart", "On Restart ?");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "On Resume ?");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "On Pause ?");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "On Stop ?");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "On Destroy ?");
    }
}
