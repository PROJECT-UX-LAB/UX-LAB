package com.example.cobakoko2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    private TextView usernameTextView;
    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);  // Pastikan layout ini berisi RecyclerView

        usernameTextView = findViewById(R.id.USERNAME);
        usernameEditText = findViewById(R.id.usernameEditText);

        String usernameParse = getIntent().getStringExtra("USERNAME_KEY");

        // Inisialisasi RecyclerView dan data
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Membuat data untuk adapter
        itemList = new ArrayList<>();
        itemList.add(new Item(R.string.game_title_1, R.string.game_desc_1, R.drawable.image1));
        itemList.add(new Item(R.string.game_title_2, R.string.game_desc_2, R.drawable.image2));
        itemList.add(new Item(R.string.game_title_3, R.string.game_desc_3, R.drawable.image3));
        itemList.add(new Item(R.string.game_title_4, R.string.game_desc_4, R.drawable.image4));
        itemList.add(new Item(R.string.game_title_5, R.string.game_desc_5, R.drawable.image5));

        itemAdapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(itemAdapter);

        usernameTextView.setText(usernameParse);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item1 = menu.findItem(R.id.item1);
        if (item1 != null) {
            item1.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item0:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                intent = new Intent(this, ProfileActivity.class);
                String globalVar = usernameTextView.getText().toString();
                intent.putExtra("USERNAME_KEY", globalVar);
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
