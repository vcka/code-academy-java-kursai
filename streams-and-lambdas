# *Lambda* išraiškos bei Java 8 srautai
### *Higher-order* funkcijos
Matematikoje ir kompiuterių moksle, funkcija vadinama *higher-order* funkcija jei ji tenkina bent vieną iš šių sąlygų:
- Priima vieną ar daugiau funkcijų kaip parametrą
- Grąžina funkciją kaip rezultatą

Įsivaizduokite funkciją *sort*, kuri kaip parametrus priima du argumentus – elementų sąrašą ir funkciją, palyginančią, kuris iš sąrašo elementų didesnis, o funkcijos grąžinamas rezultatas – naujas elementų sąrašas, išrūšiuotas naudojant pateiktą funkciją.

> `sort(elements : List<T>, comparator : (t1 : T, t2 : T) -> int) -> List<T> `

Tokia funkcija išrūšiuoja nurodytą sąrašą, keliaudama per visus jo elementus ir lygindama juos vienas su kitu, naudodama nurodytą palyginimo funkciją. Rūšiavimo funkcija yra *higher-order* funkcija.

Programavime dažnai reikalinga nurodyti tam tikrą veiksmų seką, tačiau tuos veiksmus įgyvendinti reikia vėliau. Tokiose situacijose, pavyzdžiui, rūšiuojant sąrašo elementus, yra naudojamos *higher-order* funkcijos. 

Kitose kalbose, pavyzdžiui *Scala* arba *Javascript*, metodai yra tokie pat lygiaverčiai nariai kaip ir klasės arba duomenų tipai. Tai reiškia, kad metodai gali būti priskirti kintamiesiems arba grąžinami kaip metodų rezultatai. Java programavimo kalba tokia savybe nepasižymi. Norint paduoti funkciją kaip metodo parametrą, Java kalboje naudojamos sąsajos, turinčios vieną reikalingą metodą. Tokios sąsajos vadinamos funkcinėmis sąsajomis (*functional interface*). 

Kiekvieną kartą įgyvendinti funkcinę sąsają užima daug laiko, todėl 8 Java programavimo kalbos versija pridėjo *lambda* išraiškas, palengvinančias darbą su funkcinėmis sąsajomis.  

### *Lambda* išraiškos 
*Lambda* išraiškos tai funkcijos, kurios gali būti sukurtos nepriskiriant jų jokiai klasei. *Lambda* išraiškos įgyvendina funkcinių sąsajų metodus ir gali būti paduodamos kaip objektai, ten, kur reikia funkcinių sąsajų.  

#### *Lambda* išraiškų sintaksė
*Lambda* išraiškos sintaksę sudaro **argumentų sąrašas**, **rodyklė** ir **metodo korpusas**:

```java
() -> 10
```  
nepriima argumentų ir grąžina *int* tipo argumentą. Funkcijos atitikmuo būtų `int getNum()`. Jei metodo korpusas yra iš vienos eilutės, figūriniai skliaustai bei *return* raktažodis nėra būtinas.

```java  
(int x) -> x * x
``` 
Priima *int* tipo  argumentą ir grąžina *int* tipo argumentą. Funkcijos atitikmuo būtų `int square(int x)`. 

```java
x -> x * x
```
Tokia pati išraiška kaip ir ankstesniame pavyzdyje. *Lambda* išraiškose skliaustai bei argumento tipas nėra būtini: kai jis nenurodytas, kompiliatorius tipą nuspėja automatiškai,. 
```java
(x, y) -> x + y
```
Priima du *int* tipo argumentus ir grąžina jų sumą kaip *int* reikšmę. Funkcijos atitikmuo būtų `int sum(int x, int y)`. Kai *lambda* išraiška priima daugiau nei vieną parametrą, skliaustai yra būtini.
```java
(x, y) -> {
    return x + y;
}
```
Tokia pati išraiška kaip ir ankstesnė, tačiau jei metodo korpusas yra ilgesnis nei vienos eilutės, figūriniai skliaustai yra būtini. Esant figūriniams skliaustams, jei išraiška grąžina reikšmę, *return* raktažodis turi būti nurodytas specifiškai. 

*Lambda* išraiškos gali būti priskirtos kintamiesiems, paduodamos kaip funkcijos argumentai arba grąžinamos kaip funkcijų rezultatai.
Pavyzdžiui funkcinė sąsaja
```
interface IntComparator{
   int compare(int x, int y);
} 
``` 
galėtų būti įgyvendinta naudojant *lambda* išraišką. Pavyzdžiui:
```
IntComparator comparator = (x, y) -> x – y;
```
arba
```
public IntComparator reversedComparator() {
   return (x, y) -> y – x;
}
```
#### Paketas *java.util.function*

Java teikia didelį standartinių funkcinių sąsajų rinkinį *java.util.function* pakete. Prieš aprašant naują funkcinę sąsają, reikėtų pasitikrinti ar standartinių sąsajų pakete nėra tinkamos sąsajos.

