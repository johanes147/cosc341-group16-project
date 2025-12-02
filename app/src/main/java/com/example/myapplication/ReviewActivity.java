package com.example.myapplication;

import android.os.Bundle;import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        TextView reviewTitle = findViewById(R.id.reviewTitle);
        Button submitReviewButton = findViewById(R.id.submitReviewButton);

        String sellerId = getIntent().getStringExtra("sellerId");
        User seller = ProductRepository.getInstance().getUserById(sellerId);

        if (seller != null) {
            reviewTitle.setText("Review for " + seller.getName());
        }

        submitReviewButton.setOnClickListener(v -> {
            // In a real app, you would save the review here.
            // For now, we'll just show a confirmation message.
            Toast.makeText(this, "Thank you for your review!", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity after submitting
        });
    }
}
    