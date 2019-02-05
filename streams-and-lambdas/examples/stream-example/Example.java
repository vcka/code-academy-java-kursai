package transactionStreamExamples;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {

        List<Transaction> transactions =
                Transaction.transactions(10);


        Predicate<Transaction> transactionPredicate =
                transaction -> transaction.getId() % 2 == 0;

        List<Transaction> filteredTransaction = transactions.stream()
                .filter(transactionPredicate)
                .filter(transaction ->
                        transaction.getAmount() > 1008
                )
                .map(transaction -> new Transaction(transaction.getId(),
                        transaction.getDateTime(),
                        transaction.getAmount() * 2)
                )
                .collect(Collectors.toList());


        Map<Integer, Integer> transactionMap =
                transactions.stream()
                        .collect(
                                Collectors.toMap(
                                        transaction -> transaction.getId(),
                                        transaction -> transaction.getAmount()
                                )
                        );


        print(transactions);
        print(filteredTransaction);
        print(transactionMap.entrySet());

        Function<String, Integer> stringToInt =
                (numberAsString) -> Integer.parseInt(numberAsString);

        Predicate<String> isLongerThan10 =
                stringValue -> stringValue.length() > 10;
        System.out.println(isLongerThan10.test("aaaa"));
        System.out.println(isLongerThan10.test("aaaaaaaaaaaaaaaaaaaaa"));

        getTransactionById
                (10, () -> new Transaction(10, LocalDateTime.now(), 10000));
    }

    private static void print(Collection values) {
        for (Object object : values) {
            System.out.println(object);
        }
        System.out.println("---------------------------------------------");
    }

    private static Map<Integer, Transaction> transactionMap = new HashMap<>();

    private static Transaction getTransactionById(int id, Supplier<Transaction> defaultValue) {
        Transaction transaction = transactionMap.get(id);
        if (transaction == null) {
            return defaultValue.get();
        } else {
            return transaction;
        }
    }
}
