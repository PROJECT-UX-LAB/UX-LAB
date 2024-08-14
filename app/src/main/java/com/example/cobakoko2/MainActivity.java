package com.example.cobakoko2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
    private TextView usernameTv;

    private int currentSlide = 0;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME_KEY");

        // Tambahkan kode untuk menampilkan username di UI, jika diperlukan
        // Misalnya, menggunakan TextView:
        usernameTv = findViewById(R.id.USERNAME);
        if (username != null) {
            usernameTv.setText(username);
        }

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


        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        sliderViewPager = (ViewPager) imageSlider.findViewById(com.denzcoskun.imageslider.R.id.view_pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item0 = menu.findItem(R.id.item0);
        if (item0 != null) {
            item0.setVisible(false);
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item1:
                intent = new Intent(this, ItemActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
                return true;
            case R.id.item2:
                intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("USERNAME_KEY", username);
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


    public class ReversePageTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            page.setTranslationX(-position * page.getWidth());
            page.setAlpha(1 - Math.abs(position));
        }
    }


    @Override
    public void onClick(View v) {
        int totalSlides = sliderViewPager.getAdapter().getCount();

        if (v == btnNext) {
            currentSlide++;
            if (currentSlide >= totalSlides) {
                currentSlide = 0;
            }
            sliderViewPager.setCurrentItem(currentSlide, true); // Slide ke depan dengan animasi maju
        } else if (v == btnPrev) {
            if (currentSlide == 0) {
                currentSlide = totalSlides - 1;
            } else {
                currentSlide--;
            }


            sliderViewPager.setCurrentItem(currentSlide + 1, false);
            sliderViewPager.setCurrentItem(currentSlide, true);
        }
    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

//    Button openItemActivityButton = findViewById(R.id.xxx); // Asumsi kamu punya tombol dengan ID ini
//    openItemActivityButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(MainActivity.this, ItemActivity.class);
//            startActivity(intent);
//
//    });



}
