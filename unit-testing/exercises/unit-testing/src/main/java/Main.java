import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> a = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 10;
            }
        };

        a = (String s) -> s.length() > 10;
    }
}
