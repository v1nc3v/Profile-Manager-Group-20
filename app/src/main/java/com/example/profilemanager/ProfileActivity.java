package com.example.profilemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView flag_ca, flag_eg, flag_fr, flag_jp, flag_kr, flag_sp, flag_tr, flag_uk, flag_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        flag_ca = (ImageView) findViewById(R.id.flag_ca);
        flag_eg = (ImageView) findViewById(R.id.flag_eg);
        flag_fr = (ImageView) findViewById(R.id.flag_fr);
        flag_jp = (ImageView) findViewById(R.id.flag_jp);
        flag_kr = (ImageView) findViewById(R.id.flag_kr);
        flag_sp = (ImageView) findViewById(R.id.flag_sp);
        flag_tr = (ImageView) findViewById(R.id.flag_tr);
        flag_uk = (ImageView) findViewById(R.id.flag_uk);
        flag_us = (ImageView) findViewById(R.id.flag_us);

        setClickListeners();
    }

    private void setClickListeners() {
        flag_ca.setOnClickListener(this);
        flag_eg.setOnClickListener(this);
        flag_fr.setOnClickListener(this);
        flag_jp.setOnClickListener(this);
        flag_kr.setOnClickListener(this);
        flag_sp.setOnClickListener(this);
        flag_tr.setOnClickListener(this);
        flag_uk.setOnClickListener(this);
        flag_us.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SetTeamIcon(v);
    }

    public void SetTeamIcon(View view) {
        // Creating a return Intent to pass to the Main Activity
        Intent returnIntent = new Intent();

        // Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;

        // Adding details to the return Intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        // Finishing the activity and returning to the main screen
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}