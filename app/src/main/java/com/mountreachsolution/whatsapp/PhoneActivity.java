package com.mountreachsolution.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class PhoneActivity extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText etPhone;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone); // Make sure this matches your XML name

        ccp = findViewById(R.id.ccp);
        etPhone = findViewById(R.id.etPhoneNumber);
        btnNext = findViewById(R.id.btnNext);

        // Optional: Attach EditText to CCP for formatting/validation
        ccp.registerCarrierNumberEditText(etPhone);


        btnNext.setOnClickListener(v -> {
            String fullNumber = ccp.getFullNumberWithPlus();
            Toast.makeText(this, "Phone: " + fullNumber, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PhoneActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
