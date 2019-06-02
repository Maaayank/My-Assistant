package com.example.user.myasssistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtGreet;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calender = Calendar.getInstance();
        int hrs = calender.get(Calendar.HOUR_OF_DAY);

        txtGreet = findViewById(R.id.txtGreet);
        if(hrs <12)
        {
            txtGreet.setText("Goood Morning ");
        }
        else if(hrs > 11 && hrs < 17)
        {
            txtGreet.setText("Good Afternoon");
        }
        else
        {
            txtGreet.setText("Good Evening");
        }
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
