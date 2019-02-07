
## Užduotys: *Maven*

## Nr. 1

### Užduotis

1. Atsisiųskite [javafaker](https://search.maven.org/search?q=a:javafaker) biblioteką ir pridėkite ją į Intellij projektą nenaudojant Maven. 
2. Panaudokite `javafaker` https://github.com/DiUS/java-faker pvz. sugeneruokite 100 gatvių pavadinimų, 100 celsijaus laipsnio temperatūrų ir pan.
3. Sukurkite Maven projektą, įdėkite `javafaker` priklausomybę ir perkelkite klases iš ankstesio projekto, t.y. nerašykite kodo kviečiančio `javafaker` dar kartą.

## Nr. 2

### Užduotis

1. Sukurkite naują *Maven* projektą.
2. Į POM kaip priklausomybę įtraukite [lingua](https://github.com/pemistahl/lingua)
3. Sukurkite Java klasę
4. Java klasėje `main` metode sukurkite `LanguageDetector`
5. Leiskite vartotojui įvesti 10 žodžių ar sakinių
6. Vartotojui įvedus žodį ar sakinį iškart rodyti kokia kalba jis įvedė tekstą. Panaudoti `detector.detectLanguageOf(...)`

## Nr. 3

### Užduotis

Naudojant `commons-codec` biblioteką su Maven padarykite konsolinį login.

Pvz.: vartotojui rodome meniu: [1] registruotis; [2] prisijungti
Tada pasirinkus [1] bus prašoma įvesti vartotojo vardą, vėliau - sugalvotą slaptažodį, ir dar poto - tą slaptažodį įvesti dar kartą.
Po šių veiksmų vartotojo vardas ir užšifruotas slaptažodis išsaugomi į Map.
Kai vartotojas pasirinks [2], tada programa turi paprašyti įvesti vartotojo vardą ir slaptažodį. Slaptažodį tikrinti su jau įvestu ir išsaugotu Map'e. Atspausdinti informaciją - pavyko prisijungti ar ne

Naudoti naujausią `commons-codec` versiją:
```xml
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
</dependency>
```

Šifravimas:
```java
String sha256hex = DigestUtils.sha256Hex("tekstas");
```