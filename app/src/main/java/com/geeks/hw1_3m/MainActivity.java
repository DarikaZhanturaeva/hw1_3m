package com.geeks.hw1_3m;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btnOpenEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenEmail = findViewById(R.id.btn_send);
        EditText textEmail = findViewById(R.id.text_email);
        EditText textTheme = findViewById(R.id.text_theme);
        EditText textMassage = findViewById(R.id.text_massage);

        btnOpenEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = Objects.requireNonNull(textTheme).getText().toString();
                String massage = Objects.requireNonNull(textMassage).getText().toString();
                String email = Objects.requireNonNull(textEmail).getText().toString();


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("massage/rfs822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, massage);
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}