# Sąsajos ir paveldėjimai
### Paveldėjimai
Paveldėjimas labai svarbi Java kalbos dalis. Java kalboje klasės gali būti kilusios iš kitų klasių, taip paveldint jų laukus ir metodus. Klasė, kilusi iš kitos klasės, yra vadinama *sub* klase arba vaikine klase. Klasė, iš kurios kyla kitos klasės, vadinama *super* klase arba tėvine klase. Java klasės gali turėti tik vieną *super* klasę. Jei klasė neturi nurodytos *super* klasės, ji paveldi klasę `Object` pagal nutylėjimą.

Vaikinė klasė paveldi narius (laukus, metodus, vidines klases) iš tėvinės klasės. Vaikinės klasės konstruktoriai privalo kviesti *super* klasės konstruktorių, nes jie nėra paveldimi. Kiekvieno konstruktoriaus pirma eilutė turi kviesti tėvinės klasės konstruktorių. Tačiau, jei kviečiamas standartinis, parametrų neturintis, konstruktorius (super();), to daryti nebutina, tai įvyks automatiškai kompiliavimo metu.   

Dėl savybės perduoti narius vaikinei klasei, paveldimumas taikomas siekiant naudoti laukus arba metodus, egzistuojančius kitose klasėse, neperrašant jų pačiam.
Vaikinės klasės paveldi visus *public* ir *protected* tėvinės klasės narius. Taip pat, jei vaikinė klasė yra tame pačiame kataloge (package) kaip ir tėvinė klasė, ji paveldi visus *package-private* narius. Paveldėti laukai, metodai, vidinės klasės gali būti pasiekiami tiesiogiai vaikinėje klasėje, taip pat kaip įprasti tos klasės nariai.

Vaikinės klasės gali turėti naują, tik joms būdingą funkcionalumą, tačiau jos taip pat turi tėvinės klasės savybes. Tai reiškia, kad vaikinė klasė gali būti panaudota ten, kur reikalinga jos tėvinė klasė. Pavyzdžiui, klasė `TemperatureSensor` kuri paveldi klasę `Sensor` gali būti priskirta `TemperatureSensor`, `Sensor`, `Object` tipo kintamiesiems. 
Visų šių teiginių sintaksė yra teisinga:
```java
TemperatureSensor temperatureSensor = new TemperatureSensor();
Sensor sensor = temperatureSensor;
Object object = temperatureSensor; 
```
Klasės tipo keitimas į jos tėvinių objektų tipą vadinamas *upcast‘inimu*. *Upcast‘inus* objektą į tėvinės klasės tipą, vaikinei klasei būdingi metodai tampa nematomi. *Upcast‘inimas* vyksta automatiškai.  

Tėvinius objektus galima *cast‘inti* į vaikinės klasės tipus, tai vadinama *downcasting*. *Downcast‘inimas* nevyksta automatiškai, tam reikia specifiškai nurodyti *cast‘inimo* operatorių:
```java
TemperatureSensor temperatureSensor = new TemperatureSensor();
Sensor sensor = temperatureSensor;
TemperatureSensor otherTemperatureSensor = (TemperatureSensor) sensor;
```
Paprastai *Downcast’inimas* - tiesiog nurodymas kompiliatoriui, kad tu žinai, koks iš tiesų yra objekto tipas veikimo (runtime) metu. 
*Downcast‘inti* objektus reikėtų atsargiai, nes „neatspėjus“ objekto tipo programa pateikia `ClassCastException`.
```java
Sensor sensor = new HumiditySensor();
TemperatureSensor incorrectSensor = (TemperatureSensor) sensor; // pateikiamas ClassCastException
```
Išvengti `ClassCastException` padeda operatorius `instanceOf`, naudojamas nusakyti objekto tipui:
```java
Sensor sensor = new HumiditySensor()
System.out.println(sensor instanceof HumiditySensor);
System.out.println(sensor instanceof TemperatureSensor);
```
Tokio kodo rezultatas būtų
``` 
true
false
```
Java leidžia *downcast‘inti* objektus tik į tokius tipus, kurie paveldi tėvinę klasę. 
Kodas pavyzdyje nesikompiliuoja, nes klasė `Sensor` nėra klasės `String` vaikinė klasė:
```java
String text = “simple text”;  
Sensor sensor = (Sensor) text; // Inconvertible types; cannot cast 'java.lang.String' to 'Sensor'
```

