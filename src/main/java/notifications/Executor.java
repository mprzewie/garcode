/**
 * Created by Michał on 19.12.2017.
 */
package notifications;

import exerciseCreator.executor.Outcome;
import notifications.SpecializedSenders.FileExporter;
import notifications.SpecializedSenders.MailSender;
import notifications.SpecializedSenders.SmsSender;

public class Executor {

    public static void main(String[] args) throws Exception {
//        MailSender mailSender = new MailSender();
//        FileExporter fileExporter = new FileExporter();
//        SmsSender smsSender = new SmsSender();
//        InstructorFetcher instructorFetcher = new InstructorFetcher();
//        Sender sender = new Sender(mailSender, smsSender, fileExporter, instructorFetcher);
//        Outcome outcome = new Outcome("10", "Adam", "Adamiak", "123456789", "test@test.com", "Excellent", "Title", 16, 20, "OK");
//        sender.sendResults(outcome);

//        InstructorFetcher instructorFetcher = new InstructorFetcher();
//        System.out.println(instructorFetcher.getMail());
//        Outcome outcome = new Outcome("10", "Adam", "Adamiak", "123456789", "blaszkiewiczmilosz@interia.eu", "Excellent", "Title", 16, 20, "OK");
//        MailConfiguration mailConfiguration = new MailConfiguration("grabowszczakls", "Test12345", "smtp.gmail.com", true, 587);
//        MailMessageComposer mailMessageComposer = new MailMessageComposer(outcome);
//        MailSender instructorSender = new MailSender(mailConfiguration, instructorFetcher.getMail(), mailMessageComposer);
//        instructorSender.sendResults(outcome);
    }
}
