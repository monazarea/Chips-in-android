package com.example.chips;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private Chip chip1, chip2, chip3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        chip1 = findViewById(R.id.chip1);
        chip2 = findViewById(R.id.chip2);
        chip3 = findViewById(R.id.chip3);

        if (chip1 != null && chip2 != null && chip3 != null) {
            CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateSelectedChips();
                }
            };

            chip1.setOnCheckedChangeListener(listener);
            chip2.setOnCheckedChangeListener(listener);
            chip3.setOnCheckedChangeListener(listener);
        }
    }

    private void updateSelectedChips() {
        StringBuilder builder = new StringBuilder();

        if (chip1.isChecked()) builder.append("Chip 1 (Done)\n");
        if (chip2.isChecked()) builder.append("Chip 2 (Done)\n");
        if (chip3.isChecked()) builder.append("Chip 3 (Done)\n");

        if (builder.length() > 0) {
            resultText.setText(builder.toString() );
        } else {
            resultText.setText("No chips clicked");
        }
    }
}