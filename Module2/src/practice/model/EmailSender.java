package practice.model;

import practice.enums.MessagePlatform;
import practice.interfaces.NotificationSender;

public class EmailSender implements NotificationSender {

    @Override
    public void sendNotification(String message,String email) {
       MessagePlatform platform = MessagePlatform.EMAIL;
        System.out.println("Sending email on platform " + platform);
        System.out.println("Sending email to " + email);
        System.out.println("Content: " + message);
    }
}
