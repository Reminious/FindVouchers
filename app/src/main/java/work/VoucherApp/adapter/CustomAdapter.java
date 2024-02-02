package work.VoucherApp.adapter;
// CustomAdapter.java
// CustomAdapter.java

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import work.VoucherApp.NotificationDetailsActivity;
import work.VoucherApp.R;
import work.VoucherApp.model.NotificationItem;


public class CustomAdapter extends ArrayAdapter<NotificationItem> {

    private LayoutInflater inflater;
    private Context context;

    public CustomAdapter(Context context, ArrayList<NotificationItem> data) {
        super(context, 0, data);
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_type_user_notification, parent, false);
        }

        NotificationItem item = getItem(position);

        // Find your views in the layout
        TextView senderNameTextView = convertView.findViewById(R.id.textViewSenderName);
        TextView timestampTextView = convertView.findViewById(R.id.textViewTimestamp);
        Button detailsButton = convertView.findViewById(R.id.buttonDetails);

        // Set data to your views
        senderNameTextView.setText(item.getSenderName());
        timestampTextView.setText(item.getReceiveTime());

        // Set button click listener to open NotificationDetailsActivity
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NotificationDetailsActivity and pass relevant data
                Intent intent = new Intent(context, NotificationDetailsActivity.class);
                intent.putExtra("senderName", item.getSenderName());
                intent.putExtra("timestamp", item.getReceiveTime());
                intent.putExtra("details", item.getDetails());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
