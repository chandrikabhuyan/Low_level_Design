package org.example.Solid.DependencyInversion;

//Suppose you are building a notification system that sends notifications via different channels such as email and SMS.
// Initially, you might create two classes directly for these channels:
class EmailNotification {
    public void sendEmail(String message){
        System.out.println("Sending an email: "+message);
    }
}

class smsNotification{
    public void sendSms(String message){
        System.out.println("Sending a sms: "+message);
    }
}
//In this code, we have two classes, EmailNotification and SMSNotification, each responsible for sending notifications
// through their respective channels. However, this violates the Dependency Inversion Principle because the high-level
// module (the part of your application that uses notifications) depends directly on low-level modules (email and SMS).
//To adhere to the Dependency Inversion Principle, we should introduce an abstraction (an interface in this case) and make both
// low-level modules implement it:

interface Notification{
    public void sendMessage(String message);
}

class EmaillNotification implements Notification {
    public void sendMessage(String message) {
        // Code to send an email
        System.out.println("Sending an email: " + message);
    }
}
class SMSNotification implements Notification {
    public void sendMessage(String message) {
        // Code to send an SMS
        System.out.println("Sending an SMS: " + message);
    }
}
//Now, our high-level module can depend on the Notification interface rather than specific implementations:
class NotificationService{
    public Notification noti;
    NotificationService(Notification noti){
        this.noti = noti;
    }
    void sendNotification(String message){
        noti.sendMessage(message);
    }
}

//By doing this, you've adhered to the Dependency Inversion Principle. The NotificationService class depends on the
// abstraction (Notification interface) rather than concrete implementations. This makes your code more flexible and easier to
// extend because you can easily add new notification channels by creating classes that implement the Notification interface
// without modifying the high-level code.
//In summary, the Dependency Inversion Principle encourages you to depend on abstractions (interfaces or abstract classes)
// rather than concrete implementations, promoting decoupling and flexibility in your code.