Standartinės funkcinės sąsajos yra suskirstytos į 4 grupes:
- *Consumers* - priima argumentą ir nieko negrąžina (*Consumer, BiConsumer, IntConsumer, ...*)
- *Suppliers* - nepriima jokių argumentų, bet grąžina reikšmę (*Supplier, IntSupplier, ...*)
- *Predicates* - priima argumentą ir grąžina *boolean* tipo reikšmę (*Predicate, BiPredicate, LongSupplier, ...)
- *Functions* - priima argumentą ir grąžina reikšmę (*Function, BiFunction, UnaryOperator*)

#### Metodų nuorodos
Jei metodo parašas atitinka funkcinėje sąsajoje aprašyto metodo parašą, nuoroda į tą metodą gali būti paduota vietoj *lambda* išraiškos.
```java
public class Math {

    public static double multiply(double a, double b) {
        return a * b;
    }

}
```
Aukščiau aprašytos klasės metodas * multiply *, priimantis du *double* tipo parametrus ir grąžinantis jų sandaugą kaip *double* rezultatą, gali būti naudojamas vietoj *lambda* išraiškos, ten kur reikalinga funkcinė sąsaja, su metodu, priimančiu dvi *double* reikšmes ir grąžinančiu *double* tipo rezultatą.
  
```java
BiFunction<Double, Double, Double> f;
f = (val1, val2) -> val1 * val2;
f = Math::multiply;	
```

### Srautai
Srautas -  klasė, palaikanti funkcinio tipo operacijas, paremtas funkcinėmis sąsajomis, leidžiančias transformuoti kolekcijas. 

Pavyzdžiui:
```java
     int totalSalary = people.stream()
                      .filter(person -> person.isEmployed())
                      .mapToInt(person -> person.getSalary())
                      .sum();
 ```
Šis kodas naudoja žmonių kolekciją kaip šaltinį srautui. Srautas filtruojamas ir pašalinami nedirbantys asmenys, tada srautas transformuojamas iš asmenų srauto į asmenų atlyginimo srautą ir srauto elementai yra sudedami. 


Srauto metodai suskirstyti į dvi grupes - *intermediate* ir *terminal*. Kartu šie tipai formuoja srauto grandines (*pipelines*). Grandinę sudaro šaltinis (pavyzdžiui kolekcija arba masyvas), nulis arba daugiau *intermediate* operacijų, tokių kaip *filter* arba *map*, keičiančių srauto turinį ir *terminal* operacija, pavyzdžiui *reduce* arba *collect*. 


*Intermediate* metodai aprašo taisykles srauto elementų manipuliavimui ir kaip rezultatą gražina naują srautą. Jie yra tingūs (*lazy*) – pavyzdžiui iškvietus operaciją *filter*, filtravimas iškarto nevyksta, tiesiog apibrėžiama taisyklė, kuri, prasidėjus keliavimui per šaltinio elementus, pašalins sąlygos netenkinančius elementus.  


*Terminal* metodai pradeda šaltinio elementų ėjimą per srauto grandinę vykdant *intermediate* operacijas, manipuliuojančias srauto turiniu. *Terminal* operatoriai grąžina rezultatą. Srautas įvykdžius *terminal* operatorių, laikomas panaudotu. Norint iš naujo pereiti per šaltinio elementus, reikia sukurti naują srautą.


Srauto ir kolekcijų skirtumai:
-	Srautas nesaugo duomenų. Srautas tik apdoroja duomenis iš šaltinių, tokių kaip kolekcijos, masyvai ar I/O kanalai, per įvairias skaičiavimo, transformavimo operacijas
-	Srautas laikosi funkcinio programavimo ideologijos. Kiekviena srauto operacija grąžina rezultatą, tačiau nemodifikuoja originalaus šaltinio
-	Srautas yra tingus (*lazy*). *Intermediate* operacijos nebus vykdomos tol, kol nebus iškviestas *terminal* metodas
-	Srautas neturi apibrėžto ilgio, ir gali būti begalinis
-	Srautas yra suvartojamas (*consumable*) - srauto elementai yra aplankomi tik vieną kartą ir norint antrą kartą pereiti per šaltinio elementus, turi būti sugeneruotas naujas srautas.

Srautai gali būti sukurti keliais būdais, pavyzdžiui:
-	Iš *Collection* objekto per metodą *stream()* 
-	Iš *Arrays* klasės metodo *stream(Object[])*
-	Iš *static factory* metodų kaip *Stream.of(Object[])* 
-	Iš *BuffererdReader* objekto metodo *lines()*

#### Pagrindinės *intermediate* operacijos
-	**Filter** – priima *Predicate* sąsają ir filtruoja jos netenkinančius elementus
-	**Map** – priima  *Function* sąsają ir transformuoja srauto elementus
-	**FlatMap** – priima *Function* sąsają, kuri iš kiekvieno elemento sukuria naują srautą ir sujungia juos į vieną bendrą srautą

#### Pagrindinės *terminal* operacijos
-	**Collect** - surenka srauto elementus į nurodytą kolekcijos tipą
-	**Reduce** priima *BiFunction* sąsają, kurios dėka sumažina srautą iki vieno elemento
-	**Min** - grąžina mažiausią srauto elementą
-	**Max** - grąžina didžiausią srauto elementą
### Užduotys
- [Šaltinių užduotis](exercises/stream-exercise.md)

### Šaltiniai
-	Effective Java 3rd edition
-	https://docs.oracle.com/javase/8/docs/