Vaikinės klasės gali perrašyti ne *final* tėvinės klasės metodus. Tai leidžia pritaikyti klasės veikimą pagal savo poreikius. Situacija, kai objekto tipas nulemia metodo veikimą, vadinama polimorfizmu.
Metodų perrašymo pavyzdys: 
```java
    public abstract class Sensor {
        public abstract String purpose();
    }
    public class TemperatureSensor extends Sensor {
        @Override
        public String purpose() {
            return "measures temperature";
        }
    }
    public class HumiditySensor extends Sensor {
        @Override
        public String purpose() {
            return "measures humidity";
        }
    }
    
    public static void main(String[] args) {
        Sensor temperatureSensor = new TemperatureSensor();
        Sensor humiditySensor = new HumiditySensor();
        System.out.println(temperatureSensor.purpose());
        System.out.println(humiditySensor.purpose());
    }
```
Kiekviena `Sensor` *sub* klasė išspausdins savo paskirtį:
```
measures temperature
measures humidity
``` 
Metodų perrašymas ypatingas tuo, kad visada kviečiamas perrašytas metodas - net *upcastinus* klasės tipą į tėvinį, bus kviečiamas ne tėvinis metodas, o perrašyta metodo versija.
```java
    public class HumiditySensor extends Sensor {
        @Override
        public String purpose() {
            return "measures humidity";
        }
    }
    
    public class AdvancedHumiditySensor extends HumiditySensor {
        @Override
        public String purpose() {
            return "precisely measures humidity";
        }
    }
    
    public static void main(String[] args) {
       AdvancedHumiditySensor advancedSensor = new AdvancedHumiditySensor();
       HumiditySensor sensor = advancedSensor;
        System.out.println(advancedSensor.purpose());
        System.out.println(sensor.purpose());
    }
```
Abiem atvejais programa išspausdins tekstą „precisely measures humidity“.

Visgi, vaikinėje klasėje galima pasiekti net ir perrašytus tėvinius metodus pasitelkiant raktažodį *super*. Pavyzdžiui AdvancedHumiditySensor klasė savo viduje galėtų iškviesti originalų `purpose()` metodą tokia sintakse: `super.purpose()`.
```java
    public class AdvancedHumiditySensor extends HumiditySensor {
       @Override
        public String purpose() {
            return "precisely measures humidity";
        }
        public String parentPurpose() {
            return super.purpose();
        }
    }
    public static void main(String[] args) {
        AdvancedHumiditySensor advancedSensor = new AdvancedHumiditySensor();
        System.out.println(advancedSensor.purpose());
        System.out.println(advancedSensor.parentPurpose());
    }
```
Aukščiau matomo kodo rezultatas būtų:
```
precisely measures humidity
measures humidity
```

Norint išvengti paveldimumo, gali būti naudojamas raktažodis *final*. Klasės su raktažodžiu *final* negali būti paveldėtos, o *final* metodai negali būti perrašyti.

### Abstrakčios klasės
Abstrakti klasė – tai klasė, turinti raktažodį *abstract*. Abstrakčios klasės negali būti inicializuotos, tačiau jos gali būti paveldėtos. Jos turi visus narius, būdingus paprastoms klasėmis, bei abstrakčius metodus. Abstraktūs metodai neturi įgyvendinimo, jie atrodo taip: `abstract void printStatus();`. Jei klasė turi abstrakčius metodus, ji pati turi būti įvardyta kaip abstrakti. Paveldėjus abstrakčią klasę, vaikinė klasė privalo įgyvendinti visus abstrakčius tėvinės klasės metodus. 

