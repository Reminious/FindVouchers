package work.VoucherApp.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import work.VoucherApp.NotificationDetailsActivity;
import work.VoucherApp.R;
import work.VoucherApp.model.NotificationItem;

public class NotificationAdapter extends ArrayAdapter<NotificationItem> {
    private int layoutResource;
    private Context context;

    public NotificationAdapter(@NonNull Context context, int resource, @NonNull List<NotificationItem> objects) {
        super(context, resource, objects);
        layoutResource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutResource, null);
        }

        // 获取当前位置的通知项对象
        NotificationItem notificationItem = getItem(position);

        // 将数据绑定到布局中的各个视图
        TextView senderNameTextView = view.findViewById(R.id.textViewSenderName);
        TextView timestampTextView = view.findViewById(R.id.textViewTimestamp);
        Button buttonDetails = view.findViewById(R.id.buttonDetails);

        if (notificationItem != null) {
            senderNameTextView.setText(notificationItem.getSenderName());
            timestampTextView.setText(notificationItem.getReceiveTime());

            // 设置 Details 按钮点击事件处理
            buttonDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 处理点击事件，启动新的活动，并传递详细信息
                    Intent intent = new Intent(context, NotificationDetailsActivity.class);
                    intent.putExtra("details", notificationItem.getDetails());
                    context.startActivity(intent);
                }
            });
        }

        return view;
    }
}
