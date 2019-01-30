# Darbas su failais
### Kas yra kelias (*Path*)?
Failų sistemos saugo ir organizuoja failus taip, kad jie būtų lengvai pasiekiami. Dauguma modernių failų sistemų naudoja hierarchinę struktūrą failams saugoti. Pačiame viršuje yra pagrindinis mazgas (*root node*). Žemiau jo – failai ir direktorijos. Kiekvienoje direktorijoje gali būti failai arba kitos direktorijos.

Paprastas direktorijų medžio pavyzdys:
```
    +--------------------+
    | C:\ (Windows root) |
    |   / (Linux root)   |                   
    +-----------+--------+
                |
            +---v--+
      +-----+ home +------+
      |     +------+      |
      |                   |
+-----v-----+      +------v------+
| documents |      |Program Files|
+-----+-----+      +------+------+
      |                   |
+-----v-----+        +----v----+
|dokumentas1|        |   Java  |
+-----------+        +---------+

```

Failas yra identifikuojamas pagal kelią nuo tėvinio medžio. Pavyzdžiui, failas *dokumentas.txt* iš ankstesnio pavyzdžio Windows sistemoje būtų aprašytas taip: `C:\home\documents\dokumentas1`, o Linux sistemoje jis būtų aprašytas taip: `/home/documents/dokumentas1`  

Ženklas, skirtas atskirti direktorijų pavadinimus, vadinamas *delimiter*, kiekvienoje sistemoje jis yra kitoks. Windows sistemoje tai `\`, o Linux sistemoje `/`.

Kelias gali būti pilnas (*absolute*) arba reliatyvus (*relative*). Pilnas kelias prasideda nuo pagrindinio mazgo iki failo. Pavyzdžiui `C:\home\documents\dokumentas1` yra pilnas kelias. Pilnas kelias turi visą reikalingą informaciją, reikalingą pasiekti failui. Norint pasiekti failą, reliatyvus kelias turi būti sujungtas su kitu keliu. Be papildomos informacijos programa negali pasiekti `documents\dokumentas1`  failo failų sistemoje.

### Path klasė
*Path* klasė yra failų sistemos kelio reprezentacija Java programavimo kalboje. *Path* objektas yra naudojamas rasti bei manipuliuoti failais.
Failas nurodytas *Path* objekte gali neegzistuoti. 
Norint sukurti naują *Path* objektą naudojamas statinis *Paths* klasės metodas *get*. Pavyzdžiui
`Paths.get("C:\home\documents\dokumentas");`.

*Path* objekto metodas *resolve* naudojamas sulipdyti du kelius. Pavyzdžiui kodas:
```
  Path path = Paths.get("/home");
        Path anotherPath = Paths.get("documents");
        Path newPath = path.resolve(anotherPath);
        System.out.println(newPath); 
```
išspausdins `/home/documents`.

### Files klasė
*Files* klasė naudojama dirbant su failais. Ši klasė turi rinkinį statinių metodų, leidžiančių manipuliuoti failais.

#### *Files* klasės metodai
```
boolean exists(Path path)
```
Patikrina, ar nurodytas failas arba direktorija egzistuoja
```
boolean isRegularFile(Path path)
```
Patikrina, ar nurodytas kelias rodo į paprastą failą
```
boolean isDirectory(Path path)
```
Patikrina, ar nurodytas kelias rodo į direktoriją
```
Path createDirectory(Path dir)
```
Sukuria direktoriją nurodytame kelyje
```
Path createFile(Path path)
```
Sukuria failą nurodytame kelyje
```
long size(Path path)
```
Grąžina failo dydį
```
void delete(Path path)
```
Pašalina failą/direktoriją nurodytame kelyje
```
Path copy(Path source, Path target)
```
Nukopijuoja failą į nurodytą direktoriją
```
Path move(Path source, Path target)
```
Perkelia failą į nurodytą direktoriją
```
List<String> readAllLines(Path path)
```
Grąžina sąrašą su failų eilutėmis

### Įvesties/Išvesties srautai
Java srautas - duomenų (baitų, simbolių) seka. Srauto klasės leidžia operuoti skaitymo / rašymo operacijomis. 

![Streams](stream.PNG)

Java kalboje srautą pavaizduoja `InputStream`, `OutputStream` sąsajos. Srauto sąsajos turi daug skirtingų įgyvendinimų skirtingiems srautų tipams. Pagrindinės srautų klasės yra `java.io` pakete.

Galimų srautų pavyzdžiai:
-	*Byte stream*
-	*Character stream*
-	*Buffered stream*

Srautai yra efektyvūs, nes jie leidžia skaityti/apdoroti duomenis mažomis dalimis, neįkeliant viso turinio į atmintį.

Dirbant su dideliais failais paprastai naudojami *Files* klasės metodai
```
BufferedReader newBufferedReader(Path path)
BufferedWriter newBufferedWriter(Path path)
```
grąžinantys *Buffered* tipo srautus įvesties ir išvesties.

Failo eilutės nuskaitymas iš srauto atrodo taip:
```
try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
```

Failo eilutės įrašymas atrodo taip:
```
try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {
            bufferedWriter.write("First line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second line");
            bufferedWriter.newLine();
            bufferedWriter.write("Third line");
        }
```

Darbo su failais programėles pavyzdį galite pamatyti [čia](examples/files-example/src)

### Užduotys
 - [Užduotis darbui su failais](exercises/file-exercise.md)

### Nuorodos 
-	https://docs.oracle.com/javase/tutorial/essential/io/path.html
