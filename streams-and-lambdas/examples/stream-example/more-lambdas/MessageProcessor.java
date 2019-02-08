import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class MessageProcessor {

    protected Predicate<Message> acceptableMessage;
    protected List<Message> messages = new ArrayList<>();

    public MessageProcessor(Predicate<Message> acceptableMessage) {
        this.acceptableMessage = acceptableMessage;
    }

    public boolean anyMessagesToSend() {
        return !messages.isEmpty();
    }

    void handle(Message message) {
        if (canHandle(message)) {
            messages.add(message);
        }
    }

    boolean canHandle(Message message) {
        return acceptableMessage.test(message);
    }

    abstract void sendMessages();

}
