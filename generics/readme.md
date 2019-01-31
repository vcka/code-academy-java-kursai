# Generics

## *Generic* klasės

### *Generic* klasės sintaksė
```java
class KlasesVardas<T1, T2, ..., Tn> { /* ... */ }
```
T1, T2, ..., Tn - tai yra tipų kintamieji (klasių vardai).
Tipų kintamieji gali būti bet kokie neprimityvieji tipai: bet kokios klasės tipas, bet kokio interfeiso tipas, bet kokio masyvo tipas ar bet koks kitas tipas.

### Tipo parametro vardo konvencija
Pagal Java konvenciją sutarta, kad *generic* tipo parametro vardas turi būti viena didžioji.
Dažniausiai naudojami vardai:
- E - Element
- K - Key
- N - Number
- T - Type
- V - Value

### Ne *generic* klasės pavyzdys
Pavyzdys paprastos (ne *generic*) `Box` klasės, kuri turi bet kokio tipo klasės kintamąjį. Klasė `Box` turi du metodus - `set`, kuris nustato viduje esantį objektą ir `get`, kuris grąžina viduje esantį objektą.
```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```
Tokiai klasei galime paduoti bet kokio neprimityvaus tipo objektus. Pavyzdžiui į klasę `Box` įdėsime `Integer` tipo objektą. Vėliau iš `Box` klasės pasiėmę objektą tikėsimės, kad tai yra skaičius. Viskas gerai. Bet jei kas nors į `Box` klasą įdės pavyzdžiui `String` tipo objektą, o mes pasiėmę tą objektą to nežinosime ir tikėsimės, kad tai yra skaičius, bandysime objektą *cast*'inti į `Integer` ir gausime `RuntimeException`. Situaciją vaizduojantis pavyzdys:
```java
public class BoxTest {

    public static void main(String[] args) {

        Integer number;
        Box box = new Box();

        box.set(10);
        number = (Integer)box.get(); // Viskas gerai, nes Integer

        box.set("Java");
        number = (Integer)box.get(); // RuntimeException

    }
}
```

### *Generic* klasės pavyzdys
Pakeitus klasę `Box` į *generic*, ji atrodo taip:
```java
public class Box<T> {
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

### Objekto sukūrimas
```java
Box<Integer> integerBox;
```
Taip yra apibrėžiamas `integerBox` kintamasis. Kampiniuose skliaustuose <> yra nurodoma, kokio tipo objektą saugos klasė `Box`.

Naujo objekto sukūrimas:
```java
Box<Integer> integerBox = new Box<Integer>();
```
Nuo Java 7-os versijos dešinėje galima ir netgi rekomenduojama (dėl kodo supaprastinimo) nerašyti tipo. Galime palikti tuščius kampinius skliaustus <>. 
```java
Box<Integer> integerBox = new Box<>();
```

Anksčiau sukurtos *generic* klasės `Box` naudojimo pavyzdys
```java
public class GenericBoxTest {

    public static void main(String[] args) {

        Integer number;
        Box<Integer> integerBox = new Box<>();

        integerBox.set(10);
        number = integerBox.get(); // privalumas: nereikia naudoti cast operacijos

        integerBox.set("Java");    // kompiliavimo klaida
        number = integerBox.get(); 

    }
}
```
Naudodami *generic* tipus kode padarytą klaidą pastebės kompiliatorius. Taip pat didelis privalumas, kad norint panaudoti `Box` klasės viduje esantį objektą mums nereikia atlikti *cast* operacijos.

### *Key* ir *value* poros implementacijos naudojant *generic* pavyzdys

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
```
```java
public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}
```

Klasės `OrderedPair` objekto sukūrimas:
```java
Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Eight", 8);
Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
```
Eilutė `new OrderedPair<String, Integer>` nurodo, kad `OrderedPair` klasės `K` tipo kintamasis tampa `String`, `V` tampa `Integer`, todėl galime kviesti `OrderedPair` konstruktoriu jam perdodant atitinkamas reikšmes `new OrderedPair<String, Integer>("Eight", 8)`. 
Kaip buvo minėta anksčiau, dešinėje pusėje nėra būtina rašyti *generic* tipų. Taip kodą supaprastiname iki 
```java
Pair<String, Integer> p1 = new OrderedPair<>("Eight", 8);
```
Taip pat kaip tipą galima nurodyti tokį, kuris taip turi *generic* parametrą. Pavyzdys:
```java
Pair<String, Box<Integer>> p = new OrderedPair<>("Primes", new Box<Integer>(...));
``` 

