package gym.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText membershipIdInput;
    private MaterialButton signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        membershipIdInput = findViewById(R.id.membershipIdInput);
        signInButton = findViewById(R.id.signInButton);


        // Set up sign in button click listener
        signInButton.setOnClickListener(v -> {
            String membershipId = membershipIdInput.getText() != null ?
                                  membershipIdInput.getText().toString() : "";

            if (membershipId.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter your membership ID",
                               Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to membership details
                Intent intent = new Intent(MainActivity.this, MembershipDetailsActivity.class);
                intent.putExtra("MEMBERSHIP_ID", membershipId);
                startActivity(intent);
            }
        });

        // Set up bottom navigation

    }



    private void showExitDialog() {
        // In a real app, you would show a dialog here
        Toast.makeText(this, "Exit app?", Toast.LENGTH_SHORT).show();
        // For demo purposes, we'll just finish the activity
        finishAffinity();
    }
}

