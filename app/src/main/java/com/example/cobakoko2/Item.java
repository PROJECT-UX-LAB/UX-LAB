package com.example.cobakoko2;

public class Item {
    private int dataTitle;   // Resource ID untuk title (String)
    private int dataDesc;    // Resource ID untuk deskripsi (String)
    private int dataImage;   // Resource ID untuk gambar (Drawable)

    public int getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public int getDataImage() {
        return dataImage;
    }

    public Item(int dataTitle, int dataDesc, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataImage = dataImage;
    }
}
