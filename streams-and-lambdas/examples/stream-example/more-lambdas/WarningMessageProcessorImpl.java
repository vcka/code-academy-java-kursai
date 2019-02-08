public class WarningMessageProcessorImpl extends MessageProcessor {


    public WarningMessageProcessorImpl() {
        super(message -> MessageType.WARNING_MESSAGE.equals(message.getType()));
    }

    @Override
    void sendMessages() {
        System.out.println("SENDING WARNING MESSAGES!!!!!!");
        messages.forEach(System.out::println);
        System.out.println("SENDING FINISHED");
    }
}
