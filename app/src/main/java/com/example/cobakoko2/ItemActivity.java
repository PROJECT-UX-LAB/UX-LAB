package com.example.cobakoko2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);  // Pastikan layout ini berisi RecyclerView

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
    }
}
