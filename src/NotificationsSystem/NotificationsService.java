package NotificationsSystem;

import java.util.HashMap;
import java.util.Map;

public class NotificationsService {

    private NotificationsQueue notificationsQueue;


    public NotificationsService() {
        this.notificationsQueue = new NotificationsQueue();

        Dispatcher dispatcher = new Dispatcher(this.notificationsQueue);
        dispatcher.start();
    }

    public void sendNotification(Notification notification) {
        notificationsQueue.add(notification);
    }
}
