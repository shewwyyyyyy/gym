package gym.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import gym.application.R;

public class MembershipDetailsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private MaterialButton editDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_details);

        // Initialize views
        bottomNavigation = findViewById(R.id.bottomNavigation);
        editDetailsButton = findViewById(R.id.editDetailsButton);

        // Set up bottom navigation
        setupBottomNavigation();

        // Set up edit details button
        editDetailsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MembershipDetailsActivity.this, gym.application.SaveDetailsActivity.class);
            startActivity(intent);
        });
    }

    private void setupBottomNavigation() {
        // Set the membership item as selected
        bottomNavigation.setSelectedItemId(R.id.membership);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.announcements) {
                startActivity(new Intent(MembershipDetailsActivity.this, AnnouncementsActivity.class));
                return true;
            } else if (itemId == R.id.membership) {
                // Already on membership details screen
                return true;
            } else if (itemId == R.id.exit) {
                // Show exit confirmation dialog
                showExitDialog();
                return true;
            } else if (itemId == R.id.attendance) {
                Toast.makeText(MembershipDetailsActivity.this, "Attendance feature coming soon",
                               Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        });
    }

    private void showExitDialog() {
        // In a real app, you would show a dialog here
        Toast.makeText(this, "Exit app?", Toast.LENGTH_SHORT).show();
        // For demo purposes, we'll just finish the activity
        finishAffinity();
    }
}

