package com.example.profilemanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button open;

    EditText teamAddress;

    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        open = (Button) findViewById(R.id.open);
        teamAddress = (EditText) findViewById(R.id.enterAddress);
        profile = (ImageView) findViewById(R.id.profile);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnOpenInGoogleMaps(v);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetAvatarButton(v);
            }
        });
    }

    public void OnOpenInGoogleMaps(View view) {
        // Create a Uri from a string. Use the result to create an intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start the activity that can handle the Intent
        startActivity(mapIntent);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        switch (data.getIntExtra("imageID", R.id.flag_ca)) {
                            case R.id.flag_ca:
                                profile.setImageResource(R.drawable.flag_ca);
                                break;
                            case R.id.flag_eg:
                                profile.setImageResource(R.drawable.flag_eg);
                                break;
                            case R.id.flag_fr:
                                profile.setImageResource(R.drawable.flag_fr);
                                break;
                            case R.id.flag_jp:
                                profile.setImageResource(R.drawable.flag_jp);
                                break;
                            case R.id.flag_kr:
                                profile.setImageResource(R.drawable.flag_kr);
                                break;
                            case R.id.flag_sp:
                                profile.setImageResource(R.drawable.flag_sp);
                                break;
                            case R.id.flag_tr:
                                profile.setImageResource(R.drawable.flag_tr);
                                break;
                            case R.id.flag_uk:
                                profile.setImageResource(R.drawable.flag_uk);
                                break;
                            case R.id.flag_us:
                                profile.setImageResource(R.drawable.flag_us);
                                break;
                            default:
                                profile.setImageResource(R.drawable.flag_ca);
                                break;
                        }
                    }
                }
            });

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
}