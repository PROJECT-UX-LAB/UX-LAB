package com.example.cobakoko2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView globalTV;
    private TextView emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        globalTV = findViewById(R.id.globalTV);
        emailTV = findViewById(R.id.abc);

        String username = getIntent().getStringExtra("USERNAME_KEY");

        globalTV.setText("Hi, " + username);
        emailTV.setText(username + "@gmail.com");
        globalTV.setVisibility(View.VISIBLE);
    }
}