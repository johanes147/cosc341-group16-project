package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        // Set the "Profile" item as the selected one since we are on the Chat screen
        bnv.setSelectedItemId(R.id.nav_profile);

        bnv.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                return true;
            } else if (itemId == R.id.nav_fav) {
                startActivity(new Intent(getApplicationContext(), FavoriteActivity.class));
                return true;
            } else if (itemId == R.id.nav_sell) {
                startActivity(new Intent(getApplicationContext(), SellActivity.class));
                // Don't finish HomeActivity, so the user can easily return
                return true;
            }  else if (itemId == R.id.nav_chat) {
                startActivity(new Intent(getApplicationContext(), ChatListActivity.class));
                return true;
            } else if (itemId == R.id.nav_profile) {
                // We are already on the profile screen, so do nothing.
                return true;
            }

            // Add other navigation items (chat, profile) here in the future
            return false;
        });
    }
}