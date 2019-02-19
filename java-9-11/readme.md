# Java 9-11

## Turinys
- [Java 9](#Java-9)
    - [Modulių sistema](#Modulių-sistema)
    - [VisualVM perkeltas į GraalVM](#VisualVM-perkeltas-į-GraalVM)
    - [JShell įrankis](#JShell-įrankis)
    - [Factory metodai kolekcijoms](#Factory-metodai-kolekcijoms)
    - [ObjectInputFilter](#ObjectInputFilter)
    - [Naujas HTTP klientas](#Naujas-HTTP-klientas)
    - [Patobulintas datų iteravimas](#Patobulintas-datų-iteravimas)
- [Java 10](#Java-10)
    - [var](#var)
    - [Optional.orElseThrow() metodas](#Optional.orElseThrow()-metodas)
- [Java 11](#Java-11)
    - [Nemodifikuojamų kolekcijų sukūrimas](#Nemodifikuojamų-kolekcijų-sukūrimas)
    - [Vieno failo programa](#Vieno-failo-programa)
    - [Nauji String metodai](#Nauji-String-metodai)
    - [Files.writeString() ir Files.readString() metodai](#Files.writeString()-ir-Files.readString()-metodai)
    - [TimeUnit.convert() metodas](#TimeUnit.convert()-metodas)
    - [Kitos naujienos](#Kitos-naujienos)
- [Nuorodos](#Nuorodos)
- [Užduotys](#Užduotys)

## Java 9

### Modulių sistema

Modulis - naujas programavimo komponentas. Programa gali būti suskirstyta į modulius. Leidžiama valdyti matomumą tarp skirtingų programos modulių. Java JDK taip pat buvo suskirstyta į modulius. Plačiau: http://openjdk.java.net/jeps/261

### VisualVM perkeltas į GraalVM

Įrankis VisualVM perkeltas į GraalVM ir nebėra tarp kitų `JAVA_HOME/bin` esančių įrankių.
VisualVM galima toliau naudoti parsisiuntus iš https://visualvm.github.io/

### JShell įrankis

Kataloge `JAVA_HOME/bin` galime rasti naują įrankį `jshell.exe`. Su šiuo įrankiu galime naudoti Java komandas interaktyviame lange, nekuriant jokios klasės.

Jei Java įdiegta į `C:\Program Files\Java\jdk-11.0.2`, tai `jshell` įrankį galite iškviesti komandinėje eilutėje įvedus: `"C:\Program Files\Java\jdk-11.0.2\bin\jshell.exe"`

```
C:\ROOT
λ "C:\Program Files\Java\jdk-11.0.2\bin\jshell.exe"
|  Welcome to JShell -- Version 11.0.2
|  For an introduction type: /help intro

jshell> String eilute = "Labas";
eilute ==> "Labas"

jshell> System.out.println(eilute);
Labas

jshell>
```

Daugiau apie `jshell`: https://docs.oracle.com/javase/9/jshell/toc.htm

### Factory metodai kolekcijoms

Palengvinimas norint užpildyti naujus `List`, `Set` ir `Map` objektus duomenimis.

Java 8:

```java
List<String> list8 = new ArrayList<>();
list8.add("a");
list8.add("b");
list8.add("c");
```

Java 9:

```java
List<String> list9 = List.of("a", "b", "c");
```

Tačiau toks sukurtas sąrašas yra nemodifikuojamas, t.y. jei norėsime įdėti dar vieną elementą `list9.add("d");`, ištrinti ar pakeisti esamą, to padaryti negalėsime ir gausime klaidą `UnsupportedOperationException`. Toks būdas sukurti kolekciją naudojant factory metodą `of()` naudingas tik tada, kai visi kolekcijos elementai yra žinomi ir nenorėsime modifikuoti kolekcijos vėliau.

`Set` ir `Map` taip pat galime sukurti naudojant factory metodą `of()`:
```java
Set<String> set9 = Set.of("a", "b", "c");
Map<String, Integer> map9 = Map.of("one", 1, "two", 2, "three", 3);
```
Sukurti `Set` ir `Map` objektai taip pat yra nemodifikuojami.

Plačiau: https://docs.oracle.com/javase/9/core/creating-immutable-lists-sets-and-maps.htm

### ObjectInputFilter

Sukurta `ObjectInputFilter` klasė, kuri leidžia patikrinti objektą dar prieš jį deserializuojant. Panaudojimo pavyzdys:

```java
public class Main {

    public static void main(String[] args) throws Exception {
        objectOutputInputTest(new GeraKlase());
        objectOutputInputTest(new BlogKlase());
    }

    private static void objectOutputInputTest(Object objectToSerialize) throws Exception {

        // objekto serializavimas
        Path path = Files.createTempFile("failas", "");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));
        try (objectOutputStream) {
            objectOutputStream.writeObject(objectToSerialize);
        }

        // objekto deserializavimas
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()));
        objectInputStream.setObjectInputFilter(createObjectFilter()); // nustatomas filtras
        try (objectInputStream) {
            Object o = objectInputStream.readObject();
            System.out.println("Deserializuotas objektas: " + o);
        }
    }

    private static ObjectInputFilter createObjectFilter() {
        return filterInfo -> {
            Class<?> theClass = filterInfo.serialClass();

            if (GeraKlase.class.isAssignableFrom(theClass)) {
                System.out.println("Leistina klase: " + theClass.getSimpleName());
                return ObjectInputFilter.Status.ALLOWED;
            } else {
                System.err.println("Neleistina klase: " + theClass.getSimpleName());
                return ObjectInputFilter.Status.REJECTED;
            }
        };
    }

}

class GeraKlase implements Serializable {
}

class BlogKlase implements Serializable {
}
```
Rezultatas:

```java
Leistina klase: GeraKlase
Deserializuotas objektas: lt.ca.GeraKlase@2d928643
BlogKlase class is not allowed for serialization: BlogKlase
Exception in thread "main" java.io.InvalidClassException: filter status: REJECTED
	at java.base/java.io.ObjectInputStream.filterCheck(ObjectInputStream.java:1287)
...
```

### Naujas HTTP klientas

Pakeitė seną `HttpURLConnection`. Paprastas `GET` užklausos pavyzdys:

```java
HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://postman-echo.com/get"))
        .GET()
        .build();

HttpResponse<String> response = HttpClient.newHttpClient()
        .send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());
```

Plačiau: https://openjdk.java.net/groups/net/httpclient/intro.html

### Patobulintas datų iteravimas

```java
public class Main {

    public static void main(String[] args) {

        iteruotiTarpDatu7(new Date(2019, 1, 1), new Date(2019, 1, 15));

        iteruotiTarpDatu8(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 15));
        
        iteruotiTarpDatu9(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 15));

    }

    // JAVA 7
    public static void iteruotiTarpDatu7(Date start, Date end) {
        Date current = start;

        while (current.before(end)) {
            System.out.println(current);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(current);
            calendar.add(Calendar.DATE, 1);
            current = calendar.getTime();
        }
    }

    // JAVA 8
    public static void iteruotiTarpDatu8(LocalDate start, LocalDate end) {
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            System.out.println(date);
        }
    }

    // JAVA 9
    public static void iteruotiTarpDatu9(LocalDate start, LocalDate end) {
        start.datesUntil(end).forEach(System.out::println);
    }

}
```

## Java 10

### var

Galime kairėje pusėje prieš kintamojo pavadinimą nerašyti tipo. Tipas bus nusprendžiamas pagal dešinėje pusėje esančią išraišką. Pavyzdys:

```java
var i = 10;
System.out.println(i); // 10

var list = new ArrayList<>();
list.add(2);
list.add("one");

System.out.println(list); // [2, one]
```

Bet negalime daryt taip:
```java
var i; 
var i, j = 0;
var i = null;
```
nes Java kompiliatorius nežinos, koks yra kintamojo 'i' tipas.

Daugiau apie `var` naudojimą: https://www.baeldung.com/java-10-local-variable-type-inference

### Optional.orElseThrow() metodas

Jei `Optional` yra be reikšmės galima naudoti metodą `orElseGet`, kuris grąžins nurodytą numatytąją reikšmę arba nuo Java 9-os versijos metodą `orElseThrow`, kuris iššauks klaidą. Pavyzdys:

```java
Optional<String> test = Optional.empty();
test.orElseThrow();
```

```
Exception in thread "main" java.util.NoSuchElementException: No value present
	at java.base/java.util.Optional.orElseThrow(Optional.java:382)
	at lt.ca.Main.main(Main.java:12)
```

### Nemodifikuojamų kolekcijų sukūrimas

`Map`, `List` ir `Set` klasės turi naują statinį metodą `copyOf(...)`, kuris nukopijuoja paduotos kolekcijos elementus ir sukuria nemodifikuojamą kolekciją.

Pavyzdys:
```java
List<String> sarasas = new ArrayList<>();
sarasas.add("hello");
sarasas.add("world");

List<String> nemodifikuojamasSarasas = List.copyOf(sarasas);
nemodifikuojamasSarasas.add("!!!");
```
Gausime `UnsupportedOperationException` klaidą.

## Java 11

### Vieno failo programa

Turime paprastą klasę `Greeting`, kuri reikalauja jai paduoti vardą per argumentus. Ši programa yra saugome faile pavadinimu `Greeting.java`:
```java
public class Greeting {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.err.println("Name required");
            System.exit(1);
        }
        System.out.println(String.format("Hello %s!!", args[0]));
    }
}
```
Tada tokią programą galime paleisti taip:
```
java Greeting.java John
```
t.y. nereikia naudoti kompiliavimo komandos `javac` ir vėliau naudoti `java` komandą sukompiuliuotos programos paleidimui. Nuo Java 11-os versijos komanda `java` supranta, kad norime paleisti vieno failo Java programą ir ją sukompiliavusi paleidžia.

### Nauji String metodai

String klasė turi naujus metodus:
- `isBlank()` - patikrina ar eilutė yra tuščia arba yra sudaryt iš tuščių simbolių:
    ```java
    String eilute = "";
    System.out.println(eilute.isBlank()); // true
    eilute = " ";
    System.out.println(eilute.isBlank()); // true
    ```
- `lines()` - grąžina sąrašą eilučių kaip srautą:
    ```java
    String daugEiluciu = "Hello\nworld";
        daugEiluciu.lines()
                .forEach(System.out::println);  // Hello
                                                // world
    ```

- `repeat()` - grąžina tiek kartų padidintą eilutę, kokį skaičiu padavėme per parametrus:
    ```java
    final String desimtIksu = "X".repeat(10);
    System.out.println(desimtIksu);      // XXXXXXXXXX
    ```

- `strip()`, `stripLeading()` ir `stripTrailing()` - grąžina eilutę be pradžioje ir pabaigoje buvusių tarpų:
    ```java
    System.out.println("|" + eiluteSuTarpais + "|");                // |     Labas Vakaras       |
    System.out.println("|" + eiluteSuTarpais.strip() + "|");        // |Labas Vakaras|
    System.out.println("|" + eiluteSuTarpais.stripLeading() + "|"); // |Labas Vakaras       |
    System.out.println("|" + eiluteSuTarpais.stripTrailing() + "|");// |     Labas Vakaras|
    ```

### Files.writeString() ir Files.readString() metodai

Klasės `Files` metodas `writeString` leidžia turimą `String` eilutę lengvai įrašyti į failą:
```java
Files.writeString(Path.of("failas.txt"), "Labas!");
```
Klasės `Files` metodas `readString` leidžia lengvai nuskaityti failą ir tekstą priskirti `String` tipo kintamajam:
```java
String eiluteIsFailo = Files.readString(Path.of("failas.txt"));
System.out.println(eiluteIsFailo); // Labas!
```

### TimeUnit.convert() metodas

Naudojant klasės `TimeUnit` metodą `convert()` galime konvertuoti iš vieno laiko vieneto į kitą. Pavyzdys:

```java
TimeUnit unit = TimeUnit.DAYS;

long fiftyHoursInDays = unit.convert(Duration.ofHours(50));
System.out.println(fiftyHoursInDays); // 2

unit = TimeUnit.SECONDS;

long oneYearInSeconds = unit.convert(Duration.ofDays(365));
System.out.println(oneYearInSeconds); // 31536000
```

### Kitos naujienos

Daugiau naujų funkcijų su pavyzdžiais galima rasti čia: https://dzone.com/articles/90-new-features-and-apis-in-jdk-11

## Nuorodos
- Release notes:
    - JDK 9 https://www.oracle.com/technetwork/java/javase/9all-relnotes-3704433.html
    - JDK 10 https://www.oracle.com/technetwork/java/javase/10all-relnotes-4108743.html
    - JDK 11 https://www.oracle.com/technetwork/java/javase/11all-relnotes-5013287.html


## Užduotys
- [Užduotys](exercises/readme.md)