package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class SelectBrandActivity extends AppCompatActivity {

    private CheckBox checkBoxOption1;
    private CheckBox checkBoxOption2;
    private CheckBox checkBoxOption3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_brand);

        checkBoxOption1 = findViewById(R.id.checkBoxOption1);
        checkBoxOption2 = findViewById(R.id.checkBoxOption2);
        checkBoxOption3 = findViewById(R.id.checkBoxOption3);

        Button buttonSelection = findViewById(R.id.buttonSelection);


        buttonSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Click button SearchActivity
                Intent intent = new Intent(SelectBrandActivity.this,ListVoucherActivity.class);
                startActivity(intent);
            }
        });
    }


}
