package com.example.cobakoko2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetail extends AppCompatActivity {
    private EditText emailEditText;
    private Button submitButton;
    private ImageButton backButton;
    private TextView title;
    private  TextView description;
    private FrameLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // Set the content view to your layout
        setContentView(R.layout.activity_item_detail);

        // Now you can access the Spinner after setting the content view
        Spinner spinner = findViewById(R.id.spinner_payment);

        // Set up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Initialize views
        emailEditText = findViewById(R.id.email_edit_text);
        submitButton = findViewById(R.id.order_button);
        backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();

        Integer title_text = intent.getIntExtra("itemTitle", 0);
        Integer description_text = intent.getIntExtra("itemDesc", 0);
        Integer image_text = intent.getIntExtra("itemImage", 0);


        title = findViewById(R.id.title_content);
        title.setText(getString(title_text));

        description = findViewById(R.id.description);
        description.setText(getString(description_text));

        background = findViewById(R.id.background_game);
        background.setBackground(getDrawable(image_text));

        // Set onClick listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail(intent);
            }
        });

        Intent home = new Intent(this, MainActivity.class);
        home.putExtra("USERNAME_KEY", intent.getStringExtra("USERNAME"));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });

    }

    private void validateEmail(Intent intent) {
        String emailInput = emailEditText.getText().toString().trim();

        if (emailInput.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            // Show error pop-up
            showErrorPopup();
        } else {
            // Email is valid, proceed with your logic
            showSuccessPopup(intent);
        }
    }

    private void showErrorPopup() {
        // Inflate the custom layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom, null);

        // Create and set up the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog_background);

        // Set up the OK button
        Button okButton = dialogView.findViewById(R.id.btn_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Show the dialog
        dialog.show();
    }

    private void showSuccessPopup(Intent intent) {
        // Inflate the custom layout for success
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom_success, null);

        // Create and set up the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog_background);

        // Set up the OK button
        Button okButton = dialogView.findViewById(R.id.btn_ok);
        Intent item = new Intent(this, ItemActivity.class);
        item.putExtra("USERNAME_KEY", intent.getStringExtra("USERNAME"));

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(item);
            }
        });

        // Show the dialog
        dialog.show();
      }


}