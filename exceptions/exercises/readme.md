
## Užduotys: *Exceptions*

## Nr. 1

### Užduotis

![](./exceptions.png)

Klasėje `A` yra kviečiamas klasės `B` metodas. Klasėje `B` yra kviečiamas klasės `C` metodas. Klasės `C` metodas iššaukia klaidą. Šią klaidą reikia apdoroti klasėje `A`.

## Nr. 2

### Užduotis

1. Sukurkite klasę `Input`. Klasė turi metodą, kurį iškvietus programa vartotojo paprašo įvesti sveikąjį skaičių ir metodas įvestą skaičių grąžina.
2. Kitoje klasėje metode `main` iškvieskite klasės `Input` metodą.
3. Įvestą skaičių atspausdinkite.
4. Paleiskite programą ir įveskite skaičių su slankuoju kableliu. gausite klaidą.
5. Apsaugokite programą nuo 'nulūžimo' - įvedus ne sveikąjį skaičių programa turi pranešti, kad įvesti netinkami duomenys ir prašys įvesti skaičių dar kartą. Programa prašys įvesti skaičių tol kol jį vartotojas įves teisingai.

## Nr. 3

### Užduotis

1. Sukurkite klasę `Device`. Klasė turi klasės kintamuosius - `isOn`, kuris reiškia ar įrenginys yra įjungtas, ir `id`, kuris yra unikalus įrenginio numeris (nustatomas sukuriant objektą).
2. Sukurkite keletą įrenginių, kurie paveldės `Device` klasę.
3. Sukurkite *exception* klasę `DeviceIsOffException`.
4. Klasėje `Device` sukurkite metodą 'ping', kuris patikrina ar įrenginys yra įjungtas. Jei įrenginys išjungtas, turi būti sukelta išimtis 'DeviceIsOffException'.
5. Sukurti klasę `Monitoring` su metodu `pingAllDevices`, kuris priima sąrašą įrenginių ir juos tikrina kviesdamas `ping` metodą tikrina ar įrenginys yra įjungtas. Patikrinimo rezultatą išveda į ekraną.
6. Atskiroje klasėje su `main` metodu sukurkite keletą įrenginių ir juos *monitorinkite*. Tada vieną iš įrenginių išjunkite ir vėl *monitorinkite*.

Tokios veiksmų sekos
```java
public static void main(String[] args) {

    Monitoring monitoring = new Monitoring();

    List<Device> devices = new ArrayList<>();
    devices.add(new Mouse(true));
    devices.add(new Display(true));
    devices.add(new Keyboard(true));
    devices.add(new Mouse(true));
    devices.add(new Display(true));
    devices.add(new Keyboard(true));

    monitoring.pingAllDevices(devices);
    devices.get(3).setOn(false);
    monitoring.pingAllDevices(devices);
}
```
rezultatas galėtų būti toks:
```
-----Pinging started-----
Device Mouse with id 0 is ON
Device Display with id 1 is ON
Device Keyboard with id 2 is ON
Device Mouse with id 3 is ON
Device Display with id 4 is ON
Device Keyboard with id 5 is ON
-----Pinging finished----

-----Pinging started-----
Device Mouse with id 0 is ON
Device Display with id 1 is ON
Device Keyboard with id 2 is ON
Device Mouse with id 3 is OFF.
Device Display with id 4 is ON
Device Keyboard with id 5 is ON
-----Pinging finished----
```

### Sprendimas

<details><summary>Išskleisti</summary>
<p>

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Monitoring monitoring = new Monitoring();

        List<Device> devices = new ArrayList<>();
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));

        monitoring.pingAllDevices(devices);
        devices.get(3).setOn(false);
        monitoring.pingAllDevices(devices);
    }

}

class Monitoring {
    public void pingAllDevices(List<Device> devices) {
        System.out.println("\n-----Pinging started-----");
        for (Device d : devices) {
            try {
                d.ping();
                System.out.println(String.format("Device %s with id %d is ON", d.getClass().getSimpleName(), d.getId()));
            } catch (DeviceIsOffException e) {
                System.out.println(String.format("Device %s with id %d is OFF.", d.getClass().getSimpleName(), d.getId()));
            }
        }
        System.out.println("-----Pinging finished----");
    }
}

class Device {
    public static int idCounter;
    private boolean isOn;
    private int id;

    public Device(boolean isOn) {
        this.isOn = isOn;
        id = idCounter++;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void ping() throws DeviceIsOffException {
        if (!isOn) {
            throw new DeviceIsOffException();
        }
    }

    public int getId() {
        return id;
    }
}

class Mouse extends Device {

    public Mouse(boolean isOn) {
        super(isOn);
    }
}

class Display extends Device {

    public Display(boolean isOn) {
        super(isOn);
    }
}

class Keyboard extends Device {

    public Keyboard(boolean isOn) {
        super(isOn);
    }
}

class DeviceIsOffException extends Exception {

}
```

</p>
</details>

## Nr. 4

### Užduotis

1. Sukurkite klasę `Email`, kuri turi laisko turinį, temą, informaciją kam siunciama ir būseną (naujas, issiustas, kartojamas siuntimas).
2. Sukurkite klasę `EmailSender`, kuri turi metodą `sendEmail` priimantį sąrašą laiškų. Metodas iteruoja laiškus ir po vieną siunčia. Siuntimui kviečia klasės `NetworkConnector` metodą `send`. Jei laiško išsiuntimas yra nesėkmingas (klaida `NoNetworkException`, kurios klasę taip pat reikia sukurti), tai reikia pakeisti laiško būseną į "kartojamas siuntimas". Tokius laišku reikia pakartoti po 3 sekundžių. `Thread.sleep(3000);` - Java programa laukia 3 sekundes.
3. Klasės `NetworkConnector` metodas `send` turi veikti ne visada sėkmingai:

```java
class NetworkConnector {

    public void send(Object o) throws NoNetworkException {
        Random rand = new Random();
        int n = rand.nextInt(10);
        try {
            int i = 1 / n;
        } catch (ArithmeticException e) {
            throw new NoNetworkException();
        }
    }
}
```

Tokios veiksmų sekos
```java
public static void main(String[] args) {

    EmailSender emailSender = new EmailSender();

    List<Email> emails = new ArrayList<>();
    emails.add(new Email("aaa@aaa.lt", "subject1", "body1"));
    emails.add(new Email("bbb@bbb.lt", "subject2", "body2"));
    emails.add(new Email("ccc@ccc.lt", "subject3", "body3"));
    emails.add(new Email("ddd@ddd.lt", "subject4", "body4"));
    emails.add(new Email("eee@eee.lt", "subject5", "body5"));

    emailSender.sendEmail(emails);

}
```
rezultatas galėtų būti toks:
```
Sending email to aaa@aaa.lt
Email to aaa@aaa.lt delivered

Sending email to bbb@bbb.lt
Email to bbb@bbb.lt delivered

Sending email to ccc@ccc.lt
Email to ccc@ccc.lt delivered

Sending email to ddd@ddd.lt
Email to ddd@ddd.lt delivered

Sending email to eee@eee.lt
Failed to send an email to eee@eee.lt

Redelivering email to eee@eee.lt
Email to eee@eee.lt delivered
```
