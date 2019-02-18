# Java Date Time API

## Turinys
- [LocalDate](#LocalDate)
- [LocalTime](#LocalTime)
- [LocalDateTime](#LocalDateTime)
- [Period](#Period)
- [Duration](#Duration)
- [LocalDate ir LocalTime formatavimas](#LocalDate-ir-LocalTime-formatavimas)
- [LocalDateTime ir JSON](#LocalDateTime-ir-JSON)
- [Nuorodos](#Nuorodos)
- [Užduotys](#Užduotys)

## LocalDate

`LocalDate` reiškia datą ISO formatu `yyyy-MM-dd` be laiko. Data gali būti sukuriama naudojant sistemo laikrodį:
```java
LocalDate localDate = LocalDate.now();
System.out.println(localDate); // 2019-02-15
```
Jei žinome metus, mėnesį ir dieną, taip pat galime sukurti datą:
```java
LocalDate localDate = LocalDate.of(2019, 02, 15);
System.out.println(localDate); // 2019-02-15
```
arba
```java
LocalDate localDate = LocalDate.parse("2019-02-15");
System.out.println(localDate); // 2019-02-15
```

Prie turimos Java datd galime pridėti arba iš jos atimti dienas, savaites, mėnesius ir metus.

```java
LocalDate localDate = LocalDate.parse("2019-02-15");

LocalDate tomorrow = localDate.plusDays(1);

System.out.println(tomorrow); // 2019-02-16

LocalDate yesterday = localDate.minusMonths(2);

System.out.println(yesterday); // 2018-12-15
```

Taip pat galima naudoti `ChronoUnit` enum'ą:

```java
LocalDate previousMonthSameDay = LocalDate.parse("2019-02-15").minus(1, ChronoUnit.DECADES);

System.out.println(previousMonthSameDay); // 2009-02-15
```

Galima gauti savaitės ir mėnesio dieną:
```java
DayOfWeek dayOfWeek = LocalDate.parse("2018-12-15").getDayOfWeek();
System.out.println(dayOfWeek); // SATURDAY

int fifteen = LocalDate.parse("2018-12-15").getDayOfMonth();
System.out.println(fifteen); // 15
```

Galime gauti požymį, ar tai yra keliamieji metai:
```java
boolean leapYear = LocalDate.parse("2018-12-15").isLeapYear();

System.out.println(leapYear); // false
```

Galima patikrinti, ar viena data yra vėlesnė už kitą:

```java
boolean notBefore = LocalDate.parse("2018-12-15").isBefore(LocalDate.parse("2018-12-14"));

System.out.println(notBefore); // false

boolean isAfter = LocalDate.parse("2018-12-15").isAfter(LocalDate.parse("2018-12-14"));

System.out.println(isAfter); // true
```

Galime gauti dienos pradžio laiką:
```java
LocalDateTime beginningOfDay = LocalDate.parse("2019-02-15").atStartOfDay();

System.out.println(beginningOfDay); // 2019-02-15T00:00
```
arba mėnesio pradžios datą
```java
LocalDate firstDayOfMonth = LocalDate.parse("2019-02-15").with(TemporalAdjusters.firstDayOfMonth());

System.out.println(firstDayOfMonth); //2019-02-01
```

## LocalTime

`LocalTime` yra laika sbe datos.

```java
LocalTime now = LocalTime.now();

System.out.println(now); // 23:23:17.594
```

Galima nurodyti tikslų laiką:

```java
LocalTime sixThirty = LocalTime.parse("06:30");

System.out.println(sixThirty); // 06:30
```
arba
```java
LocalTime sixThirty = LocalTime.of(6, 30);

System.out.println(sixThirty); // 06:30
```

Galime nurodyti prie turimo laiko pridėti laiko vienetą naudojant `ChronoUnit`:
```java
LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);

System.out.println(sevenThirty); // 07:30
```

Galima gauti laiko dalį - valandą, minutę, sekundė ir t.t.:
```java
LocalTime time = LocalTime.parse("06:30");
int hour = time.getHour();
int minute = time.getMinute();

System.out.println(hour); // 6
System.out.println(minute); // 30
```

Galima patikrinti, ar vienas laikas yra ankstesnis už kitą:
```java
boolean isBefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

System.out.println(isBefore); // true

boolean isAfter = LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"));

System.out.println(isAfter); // false
```

Galima gauti minimalų ir makslimalų laiką:
```java
System.out.println(LocalTime.MIN); // 00:00
System.out.println(LocalTime.MAX); // 23:59:59.999999999
```

## LocalDateTime

`LocalDateTime` yra data su laiku.

```java
LocalDateTime now = LocalDateTime.now();

System.out.println(now); // 2019-02-15T23:38:27.859

LocalDateTime now1 = LocalDateTime.of(2019, Month.FEBRUARY, 15, 23, 39);

System.out.println(now1); // 2019-02-15T23:39

LocalDateTime now2 = LocalDateTime.parse("2019-02-15T23:39:00");

System.out.println(now2); // 2019-02-15T23:39
```

Galima naudoti `plus` ir `minus` metodus:
```java
LocalDateTime now = LocalDateTime.parse("2019-02-15T23:39:00");

now = now.plusDays(1);
now = now.minusHours(5);

System.out.println(now); // 2019-02-16T18:39
```

## Period 

Galime paskaičiuoti periodą tarp dviejų datų:
```java
LocalDate now = LocalDate.parse("2019-02-15");
LocalDate nextWeek = now.plus(Period.ofDays(7));

long seven = Period.between(now, nextWeek).getDays();

System.out.println(seven); // 7

seven = ChronoUnit.DAYS.between(now, nextWeek);

System.out.println(seven); // 7
```

## Duration

Galime paskaičiuoti trukmę tarp dviejų laikų:
```java
LocalTime initialTime = LocalTime.of(6, 30, 0);
LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

long thirty = Duration.between(initialTime, finalTime).getSeconds();

System.out.println(thirty); // 30

thirty = ChronoUnit.SECONDS.between(initialTime, finalTime);

System.out.println(thirty); // 30
```

Naudojant `Duration` galime apskaičiuoti per kiek laiko programa atliko veiksmus:
```java
LocalTime startTime = LocalTime.now();

for (int i = 0; i < 1000000; i++) {
    System.out.println(i);
}

LocalTime endTime = LocalTime.now();

long trukme = Duration.between(startTime, endTime).getSeconds();

System.out.println("Pradžia: " + startTime);        // Pradžia: 13:24:42.666
System.out.println("Pabaiga: " + endTime);          // Pabaiga: 13:24:51.272
System.out.println("Trukmė:  " + trukme + " sec");  // Trukmė:  8 sec
```

## LocalDate ir LocalTime formatavimas

```java
LocalDateTime localDateTime = LocalDateTime.now();

System.out.println(localDateTime); // 2019-02-15T23:30:35.407

String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);

System.out.println(localDateString); // 2019-02-15

String formattedLocalDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

System.out.println(formattedLocalDateTime); // 2019/02/15
```

## LocalDateTime ir JSON

Norint konvertuoti `LocalDateTime` objektą į JSON naudojant `Jackson` turime sukurti datos ir laiko serializerį ir deserializerį.

`LocalDateTimeSerializer` klasė:
```java
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    public LocalDateTimeSerializer() {
        super(LocalDateTime.class);
    }

    protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
```

`LocalDateTimeDeserializer` klasė:
```java
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    protected LocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return LocalDateTime.parse(jsonParser.readValueAs(String.class));
    }
}
```

Objekto su laiku klasė `ObjektasSuLaiku`:
```java
public class ObjektasSuLaiku {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime laikas;

    public ObjektasSuLaiku() {
        this.laikas = LocalDateTime.now();
    }

    public LocalDateTime getLaikas() {
        return laikas;
    }

    public void setLaikas(LocalDateTime laikas) {
        this.laikas = laikas;
    }
}
```

Tokio objekto serializavimo į JSON ir deserializavimo pavyzdys:
```java
ObjektasSuLaiku objektasSuLaiku = new ObjektasSuLaiku();

ObjectMapper mapper = new ObjectMapper();

String jsonString = mapper.writeValueAsString(objektasSuLaiku);

System.out.println(jsonString);     // {"laikas":"2019-02-16T19:26:28.751"}

ObjektasSuLaiku objektasSuLaikuIsJson = mapper.readValue(jsonString, ObjektasSuLaiku.class);

System.out.println(objektasSuLaikuIsJson.getLaikas());  // 2019-02-16T19:26:28.751
```

## Nuorodos
- https://www.baeldung.com/java-8-date-time-intro
- https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
- https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html


## Užduotys
- [Užduotys](exercises/readme.md)