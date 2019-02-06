# Prieigos modifikatoriai: *public*, *protected*, *private*, *package-private*

## Teorija

Modifikatorius | Klasė | Interfeisas | Konstruktorius | Metodas | Klasės kintamasis
--- | --- | --- | --- | --- | ---
public | + | + | + | + | +
protected | - | - | + | + | +
private | - | - | + | + | +
*package-private* | + | + | + | + | +

```
src
│
└───lt
    │
    └───codeacademy
            │
            └───learn
            |     │
            |     └───services
            |     |     │
            |     |     └───Service.java
            |     |     │
            |     |     └───SecondService.java
            |     |     │
            |     |     └───EmailService.java
            |     |     |
            |     |     └───GoogleService.java
            |     │
            |     └───factories
            |           |     
            |           └───BaseFactory.java
            |           |     
            |           └───BaseFactory2.java
            |           |  
            |           └───email
            |                 |
            |                 └───EmailFactory.java
            └───Application.java
```

### Klasė
#### public
<details><summary>Išskleisti</summary>
<p>

Klasė, kuri yra `public` yra prieinama iš visur, nepaisant to, kuriame pakete ji yra.
```java
package lt.codeacademy.learn.services;

public class EmailService {
}
```

Klasė `lt.codeacademy.learn.services.EmailService` yra pasiekiama:
- klasėje `lt.codeacademy.learn.services.EmailService`
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`
- klasėje `lt.codeacademy.learn.services.GoogleService`
- interfeise `lt.codeacademy.learn.services.Service`
- interfeise `lt.codeacademy.learn.services.SecondService`
- klasėje `lt.codeacademy.learn.Application`
    
Pavyzdys:
```java
package lt.codeacademy.learn;

import lt.codeacademy.learn.services.EmailService;

public class Application {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
    }
}
```
</p>
</details>

#### *package-private*

<details><summary>Išskleisti</summary>
<p>

Klasė, kuri neturi prirašyto modifikatoriaus (vadinama *package-private*) yra prieinama tik tame pačiame pakete esančioms klasėms ir interfeisams.

```java
package lt.codeacademy.learn.services;

class GoogleService {
}
```

Klasė `lt.codeacademy.learn.services.GoogleService` yra pasiekiama:
- klasėje `lt.codeacademy.learn.services.GoogleService`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.services.EmailService`, nes yra tame pačiame pakete
- interfeise `lt.codeacademy.learn.services.Service`, nes yra tame pačiame pakete
- interfeise `lt.codeacademy.learn.services.SecondService`, nes yra tame pačiame pakete

</p>
</details>

### Interfeisas
#### public

<details><summary>Išskleisti</summary>
<p>

Interfeisas kaip ir klasė, jei jis yra `public` tada jis yra prieinamas iš visur, nepaisant to, kuriame pakete jis yra.

```java
package lt.codeacademy.learn.services;

public interface Service {
}
```

Interfeisas `lt.codeacademy.learn.services.Service` yra pasiekiamas:
- interfeise `lt.codeacademy.learn.services.Service`
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`
- klasėje `lt.codeacademy.learn.services.GoogleService`
- klasėje `lt.codeacademy.learn.services.EmailService`
- interfeise `lt.codeacademy.learn.services.SecondService`
- klasėje `lt.codeacademy.learn.Application`

</p>
</details>

#### *package-private*

<details><summary>Išskleisti</summary>
<p>


Interfeisas, kuris neturi prirašyto modifikatoriaus (vadinamas *package-private*) yra prieinamas tik tame pačiame pakete esančioms klasėms ir interfeisams.

```java
package lt.codeacademy.learn.services;

interface SecondService {
}
```

Interfeisas `lt.codeacademy.learn.services.SecondService` yra pasiekiamas:
- interfeise `lt.codeacademy.learn.services.SecondService`, nes tas pats interfeisas
- klasėje `lt.codeacademy.learn.services.EmailService`, nes yra tame pačiame pakete
- klasėje `lt.codeacademy.learn.services.GoogleService`, nes yra tame pačiame pakete
- interfeise `lt.codeacademy.learn.services.Service`, nes yra tame pačiame pakete


</p>
</details>

### Konstruktorius
#### public

<details><summary>Išskleisti</summary>
<p>


Konstruktorius, kuris yra `public` yra prieinamas iš visur, nepaisant to, kuriame pakete ji yra.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    public BaseFactory() {
    }
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` konstruktorių galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`
- klasėje `lt.codeacademy.learn.services.GoogleService`
- klasėje `lt.codeacademy.learn.services.EmailService`
- klasėje `lt.codeacademy.learn.Application`

Pavyzdys:
```java
package lt.codeacademy.learn;

