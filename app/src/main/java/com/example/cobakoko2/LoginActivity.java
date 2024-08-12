package com.example.cobakoko2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameET;
    private EditText passwordET;
    private RadioButton tncRB;
    private Button loginBtn;
    private TextView errorTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        tncRB = findViewById(R.id.tncRB);
        loginBtn = findViewById(R.id.loginBtn);
        errorTV = findViewById(R.id.errorTV);

        usernameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    usernameET.setTextColor(Color.RED); // Ubah warna teks menjadi merah
                    usernameET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.redUnderlineColor)
                    );

                } else {
                    usernameET.setTextColor(Color.BLACK); // Kembali ke warna hitam jika kosong
                    usernameET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.defaultUnderlineColor)
                    ); // Kembali ke warna default
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 0) {
                    passwordET.setTextColor(Color.RED); // Ubah warna teks menjadi merah
                    passwordET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.redUnderlineColor)
                    );

                } else {
                    passwordET.setTextColor(Color.BLACK); // Kembali ke warna hitam jika kosong
                    passwordET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.defaultUnderlineColor)
                    ); // Kembali ke warna default
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    passwordET.setTextColor(Color.RED); // Ubah warna teks menjadi merah
                    passwordET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.redUnderlineColor)
                    );

                } else {
                    passwordET.setTextColor(Color.BLACK); // Kembali ke warna hitam jika kosong
                    passwordET.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.defaultUnderlineColor)
                    ); // Kembali ke warna default
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameET.getText().toString().equals("")){
                    errorTV.setText("Username must be filled");
                    errorTV.setVisibility(View.VISIBLE);
                } else if (passwordET.getText().toString().equals("")) {
                    errorTV.setText("Password must be filled");
                    errorTV.setVisibility(View.VISIBLE);
                } else if (passwordET.getText().toString().length() < 8 ) {
                    errorTV.setText("Password must be at least 8 characters");
                    errorTV.setVisibility(View.VISIBLE);
                } else if (!tncRB.isChecked()) {
                    errorTV.setText("You have to agree to the terms & conditions");
                    errorTV.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(LoginActivity.this, "Successfully Log in",
                            Toast.LENGTH_SHORT).show();
                    errorTV.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}