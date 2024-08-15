package com.example.cobakoko2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView globalTV;
    private TextView emailTV;

    private  String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        globalTV = findViewById(R.id.globalTV);
        emailTV = findViewById(R.id.abc);

        this.username = getIntent().getStringExtra("USERNAME_KEY");

        globalTV.setText("Hi, " + username);
        emailTV.setText(username + "@gmail.com");
        globalTV.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
//        MenuItem item0 = menu.findItem(R.id.item0);
//        if (item0 != null) {
//            item0.setVisible(false);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item0:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("USERNAME_KEY", this.username);
                startActivity(intent);
                return true;
            case R.id.item1:
                intent = new Intent(this, ItemActivity.class);
                intent.putExtra("USERNAME_KEY", this.username);
                startActivity(intent);
                return true;
            case R.id.item2:
                intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("USERNAME_KEY", this.username);
                startActivity(intent);
                return true;
            case R.id.item3:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}