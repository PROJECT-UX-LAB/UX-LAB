package com.example.cobakoko2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ItemDetail extends AppCompatActivity {
    private EditText emailEditText;
    private Button submitButton;
    private Button backButton;

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
        
        // Set onClick listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });

    }

    private void validateEmail() {
        String emailInput = emailEditText.getText().toString().trim();

        if (emailInput.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            // Show error pop-up
            showErrorPopup();
        } else {
            // Email is valid, proceed with your logic
            showSuccessPopup();
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

    private void showSuccessPopup() {
        // Inflate the custom layout for success
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom_success, null);

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


}
