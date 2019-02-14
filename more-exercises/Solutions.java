import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {

    /**
     * Parašykite metodą, kuris priimtų Integer tipo sąrašą ir grąžintų String tipo reikšmę su visais sąrašo elementais, atskirtais kableliais. Prie kiekvieno elemento turėtų būti pridėta raidė e jei skaičius yra lyginis arba raidė o jei skaičius nėra lyginis. Naudokite srautus.
     */

    public static String manipulateIntList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number % 2 == 0 ? "e" + number : "o" + number)
                .collect(Collectors.joining(","));
    }

    /**
     * Parašykite metodą, kuris priimtų 3 parametrus – du String tipo žodžius ir BiPredicate palyginantį du žodžius ir grąžinantį true, jei pirmas žodis geresnis nei antras. Metodas turi grąžinti geresnį žodį panaudodamas gautą BiPredicate.
     */
    public static String betterWord(String firstWord, String secondWord, BiPredicate<String, String> betterWord) {
        return (betterWord.test(firstWord, secondWord)) ? firstWord : secondWord;
    }

    /**
     * Parašykite metodą, kuris priima sąrašą žodžių ir kaip rezultatą grąžina sąrašą su visomis unikaliomis žodžių raidėmis. Įgyvendinkite tai naudodami srautus.
     */
    public static Set<String> uniqueChars(List<String> words) {
        return words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toSet());
    }

    /**
     * Parašykite metodą, kuris priima sąrašą raidžių. Sukurkite failą, kuriame būtų surašytos sąraše esančios raidės ir skaičiai, kiek kartų pasikartojo kiekviena raidė. Naudokite srautus (group by collectorių).
     */
    public static void groupingLetters(List<String> letters) throws IOException {
        final Map<String, List<String>> groupedLetters = letters.stream()
                .collect(Collectors.groupingBy(letter -> letter));

        final Path newFile = Files.createFile(Paths.get("./groupedLetters"));
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFile)) {
            groupedLetters.forEach((letter, repetitions) -> {
                try {
                    bufferedWriter.write(letter + ": " + repetitions.size());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    /**
     * Parašykite metodą, kuris priima String tipo parametrą su kableliu išskirtais skaičiais. Kiekvieną skaičių padauginkite iš dviejų ir išmeskite skaičius, kurie dalinasi iš 4, grąžinkite likusius skaičius išskirtus dvitaškiu kaip String tipo kintamąjį
     */
    public static String manipulateNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .map(number -> number * 2)
                .filter(number -> number % 4 == 0)
                .map(Object::toString)
                .collect(Collectors.joining(":"));
    }

    /**
     * Parašykite metodą, kuris priima Integer tipo parametrą - i ir grąžina String tipo reikšmę vaizduojančią skaičių seką (1, 2, ... , i). Sekoje visi skaičiai besidalijantys iš 3 yra pakeisti žodžiu Fizz, skaičiai besidalijantys iš 5 pakeisti žodžiu Buzz, o skaičiai, kurie dalijasi ir iš 3 ir iš 5 yra pakeisti žodžiu FizzBuzz. Visi kiti skaičiai lieka nepakeisti. Pabandykite tai įgyvendinti naudodami srautus.
     */
    public static String fizzBuzz(int i) {
        return IntStream.rangeClosed(1, i)
                .mapToObj(number -> number % 3 == 0 ? (number % 5 == 0 ? "FizzBuzz" : "Fizz") : (number % 5 == 0 ? "Buzz" : String.valueOf(number)))
                .collect(Collectors.joining());
    }

    /**
     * Parašykite metodą, kuris priima String tipo parametrą - kelią iki direktorijos. Metodas turėtų nuskaityti visus failus direktorijoje ir jų turinį surašyti į vieną failą. Naudokite srautus.
     */
    public static void concatFiles(String pathToDir) throws IOException {
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("./result"))) {
            for (Path path : Files.walk(Paths.get(pathToDir)).collect(Collectors.toList())) {
                for (String line : Files.readAllLines(path)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        }
    }


}
