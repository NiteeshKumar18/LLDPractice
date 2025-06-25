package NotificationsSystem;

import java.util.EnumMap;
import java.util.Map;

public class Dispatcher extends Thread {

    private NotificationsQueue notificationsQueue;
    private Map<NotificationsType, Channel> typeChannelMap;

    public Dispatcher(NotificationsQueue notificationsQueue) {
        this.notificationsQueue = notificationsQueue;
        this.typeChannelMap = new EnumMap<NotificationsType, Channel>(NotificationsType.class);
        typeChannelMap.put(NotificationsType.EMAIL, new EmailNotificationSystem());
    }

    @Override
    public void run() {
        while (true) {
            processMessage();
        }
    }

    public void processMessage() {
        Notification notification = notificationsQueue.remove();
        if (notification != null) {
            boolean success = false;
            int noOfRetries = 3;

            while (noOfRetries > 0 && !success) {
                success = typeChannelMap.get(notification.getType()).sendMessage(notification);
                noOfRetries--;
            }

            if (!success) {
                System.out.println("Couldnt send the required message");
            }
        }
    }
}
