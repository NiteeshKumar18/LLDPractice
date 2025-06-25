package NotificationsSystem;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        NotificationsService notificationsService = new NotificationsService();
        User user = new User("Niteesh kumar", "nkumar@clari.com");
        Notification notification = new Notification(ThreadLocalRandom.current().nextInt(),user, "Hello", 2, NotificationsType.EMAIL);
        Notification notification2 = new Notification(ThreadLocalRandom.current().nextInt(),user, "Hello2", 3, NotificationsType.EMAIL);
        Notification notification3 = new Notification(ThreadLocalRandom.current().nextInt(),user, "Hello3", 1, NotificationsType.EMAIL);
        notificationsService.sendNotification(notification);
        notificationsService.sendNotification(notification2);
        notificationsService.sendNotification(notification3);

    }
}
