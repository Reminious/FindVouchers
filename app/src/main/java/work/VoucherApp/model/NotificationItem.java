package work.VoucherApp.model;

public class NotificationItem {
    private String senderName;
    private String receiveTime;
    private String details;

    // 构造函数，getter 和 setter 方法

    public NotificationItem(String senderName, String receiveTime, String details) {
        this.senderName = senderName;
        this.receiveTime = receiveTime;
        this.details = details;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public String getDetails() {
        return details;
    }


}
