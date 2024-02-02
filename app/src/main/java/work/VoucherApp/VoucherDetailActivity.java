package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

 public class VoucherDetailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_feedback.xml layout file
        setContentView(R.layout.view_voucher_detail);

        // Here you can initialize your views and set up listeners for the submit button
        // For example, you might use findViewById to get a reference to the EditText and Button views
        Button buttonLogin = findViewById(R.id.addToFavoriteBtn);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 当，启动 SearchActivity
                Intent intent = new Intent(VoucherDetailActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
    }
}