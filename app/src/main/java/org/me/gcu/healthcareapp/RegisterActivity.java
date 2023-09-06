package org.me.gcu.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    EditText userNameRegister, email, password, confirmPassword;
    Button registerButton;
    TextView tView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameRegister = findViewById(R.id.editTextAppAddress);
        email = findViewById(R.id.editTextFullName);
        password = findViewById(R.id.editTextAppContactNo);
        confirmPassword = findViewById(R.id.editTextAppFees);
        registerButton = findViewById(R.id.editTextBookAppointment);
        tView2 = findViewById(R.id.tView2);

        registerButton.setOnClickListener(this);
        tView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == registerButton){
            String uname = userNameRegister.getText().toString();
            String emails = email.getText().toString();
            String pword = password.getText().toString();
            String cfirm = confirmPassword.getText().toString();
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            if(uname.length() == 0 || emails.length() == 0 || pword.length() == 0 || cfirm.length() == 0){
                Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
            }
            else{
                if(pword.compareTo(cfirm)==0){
                    if(isValid(pword)) {
                        db.register(uname, emails, pword);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter, digit and special symbol", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Password and Confirmed Password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(v == tView2){
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }


    }
    public static boolean isValid(String passwordhere){
        int f1=0, f2=0, f3=0;
        if (passwordhere.length() <8){
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++){
                if (Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if (c>33&&c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;

        }


    }
}