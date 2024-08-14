package com.example.cobakoko2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobakoko2.Item;
import com.example.cobakoko2.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private Context context;

    private String username;


    public ItemAdapter(List<Item> itemList, Context context, String username) {
        this.itemList = itemList;
        this.context = context;
        this.username = username;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.recTitle.setText(item.getDataTitle());   // Mengatur title dari resource ID (int)
        holder.recDesc.setText(item.getDataDesc());     // Mengatur deskripsi dari resource ID (int)
        holder.recImage.setImageResource(item.getDataImage());  // Mengatur gambar dari resource ID (int)

        Intent intent = new Intent(context, ItemDetail.class);

        holder.recButton.setOnClickListener(v ->
                {
                    intent.putExtra("itemTitle", item.getDataTitle());
                    intent.putExtra("itemDesc", item.getDataDesc());
                    intent.putExtra("itemImage", item.getDataImage());
                    intent.putExtra("USERNAME", this.username);
                    context.startActivity(intent);
                }
        );


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView recImage;
        TextView recTitle, recDesc;
        Button recButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            recImage = itemView.findViewById(R.id.recImage);
            recTitle = itemView.findViewById(R.id.recTitle);
            recDesc = itemView.findViewById(R.id.recDesc);
            recButton = itemView.findViewById(R.id.recButton);
        }

    }





}
