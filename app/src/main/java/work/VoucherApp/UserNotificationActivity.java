// UserNotificationActivity.java
package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import work.VoucherApp.adapter.CustomAdapter;
import work.VoucherApp.model.NotificationItem;

public class UserNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_notification);

        // Assuming you have a list of notifications to display, replace this with your actual data
        ArrayList<NotificationItem> notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem("Sender 1", "2022-02-02 10:00 AM", "Notification 1 details"));
        notificationList.add(new NotificationItem("Sender 2", "2022-02-02 11:00 AM", "Notification 2 details"));
        // Add more notifications as needed

        // UserNotificationActivity.java
// ...

// Create a CustomAdapter to bind the data to the ListView

        CustomAdapter adapter = new CustomAdapter(this, notificationList);

// ...

        // Find the ListView by ID
        ListView listView = findViewById(R.id.listView);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set item click listener to open NotificationDetailsActivity
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected notification
            NotificationItem selectedNotification = notificationList.get(position);

            // Start NotificationDetailsActivity and pass relevant data
            Intent intent = new Intent(UserNotificationActivity.this, NotificationDetailsActivity.class);
            intent.putExtra("senderName", selectedNotification.getSenderName());
            intent.putExtra("timestamp", selectedNotification.getReceiveTime());
            intent.putExtra("details", selectedNotification.getDetails());
            startActivity(intent);
        });
    }
}
