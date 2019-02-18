# Regex

## Turinys
- [Regex](#Regex)
- [Regex sudarymo taisyklės](#Regex-sudarymo-taisyklės)
- [Bendrieji simboliai](#Bendrieji-simboliai)
- [Metasimboliai](#Metasimboliai)
- [Kiekybiniai simboliai](#Kiekybiniai-simboliai)
- [Grupavimas ir nuorodos](#Grupavimas-ir-nuorodos)
- [String metodų naudojimas su regex](#String-metodų-naudojimas-su-regex)
- [Nuorodos](#Nuorodos)
- [Užduotys](#Užduotys)

## Regex

Regex yra santruma reškianti reguliarią išrašką.
Regex apibrėžia paieškos šabloną eilutėje arba tekste. 
Paieškos šablonas gali būti bet kas nuo simbolio ar fiksuotos eilutės iki sudėtingos išraiškos su specialiais simboliais.

## Regex sudarymo taisyklės

## Bendrieji simboliai

 - `.` atitinka bet kokį simbolį:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll(".", "#");
    System.out.println(text);
                // ###########################################
    ```

- `^regex` suranda regex, kuris turi eilutės pradžios simbolį:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("^fox", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy dog
    text = text.replaceAll("^The", "#");
    System.out.println(text);
                // # quick brown fox jumps over the lazy dog
    ```

- `regex$` suranda regex, kuris turi eilutės pabaigos simbolį:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("fox$", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy dog
    text = text.replaceAll("dog$", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy #
    ```

- `[abc]` suranda simbolius *a*, *b* arba *c*:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("[abc]", "#");
    System.out.println(text);
                // The qui#k #rown fox jumps over the l#zy dog
    ```

- `[abc][kz]` suranda simbolius *a*, *b* arba *c*, po kurių būtinai turi sekti raidė *k* arba *z*:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("[abc][kz]", "#");
    System.out.println(text);
                // The qui# brown fox jumps over the l#y dog
    ```

- `[^abc]` regex priešingas `[abc]`, t.y. tinka bet koks simbolis išskyrus *a*, *b* arba *c*:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("[^abc]", "#");
    System.out.println(text);
                // #######c##b#########################a######
    ```

- `[a-d1-7]` tinka visos raidės nuo *a* iki *z* ir skaičiai nuo *1* iki *7*:
    ```java
    String text = "The quick brown fox jumps over the lazy dog1230";
    text = text.replaceAll("[a-d1-7]", "#");
    System.out.println(text);
                // The qui#k #rown fox jumps over the l#zy #og###0
    ```

- `x|y|z` tinka *x*, *y* arba *z* raidės:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("x|y|z", "#");
    System.out.println(text);
                // The quick brown fo# jumps over the la## dog
    ```

- `zy` tinka raidės *z* ir *y* sekančios viena po kitos:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("zy", "#");
    System.out.println(text);
                // The quick brown fox jumps over the la# dog
    ```

- `^` tinka eilutės pradžios simbolis:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("^", "#");
    System.out.println(text);
                // #The quick brown fox jumps over the lazy dog
    ```

- `$` tinka eilutės pabaigos simbolis:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("$", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy dog#
    ```

## Metasimboliai

- `\d` tinka bet koks skaitmuo, atitinka regex `[0-9]`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog123";
    text = text.replaceAll("\\d", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy dog###
    ```

- `\D` tinka bet koks skibolis, kuris yra ne skaitmuo, atitinka regex `[^0-9]`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog123";
    text = text.replaceAll("\\D", "#");
    System.out.println(text);
                // ###########################################123
    ```

- `\s` tinka tarpo simboliai:
    ```java
    String text = "The quick brown fox jumps over the lazy dog   ";
    text = text.replaceAll("\\s", "#");
    System.out.println(text);
                // The#quick#brown#fox#jumps#over#the#lazy#dog###
    ```

- `\S` tinka bet kokie simboliai išsyrus tarpą:
    ```java
    String text = "The quick brown fox jumps over the lazy dog   ";
    text = text.replaceAll("\\S", "#");
    System.out.println(text);
                // ### ##### ##### ### ##### #### ### #### ###   
    ```

- `\w` tinka simboliai sudarantys žodžius, atitinka regex `[a-zA-Z_0-9]`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\w", "#");
    System.out.println(text);
                // ### ##### ##### ### ##### #### ### #### ###
    ```

- `\W` tinka visi simboliai, kurie nesudaro žodžių, atitinka regex `[^\w]`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\W", "#");
    System.out.println(text);
                // The#quick#brown#fox#jumps#over#the#lazy#dog
    ```

- `\b` randa žodžio ribas:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\b", "#");
    System.out.println(text);
                // #The# #quick# #brown# #fox# #jumps# #over# #the# #lazy# #dog#
    ```

## Kiekybiniai simboliai

- `{X}` kartojasi X kartų. Pvz. `\d{3}` tinka trys iš eilės sekantys skaitmenys:
    ```java
    String text = "The quick brown fox jumps over the lazy dog 1234";
    text = text.replaceAll("\\d{3}", "#");
    System.out.println(text);
                // The quick brown fox jumps over the lazy dog #4
    ```
    arba `\w{5}` tinka visi 5 simbolių ilgio žodžiai:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\w{5}", "#");
    System.out.println(text);
                // The # # fox # over the lazy dog
    ```

- `{X,Y}` kartojasi nuo X iki Y kartų. Pvz. `\w{4,5}` tinka visi žodžiai, kurių ilgis nuo 4 iki 5 simbolių.
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\w{4,5}", "#");
    System.out.println(text);
                // The # # fox # # the # dog
    ```

- `*` kartojasi 0 arba daugiau kartų, atitinka regex `{0,}`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog bb";
    text = text.replaceAll("[b*]", "#");
    System.out.println(text);
                // The quick #rown fox jumps over the lazy dog ##
    ```

- `+` kartojasi 1 arba daugiau kartų, atitinka regex `{1,}`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog bb";
    text = text.replaceAll("[b+]", "#");
    System.out.println(text);
                // The quick #rown fox jumps over the lazy dog ##
    ```

- `?` kartojasi 0 arba 1 kartą, atitinka regex `{0,1}`:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\s.?ro..", "#");
    System.out.println(text);
                // The quick# fox jumps over the lazy dog
    ```

## Grupavimas ir nuorodos

Galima šabloną sugrupuoti, pvz. šabloną `\w\s+[\.,]` pakeisti į `(\w)(\s+)([\.,])`, kurį sudaro trys grupės. Tada tas grupes galima naudoti pvz. `replaceAll` metode. Turime tekstą, kuriame po žodžių yra tarpas ir kablelis. Norime pašalinti tarpus prieš kablelius:
```java
String pattern = "(\\w)(\\s+)([\\.,])";
String text = "The quick brown fox , jumps over , the lazy dog";
text = text.replaceAll(pattern, "$1$3");
System.out.println(text);
            // The quick brown fox, jumps over, the lazy dog
```

## String metodų naudojimas su regex

- `matches("regex")` galime patikrinti ar toks regex yra tekste:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    System.out.println(text.matches(".*brown.*")); // true
    ```

- `split("regex")` galime suskaidyti eilutę į keletą eilučių ties regex atitinkančiomis teksto vietomis:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    String[] textArray = text.split("\\s");
    for (String s : textArray) {
        System.out.println(s);
    }
    //The
    //quick
    //brown
    //fox
    //jumps
    //over
    //the
    //lazy
    //dog
    ```

- `replaceFirst("regex", "replacement")` galime pakeisti pirmą teksto vietą, kuri tenkina regex:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceFirst("\\s", "#");
    System.out.println(text); // The#quick brown fox jumps over the lazy dog
    ```

- `replaceAll("regex", "replacement")` galime pakeisti visas teksto vietas, kurios tenkina regex:
    ```java
    String text = "The quick brown fox jumps over the lazy dog";
    text = text.replaceAll("\\s", "#");
    System.out.println(text); //The#quick#brown#fox#jumps#over#the#lazy#dog
    ```

Telefono numerio tikrinimas:
```java
String phone1 = "+37061234567";
String phone2 = "861234567";
String phone3 = "+61234567";

String pattern = "^(\\+370|8)\\d{8}$";
System.out.println(phone1.matches(pattern)); // true
System.out.println(phone2.matches(pattern)); // true
System.out.println(phone3.matches(pattern)); // false
```

## Nuorodos
- https://www.oreilly.com/library/view/java-cookbook-3rd/9781449338794/ch04.html
- Įrankis Regex patikrinti: https://regex101.com/

## Užduotys
- [Užduotys](exercises/readme.md)