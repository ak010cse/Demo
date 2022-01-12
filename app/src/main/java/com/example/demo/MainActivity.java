package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private String username = "arvind";
    private String pass = "password";
    private Button btnlogin;

    private TextView textView;
    int MaxLoginAttampts = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilize();
        clicklistener();
        //  checkTime();

    }

    public void initilize() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPass);
        btnlogin = findViewById(R.id.btnLogin);
        textView = findViewById(R.id.timerTv);
    }

    public void clicklistener() {

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString().equals("")) {
                    etUsername.setError("please enter username");

                } else if (etPassword.getText().toString().equals("")) {
                    etPassword.setError("Please enter Password");

                } else if (etUsername.getText().toString().trim().equals(username) && etPassword.getText().toString().trim().equals(pass)) {
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                } else {
                    MaxLoginAttampts--;
                    etUsername.setText("");
                    etPassword.setText("");
                    Toast.makeText(MainActivity.this, " username and password Not correct ", Toast.LENGTH_SHORT).show();
                }
                if (MaxLoginAttampts == 0) {
                    textView.setVisibility(View.VISIBLE);
                    btnlogin.setEnabled(false);
                    MaxLoginAttampts=3;

                 new CountDownTimer(30000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            long millis = millisUntilFinished;
                            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis)
                                    , TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                            textView.setText(hms);
                        }

                        public void onFinish() {
                            btnlogin.setEnabled(true);
                            textView.setVisibility(View.GONE);
                        }
                    }.start();

                }
            }
        });

    }
}
