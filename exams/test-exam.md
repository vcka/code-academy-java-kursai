- Koks skirtumas tarp failo turinio nuskaitymo naudojant `Files.readAllLines` metodą ir failo turinio nuskaitymo naudojant BufferedReader, gaunama kviečiant metodą `Files.newBufferedReader`. Kada reikėtų naudoti vieną, o kada kitą metodą?

- Pabaikite rašyti *lambda* išraišką, kuri sujungtų du Stringus ir grąžintų rezultatą kaip *char* masyvą nurodytame kode:
```java
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

public class MyApp {
  public static void main(String[] args) {
           BiFunction<String, String, Character[]> combineWordsIntoArray;
           combineWordsIntoArray = // aprašyti
  }
}
```
- Koks rezultatas bus išvestas į konsolę nurodytame kode:
```java
public class MyApp {
    public static String processWords(List<String> words) {
        return words.stream()
                .filter(word -> word.length() > 4)
                .map(word -> word + 10)
                .collect(Collectors.joining("-"));
    }

    public static void main(String[] args) {
        System.out.println(processWords(Arrays.asList("public", "static", "void", "main", "args")));
    }
}
```
- Koks rezultatas bus išvestas į konsolę, nurodytame kode:
```java
public class MyApp {

    public static void main(String[] args) {
        System.out.println(distinctNumbers(Arrays.asList(123,653,142,975)));
    }

    public static String distinctNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .flatMap(number -> Arrays.stream(number.split("")))
                .distinct()
                .collect(Collectors.joining(","));
    }
}
```

- Pasirinkite variantą, kuriame surašyti tik primityvieji tipai:
    - [ ] **A** `long`, `int`, `Float`, `double`, `short`
    - [ ] **B** `int`, `String`, `float`, `long`, `double`
    - [ ] **C** `double`, `boolean`, `float`, `short`, `char`
    - [ ] **D** `boolean`, `int`, `Char`, `long`, `short`
    - [ ] **E** `Long`, `Double`, `Integer`, `Char`, `Float`

- Ką atspausdins tokia programa:
    ```java
    for (int i = 0; i < 10; i++) {
        System.out.print(i++);
    }
    ```
    - [ ] **A** 0246810
    - [ ] **B** 246810
    - [ ] **C** 13579
    - [ ] **D** 02468
    - [ ] **E** 13579

- Ką atspausdins tokia programa:
    ```java
    int a = 65533 + 2;
    int b = 65534 + 1;
    String c = "testas";
    String d = "Testas";
    String e = new String("Testas");
    System.out.print(a == b);
    System.out.print(" ");
    System.out.print((c == d) + "/" + c.equals(d));
    System.out.print(" ");
    System.out.print((c == e) + "/" + c.equals(e));
    System.out.print(" ");
    System.out.print((e == d) + "/" + e.equals(d));
    ```
    - [ ] **A** `true false/false false/false false/true`
    - [ ] **B** `true false/false false/false true/true`
    - [ ] **C** `false false/false false/false false/true`

- Ką atspausdins tokia programa:
    ```java
    public class MyApp {

        public static void main(String[] args) {

            try {
                notSafeMethod();
            } catch (MyChildException e) {
                System.out.println(1);
            } catch (MyParentException e) {
                System.out.println(2);
            } catch (Exception e) {
                System.out.println(3);
            }
        }

        public static void notSafeMethod() throws MyParentException {
            throw new MyParentException();
        }
    }

    class MyParentException extends Exception {}

    class MyChildException extends MyParentException {}
    ```
    - [ ] **A** 1
    - [ ] **B** 2
    - [ ] **C** 3

- Duota tokia *Generic* klasė:
    ```java
    public class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    ```
    Kokiais būdais galime sukurti klasės `Pair` objektą?
    ```java
    Pair<String, Integer> myPair = new Pair<>("one", 1);    // 1
    Pair<String, Integer> myPair2 = new Pair<>();           // 2
    Pair<String, Integer> myPair3 = new Pair<>(1, "one");   // 3
    Pair myPair4 = new Pair(1, "one");                      // 4
    ```

    - [ ] **A** 1, 2 ir 4
    - [ ] **B** 1 ir 2
    - [ ] **C** 1 ir 4
    - [ ] **D** 1 ir 3
    - [ ] **E** 1, 2, 3 ir 4

- Kuri *Maven* artefakto gyvavimo ciklo fazė įdiegia paketą į nutolusią saugyklą?
    - [ ] **A** `compile`
    - [ ] **B** `install`
    - [ ] **C** `deploy`
    - [ ] **D** `site`