### *Raw* (neapdoroti) tipai
*Raw* tipu vadinamas *generic* klasės arba interfeiso vardas be tipo parametro. Pavyzdžiui turime tą pačią klasę `Box`:
```java
class Box<T> {
    private T object;

    public void set(T object) { this.object = object; }
    public T get() { return object; }
}
```
Jei kuriant klasės `Box` objektą nurodome koks tipas atitinka `T` generic parametrą, tada turime parametrizuotą `Box<T>` tipą:
```java
Box<Integer> intBox = new Box<>();
```
Bet jei kuriant tos pačios klasės objektą nenurodome *generic* tipo, tada turime `Box<T>` *raw* tipą:
```java
Box rawBox = new Box();
```
Kaip buvo minėta anksčiau *generics* atsirado nuo Java 5-os versijos, todėl *raw* tipai yra daugiau skirti kodui parašytam naudojant ankstesnes Java versijas palaikyti.

Tačiau rašant naują kodą, reikia vengti naudoti *raw* tipus. Pavyzdys dempnstruojantis galimą problmą:
```java
public class RawBoxTest {

    public static void main(String[] args) {
        Box rawBox = new Box();         // raw tipas
        rawBox.set("java");             // kompiliatorius: warning: unchecked invocation to set(T)
        Box<Integer> intBox = rawBox;   // keičiame į parametrizuotą tipą. 
                                        // kompiliatorius: warning: unchecked conversion
        intBox.get().intValue();        // gauname RuntimeException
    }
}
```
Parašius tokį kodą kompiliatorius perspėja, kad kompiliavimo metu negali nuspręsti tipo ir gali kilti problemų. Jei tokius perspėjimus ignoruojame, vykdymo metu gauname `RuntimeException` klaidą.
Norint ignoruoti ir paslėpti tokius kompiliatoriaus perspėjimus galime naudoti anotaciją `@SuppressWarnings("unchecked")`. Pavyzdys:
```java
public class RawBoxTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Box rawBox = new Box();        
        rawBox.set("java");  
        Box<Integer> intBox = rawBox;
        intBox.get().intValue();        // gauname RuntimeException
    }
}
```
Tačiau šiuo atveju tik paslepiamas perspėjimas, o vykdymo klaidos neišvengiama.
Todėl patariama nenaudoti `raw` tipų.

## *Generic* metodai
Java *generic* taip pat gali būti nadojami metodų tipams nurodyti. Sintaksė tokia pati kaip ir naudojant *generic* klasių tipams nurodyti, tačiau skirias tipo matomumo ribos - tipas matomas tik to metodo viduje.
### *Generic* metodo pavyzdys
Turime klasė `Pair` su `K` ir `V` tipų patametrais. 
```java
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}
```
Ir turime `Util` klasę, kurios metodas `compare(...)` yra `generic`.
```java
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}
```
Sukuriame du klasės `Pair` objektus.
```java
Pair<Integer, String> p1 = new Pair<>(1, "apple");
Pair<Integer, String> p2 = new Pair<>(2, "pear");
```
*Generic* metodo iškvietimo pavyzdys:
```java
boolean same = Util.<Integer, String>compare(p1, p2);
```
Šiu atveju tipų aprašyti dešinėje pusėje nėra būtina. Java kompiliatorius pats nuspręs kokie tai yra tipai. Todėl galime supaprastinti kodą:
```java
boolean same = Util.compare(p1, p2);
```

## *Bounded* (apriboto) tipo parametrai
Gali būti situacijų, kai norime apriboti tipą, kuris naudojamas kaip *generic* parametras.

Pavyzdys: norime turėti klasę su *generic* parametru, kuris yra skaičius. `Number` yra tokių klasių kaip `Integer`, `Double`, `Long` ir keletos kitų skaičių tipų superklasė.

