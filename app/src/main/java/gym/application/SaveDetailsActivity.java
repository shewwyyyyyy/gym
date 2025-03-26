package gym.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import gym.application.R;

public class SaveDetailsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private MaterialButton saveDetailsButton;
    private AutoCompleteTextView membershipTypeDropdown;
    private AutoCompleteTextView coachDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_details);

        // Initialize views
        bottomNavigation = findViewById(R.id.bottomNavigation);
        saveDetailsButton = findViewById(R.id.saveDetailsButton);
        membershipTypeDropdown = findViewById(R.id.membershipTypeDropdown);
        coachDropdown = findViewById(R.id.coachDropdown);

        // Set up dropdowns
        setupDropdowns();
        
        // Set up bottom navigation
        setupBottomNavigation();
        
        // Set up save details button
        saveDetailsButton.setOnClickListener(v -> {
            // In a real app, you would validate and save the data here
            Intent intent = new Intent(SaveDetailsActivity.this, gym.application.SuccessActivity.class);
            startActivity(intent);
        });
    }

    private void setupDropdowns() {
        // Set up membership type dropdown
        String[] membershipTypes = getResources().getStringArray(R.array.membership_types);
        ArrayAdapter<String> membershipAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, membershipTypes);
        membershipTypeDropdown.setAdapter(membershipAdapter);

        // Set up coach dropdown
        String[] coaches = getResources().getStringArray(R.array.coaches);
        ArrayAdapter<String> coachAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, coaches);
        coachDropdown.setAdapter(coachAdapter);
    }

    private void setupBottomNavigation() {
        // Set the membership item as selected
        bottomNavigation.setSelectedItemId(R.id.membership);
        
        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            
            if (itemId == R.id.announcements) {
                startActivity(new Intent(SaveDetailsActivity.this, gym.application.AnnouncementsActivity.class));
                return true;
            } else if (itemId == R.id.membership) {
                // Already on membership details screen
                return true;
            } else if (itemId == R.id.exit) {
                // Show exit confirmation dialog
                showExitDialog();
                return true;
            } else if (itemId == R.id.attendance) {
                Toast.makeText(SaveDetailsActivity.this, "Attendance feature coming soon", 
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

