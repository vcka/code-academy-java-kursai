
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
Tada pasirinkus [1] bus prašoma įvesti vartotojo vardą, vėliau - sugalvotą slaptažodį, ir dar po to - tą slaptažodį įvesti dar kartą.
Po šių veiksmų vartotojo vardas ir užšifruotas slaptažodis išsaugomi į Map.
Kai vartotojas pasirinks [2], tada programa turi paprašyti įvesti vartotojo vardą ir slaptažodį. Slaptažodį tikrinti su jau įvestu ir išsaugotu Map'e. Atspausdinti informaciją - pavyko prisijungti ar ne

Naudoti naujausią `commons-codec` versiją:
```xml
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
</dependency>
```

Užšifravimas:
```java
String sha256hex = DigestUtils.sha256Hex("tekstas");
```

## Nr. 4

### Užduotis

Sukurkite Maven projektą su tėviniu POM ir moduliu, kuriame yra vaikinis POM.
Remiantis teorijos medžiaga pabandykite `javafaker` įdėti į tėvinio POM `dependencyManagement`, vėliau be `dependencyManagement`.
Sukurkite Java klasę vaikiniame modulyje ir panaudokite `Faker` funkcijas, pvz. sugeneruokite vardą.
`javafaker` iškelti į POM `properties`.

## Nr. 5

### Užduotis