```
                 +--------+
                 | Number |
                 +---+----+
                     ^
      +-----------------------------+----------+
      |              |              |          |
+-----+---+     +----+---+      +---+--+    +--+--+
| Integer |     | Double |      | Long |    | ... |
+---------+     +--------+      +------+    +-----+
```
Todėl klasėje `Calculator` galima nurodyti `T extends Number` taip pažymint, kad klasei tinka tik tokie tipai, kurie yra `Number` vaikai. Tai yra apriboto tipo parametrai.

```java
public class Calculator<T extends Number> {

    private T n;
    private T m;

    public Calculator(T n, T m)  {
        this.n = n;
        this.m = m;
    }

    public Number sum() {
        return n.doubleValue() + m.doubleValue();
    }
}
```
Kuriant `Calculator` klasės objektą konstruktoriui galime perduoti tik skaičius. Jei bandysime perduoti kitokio tipo objektus, pavyzdžiui eilutės `String` tipo, gausime kompiliavimo klaidą.
```java
Calculator calc = new Calculator(5, 8.9f);
calc.sum();
```
Apriboto tipo parametrus taip pat galima naudoti ir su *generic* metodais. Pavyzdys:
```java
public class Calculator {

    public <T extends Number> Number sum(T n, T m) {
        return n.doubleValue() + m.doubleValue();
    }
}
```
```java
Calculator calc = new Calculator();
calc.sum(5, 8.9f);
calc.sum("5", "8.9f"); // kompiliavimo klaida
```

## *Generic* ir paveldėjimas
Situacija: turime metodą `someMethod`, kuriam galime perduoti `Number` tipo objektą.
```java
public void someMethod(Number n) { /* ... */ }
```
Žinome, kad tokiam metodui galime perduoti ne tik `Number` tipo objektus, bet ir `Number` subklasių (vaikinių klasių) tipų objektus:
```java 
someMethod(new Integer(10));
someMethod(new Double(10.1));
```
Jei turime metodą `someGenericMethod`, kurio parametras yra *generic* tipo `Box<Number>`.
```java
public void someGenericMethod(Box<Number> n) { /* ... */ }
```
Tada tokiu atveju galime kviesti metodą perduodant `Box<Number>` tipo parametrą, tačiau negalima kviesti perduodant `Box<Integer>` tipo parametrą. Nors klasė `Number` yra klasės `Integer` superklasė, bet `Box<Number>` nėra `Box<Integer>` superklasė.

![](./img/generics-subtypeRelationship.gif)

Pavyzdys:
```java
public class Box<T> {
    private T object;

    public void set(T object) { this.object = object; }
    public T get() { return object; }
}
```
```java
public class BoxNumberTest {

    public static void boxTest(Box<Number> n) { /* ... */ }

    public static void main(String[] args) {
        Box<Number> boxNumber = new Box();
        Box<Integer> boxInteger = new Box();

        boxTest(boxNumber);
        boxTest(boxInteger);    // kompiliavimo klaida
    }
}
```
## *Generic* klasės ir potipiai

```java
public class Collection<E> { /* ... */}
```
```java
public class List<E> extends Collection<E> { /* ... */}
```
```java
public class ArrayList<E> extends List<E> { /* ... */}
```
```java
List<Integer> integerList = new ArrayList<>();
List<String> stringList = new ArrayList<>();
integerList = stringList; // kompiliavimo klaida: Incompatible types
```
Negalima `List<Integer>` tipo kintamajam `integerList` priskirti kintamojo `stringList`, kuris yra `List<String>` tipo, nes abu tipai priklauso skirtingoms klasių hierarchijoms.

