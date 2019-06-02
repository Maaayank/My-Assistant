package com.example.user.myasssistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnStart;
    Button btnSignup;
    Button btnDelete;
    EditText etName;
    EditText etPassword;
    TextView tvStatus;
    Integer count =3;
    String string[] = new String[2];
    UserLogins ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnStart = findViewById(R.id.btnStart);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvStatus = findViewById(R.id.tvStatus);
        btnSignup = findViewById(R.id.btnSignup);
        btnDelete = findViewById(R.id.btnDelete);
        ur = new UserLogins();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    string[0] = etName.getText().toString();
                    string[1] = etPassword.getText().toString();
                    if ("".equals(string[0]) || string[1].length() < 8) {
                        tvStatus.setText("Enter Your Name and Password Length should be of 8 digits ");
                    } else if (ur.fileReader(string,LoginActivity.this)) {
                        Intent intent = new Intent(LoginActivity.this, Work.class);
                        startActivity(intent);
                    } else {
                        if (count > 0) {
                            tvStatus.setText("Wrong Password try Again \n Number of Attempts left " + count--);
                        } else {
                            tvStatus.setText("Sorry You are out of attempts");
                            btnStart.setEnabled(false);
                        }
                    }
                    etName.setText("");
                    etPassword.setText("");
                }catch(Exception e){
                    Toast t = Toast.makeText(LoginActivity.this,"Error" + e,Toast.LENGTH_LONG) ;
                    t.show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    string[0] = etName.getText().toString();
                    string[1] = etPassword.getText().toString();
                    if ("".equals(string[0]) || string[1].length() < 8) {
                        tvStatus.setText("Enter Your Name and Password Length should be of 8 digits ");
                    } else
                        if(ur.fileWriter(string,LoginActivity.this))
                        {
                            Toast t1 = Toast.makeText(LoginActivity.this,"Successful", Toast.LENGTH_SHORT);
                            t1.show();
                            Intent intent = new Intent(LoginActivity.this, Work.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast t2 = Toast.makeText(LoginActivity.this,"Unsuccessful", Toast.LENGTH_SHORT);
                            t2.show();
                        }
                    }catch(Exception e) {
                        Toast t = Toast.makeText(LoginActivity.this, "Error" + e, Toast.LENGTH_LONG);
                        t.show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    string[0] = etName.getText().toString();
                    string[1] = etPassword.getText().toString();
                    if ("".equals(string[0]) || string[1].length() < 8) {
                        tvStatus.setText("Enter Your Name and Password Length should be of 8 digits ");
                    }
                    else
                    {
                        ur.deleteUser(string,LoginActivity.this);
                    }
                }catch(Exception e) {
                    Toast t = Toast.makeText(LoginActivity.this, "Error" + e, Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });

    }
}
