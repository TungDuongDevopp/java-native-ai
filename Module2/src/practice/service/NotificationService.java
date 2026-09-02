package practice.service;
import practice.interfaces.NotificationSender;

public class NotificationService {

    private final NotificationSender notification;

    public NotificationService(NotificationSender notification) {
        this.notification = notification;
    }

    public void sendNotification(String message,String reciver) {
        if(message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or blank");
        }
        if(reciver == null || reciver.isBlank()) {
            throw new IllegalArgumentException("Reciver cannot be null or blank");
        }
        notification.sendNotification(message,reciver);
    }

}