```
+--------------------+          +---------------------+
| Collection<String> |          | Collection<Integer> |
+---------^----------+          +---------^-----------+
          |                               |
+---------+----------+          +---------+-----------+
| List<String>       |          | List<Integer>       |
+---------^----------+          +---------^-----------+
          |                               |
+---------+----------+          +---------+-----------+
| ArrayList<String>  |          | ArrayList<Integer>  |
+--------------------+          +---------------------+

```
## Pakaitos simboliai *(wildcards)*
### Viršutinio apribojimo pakaitos simboliai
*Generic* tipą galime apriboti iš viršaus naudojant tokią sintaksę `<? extends VirsutinisTipas>`.
Pavyzdys: norime turėti metodą, kuris priima `List` tipo parametrą su elementais, kurie yra bet kokie skaičiai `Numbers`. Užrašas `List<Numbers>` yra per daug griežtas, nes tokiu atveju negalėsime metodui perduoti `List<Integer>` sąrašo. Šiuo atveju naudojame iraišką `List<? extends Number>`.
```
                    +--------+
                    | Object |
                    +---^----+
                        |
+-------------------------------------------------+
|                       |                         |
|                   +---+----+                    |
|                   | Number |                    |
|                   +---^----+                    |
|                       |                         |
|        +--------------+----------------+        |
|        |                               |        |
|   +----+----+                     +----+---+    |
|   | Integer |                     | Double |    |
|   +---------+                     +--------+    |
|                                                 |
|                                                 |
|                                                 |
+-------------------------------------------------+
           Number with subclasses
```
```java
public static void printList(List<? extends Number> list) {
        for (Number n: list) {
            System.out.println(n.doubleValue());
        }
    }
```
```java
List<Integer> integerList = Arrays.asList(1, 5, 10);
List<Double> doubleList = Arrays.asList(1.5, 5.9, 10.2);
printList(integerList);
printList(doubleList);
```

### Apatinio apribojimo pakaitos simboliai
*Generic* tipą galime apriboti iš apačios naudojant tokią sintaksę `<? super ApatinisTipas>`. Panaudojimo pavyzdys:
```
+----------------------------------------+
|                                        |
|                           +--------+   |
|                           | Object |   |
|                           +---^----+   |
|                               |        |
|                               |        |
|                               |        |
|                           +---+----+   |
|                           | Number |   |
|                           +---^----+   |
|                               |        |
|                +--------------+----------------+
|                |                       |       |
|           +----+----+                  |  +----+---+
|           | Integer |                  |  | Double |
|           +---------+                  |  +--------+
|                                        |
+----------------------------------------+
      Integer with superclasses
```
```java
public static void addTenNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
```
```java
List<Integer> integerList = Arrays.asList(1, 5, 10);
List<Double> doubleList = Arrays.asList(1.5, 5.9, 10.2);
addTenNumbers(integerList);
addTenNumbers(doubleList);     // kompiliavimo klaida. 
                               // Double nėra Integer klasės superklasė
```
### Neribojantys pakaitos simboliai
Jei metodo logika nepriklauso nuo to, pavyzdžiui kokio tipo elementai bus metodui paduodame sąraše, tada galime naudoti `List<Object> list`, nes Object yra visų Java klasių superklasė;
```java
public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
    }
```
Bet tada galėsime metodui perduoti tik tokius sąrašus, kurių elementai yra `Object` tipo.
```java
List<Object> objectList = Arrays.asList(new Object(), new Object());
List<Integer> integerList = Arrays.asList(1, 5, 10);
List<Double> doubleList = Arrays.asList(1.5, 5.9, 10.2);
printList(objectList);      // OK
printList(integerList);     // kompiliavimo klaida
printList(doubleList);      // kompiliavimo klaida
```
Sprendimas yra naudoti neribojantį pakaitos simblį `<?>`
```java
public static void printList(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
    }
```
```java
printList(objectList);      // OK
printList(integerList);     // OK
printList(doubleList);      // OK
```

## Tolesniam skaitymui

- M Naftalin, P Wadler: *Java Generics and Collections*

[![][image]][hyperlink]

  [hyperlink]: https://www.amazon.co.uk/Java-Generics-Collections-M-Naftalin/dp/0596527756/ref=sr_1_1?ie=UTF8&qid=1547939492&sr=8-1&keywords=java+generics+and+collections
  [image]: ./img/java-generics-book.jpg

- Joshua Bloch: *Effective Java* (26-33 skyriai)

[![][image2]][hyperlink2]

  [hyperlink2]: https://www.amazon.co.uk/Effective-Java-Joshua-Bloch/dp/0134685997/ref=sr_1_1?ie=UTF8&qid=1547980931&sr=8-1&keywords=effective+java+3rd
  [image2]: ./img/effective-java.jpg 
  
- Venkat Subramaniam: *The Good, Bad, and Ugly of Java Generics*
https://www.youtube.com/watch?v=34oiEq9nD0M

## Šaltiniai
- https://docs.oracle.com/javase/tutorial/java/generics/index.html

## Užduotys
- [Užduotys](exercises/readme.md)