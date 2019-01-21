# Įvadas į Java programavimo kursus

## Įvadas
- [ivadas.pptx](ivadas.pptx)

## Aplinkos paruošimas

### Java

1. Atsisiųsti [`Java SE Development Kit 8 (JDK 8)`](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Įdiegti atsiųstą failą.
3. Pamodifikuoti `Windows Environment Variables` kintamąjį `path`, kad turėtų nuorodą į mūsų įdiegtą Java. 

    Atidaryti komandinę eilutę `Admin` režimu `(Run as administrator)` ir įvykdyti tokią komandą: 
    
    ```
    rundll32 sysdm.cpl,EditEnvironmentVariables
    ``` 
    
    Atsidarys `Environment Variables` langas. 
    
    Tarp `System variables` surasti kintamąjį *(variable)* pavadinimu `path`, spausti `Edit` ir `Variable value` laukelio pabaigoje įrašyti: 
    ```
    ;kelias\iki\java\bin\katalogo
    ```
    Kelio iki Java `bin` katalogo pavyzdys `C:\Program Files\Java\jdk1.8.0_191\bin`. Pakeitimus išsaugoti. 
    
    Po šių pakeitimų galime atidaryti komandinę eilutę *(cmd)* ir patikrinti ar Java sukonfigūruota sėkmingai. Įvykdžius komandą 
    ```
    java -version
    ``` 
    turėtume gauti panašų rezultatą:
    ```
    java version "1.8.0_191"
    Java(TM) SE Runtime Environment (build 1.8.0_191-b12)
    Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)
    ```

### Intellij IDEA

1. Atsisiųsti [`Intellij IDEA`](https://www.jetbrains.com/idea/download/#section=windows)

2. Įdiegti atsiųstą failą.

3. Atidaryti įdiegtą Intellij IDEA.

4. Sukurti naują projektą:
    ```
    File > New > Project
    ```
    Pasirinkti `Project SDK` Java 1.8. Sąraše pasirinkimo nėra, tada spausti `New` ir nurodyti vietą, kur yra įdiegta Java. 
    
    Kitame lange nurodyti projekto pavadinimą *(Project name)* ir pasirinkti, kur projektas bus saugomas *(Project location)*.

5. Sukurti naują Java klasę
    ```
    File > New > Java Class
    ```
    Jei nenurodysime kitaip, nauja Java klasė bus sukurta `src` kaltaloge.

6. Naujoje klasėje skurti `main` metodą:

    ```java
    public static void main(String[] args) {
        System.out.println("Hello wold");
    }
    ```

7. Programa paleidžiama šalia `main` metodo paspaudus žalią trikampį arba naudojant klaviatūros klavišų kombinaciją 
    ```
    Ctrl + Shift + F10
    ```

8. `Intellij IDEA` labai gerai pritaikyta atlikti veiksmus be pelės, naudojant įvairias klaviatūros klavišų kombinacijas. Pagrindinių kombinacijų galima išmokti iš šio sąrašo [DEFAULT KEYMAP](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf) 
arba įdiegus įskiepį, kuris atliekant veiksmus pele, trumpai ekrane parodys kokia klaviatūros klavišų kombinacija atlieka tą patį veiksmą. Įskiepio įdiegimas:
    ```
    File > Settings > Plugins > Browse Repositories
    ```
    Paieškos laukelio pagalba surasti įskiepį `Key Promoter X` ir įdiegti spaudžiant `Install`. Spausti `Restart Intellij IDEA` norint įgalintį įdiegtą įskiepį.

## Užduotys
- [Užduotys](uzduotys/uzduotys1.pdf)
- [Užduotys2](uzduotys/uzduotys2.pdf)