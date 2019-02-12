# Programinės įrangos testavimas
Programinės įrangos testas - kodo dalis, įvykdanti kitą kodo dalį. Testas validuoja, kad įvykdytas kodas grąžino reikiamą rezultatą ir veiksmų seka buvo tokia, kokia tikėtasi.  

Testai padeda užtikrinti, kad programos logika yra teisinga. Jei nauji pakeitimai programiniame kode, kuris yra padengtas testais, sugriauna tinkamą programos veikimą,  galima tikėtis, kad tai bus pastebėta testų vykdymo metu.

### *Unit* testai
Tai kodas, kuris įvykdo tam tikrą sistemos dalį ir patvirtina tam tikrą rezultatą, elgesį ar būseną. *Unit* testai testuoja mažą kodo dalelę (*unit‘ą*) – metodą arba klasę. Priklausomybės nuo kitų klasių turėtų būti pašalintos, pakeičiant išorines klases testinėmis implementacijomis arba kitaip *mock‘ais*.

Procentas, nurodantis, kiek kodo yra ištestuota naudojant *unit* testus yra vadinamas *test coverage*.

### Integraciniai testai
Integraciniai testai tikrina ne vienos mažos kodo dalies veikimą, o tam tikrą programos veiksmų seką, vykstančią per kelias skirtingas klases. Integraciniai testai dažniausiai testuoja esminius sistemos funkcionalumus, kaip, pavyzdžiui, internetinės parduotuvės programėlėje, integracinis testas galėtų testuoti programos seką, vykdomą perkant tam tikrą prekę.

### *Unit* testai Java programavimo kalboje
Yra keli populiarūs testavimo karkasai kaip – *JUnit* ir *TestNG*. Ši medžiaga demonstruos testavimą naudojant *JUnit* 5 biblioteką.
Paprastai *unit*  testai yra kuriami atskiroje direktorijoje, kad testavimo kodas būtų atskirtas nuo pagrindinio kodo. Standartiškai, dirbant su *Maven* arba *Gradle* įrankiais, naudojamos dvi direktorijos klasėms saugoti:
-	`src/main/java` - standartinėms sistemos klasėms 
-	`src/test/java` - testų klasėms

Parašyti testai gali būti paleidžiami per naudojamą IDE arba, tinkamai sukonfigūravus *Maven*/*Gradle* įrankius, testai bus automatiškai įvykdomi šių įrankių konstravimo (*Build*) *test* fazėje. Pavyzdžiui vykdant komandą `mvn test`.


### *Unit* testai su JUnit
*JUnit* testai yra metodai, aprašyti testavimui skirtoje klasėje. Norint nurodyti, kad tam tikras metodas yra testas, reikia jam pridėti anotaciją `@Test`. Toks metodas įvykdo tam tikras kodo dalis ir patikrina gautus rezultatus. *JUnit* biblioteka pateikia metodus, leidžiančius palyginti gautus rezultatus su tikėtaisiais. Tokie metodai vadinami *asserts* arba *assert statements*.

***Unit* testo pavyzdys**
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTests {
    @Test
    void testPower() {
        assertEquals(4, Math.pow(2, 2), "2 power of 2 should be 4");
        assertEquals(16, Math.pow(4, 2), "4 power of 2 should be 16");
        assertEquals(1, Math.pow(2, 0), "2 power of 0 should be 1");
    }
}
```

### *JUnit* 5 funkcionalumai
Kaip buvo minėta anksčiau, biblioteka pateikia rinkinį *assert* metodų, padedančių įsitikinti, ar gauti rezultatai yra tokie, kaip tikėtasi. *JUnit* biblioteka taip pat palaiko rinkinį anotacijų, leidžiančių praplėsti *unit* testus.

**Pagrindinės anotacijos:**
-	`@Test` - nurodo, kad metodas yra testas
-	`@BeforeEach`, `@AfterEach` - nurodo, kad metodas bus įvykdomas prieš/po kiekvieno testo
-	`@BeforeAll`, `@AfterAll` - nurodo, kad metodas bus įvykdomas prieš vykdant/įvykdžius visus klasės testus
-	`@Disabled` - nurodo, kad testas yra išjungtas ir metodas neturėtų būti vykdomas

**Pagrindiniai *assert* metodai:**
-	`assertEquals(expectedResult, actualResult);` - palygina gautą rezultatą su rezultatu, kurio buvo tikimasi. Jei jie nesutampa, testas nėra sėkmingas
-	`assertNotEquals(unexpectedResult, actualResult);` - palygina gautą rezultatą su rezultatu, kurio nebuvo tikimasi. Jei jie sutampa, testas nėra sėkmingas
-	`assertFalse(condition);` - patikrina, ar gauta sąlyga yra neteisinga. Jei ji teisinga, testas nėra sėkmingas
-	`assertTrue(condition);` - patikrina ar gauta sąlyga yra teisinga. Jei ji neteisinga, testas nėra sėkmingas
-	`assertThrows(Exception.class, executor);` – patikrina ar kodas grąžina *exception*, jei ne – testas nėra sėkmingas

### Priklausomybių paslėpimas (*mocking*)
*Unit* testai vykdo mažas kodo dalis, dažniausiai metodus, vieną arba kelias susijusias klases. 
Paprastai, jei testuojamoje klasėje yra naudojamos kitos klasės papildomiems veiksmams atlikti,  pavyzdžiui testuojama klasė `PersonService`, kuri naudoja `PersonRepository` klasę, reikalingą gauti žmonių sąrašui, tos klasės yra „pakeičiamos“ *mock* objektais.  *Mock* objektas simuliuoja tam tikrą klasę, tačiau nevykdo jokios logikos, o tiesiog grąžina iš anksto aprašytus rezultatus. Tai leidžia testuoti vieną, konkrečią klasę, išvengiant klaidų testavimo kitose, jos naudojamose klasėse.

### Užduotys
-   [Boulingo žaidimas](exercises/bowling-game.md)
-	[Asmens kodo generatorius](exercises/official-id-generator.md)	
### Šaltiniai: 
-	http://www.vogella.com/tutorials/JUnit/article.html
-	https://junit.org/junit5/docs/current/user-guide/