- Kas yra serializacija?
    - [ ] **A** Java objekto pavertimas į baitų srautą
    - [ ] **B** Baitų srauto pavertimas į Java objektą

- Turime tokią programą, kuri naudoja *Jackson* biblioteką:
    ```java
    public class MyApp {

        public static void main(String[] args) {

            Car car = new Car();
            car.setMake("WV");
            car.setModel("Passat");

            ObjectMapper mapper = new ObjectMapper();
            String carJson = mapper.writeValueAsString(car);

            System.out.println(carJson);

        }
        
    }

    class Car {

        private String make;
        @JsonProperty("modelis")
        private String model;

        // konstruktoriai, getteriai ir setteriai
    }
    ```
    Ką atspausdins programa?
    - [ ] **A** `{"make": "WV", "model": "Passat"}`
    - [ ] **B** `{"Make": "WV", "Model": "Passat"}`
    - [ ] **C** `{"make": "WV", "modelis": "Passat"}`
    - [ ] **D** `{"make": "WV", "model": null}`

- Ką atspausdins tokia programa:
    ```java
    LocalDateTime now = LocalDateTime.of(2019, Month.FEBRUARY, 15, 23, 39);

    System.out.println(now);
    ```
    - [ ] **A** 2019-02-15
    - [ ] **B** 2019-02-15T23:39
    - [ ] **C** 23:39
    - [ ] **D** 2019-FEBRUARY-15 23:39

- Ką atspausdins tokia programa:
    ```java
    LocalDate now = LocalDate.parse("2019-02-21");

    now = now.plusDays(1);
    now = now.minusMonths(2);
    now = now.plusYears(3);
    now = now.minusDays(15);
    now = now.plus(Period.ofMonths(7));

    System.out.println(now);
    ```
    - [ ] **A** 2022-07-06
    - [ ] **B** 2019-02-21
    - [ ] **C** 2022-07-22
    - [ ] **D** 2019-07-07
    - [ ] **E** 2022-07-07

- Turime tokią programą:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("(\\s+)(\\w{3})(\\s+)", "$1*$3");

    System.out.println(text);
    ```
    Ką ji atspausdins?
    - [ ] **A** The quick brown * jumps over * lazy dog
    - [ ] **B** * *ck *wn * *ps *r * *y *
    - [ ] **C** * quick brown * jumps over * lazy *
    - [ ] **D** * * * * * * * * *
    - [ ] **E** The quick brown fox jumps over the lazy dog

- Turime tokią programą (*java9*):
    ```java
    List<String> listas = List.of("1", "2", "3");   // 1 eil.
    listas.add(4);                                  // 2 eil.
    System.out.println(listas);                     // 3 eil.
    ```
    - [ ] **A** Antroje eilutėje gausime vykdymo klaidą `UnsupportedOperationException`
    - [ ] **B** Antroje eilutėje gausime kompiliavimo kladą `incompatible types`
    - [ ] **C** Pirmoje eilutėje gausime klaidą, nes klasė `List` neturi metodo `of(...)`
    - [ ] **D** Atspausdins [1, 2, 3, 4]
    
- Koks skirtumas tarp git *add* ir git *commit* komandų?


- Kokie elementai sudaro *list2* sąrašą?
```java
List<String> list1 = Arrays.asList(".", ":", "..", ":", "-", "-");
Set<String> set1 = new HashSet<>(list1);
List<String> list2 = new Linked<>(set1);
```

- Kokia yra teisinga veiksmų seka norint nusiųsti kodo pakeitimus į *remote* serverį?
- [ ] git pull -> git commit -> git pull
- [ ] git add -> git commit
- [ ] git pull -> git add -> git commit -> git push
- [ ] git push -> git add -> git commit -> git pull
- [ ] git add -> git commit -> git push


- Kaip parašyti teisingą *assert statement*, įrodantį, jog metodas `static int multiplyBySix(int number)` veikia taip, kaip reikia
- [ ] assertEquals(36, multiplyBySix(6))
- [ ] assertEquals(multiplyBySix(6), 36)
- [ ] assertEquals(multiplyBySix(6), 36, "6 multiplied by 6 should be 36")
- [ ] assertEquals(6 * 6, 36)


- Kurie žemiau nurodyti kintamojo priskirimai teisingi?
```java
   public class PrivatePerson extends Person {
   }
   
   public abstract class Person implements Citizen {
   }
```
- [ ] PrivatePerson person = new PrivatePerson();
- [ ] PrivatePerson person = new Ciziten();
- [ ] Citizen citizen = new PrivatePerson();
- [ ] Person person = new Person();
- [ ] Person person = new PrivatePerson(); PrivatePerson privatePerson = (PrivatePerson) person;

