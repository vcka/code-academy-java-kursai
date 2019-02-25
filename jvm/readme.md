# Java virtuali mašina

Java virtuali mašina (trumpiau JVM) - kompiuterinė aplinka, leidžianti vykdyti sukompiliuotas Java programas, vadinamas *bytecode*. Java virtuali mašina yra apibrėžtą specifikacija kuri aprašo kaip ji turėtų veikti. Teisingai įgyventinus specifikaciją galima sukurti savo JVM kuri galėtų vykdyti sukompiliuotą Java baitų kodą. Yra daug skirtingų JVM įgyvendinimų – iš skirtingų tiekėjų, įvairioms platformoms. 

Geras JVM supratimas padeda geriau išmanyti pačios Java veikimą.

Vienas iš svarbių Java privalumų – gebėjimas veikti įvairiose platformose. Ji kurta remiantis idėja ‘‘Parašyti kartą, leisti bet kur“. Skirtingai nei kitos kalbos, Java šaltinio kodas pirmiausia sukompiliuojamas į *bytecode* - *.class* failą, kurį ir interpretuoja JVM.

### Architektūra

Java virtualią mašiną sudaro trys pagrindinės dalys:
- **Class loader subsystem** - klasių užkrovimo posistemė
- **Runtime data area** - vykdymo sritis
- **Execution engine** - vykdymo variklis 


Diagrama iš [javatutorial.net](https://javatutorial.net/jvm-explained) vaizduojanti JVM architektūrą

![JVM architektūra](https://javatutorial.net/wp-content/uploads/2017/10/jvm-architecture.png)


#### Klasių užkrovimo posistemė (Class loader subsystem)

Kaip jau minėta, sukompiliuotos klasės saugomos kaip *.class* failai. Naudojantis *class* failu, *classLoader* užkrauna  reikalingą klasę į atmintį. Klasės įvedamos į Java aplinką, kai jas iškviečia jau vykstanti klasė. Jau veikiant pirmajai klasei, kitų klasių užkrovimą vykdo *classLoader*. Pirmoji klasė dažniausiai paleidžiama naudojant * static main()* metodą.

Yra trys *ClassLoader* rūšys:
-	Bootstrap Class Loader – užrauna vidines JDK klases, tokias kaip klases esančias `java.lang.*` pakete
-	Extensions Class Loader – užkrauna papildomas JDK klases paprastai iš  JRE `lib/ext` direktorijos
-	System Class Loader – užkrauna klases iš *classpath*

##### Susiejimas
Jungiant klases ar sąsajas vyksta reikalingų klasių ar sąsajų, jų tiesioginių superklasių, supersąsajų, elementų tipų patvirtinimas ir paruošimas.
JVM reikalauja, kad būtų laikomasi šių savybių:
- Klasė ar sąsaja prieš siejant turi būti visiškai užkrauta
- Klasė ar sąsaja turi būti pilnai patvirtinta ir paruošta prieš inicializavimą
- Klaidos, aptiktos siejant, grąžinamos toje programos vietoje, kurioje tiesiogiai ar netiesiogiai gali būti reikalingas siejimas tai klasei ar sąsajai

##### Inicializavimas 
Klasės ar sąsajos inicializavimas yra klasės objekto sukūrimas  atmintyje. Inicializavimas sudarytas iš klasės ar sąsajos inicializavimo metodo, kitaip klasės konstruktoriaus, iškvietimo.
Dėl JVM *multithreadingo* klasės ar sąsajos inicializavimas turi būti kruopščiai sinchronizuotas. Priešingu atveju skirtingos gijos gali mėginti inicializuoti klasę tuo pat metu.

### Vykdymo duomenų sritis (Runtime data area)
Vykdymo sritį sudaro penki pagrindiniai komponentai:

- Metodo sritis (Method area) - šioje srityje saugomi visi klasių lygio duomenys ir statiniai kintamieji. JVM yra tik viena, bendra metodo sritis
- Grupės sritis (Heap area) - šioje srityje saugomi visi objektai, masyvai ir jų atitinkami kintamieji. JVM turi tik vieną grupės sritį. Kadangi *method* ir*heap* sritys yra bendros tarp skirtingų gijų, saugomi duomenys nėra *thread safe* 
- Steko sritis (Stack area)
Kiekvienai gijai yra sukuriamas atskiras vykdomasis stekas. Kiekvienam kviečiamam metodui sukuriamas atskiras įrašas steko atmintyje, vadinamas *Stack Frame*. Steko atmintyje kuriami visi lokalūs metodo kintamieji. Ši dalis yra *thread safe* nes ja nėra dalijamasi tarp skirtingų gijų. *Stack Frame* skirstoma į tris dalis:
  - Lokalių kintamųjų masyvas – lokalus metodo kintamieji yra saugomi šiame masyve 
  - Operandų stekas – naudojamas tarpinėms (skaičiavimo) operacijoms. Operandų stekas veikia kaip vykdymo vieta kurioje atliekamos operacijos
  - Frame data – naudojama pasiekti konstantas bei metode įvykusius *exception*
- Registrai (PC Registers)
Kiekvienas gija turi atskirus registrus, saugančius tuo metu vykstančios operacijos adresą. Įvykdžius operaciją, į registrą pakraunamas naujos operacijos adresas.

- Native Method stacks
Laiko informaciją apie gijos naudojamus *native* metodus

### Vykdymo variklis (Execution engine)
Vykdymo duomenų sričiai priskirtas *bytecode* bus vykdomas atlikimo variklio, kuris iš eilės skaito ir vykdo gautą kodą.

#### Interpretatorius
Interpretatorius interpretuoja baitų kodą ir pateikią jį vykdyti kompiuteriui kaip mašinį *native* kodą . Interpretatorius *bytecode* interpretuoja greitai, tačiau jo vykdymas yra gan lėtas. Interpretatoriaus trūkumas – kviečiant tą patį metodą kelis kartus, interpretavimas kaskart bus kartojamas.

#### JIT kompiliatorius
JIT kompiliatorius neutralizuoja interpretatoriaus minusus. Konvertuojant *bytecode*  atlikimo variklis naudoja interpretatorių, tačiau aptikus pasikartojantį kodą, pasitelkiamas JIT kompiliatorius. Tokiu atveju sukompiliuojamas visas *bytecode*  ir pakeičiamas į  *native code*. Native code naudojamas pasikartojantiems metodo iškvietimams, taip pagreitinant vykdymą.
#### Garbage collector 
The Garbage collector (GC) surenka ir pašalina nenaudojamus objektus – atmintyje sukurtus objektus į kuriuos nėra jokių nuorodų. Garbage Collection gali būti įjungiama iškviečiant `System.gc()`, tačiau tai negarantuoja paleidimo.

#### Java Native Interface (JNI)
Sąsaja skirta bendrauti su *Native method libraries*, norint vykdyti *native* metodus 

#### Native Method Libraries
Kolekcija *native* bibliotekų reikalingų vykdymo varikliui

### Šaltiniai
-	https://javatutorial.net/jvm-explained
-	https://docs.oracle.com/javase/specs/jvms/se8/html/index.html
