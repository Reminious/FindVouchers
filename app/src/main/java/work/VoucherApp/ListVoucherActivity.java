package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListVoucherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_vouchers);

        final String[] voucherTitles = {"Voucher 1", "Voucher 2", "Voucher 3"};

        ListView voucherListView = findViewById(R.id.voucherListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, voucherTitles);

        voucherListView.setAdapter(adapter);
        voucherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 处理点击事件，跳转到 VoucherDetailActivity
                String selectedVoucher = voucherTitles[position];
                Intent intent = new Intent(ListVoucherActivity.this, VoucherDetailActivity.class);
                intent.putExtra("voucherTitle", selectedVoucher);
                startActivity(intent);
            }
        });

    }
}