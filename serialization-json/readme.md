# Serializacija ir JSON

## Turinys
- [Serializacija ir deserializacija](#Serializacija-ir-deserializacija)
- [Užduotys](#Užduotys)


## Serializacija ir deserializacija


![](./img/ser-deser.png)

Klasės gali būti serializuojamos ir deserializuojamos. Gali būti serializuojamos vienoje sistemoje, o deserializuojamos kitoje.
Klasės, kurias norime serializuoti, turi įgyvendinti `Serializable` interfeisą. 

Java klasė `ObjectOutputStream` gali primityviuosius tipus ir objektus gali paversti į baitų srautą, o baitų srautą skaito ir gali pavesti į Objektus ir primityviuosius klasė `ObjectInputStream`.

Svarbiausias `ObjectOutputStream` metodas yra:
```java
public final void writeObject(Object o) throws IOException;
```
kuris paima serializuojamą objektą ir paverčia jį į baitų srautą.

`ObjectInputStream` atveju metodas, kuris skaito baitų srautą ir paverčia jį atgal į Java objektą yra:
```java
public final Object readObject() throws IOException, ClassNotFoundException;
```

Pavyzdys. Turime klasę `Asmuo` su keliais klasės kintamaisiais:
```java
import java.io.Serializable;

public class Asmuo implements Serializable {

    private String vardas;
    private int amzius;

    // getteriai ir setteriai
}
```
Tada sukuriame `Asmuo` objektą ir jį serializuojame į failą, vėliau iš failo deserializuojame atgal į Java objektą ir atspausdiname objekto reikšmes:
```java
Asmuo asmuo = new Asmuo();
asmuo.setVardas("Jurgis");
asmuo.setAmzius(50);

FileOutputStream fileOutputStream = new FileOutputStream("asmens_failas.txt");
ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject(asmuo);
objectOutputStream.flush();
objectOutputStream.close();

FileInputStream fileInputStream = new FileInputStream("asmens_failas.txt");
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
Asmuo asmuo2 = (Asmuo) objectInputStream.readObject();
objectInputStream.close();

System.out.println(asmuo2.getVardas());
System.out.println(asmuo2.getAmzius());
``` 
```
Jurgis
50
```

Java objektas serializuojamas į baitų srautą:
```java
objectOutputStream.writeObject(asmuo);
```

Iš baitų srauto deserializuojama į Java objektą:
```java
Asmuo asmuo2 = (Asmuo) objectInputStream.readObject();
```
Operacija *cast* šioje vieotje yra būtina.

Naudojant `transient` operatorių galime nurodyti kurios objekto dalies nenorime serializuoti. Pavyzdžiui nenorime serializuoti slaptažodžių dėl saugumo.
```java
public class Asmuo implements Serializable {

    private transient String vardas;
    private int amzius;

    // getteriai ir setteriai
}
```
Tada pagal anstesnį serializavimo, deserialiazavimo ir objekto reikšmių atspausdinimo pavyzdį gautume rezultatą:
```
null
50
```
Jei klasė įgyvendina `Serializable` interfeisą, tai visų tos klasės vaikų (paveldinčių klasių) objektai taip pat galės būti serializuojami. Tačiau kompozicijos atveju kiekviena klasė turi įgyvendinti `Serializable` interfeisą. Pavyzdys:
```java
public class Asmuo implements Serializable {

    transient private String vardas;
    private int amzius;
    private Adresas adresas;

    // getteriai ir setteriai
}
```
Tada klasė `Adresas` taip pat turi įgyvendinti `Serializable` interfeisą.

Serializacijoje yra naudojamas `serialVersionUID`. Pavyzdys:
```java
public class Asmuo implements Serializable {

    private static final long serialVersionUID = 1L;

    transient private String vardas;
    private int amzius;

    // getteriai ir setteriai
}
```
`serialVersionUID` yra skaičius, kuris užtikrina, kad objektas, kurį deserilizuojame, atitiks klasės sandarą, kuri buvo serializuojant objektą. `serialVersionUID` yra didelis skaičius, paskaičiuojamas pagal klasės pavadinimą, klasės atributus ir klasėje naudojamus prėjimo modifikatorius. Jei šis skiačius nėra parašytas klasėje, tada JVM tai padaro už mus. 
Jei serializuosime objektą, o vėliau pakeisime klasę, pvz. parašysime naują metodą, tada deserializuojant gausime `InvalidClassException` klaidą, nes `serialVersionUID`, kuriuos generuoja pati JVM, nesutaps. To išvengti padėtų, jei mes patys priskitume `serialVersionUID` reikšmę.

Jei bandysime serializuoti objektą, kurio klasė neįgyvendina `Serializable` interfeiso, tada gausime `NotSerializableException` klaidą.

Serializavimo/deserializamino procesą galime šiek tiek modifikuoti. Pavyzdžiui turime klasę `Adresas`:
```java
public class Adresas {
    
    private String miestas;
    private String gatve;

    // getteriai ir setteriai
}
```
ir turime klasę `Asmuo`, kurioje adresas yra pažymėtas kaip `transient`, t.y. neserializuojamas:
```java
public class Asmuo implements Serializable {

    private String vardas;
    private int amzius;
    private transient Adresas adresas;

    // getteriai ir setteriai
}
```
bet norime serializuoti adresą. Tada klasėje `Asmuo` turime sukurti `writeObject` ir `readObject` metodus:
```java
public class Asmuo implements Serializable {

    private String vardas;
    private int amzius;
    private transient Adresas adresas;

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(adresas.getMiestas());
        oos.writeObject(adresas.getGatve());
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        String miestas = (String) ois.readObject();
        String gatve = (String) ois.readObject();
        Adresas adresas = new Adresas();
        adresas.setMiestas(miestas);
        adresas.setGatve(gatve);
        this.setAdresas(adresas);
    }

    // getteriai ir setteriai
}
```
Tokiu atveju adresas bus serializuotas ir galėsime deserializuojant gauti miestą bei gatvę.
```java
Asmuo asmuo = new Asmuo();
asmuo.setVardas("Jurgis");
asmuo.setAmzius(50);

Adresas adresas = new Adresas();
adresas.setMiestas("Vilnius");
adresas.setGatve("Sauletekio");
asmuo.setAdresas(adresas);

FileOutputStream fileOutputStream = new FileOutputStream("asmens_failas.txt");
ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject(asmuo);
objectOutputStream.flush();
objectOutputStream.close();

FileInputStream fileInputStream = new FileInputStream("asmens_failas.txt");
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
Asmuo asmuo2 = (Asmuo) objectInputStream.readObject();
objectInputStream.close();

System.out.println(asmuo2.getVardas());
System.out.println(asmuo2.getAmzius());
System.out.println(asmuo2.getAdresas().getMiestas());
System.out.println(asmuo2.getAdresas().getGatve());
```
Rezultatas:
```
Jurgis
50
Vilnius
Sauletekio
```


## Užduotys
- [Užduotys](exercises/readme.md)