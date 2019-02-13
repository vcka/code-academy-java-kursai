
## Užduotys: Serializacija ir JSON

## Nr. 1

### Užduotis

1. Sukurkite klases `Sender` ir `Receiver`, kurios paveldi klasę `Asmuo`. 
2. Sukurkite klasę `Payment` kuri turi klasės atributus `sender` ir `receiver`.
3. Sukurkite ir užpildykite `Payment` objektą duomenimis.
4. Serializuokite sukurtą objektą į failą.
5. Deserializuokite iš failo į `Payment` objektą ir patikrinkite ar nepraradote duomenų.

## Nr. 2

### Užduotis

1. Naudoti ankstesnės užduoties sąlygas, tik serializuoti į JSON failą.
2. Deserializuoti iš JSON failo atgal į `Payment` Java objektą.
3. Konvertuokite `Payment` objektą į JSON formato String eilutę.

## Nr. 3

### Užduotis

1. Sukurkite klasę `Imone`, kuri tokius duomenis kaip įmonės pavadinimas, įmonės kodas, darbuotojų skaičius, vidutinis atlyginimas ir panašiai.
2. Sukurkite sąrašą, į kurį galėtume įdėti klasės `Imone` tipo objektus.
3. Sukurkite 100 įmonės objektų. Duomenis reikalingus įmonei generuokite. Galite naudoti [java-faker](https://github.com/DiUS/java-faker).
4. Sąrašą serializuokite į JSON failą pavadinimu `imoniu_sarasas.json`

## Nr. 4

### Užduotis

1. Sukurkite Maven projektą `internetas`
2. Maven projekte `internetas` sukurkite modulius `narsykle`, `serveris` ir `helper`
3. `internetas` turi turėti `jackson` priklausomybę (dependency)
4. Modulyje `helper` sukurkite klasę `Uzklausa`, kuri turės vieną lauką `imonesKodas`. Taip pat sukurkite klasę `Atsakymas`, kuri turės laukus - `imonesKodas`, `imonesPavadinimas` ir `vidutinisAtlyginimas`
5. Modulyje `helper` sukurtos klasės turi būti prieinamos moduliuose `narsykle` ir `serveris`
6. Sukurkite folderį pvz. and Desktop su pavadinimu `internetas`
7. Modulyje `narsykle` sukurkite klasę `Narsykle` su `main` metodu. 
8. Modulyje `serveris` sukurkite klasę `Serveris` su `main` metodu. 
9. Klasės `Narsykle` veiksmu seka:
    - Papraso vartotojo įvesti imones kodą
    - Vartotojo įvestą kodą panaudoja pagaminti `Uzklausa` objektui
    - Objektą `Uzklausa` serializuoja į JSON failą ir išsaugo į `internetas` folderį su pavadinimu `uzklausa.json`
    - Laukia failo tame pačiame folderyje su pavadinimu `atsakymas.json`
        Patikrinimas ar failas su tokiu vardu egzistuoja:
        ```java
        File file = new File("C:/Users/USERNAME/Desktop/internetas/atsakymas.json");
        boolean failasEgzistuoja = file.exists();
        ```
        Jei patikrinus failo dar nėra, palaukti sekundę ir tikrinti vėl `Thread.sleep(1000);`
    - Sulaukus failo, jis yra deserializuojamas iš JSON į objektą `Atsakymas`
    - Failas pavadinimu `atsakymas.json` ištrinamas iš folderio `internetas`. `file.delete()`
    - Atsakymo informacija atspausdinama į ekraną ir toliau leidžiama vartotojui įvesti kitą įmonės kodą
10. Kasės `Serveris` veiksmų seka:
    - Serveris turi sąrašą įmonių objektų. Startuojant serveriui panaudoti ankstesnėje užduotyje sukurtą `imoniu_sarasas.json` failą jį deserializuojant iš JSON į imonių sąrašą.
    - Serveris taip pat kaip ir naršyklė - naudoja folderį `internetas` ir laukia ten failo pavadinimu `uzklausa.json`
    - Sulaukęs failo, serveris failą `uzklausa.json` deserializuoja į objektą `Uzklausa` ir ištrina failą `uzklausa.json`
    - Gautą užklausą spausdina į log'us. Naudoti `org.apache.logging.log4j`.
    - Pasinaudodamas informacija iš `Uzklausa` objekto, atlieka paiešką turimame įmonių sąrašą
    - Suradęs įmonę sukuria objektą `Atsakymas` ir jį serializuoja į failą `atsakymas.json`, kurį išsaugo į `internetas` folderį
    - Toliau laukia kito failo `užklausa.json`. Tikrina folderį kas sekundę.
11. Pirmiausia paleiskite serverį, o po to naršyklę ir pabandykite surasti informaciją apie įmonę naudojantis savo sukurta naršykle.
