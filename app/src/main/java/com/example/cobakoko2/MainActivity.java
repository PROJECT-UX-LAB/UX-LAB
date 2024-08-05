package com.example.cobakoko2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView termsTextView;
    private Button termsButton;
    private Button conditionsButton;
    Button btnPrev;
    Button btnNext;
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imageSlider = findViewById(R.id.imageSlider);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        termsTextView = findViewById(R.id.terms);
        termsButton = findViewById(R.id.btn_terms);
        conditionsButton = findViewById(R.id.btn_conditions);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        // Check if buttons are null and set them to null if they are
        if (btnPrev == null) {
            btnPrev = null;
            System.out.println("btnPrev is null");
        }
        if (btnNext == null) {
            btnNext = null;
            System.out.println("btnNext is null");
        }

        // Initialize image slider with images
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // Set button click listeners
//        btnPrev.setOnClickListener(v -> imageSlider.movePreviousPosition());
//        btnNext.setOnClickListener(v -> imageSlider.moveNextPosition());

        // Set terms and conditions button click listeners
        termsButton.setOnClickListener(v -> {
            termsTextView.setText("[ Terms ] : Permudah Pengelolaan Aset Game Anda\n\nAXForAsset adalah aplikasi mobile yang dirancang untuk mempermudah pengelolaan dan distribusi aset game. Aplikasi ini ditujukan untuk developer game individual maupun studio yang ingin menyederhanakan alur kerja aset mereka dan meningkatkan kolaborasi.\n\n1. Privasi: User berkomitmen untuk melindungi privasi Pengguna dan hanya akan mengumpulkan dan menggunakan informasi pribadi sesuai dengan Kebijakan Privasi.\n2. Batasan Tanggung Jawab: AXForAsset tidak bertanggung jawab atas kerusakan atau kerugian akibat gangguan aplikasi, kehilangan data, pelanggaran Syarat dan Ketentuan, atau tindakan pihak ketiga.\n3. Penghentian Layanan: AXForAsset berhak menghentikan layanan secara keseluruhan atau sebagian tanpa pemberitahuan sebelumnya. Pengguna dapat berhenti menggunakan Aplikasi kapan saja.");
            termsButton.setTypeface(null, Typeface.BOLD);
            conditionsButton.setTypeface(null, Typeface.NORMAL);
            termsButton.setBackgroundResource(R.drawable.button_pressed);
            conditionsButton.setBackgroundResource(R.drawable.button_selector);
        });

        conditionsButton.setOnClickListener(v -> {
            termsTextView.setText("[ Conditions ]: Permudah Pengelolaan Aset Game Anda\n\nAXForAsset adalah aplikasi mobile yang dirancang untuk mempermudah pengelolaan dan distribusi aset game. Aplikasi ini ditujukan untuk developer game individual maupun studio yang ingin menyederhanakan alur kerja aset mereka dan meningkatkan kolaborasi.\n\n1. Penerimaan:\n- Pengguna dianggap telah menyetujui dan terikat dengan Syarat dan Ketentuan ini dengan mengunduh, mendaftar, dan menggunakan Aplikasi.\n2. Akun Pengguna:\n- Pengguna wajib membuat akun untuk menggunakan Aplikasi.\n- Pengguna bertanggung jawab atas keamanan akunnya dan semua aktivitas yang terjadi dalam akunnya.\n3. Pembayaran:\n- Pengguna dapat membeli aset game dan game lain berbayar melalui AXForAsset.\n- Metode pembayaran yang tersedia dapat berubah sewaktu-waktu.");
            conditionsButton.setTypeface(null, Typeface.BOLD);
            termsButton.setTypeface(null, Typeface.NORMAL);
            conditionsButton.setBackgroundResource(R.drawable.button_pressed);
            termsButton.setBackgroundResource(R.drawable.button_selector);
        });
    }

    @Override
    public void onClick(View v) {
//        if(v == btnNext){
//            imageSlider.showNext();
//        }
//        else if(v == btnPrev){
//            imageSlider.showPrevious();
//        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
