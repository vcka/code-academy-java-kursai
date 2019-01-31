
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