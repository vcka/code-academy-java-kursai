
## Užduotys: *Generics*

## Nr. 1

### Užduotis

Turime du masyvus - viename skaičiaus tipo elementai `{ 1, 2, 3 }`, kitame eilutės tipo elementai `{"Hello", "World"}`.

Užduotis: parašyti **vieną** metodą ``printArray``, kuris gali atspausdinti visus abiejų turimų masyvų elementus. Metodas turi priimti ir masyvą su skaičiais, ir masyvą su eilutėmis.

Tikėtinas rezultatas:
```
1
2
3
Hello
World
```

## Nr. 2

### Užduotis

Sukurti tokią klasių/interfeisių hierarchiją:
```
                           +-------+
                           | Medis |
                           +---^---+
                               |
             +-----------------+-------------------+
             |                                     |
       +-----+----+                          +-----+-------+
       | Lapuotis |                          | Spygliuotis |
       +-----^----+                          +-----^-------+
             |                                     |
     +-------+-------+             +-------------+-+------------+
     |               |             |             |              |
+----+----+     +----+---+      +--+---+     +---+---+    +-----+---+
| Azuolas |     | Berzas |      | Egle |     | Pusis |    | Kadagys |
+---------+     +--------+      +------+     +-------+    +---------+
```

Kiekvienam objektui turime turėti galimybę iškviesti metodą `turi()`, kuris aptspausdina informaciją apie objektą. Pavyzdžiui, jei sukurtume ąžuolo objektą `Azuolas azuolas = new Azuolas();` ir jam iškviestume metodą `azuolas.turi();` tada turi būti atspausdinta `Azuolas turi lapus`. Nekurti kiekvienam to paties `turi()` metodo kiekvienoja klasėje, o panaudoti paveldėjimo savybes.

Panaudojant *generics* atskiroje klasėje sukuri metodus:
- `ivairusMiskas(...)` - priima bet kokių medžių sąrašą
- `spygliuociuMiskas(...)` - priima bet kokių spgliuočių sąašą
- `berzuMiskas(...)` - priima tik beržų sąrašą

Visų metodų logika panaši: atspausdina koks tai miškas ir kiekvienam medžiui iškviečia metodą `turi()`

Sukurti sąrašą, į kurį įdėti ivairių mežių ir iškviesti metodą `ivairusMiskas(...)`.

Sukurti sąrašą, į kurį įdėti ivairių mežių ir iškviesti metodą `spygliuociuMiskas(...)`.

Sukurti sąrašą, į kurį įdėti ivairių mežių ir iškviesti metodą `berzuMiskas(...)`.


Tikėtinas rezultatas:
```
Ivairus miskas:
Berzas turi lapus
Azuolas turi lapus
Kadagys turi spyglius
Egle turi spyglius
Pusis turi spyglius

Spygliuociu miskas:
Kadagys turi spyglius
Egle turi spyglius
Pusis turi spyglius

Berzu miskas:
Berzas turi lapus
Berzas turi lapus
Berzas turi lapus
```

## Nr. 3

### Užduotis
Sukurkite klasę `Pora`, su klasės atributais `Raktas` ir `Reiksme`. Abu klasės atributai gali būti bet koks objektas.

Sukurkite klasę `Mapas` su vienu klasės atributu `sarasasPoru`, kuris bus sarasas, skirtas saugoti klasės `Pora` objektams. Klasė `Mapas` turi turėti metodą `ideti`, kuriam per parametrus perdavus raktą ir reikšmę, iš jų sukonstruoja porą ir ją įdeda į map'ą. Taip pat reikalingas metodas `gauti`, kuriam per parametrą perdavus raktą, gausime reikšmę pagal tą raktą iš sąrašo.  

Sukurkite klasę `DnsServer`, kuri turi atributus `ip1` ir `ip2`. 

Sukurkite enum `DnsProvider`, kuris saugos keletą reikšmių, pvz. `GOOGLE`.

Atskiroje klasėje `main` metode sukurti map'ą, kuris saugo `DnsProvider -> DnsServer` poras. Sukurti kitą map'ą, kuris saugo `String -> String` poras. Map'us užpildyti duomenimis ir pabandyti gauti reikšmes pagal raktus.

Panaudojimo pavyzdys:
```java
Mapas<DnsProvider, DnsServer> dnsMapas = new Mapas<>();

dnsMapas.ideti(GOOGLE, new DnsServer("8.8.8.8", "8.8.4.4"));
dnsMapas.ideti(CLOUDFLARE, new DnsServer("1.1.1.1", "1.0.0.1"));
// ...

DnsServer googleDns = dnsMapas.gauti(GOOGLE);
System.out.println(googleDns);

Mapas<String, String> zodynoMapas = new Mapas<>();
zodynoMapas.ideti("Labas", "Hello");
zodynoMapas.ideti("Pasaulis", "World");
// ...

String labas = zodynoMapas.gauti("Labas");
System.out.println(labas);
```
programa atspausdina:
```
DnsServer{ip1='8.8.8.8', ip2='8.8.4.4'}
Hello
```
