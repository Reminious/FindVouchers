package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button buttonSearch = findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Click button SearchActivity
                Intent intent = new Intent(SearchActivity.this,SelectBrandActivity.class);
                startActivity(intent);
            }
        });
    }
}
