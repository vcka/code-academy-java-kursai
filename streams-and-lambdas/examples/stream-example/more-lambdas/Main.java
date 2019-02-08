import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) {

        List<MessageProcessor> processors = new ArrayList<>();
        processors.add(new EncryptedMessageProcessorImpl());
        processors.add(new WarningMessageProcessorImpl());

        MessageHandler messageHandler = new MessageHandler(processors);
        for (int i = 0; i < 4; i++) {
            List<Message> messages = messages(5);
            messageHandler.handleMessages(messages);
        }
        System.out.println("FAILED MESSAGES:");
        print(messageHandler.getFailedMessages());

    }

    private static void print(Iterable<?> iterable) {
        iterable.forEach(System.out::println);
    }

    private static List<Message> messages(int n) {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            messages
                    .add(new Message(
                            i,
                            i + " " + i * 10,
                            LocalDateTime.now().plusDays(i), MessageType.getRandom(i),
                            emptyList()));
        }
        return messages;
    }
}