Abstrakčios klasės turėtų būti taikomos naudojant tą patį kodą keliose, glaustai susijusiose klasėse. Pavyzdžiui, siuntų tarnybos sistema apdoroja įvairias siuntas. Tai gali būti paprasta siunta, skubi siunta, didelio dydžio siunta. Visos šios siuntos turi bendrus parametrus – gavėjo adresą ir išsiuntimo datą. Taip pat apie siuntas turėtų būti žinoma siuntos gavimo data, siuntimo būdas. Ši informacija būdinga kiekvienai siuntai, tačiau kiekvienam tipui ji bus skirtinga. 
Žinant šią informaciją, galima sukurti abstrakčią klasę, turinčią visas bendras siuntų savybes. Klasė atrodytų taip:
```java
public abstract class Shipment {
    private final String address;
    private final LocalDateTime shippingDate;

    public Shipment(String address, LocalDateTime shippingDate) {
        this.address = address;
        this.shippingDate = shippingDate;
    }
    public abstract LocalDateTime expectedDelivery();
    public abstract String shipmentMethod();

    public String getAddress() {
        return address;
    }
    public LocalDateTime getShippingDate() {
        return shippingDate;
    }
}
```
Metodai `expectedDelivery` ir `shipmentMethod` yra abstraktūs, nes jie yra skirtingi kiekvienam siuntos tipui.
Standartinės siuntos vežamos autobusiuke, pristatymo trukmė yra dešimt dienų. Klasė, vaizduojanti standartinę siuntą, atrodo taip:
```java 
public class StandardShipment extends Shipment {
        public StandardShipment(String address, LocalDateTime shippingDate) {
            super(address, shippingDate);
        }
        @Override
        public LocalDateTime expectedDeliver() {
            return getShippingDate().plusDays(10);
        }
        @Override
        public String shipmentMethod() {
            return "by van";
        }
    }
```
Abstraktūs metodai įgyvendinami pagal standartinės siuntos suvaržymus.
Klasės, vaizduojančios didelius bei skubius siuntinius, taip pat įgyvendinamos pagal joms taikomus reikalavimus
```java
    public class LargeShipment extends Shipment {
        public LargeShipment(String address, LocalDateTime shippingDate) {
            super(address, shippingDate);
        }
        @Override
        public LocalDateTime expectedDelivery() {
            return getShippingDate().plusDays(20);
        }
        @Override
        public String shipmentMethod() {
            return "by train";
        }
    }

    public class UrgentShipment extends Shipment {
        public UrgentShipment(String address, LocalDateTime shippingDate) {
            super(address, shippingDate);
        }
        @Override
        public LocalDateTime expectedDelivery() {
            return getShippingDate().plusDays(3);
        }
        @Override
        public String shipmentMethod() {
            return "by plane";
        }
    }
```
Skubi siunta siunčiama lėktuvu ir atkeliauja per tris dienas, o didėlė siunta siunčiama traukiniu. Tai užtrunka ilgiau nei įprastai – dvidešimt dienų.
### Sąsajos
Kompiuterių inžinerijoje dažni atvejai, kai atskiros programuotojų grupės turi sudaryti „kontraktus“, apibrėžiančius, kaip jų programinė įranga bendrauja tarpusavyje. Kiekviena grupė turėtų gebėti kurti savo programinį kodą, nežinodami, kaip parašytas kitų grupių kodas. Sąsajos (interfaces) Java programavimo kalboje ir yra tokie kontraktai. 