import lt.codeacademy.learn.factories.BaseFactory;

public class Application {

    public static void main(String[] args) {
        BaseFactory baseFactory = new BaseFactory();
    }
}
```

</p>
</details>

#### protected

<details><summary>Išskleisti</summary>
<p>

Konstruktorius, kuris yra `protected` yra prieinamas tik klasėse, kurios yra tame pačiame pakete arba tą klasę paveldinčiose klasėse, kurios yra kituose paketuose.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    protected BaseFactory() {
    }
}
```
Šiuo atveju taip pat turime paveldėjimą:
```
+-------------+
| BaseFactory |
+------^------+
       |
       |
       |
+------+-------+
| EmailFactory |
+--------------+
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` konstruktorių galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.BaseFactory`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory` nes `EmailFactory` paveldi `BaseFactory`

Pavyzdys:
```java
package lt.codeacademy.learn.factories.email;

import lt.codeacademy.learn.factories.BaseFactory;

public class EmailFactory extends BaseFactory {
    public EmailFactory() {
        super();
    }
}
```

</p>
</details>

#### private

<details><summary>Išskleisti</summary>
<p>

Konstruktorius, kuris yra `private` yra prieinamas tik toje pačioje klasėje.

```java
package lt.codeacademy.learn.services;

public class GoogleService implements Service {

    private static GoogleService obj = null;

    private GoogleService() {
    }

    public static GoogleService objectCreationMethod(){
        if(obj == null){
            obj = new GoogleService();
        }
        return obj;
    }

}
```

Klasės `lt.codeacademy.learn.services.GoogleService` konstruktorių galime pasiekti:
- klasėje `lt.codeacademy.learn.services.GoogleService`, nes ta pati klasė

Panaudojimo pavyzdys:
```java
package lt.codeacademy.learn;

import lt.codeacademy.learn.services.GoogleService;

public class Application {

    public static void main(String[] args) {
        GoogleService googleService = GoogleService.objectCreationMethod();
    }
}
```
Šiuo atveju klasė `GoogleService` yra singleton klasė. Tai riškia, kad tokios klasės objektą galime sukurti tik vieną kartą ir visada naudoti tą patį objektą.

</p>
</details>

#### *package-private*

<details><summary>Išskleisti</summary>
<p>

Klasės konstruktorius, kuris neturi prirašyto modifikatoriaus (vadinama *package-private*) yra prieinamas tik tame pačiame pakete esančioms klasėms.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory2 {
    BaseFactory2() {
    }
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory2` konstruktorių galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.BaseFactory2`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.BaseFactory`, nes tas pats paketas

Pavyzdys:
```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    public void callOtherConstructor() {
        new BaseFactory2();
    }
}
```

</p>
</details>

### Metodas
#### public

<details><summary>Išskleisti</summary>
<p>

Metodas, kuris yra `public` yra prieinamas iš visur, nepaisant to, kuriame pakete ji yra.

```java
public class EmailService {
    public void checkConnection() {
    }
}
```

Klasės `lt.codeacademy.learn.services.EmailService` metodą `checkConnection` galime pasiekti:
- klasėje `lt.codeacademy.learn.services.EmailService`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`
- klasėje `lt.codeacademy.learn.services.GoogleService`
- klasėje `lt.codeacademy.learn.Application`

Pavyzdys
```java
package lt.codeacademy.learn;

import lt.codeacademy.learn.services.EmailService;

public class Application {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        emailService.checkConnection();
    }
}
```

</p>
</details>

#### protected

<details><summary>Išskleisti</summary>
<p>

Metodas, kuris yra `protected` yra prieinamas tik klasėse, kurios yra tame pačiame pakete arba tą klasę paveldinčiose klasėse, kurios yra kituose paketuose.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    protected int getCounter() {
        return 1;
    }
}
```

Šiuo atveju taip pat turime paveldėjimą:
```
+-------------+
| BaseFactory |
+------^------+
       |
       |
       |
