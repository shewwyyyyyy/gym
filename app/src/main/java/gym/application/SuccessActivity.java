package gym.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class SuccessActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private MaterialButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // Initialize views
        bottomNavigation = findViewById(R.id.bottomNavigation);
        backButton = findViewById(R.id.backButton);

        // Set up bottom navigation
        setupBottomNavigation();
        
        // Set up back button
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(SuccessActivity.this, MembershipDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }

    private void setupBottomNavigation() {
        // Set the membership item as selected
        bottomNavigation.setSelectedItemId(R.id.membership);
        
        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            
            if (itemId == R.id.announcements) {
                startActivity(new Intent(SuccessActivity.this, AnnouncementsActivity.class));
                return true;
            } else if (itemId == R.id.membership) {
                Intent intent = new Intent(SuccessActivity.this, MembershipDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.exit) {
                // Show exit confirmation dialog
                showExitDialog();
                return true;
            } else if (itemId == R.id.attendance) {
                Toast.makeText(SuccessActivity.this, "Attendance feature coming soon", 
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