1. Užsiregistruokite [Twilio](https://www.twilio.com)
2. Susikonfigūruokte Twilio SMS (trial): https://www.twilio.com/console/sms/getting-started/build
3. Sukurkite Maven prijektą ir prodėkite Twilio priklausomybę: https://www.twilio.com/docs/libraries/java
4. Sukurkite Java programą, kuri moka išsiųsti SMS. Pavyzdys, kaip naudojant Twilio iš Java programos išsiųsti SMS: https://www.twilio.com/docs/sms/quickstart/java. `ACCOUNT SID` ir `AUTH TOKEN` rasite pagrindiniame Twilio puslapyje: https://www.twilio.com/console


## Nr. 6

### Užduotis

1. Sukurti naują Maven projektą. Pavadinkite pvz. `Bankas`.
2. Sukurti klasę `Asmuo`, kuri turi `id` (ir statinį skaitliuką, kurio reikšmė priskiriama `id` klasės kintamajam). Klasės kintamajam `id` reikšmė priskiriama tik vieną kartą. Klasė `Asmuo` taip pat turi vardą ir pavardę.
3. Sukurti klasę `BankoSaskaita`, kuri turi sugeneruotą sąskaitos numerį (apie generavimą bus kitame punkte), likutį, valiutą (gali būti Enum reikšmė) ir sąskaitos valdytoją - klasės `Asmuo` objektą. Banko sąskaitos numeris taip pat turi būti priskiriamas tik vieną kartą.
4. Klasė `BankoSaskaita` turi turėti konstruktorių, kuriam galima paduoti pradinį likutį, valiutą ir asmenį, kurio tai sąskaita.
5. Klasė `BankoSaskaita` turi turėti metodus `gautiLikuti()`, kuris grąžina sąskaitos likutį, `ideti(...)`, kuriam paduosime norimą įdėti į sąskaitą pinigų sumą, `nuskaiciuoti(...)`, kuriam paduosime pinigų sumą norimą nuskaičiuoti nuo sąskaitos (būtina patikrinti ar pakanka pinigų).
6. `BankoSaskaita` klasės kintamojo "saskaitos numeris" reikšmė turi būti generuojama. Tam galime panaudoti papildomą biblioteką, kurios `groupId` yra `org.apache.commons`, o `artifactId` yra `commons-lang3`. Tada generavimui galėsite naudoti pvz. `"LT" + RandomStringUtils.randomNumeric(18);`. Plačiau apie Commons Lang [čia](https://commons.apache.org/proper/commons-lang/index.html).
7. Sukurkite klasę `Bankas`, kuri turės klasės kintamąjį - sąrašą banko sąskaitų.
8. Klasėje `Bankas` sukurti metodą `sukurtiBankoSaskaita(...)`. Metodas priima per parametrus asmens objektą ir valiutą. Sukuria naują banko sąskaitą ir įdeda ją į banko sąskaitų sąrašą.
9. Klasėje `Bankas` sukurti metodą `gautiAsmensSaskaitosLikuti(...)`, kuriam padavus asmens objektą grąžins jo turimos sąskaitos likutį.
10. Klasėje `Bankas` sukurti metodą `pervestiPinigus(...)`, kuriam padavus asmens siuntėjo ir asmens gavėjo objektus, taip pat pervedamą sumą ir valiutą, bus įvykdytas pinigų pervedimas.
11. Klasėje `Bankas` sukurti metodą `inestiPiniguISaskaita(...)`, kur padavus asmens, į kurio sąskaitą įdedami pinigai ir sumą, ją įdės į banko sąskaitą.
12. Klasėje `Bankas` sukurti metodą `spausdintiSaskaituDuomenis()`, kuris atspausdins informaciją apie visas banko sąskaitas - numeriai, savininkai, likučiai ir t.t.
13. Šiame projekte nenaudoti nei vieno `System.out.println()`. Vietoje jo naudoti `log4j` biblioteką. Tam reikės dviejų priklausomybių. Abiejų `groupId` yra `org.apache.logging.log4j`. Pirmosios `artefactId` yra `log4j-api`, antrosios - `log4j-core`. Plačiau apie Log4j konfigūraciją [čia](https://logging.apache.org/log4j/2.x/manual/configuration.html), tačiau šiame uždavinyje reikiama konfigūracija yra tokia:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="WARN">

        <Appenders>
            <Console name="Console" target="SYSTEM_OUT">
                <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
            </Console>
            <File name="File" fileName="Application.log">
                <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
            </File>
        </Appenders>

        <Loggers>
            <Root level="info">
                <AppenderRef ref="Console"/>
                <AppenderRef ref="File"/>
            </Root>
        </Loggers>

    </Configuration>
    ```
    Šią konfigųraciją išsaugoti į loginimo konfigūracijos failą.
    Reikia sukurti loginimo konfigūracijos failą pavadinimu `log4j2.xml` ir jį išsaugoti į `../src/main/resources/`.

    Loginimo pavyzdys:
    ```java
    public class KlasėX {
        private static final Logger LOG = LogManager.getLogger(KlasėX.class);

        public String metodasX(int numeris) {
            // ...
            LOG.info("Kvieciamas metodasX. Ieskoma informacijos pagal numerį {}", numeris);
            // ...
        }
    }
    ```
    Panaudoti šį loginimo mechanizmą klasėse `Bankas` ir `BankoSaskaita`. Tai yra bankas, todėl kiekvienas atliktas veiksmas turi būti registruojamas į žurnalą (loginamas).
14. Atskiroje klasėje su `main` metodu sukurkite banką, taip pat keletą banko vartotojų. Pabandykite įdėti pinigų, pervesti pinigus iš vienos sąskaitos į kitą. Pabandykite ir blogus scenarijus, pvz. bandome pervesti pinigus asmeniui, kuris neturi banko sąskaitos.

    <details><summary>Pavyzdys</summary>
    <p>

    Įvykdžius tokias komandas:

    ```java
    public static void main(String[] args) throws NerastaSaskaitaException, NepakankamasLikutisException {

        Bankas bankas = new Bankas();

        Asmuo petras = new Asmuo("Petras", "Petraitis");
        Asmuo antanas = new Asmuo("Antanas", "Antanaitis");
        Asmuo jonas = new Asmuo("Jonas", "Jonaitis");

        bankas.sukurtiBankoSaskaita(petras, Valiuta.EUR);
        bankas.sukurtiBankoSaskaita(antanas, Valiuta.EUR);

        bankas.inestiPiniguISaskaita(petras, 100);
        bankas.inestiPiniguISaskaita(petras, 50);

        bankas.inestiPiniguISaskaita(antanas, 200);

        bankas.spausdintiSaskaituDuomenis();

        bankas.pervestiPinigus(petras, antanas, 30, Valiuta.EUR);

        bankas.spausdintiSaskaituDuomenis();

        bankas.pervestiPinigus(petras, jonas, 200, Valiuta.EUR);

        bankas.spausdintiSaskaituDuomenis();

        bankas.pervestiPinigus(antanas, petras, 500, Valiuta.EUR);

        bankas.spausdintiSaskaituDuomenis();
    }
    ```
    Turite gauti panašų įvykių žurnalą:
    ```
    17:36:25.849 [main] INFO  lt.codeacademy.Bankas - Sukurta banko saskaita nr. LT608499837728052615 asmeniui Petras Petraitis
    17:36:25.854 [main] INFO  lt.codeacademy.Bankas - Sukurta banko saskaita nr. LT774394194098144407 asmeniui Antanas Antanaitis
    17:36:25.854 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Petras Petraitis banko saskaitos
    17:36:25.929 [main] INFO  lt.codeacademy.BankoSaskaita - I saskaita LT608499837728052615 ideta 100.0EUR
    17:36:25.929 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Petras Petraitis banko saskaitos
    17:36:25.929 [main] INFO  lt.codeacademy.BankoSaskaita - I saskaita LT608499837728052615 ideta 50.0EUR
    17:36:25.929 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Antanas Antanaitis banko saskaitos
    17:36:25.929 [main] INFO  lt.codeacademy.BankoSaskaita - I saskaita LT774394194098144407 ideta 200.0EUR
    17:36:25.930 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.931 [main] INFO  lt.codeacademy.Bankas -          SASKAITU DUOMENYS         
    17:36:25.932 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.932 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT608499837728052615
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Vardas:       Petras
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Petraitis
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Likutis:      150.0
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT774394194098144407
    17:36:25.933 [main] INFO  lt.codeacademy.Bankas - Vardas:       Antanas
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Antanaitis
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Likutis:      200.0
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Asmuo Petras Petraitis siuncia 30.0EUR asmeniui Antanas Antanaitis
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Petras Petraitis banko saskaitos
    17:36:25.934 [main] INFO  lt.codeacademy.Bankas - Rasta siuntejo banko saskaita nr. LT608499837728052615
    17:36:25.935 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Antanas Antanaitis banko saskaitos
    17:36:25.935 [main] INFO  lt.codeacademy.Bankas - Rasta gavejo banko saskaita nr. LT774394194098144407
    17:36:25.935 [main] INFO  lt.codeacademy.BankoSaskaita - Nuo saskaitos LT608499837728052615 nuskaiciuojama suma: 30.0EUR
    17:36:25.935 [main] INFO  lt.codeacademy.BankoSaskaita - I saskaita LT774394194098144407 ideta 30.0EUR
    17:36:25.935 [main] INFO  lt.codeacademy.Bankas - 30.0EUR pervesti is saskaitos LT608499837728052615 PETRAS PETRAITIS i saskaita LT774394194098144407 ANTANAS ANTANAITIS
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas -          SASKAITU DUOMENYS         
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT608499837728052615
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - Vardas:       Petras
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Petraitis
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.936 [main] INFO  lt.codeacademy.Bankas - Likutis:      120.0
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT774394194098144407
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Vardas:       Antanas
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Antanaitis
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Likutis:      230.0
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.937 [main] INFO  lt.codeacademy.Bankas - Asmuo Petras Petraitis siuncia 200.0EUR asmeniui Jonas Jonaitis
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Petras Petraitis banko saskaitos
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas - Rasta siuntejo banko saskaita nr. LT608499837728052615
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Jonas Jonaitis banko saskaitos
    17:36:25.938 [main] ERROR lt.codeacademy.Bankas - Nerasta banko sakaita!
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas -          SASKAITU DUOMENYS         
    17:36:25.938 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT608499837728052615
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Vardas:       Petras
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Petraitis
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Likutis:      120.0
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT774394194098144407
    17:36:25.939 [main] INFO  lt.codeacademy.Bankas - Vardas:       Antanas
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Antanaitis
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - Likutis:      230.0
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - Asmuo Antanas Antanaitis siuncia 500.0EUR asmeniui Petras Petraitis
    17:36:25.940 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Antanas Antanaitis banko saskaitos
    17:36:25.941 [main] INFO  lt.codeacademy.Bankas - Rasta siuntejo banko saskaita nr. LT774394194098144407
    17:36:25.941 [main] INFO  lt.codeacademy.Bankas - Ieskoma asmens Petras Petraitis banko saskaitos
    17:36:25.941 [main] INFO  lt.codeacademy.Bankas - Rasta gavejo banko saskaita nr. LT608499837728052615
    17:36:25.941 [main] INFO  lt.codeacademy.BankoSaskaita - Nuo saskaitos LT774394194098144407 nuskaiciuojama suma: 500.0EUR
    17:36:25.941 [main] ERROR lt.codeacademy.BankoSaskaita - Saskaitoje LT774394194098144407 nepakanka pinigu
    17:36:25.941 [main] ERROR lt.codeacademy.Bankas - Nepakankamas likutis saskaitoje!
    17:36:25.941 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    17:36:25.941 [main] INFO  lt.codeacademy.Bankas -          SASKAITU DUOMENYS         
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT608499837728052615
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - Vardas:       Petras
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Petraitis
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - Likutis:      120.0
    17:36:25.942 [main] INFO  lt.codeacademy.Bankas - 
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - Sakaitos nr.: LT774394194098144407
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - Vardas:       Antanas
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - Pavarde:      Antanaitis
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - Valiuta:      EUR
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - Likutis:      230.0
    17:36:25.943 [main] INFO  lt.codeacademy.Bankas - -----------------------------------
    ```
    </p>
    </details>