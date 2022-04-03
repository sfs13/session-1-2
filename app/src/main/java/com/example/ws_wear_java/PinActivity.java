package com.example.ws_wear_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ws_wear_java.databinding.ActivityPinBinding;

public class PinActivity extends AppCompatActivity {

    private ActivityPinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}