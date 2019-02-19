
## Užduotys: Java 9-11

## Nr. 1

### Užduotis

Surasti `jshell` įrankį ir atlikti keletą nesudėtingų Java operacijų:
- sukurti sąrašą
- į sąrašą įdėti keletą elementų
- elementus surūšiuoti ir atspausdinti

## Nr. 2

### Užduotis

Naudojant `List.of()` sukurkite sąrašą su duomenimis. Sukurtas sąrašas yra nemodifikuojamas. 
Padarykite taip, kad į sąrašą galėtumėte įdėti naujų elementų ir atspausdinkite papildytą sąrašą.

## Nr. 3

### Užduotis


Naudodami `HttpClient` ir `GET` užklausą iškvieskite šį adresą `http://api.population.io:80/1.0/population/2019/Lithuania/`.
Atspausdinkite gautą rezultatą. Galite iš JSON formato gautus duomenis paversti į Java objektus ir atspausdinti informaciją struktūrizuotai. 
Daugiau šio serviso metodų: http://api.population.io/

## Nr. 4

### Užduotis

Naudojantis datų iteravimo pavyzdžiu ir `String` klasės metodu `repeat(...)` atspausdinkite visas datas nuo 2019-01-01 iki 2019-02-15 tokiu formatu:

```
2019-01-01
 2019-01-02
  2019-01-03
   2019-01-04
    2019-01-05
     2019-01-06
      2019-01-07
       2019-01-08
        2019-01-09
         2019-01-10
          2019-01-11
           2019-01-12
          2019-01-13
         2019-01-14
        2019-01-15
       2019-01-16
      2019-01-17
     2019-01-18
    2019-01-19
   2019-01-20
  2019-01-21
 2019-01-22
2019-01-23
 2019-01-24
  2019-01-25
   2019-01-26
    2019-01-27
     2019-01-28
      2019-01-29
       2019-01-30
        2019-01-31
         2019-02-01
          2019-02-02
           2019-02-03
          2019-02-04
         2019-02-05
        2019-02-06
       2019-02-07
      2019-02-08
     2019-02-09
    2019-02-10
   2019-02-11
  2019-02-12
 2019-02-13
2019-02-14
```

## Nr. 5

### Užduotis

Sukurkite Map'ą nurodydami kintamojo tipą `var`, į jį įdėkite keletą porų, Map'ą atspausdinkite. Atspausdinkite Map kintamojo tipą.

## Nr. 6

### Užduotis

Sukurkite paprastą Java programą viename faile ir jį paleiskite su Java 11-os versijos komanda `java FailoPavadinimas.java`

## Nr. 7

### Užduotis

Naudojant klasės `TimeUnit` metodą `convert` parašykite programą, kuriai įvedus skaičių (dienų, valandų ir pan.) atspausdins tą patį laiką tik kitais matavimo vienetais. Pavyzdžiui įvedus 15 dienų programa turi atspausdinti:
```
15 dienu
360 valandu
21600 minuciu
1296000 sekundziu
1296000000 milisekundziu
1296000000000 mikrosekundziu
1296000000000000 nanosekundziu
```

## Nr. 8

### Užduotis

Parašykite vieną kodo eilutę naudojant Java 11-os versijos naujus `String` metodus, kad gautumėte:
```
|_
_|
|_
_|
|_
_|
|_
_|
|_
_|
```
Gautą rezultatą įrašykite į failą naudojant `Files` metodą `writeString`.