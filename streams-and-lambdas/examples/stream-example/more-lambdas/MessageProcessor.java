import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class MessageProcessor {

    protected Predicate<Message> acceptableMessage;
    protected List<Message> messages = new ArrayList<>();

    public MessageProcessor(Predicate<Message> acceptableMessage) {
        this.acceptableMessage = acceptableMessage;
    }

    abstract boolean add(Message message);

    abstract void sendMessages();

}
