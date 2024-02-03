package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FunctionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);

        Button buttonSearch = findViewById(R.id.btn_goToSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        Button buttonProfile = findViewById(R.id.btn_goToProfile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, ManageProfileActivity.class);
                startActivity(intent);
            }
        });

        Button buttonFeedback = findViewById(R.id.btn_goToFeedback);
        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, SubmitFeedback.class);
                startActivity(intent);
            }
        });

        Button buttonNotification=findViewById(R.id.btn_goToNotification);
        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, UserNotificationActivity.class);
                startActivity(intent);
            }
        });


        Button buttonFavorites=findViewById(R.id.btn_goToFavorites);
        buttonFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLogout=findViewById(R.id.btn_goToLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunctionsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}