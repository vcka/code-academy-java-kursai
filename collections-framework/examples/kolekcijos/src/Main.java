import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Payment> randomPayments = Payment.getRandomPayments(20);
        for (Payment payment : randomPayments) {
            System.out.println(payment);
        }
    }
}
