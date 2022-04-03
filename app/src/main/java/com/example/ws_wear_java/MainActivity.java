package com.example.ws_wear_java;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ws_wear_java.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.statsButton.setOnClickListener(view -> {
            startActivity(
                    new Intent(this, MainActivity2.class)
            );

            finish();
        });

        binding.devicesButton.setOnClickListener(view -> {
            startActivity(
                    new Intent(this, PinActivity.class)
            );

            finish();
        });
    }
}