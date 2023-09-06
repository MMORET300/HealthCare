package org.me.gcu.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        password = findViewById(R.id.editTextAppContactNo);
        loginButton = findViewById(R.id.loginButton);
        tView1 = findViewById(R.id.tView1);

        loginButton.setOnClickListener(this);
        tView1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == loginButton) {
            String uname = userName.getText().toString();
            String pword = password.getText().toString();
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            if (uname.length() == 0 || pword.length() == 0) {

                Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
            } else {
                if (db.login(uname,pword)== 1) {

                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", uname);
                    // to save our data with key and value.
                    editor.apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {

                    Toast.makeText(getApplicationContext(), "Invalid Username and Password!", Toast.LENGTH_SHORT).show();
                }

            }

        }

        if (v == tView1) {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }

    }


}