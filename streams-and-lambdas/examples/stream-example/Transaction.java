package transactionStreamExamples;

import java.time.LocalDateTime;
import java.util.List;

public class Transaction {
    private int id;
    private LocalDateTime dateTime;
    private int amount;
    private List<String> recipients;


    public Transaction(int id, LocalDateTime dateTime, int amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getAmount() {
        return amount;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }
    
    public static List<Transaction> transactions(int n) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transactions
                    .add(new Transaction(n,
                            LocalDateTime.now().plusMinutes(n),
                            1000 + n * 2));
        }
        return transactions;
    }
}
