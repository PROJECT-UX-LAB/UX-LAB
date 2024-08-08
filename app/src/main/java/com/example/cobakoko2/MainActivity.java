package com.example.cobakoko2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabPagerAdapter tabPagerAdapter;
    private ImageView btnPrev;
    private ImageView btnNext;
    private ImageButton menu_button;
    private ImageSlider imageSlider;
    private ViewPager sliderViewPager;

    private int currentSlide = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageSlider);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        menu_button = findViewById(R.id.menu_button);
        registerForContextMenu(menu_button);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        // Inisialisasi ImageSlider dengan gambar-gambar
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // Ambil referensi ViewPager dari dalam ImageSlider
        sliderViewPager = (ViewPager) imageSlider.findViewById(com.denzcoskun.imageslider.R.id.view_pager);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_item, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Items", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public class ReversePageTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            page.setTranslationX(-position * page.getWidth());
            page.setAlpha(1 - Math.abs(position));
        }
    }


    public void onClick(View v) {
        int totalSlides = sliderViewPager.getAdapter().getCount();

        if (v == btnNext) {
            currentSlide++;
            if (currentSlide >= totalSlides) {
                currentSlide = 0; // Kembali ke slide pertama jika sudah mencapai slide terakhir
            }
            sliderViewPager.setCurrentItem(currentSlide, true); // Slide ke depan dengan animasi maju
        } else if (v == btnPrev) {
            currentSlide--;
            if (currentSlide < 0) {
                currentSlide = totalSlides - 1; // Kembali ke slide terakhir jika sudah di slide pertama
            }
            sliderViewPager.setCurrentItem(currentSlide, false); // Slide ke belakang dengan animasi mundur
        }
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
