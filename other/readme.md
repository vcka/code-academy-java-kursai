
## Nr. 1

### Užduotis

1. Panaudojant `HttpClient` iškvieskite https://jsonvat.com/ ir gaukite šalių PVM duomenis.

2. Remiantis JSON struktūra sukurkite atitinkamas klases su reikiamais laukais. Naudojant *Jackson* `ObjectMapper` deserializuokite JSON į Java objektus. Klasės turi būti logiškai išskirstytos į paketus.

3. JSON esančią datą deserializuokite į `LocalDate`.

4. Naudojant srautus tarp duomenų palikite tik galiojančius periodus, t.y. kai šalis turi kelis periodus, turi likti tik naujausias. Surūšiuokite pagal šalies pavadinimą ir atspausdinkite tokiu formatu:
```
| Country         | VAT |
-------------------------
| Austria         |  20 |
| Belgium         |  21 |
| Bulgaria        |  20 |
| Croatia         |  25 |
| Cyprus          |  19 |
...
```

5. Sukurkite klasę `CustomVatInfo` su laukais `name`, `reduced1`, `reduced2`, `standard` ir kitais, jei reikia. Transformuokite `Rate` klasės objektus į `CustomVatInfo`. Turite gauti `CustomVatInfo` sąrašą

6. `CustomVatInfo` sąrašą sugrupuokite pagal `standard` ir atspausdinkite tokiu formatu:
```
17:
    Luxembourg
18:
    Malta
19:
    Cyprus
    Romania
    Germany
...
```