Įsivaizduokite įmonę, kuriančią dronus. Viena komanda atsakinga už programinę įrangą, skirtą bendrauti su drono technine įranga (hardware). Ši dalis valdo droną, kompiuterinės komandos kontroliuoja drono „geležį“, liepia jam kilti, leistis, suktis į kairę ir t.t. Kita komanda kurią programinę įrangą, kuri priima komandas iš nuotolinio pulto ir perduoda jas anksčiau minėtai sistemai, kad dronas keistų savo skridimo trajektoriją pagal gautas komandas iš pulto. Pirmoji komanda pateikia sąsają `OperateDrone` skirtą kreiptis į jų programinę įrangą. 
Sąsaja atrodo taip:
```java
interface OperateDrone {
    void up();
    void down();
    void left(int angle);
    void right(int angle);
    void accelerate();
    void decelerate();
}
``` 
Dėl šios sąsajos antroji komanda gali valdyti droną nesirūpindama, kaip tai vyksta žemesniame lygmenyje. Sąsajos įgyvendinimas jai neaktualus.
Įsivaizduokite, kad įmonė turi kelis skirtingus dronus – „Drone 2x Lite “ ir „Drone  8x Professional“. Jie turi skirtingą techninę įrangą, kuri programavimo lygmenyje turi būti valdoma skirtingai, dėl to reikalingos skirtingos programinės įrangos jiems valdyti. Pirmoji komanda pateikia du `OperateDrone` sąsajos įgyvendinimus: `Operate2xLiteDrone` ir `Operate8xProfessionalDrone`, skirtus valdyti skirtingų tipų dronus. Antrajai komandai šis suvaržymas nėra aktualus. Jos parašytas komandinis kodas naudoja `OperateDrone` sąsają ir sąsajos įgyvendinimas jai nėra svarbus. 

Šios sistemos pavyzdį galite pamatyti [čia](examples/src/)

Sąsajos gali turėti abstrakčius metodus bei konstantas (kintamuosius su *public, static, final* raktažodžiais). Taip pat nuo 8 Javos versijos, sąsajos gali turėti statinius metodus, bei *default* metodus – metodus su numatytu įgyvendinimu. 

Sąsajos ypatingos tuo, kad klasės gali įgyvendinti neribotą kiekį sąsajų ir apribojimas, kad klasė gali paveldėti tik vieną klasę, sąsajoms negalioja. Abstrakčios klasės taip pat gali įgyvendinti sąsajas, tačiau sąsajų metodai gali likti abstraktūs. Tokiu atveju sąsajų metodus turės įgyvendinti klasės, paveldinčios minėtą abstrakčią klasę.   

### Abstrakti klasė ar sąsaja? Ką pasirinkti?
Naudokite abstrakčias klases kai:
- norite dalintis kodu tarp kelių, glaustai susijusių klasių
- jums reikia laukų, kurie nebūtų konstantos

Naudokite sąsajas kai:
-	tikitės, kad klasės, įgyvendinančios jūsų sąsają, nebus glaustai susijusios
-	norite užtikrinti kontraktą, bet jo įgyvendinimo detalės nėra svarbios
-	norite pasinaudoti galimybe paveldėti kelias sąsajas

Tvarkingą kodą užtikriną abstrakcijos, nepriklausomi, vienas nuo kito atskirti komponentai/klasės/metodai. Programuojant reikėtų naudoti pačią žemiausią tėvinę klasę iš paveldėjimo grandinės, teikiančią norimą funkcionalumą. Nėra reikalo naudoti vaikinį objekto tipą, jei visi reikalingi metodai būdingi tėviniam duomenų tipui. Pavyzdžiui, nekurkite `TemperatureSensor` tipo objektų, jei jums tereikia `Sensor` tipo metodų. 

Taip pat, sąsajas reikėtų naudoti tipams nurodyti, o jų įgyvendinimas turėtų būti kiek galima paslėptas. Tvarkingi metodai grąžina sąsajas. Klientui nereikia žinoti, ar jis gauna `ArrayList` ar `LinkedList` įgyvendinimą, jam svarbu kad gautas objektas tenkintų `List` sąsajos kontraktą. Besilaikant tokių praktikų, lengviau išlaikyti tvarkingą ir nuo skirtingų komponentų nepriklausomą kodą.

### Šaltiniai:
-	https://docs.oracle.com/javase/tutorial/java/IandI/index.html
