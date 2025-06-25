package NotificationsSystem;

public class EmailNotificationSystem implements Channel {
    @Override
    public boolean sendMessage(Notification notification) {
        System.out.println("Sending email Notification with priority " + notification.getPriority());
        return true;
    }
}
