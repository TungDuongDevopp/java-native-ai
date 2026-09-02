package practice.model;

import practice.enums.MessagePlatform;
import practice.interfaces.NotificationSender;

public class SmsSender implements NotificationSender {

    @Override
    public void sendNotification(String message,String phone) {
        MessagePlatform platform = MessagePlatform.SMS;
        System.out.println("Sending sms on platform " + platform);
        System.out.println("Sending sms to " + phone);
        System.out.println("Content: " + message);
    }
}
