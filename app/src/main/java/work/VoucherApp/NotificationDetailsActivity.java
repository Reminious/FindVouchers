// NotificationDetailsActivity.java
package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import work.VoucherApp.model.NotificationItem;

public class NotificationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_details);

        // 获取传递的数据
        Intent intent = getIntent();
        NotificationItem notification = (NotificationItem) intent.getSerializableExtra("notification");

        // 在 TextView 中显示详细信息
        TextView textViewDetails = findViewById(R.id.textViewDetails);
        if (notification != null) {
            textViewDetails.setText("Name: " + notification.getSenderName() + "\nTime: " + notification.getReceiveTime() + "\nDetails: " + notification.getDetails());
        }
    }
}
