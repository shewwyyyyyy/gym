package gym.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

public class AnnouncementsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private MaterialCardView announcementCard1;
    private MaterialCardView announcementCard2;
    private MaterialCardView announcementCard3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        // Initialize views
        bottomNavigation = findViewById(R.id.bottomNavigation);
        announcementCard1 = findViewById(R.id.announcementCard1);
        announcementCard2 = findViewById(R.id.announcementCard2);
        announcementCard3 = findViewById(R.id.announcementCard3);

        // Set up bottom navigation
        setupBottomNavigation();
        
        // Set up announcement card click listeners
        setupAnnouncementCards();
    }

    private void setupBottomNavigation() {
        // Set the announcements item as selected
        bottomNavigation.setSelectedItemId(R.id.announcements);
        
        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            
            if (itemId == R.id.announcements) {
                // Already on announcements screen
                return true;
            } else if (itemId == R.id.membership) {
                startActivity(new Intent(AnnouncementsActivity.this, gym.application.MainActivity.class));
                return true;
            } else if (itemId == R.id.exit) {
                // Show exit confirmation dialog
                showExitDialog();
                return true;
            } else if (itemId == R.id.attendance) {
                Toast.makeText(AnnouncementsActivity.this, "Attendance feature coming soon", 
                               Toast.LENGTH_SHORT).show();
                return true;
            }
            
            return false;
        });
    }

    private void setupAnnouncementCards() {
        // Set click listeners for announcement cards
        announcementCard1.setOnClickListener(v -> {
            Toast.makeText(this, "Announcement 1 details", Toast.LENGTH_SHORT).show();
            // In a real app, you would navigate to announcement details
        });
        
        announcementCard2.setOnClickListener(v -> {
            Toast.makeText(this, "Announcement 2 details", Toast.LENGTH_SHORT).show();
            // In a real app, you would navigate to announcement details
        });
        
        announcementCard3.setOnClickListener(v -> {
            Toast.makeText(this, "Announcement 3 details", Toast.LENGTH_SHORT).show();
            // In a real app, you would navigate to announcement details
        });
    }

    private void showExitDialog() {
        // In a real app, you would show a dialog here
        Toast.makeText(this, "Exit app?", Toast.LENGTH_SHORT).show();
        // For demo purposes, we'll just finish the activity
        finishAffinity();
    }
}