+------+-------+
| EmailFactory |
+--------------+
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` metodą `getCounter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`, nes tas pats paketas
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`, nes klasė `EmailFactory` paveldi 'BaseFactory'

Pavyzdys:
```java
package lt.codeacademy.learn.factories.email;

import lt.codeacademy.learn.factories.BaseFactory;

public class EmailFactory extends BaseFactory {
    public EmailFactory() {
        getCounter();
    }
}
```

</p>
</details>

#### private

<details><summary>Išskleisti</summary>
<p>

Metodas, kuris yra `private` yra prieinamas tik toje pačioje klasėje.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    private int getCounter() {
        return 1;
    }

    public void callCounter() {
        getCounter();
    }
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` metodą `getCounter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė

</p>
</details>

#### *package-private*

<details><summary>Išskleisti</summary>
<p>

Metodas, kuris neturi prirašyto modifikatoriaus (vadinama *package-private*) yra prieinamas tik tame pačiame pakete esančioms klasėms.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    int getCounter() {
        return 1;
    }
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` metodą `getCounter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`, nes tas pats paketas

Pavyzdys:
```java
package lt.codeacademy.learn.factories;

public class BaseFactory2 {

    public void someMethod() {
        BaseFactory b = new BaseFactory();
        b.getCounter();
    }
}
```

</p>
</details>

### Klasės kintamasis
#### public

<details><summary>Išskleisti</summary>
<p>

Klasės kintamasis, kuris yra `public` yra prieinamas iš visur, nepaisant to, kuriame pakete ji yra.

```java
public class EmailService {
    public Object smtpConnection;
}
```

Klasės `lt.codeacademy.learn.services.EmailService` kintamąjį `smtpConnection` galime pasiekti:
- klasėje `lt.codeacademy.learn.services.EmailService`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`
- klasėje `lt.codeacademy.learn.services.GoogleService`
- klasėje `lt.codeacademy.learn.Application`

Pavyzdys
```java
package lt.codeacademy.learn;

import lt.codeacademy.learn.services.EmailService;

public class Application {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        Object smtp = emailService.smtpConnection;
    }
}
```

</p>
</details>

#### protected

<details><summary>Išskleisti</summary>
<p>

Klasės kintamasis, kuris yra `protected` yra prieinamas tik klasėse, kurios yra tame pačiame pakete arba tą klasę paveldinčiose klasėse, kurios yra kituose paketuose.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    protected int counter;
}
```

Šiuo atveju taip pat turime paveldėjimą:
```
+-------------+
| BaseFactory |
+------^------+
       |
       |
       |
+------+-------+
| EmailFactory |
+--------------+
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` kintamąjį `counter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`, nes tas pats paketas
- klasėje `lt.codeacademy.learn.factories.email.EmailFactory`, nes klasė `EmailFactory` paveldi 'BaseFactory'

Pavyzdys:
```java
package lt.codeacademy.learn.factories.email;

import lt.codeacademy.learn.factories.BaseFactory;

public class EmailFactory extends BaseFactory {
    public EmailFactory() {
        System.out.println(counter);
    }
}
```

</p>
</details>

#### private

<details><summary>Išskleisti</summary>
<p>

Klasės kintamasis, kuris yra `private` yra prieinamas tik toje pačioje klasėje.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    private int counter;

    public void increaseCounter() {
        counter++;
    }
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` kintamąjį `counter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė

</p>
</details>

#### *package-private*

<details><summary>Išskleisti</summary>
<p>

Klasės kintamasis, kuris neturi prirašyto modifikatoriaus (vadinama *package-private*) yra prieinamas tik tame pačiame pakete esančioms klasėms.

```java
package lt.codeacademy.learn.factories;

public class BaseFactory {
    int counter;
}
```

Klasės `lt.codeacademy.learn.factories.BaseFactory` kintamąjį `counter` galime pasiekti:
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory`, nes ta pati klasė
- klasėje `lt.codeacademy.learn.factories.email.BaseFactory2`, nes tas pats paketas

Pavyzdys:
```java
package lt.codeacademy.learn.factories;

public class BaseFactory2 {

    public void someMethod() {
        BaseFactory b = new BaseFactory();
        b.counter++;
    }
}
```

</p>
</details>

## Užduotys
- [Užduotys](exercises/readme.md)
