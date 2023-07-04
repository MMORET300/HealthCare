package org.me.gcu.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userName, password;
    Button loginButton;
    TextView tView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        tView1 = findViewById(R.id.tView1);

        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == loginButton) {
            String uname = userName.getText().toString();
            String pword = password.getText().toString();
            if(uname.length()==0 || pword.length()==0){

                Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
            }

        }

    }
}