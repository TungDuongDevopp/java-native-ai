package practice.main;


import practice.interfaces.NotificationSender;
import practice.model.EmailSender;
import practice.model.SmsSender;
import practice.service.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationSender smsSender = new SmsSender();
        NotificationService service = new NotificationService(smsSender);
        service.sendNotification("Hello World!","0345976153");

        NotificationSender emailSender = new EmailSender();
        service = new NotificationService(emailSender);
        service.sendNotification("Hello World!","Xaydaa8@gmail.com");
    }

}
