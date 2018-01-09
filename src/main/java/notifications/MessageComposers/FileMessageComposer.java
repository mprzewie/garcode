package notifications.MessageComposers;

import exerciseCreator.Outcome;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileMessageComposer extends MessageComposer {
    public FileMessageComposer(Outcome outcome) {
        super(outcome);
    }

    public String composeMessage() {
        return super.composeMessage(Paths.get("src/main/resources/messageContent/fileMessageContent.txt"));
    }

    @Override
    protected String formatMessageText(String line) {
        line = line.replaceAll("%fileInfo%", "Wygenerowano " + LocalDateTime.now().toString());
        return super.formatMessageText(line);
    }
}