package com.example.cobakoko2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameET;
    private EditText passwordET;
    private RadioButton tncRB;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        tncRB = findViewById(R.id.tncRB);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameET.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Username must be filled", 
                            Toast.LENGTH_SHORT).show();
                } else if (passwordET.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Password must be filled", 
                            Toast.LENGTH_SHORT).show();
                } else if (passwordET.getText().toString().length() < 8 ) {
                    Toast.makeText(LoginActivity.this, "Password must be at least 8 characters",
                            Toast.LENGTH_SHORT).show();
                } else if (!tncRB.isChecked()) {
                    Toast.makeText(LoginActivity.this, "You have to agree to the terms & conditions",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Successfully Log in",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}