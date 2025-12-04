package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserListingsActivity extends AppCompatActivity {

    private List<Product> allUserListings;
    private UserListingAdapter adapter;
    private ImageView backButton;
    private TextView emptyView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_listings);
        // Handle status bar padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0); // Important: only top padding
            return insets;
        });

        backButton = findViewById(R.id.arrowBackButton);
        backButton.setOnClickListener(v -> finish());
        emptyView = findViewById(R.id.empty_view_listings);

        RecyclerView allListingsRecyclerView = findViewById(R.id.allListingsRecyclerView);

        allUserListings = ProductRepository.getInstance().getUserListings();
        if (allUserListings.isEmpty()) {
            allListingsRecyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            allListingsRecyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

        adapter = new UserListingAdapter(this, allUserListings);
        allListingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allListingsRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 1. Get the potentially updated list from the repository.
        List<Product> updatedListings = ProductRepository.getInstance().getUserListings();

        // 2. Update the adapter's list.
        // It's good practice to clear the old list and add the new one.
        allUserListings.clear();
        allUserListings.addAll(updatedListings);

        // 3. Notify the adapter that the entire dataset has changed.
        adapter.notifyDataSetChanged();
    }
}
