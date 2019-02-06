# Kolekcijų karkasas: užduotis

### 1. Užduotis
-	Sukurkite klasę `Payment` su laukais *id, name, paymentDate, recipientId, payerId*

-	Sukurkite statinį metodą, kuris priimtų int tipo parametrą. Parametras nurodo, kiek `Payment` reikšmių reikia sugeneruoti. Dinamiškai generuokite `Payment` objektus ir grąžinkite sąrašą su nurodytu reikšmių kiekiu 

-	Padarykite, kad generuojami *id* laukai kartais pasikartotų

-	Naudokite metodo grąžinamus duomenis sukurti *ArrayList* bei *LinkedList* sąrašus (duomenys abiejose kolekcijose turi būti tokie patys). Sukurtos kolekcijos turėtų būti įvairaus dydžio - nuo kelių iki kelių tūkstančių elementų 

-	Paskaičiuokite *List* sąsajos metodų (add, delete, get) vykdymo laikus skirtingiems įgyvendinimams. Atkreipkite dėmesį, kaip laikai skiriasi nuo sąrašo dydžio

-	Paverskite sąrašą į rinkinį, įsitikinkite, kad besikartojančios reikšmės dingsta


### 2. Užduotis 

- Sukurkite klasę `PeopleDatabase` 

- Pridėkite jai `Map` tipo lauką ir duokite jam reikšmingą pavadinimą 

- Klasės inicializavimo metu užpildykite lauką duomenimis apie žmones, kur raktas yra `String` tipo asmens kodas, o reikšmė yra `String` tipo žmogaus vardas. Tegul vardai būna reikšmingi, o asmens kodai atitinka reikalavimus
> Bonus: sukurkite funkciją, generuojančią atsitiktinius ir teisingus asmens kodus 

- Sukurkite metodą, kuris grąžintų visų žemėlapyje esančių žmonių vardus ir kitą metodą, kuris grąžintų visus asmens kodus 

- Sukurkite metodą, kuris priima vieną parametrą – asmens kodą ir grąžina asmens kodo savininko vardą

- Sukurkite metodą, kuris grąžintų visus unikalius vardus

- Patobulinkite metodą, grąžinantį visus žmonių vardus taip, kad jis grąžintų sąrašą sudarytą iš asmens kodo + vardo elementų

- Sukurkite metodą, kuris grąžintų žemėlapį su visais asmens kodais, sudėtais pagal raktus vyras ir moteris

- Sukurkite metodą, kuris priima vieną parametrą - žmogaus vardą ir grąžina sąrašą asmens kodų su tokiu vardu 

- Sukurkite programėlę, naudojančią `PeoplDatabase` klasę. Programėlė paleidimo metu priimtų argumentą – norimo metodo numerį ir atspausdintų iškviesto metodo rezultatą. Jei metodui reikia papildomų parametrų, pridėkite juos kaip papildomus argumentus 

- Argumentas *help* turėtų išspausdinti visus galimus metodus, bei jų iškvietimo numerius

#### Veikimo pavyzdys
Komanda:
```
java uzduotis -h
```
Išspausdina rezultatą:
```
1) Metodas gauti unikaliems vardas
2) Metodas gauti vardui pagal asmens kodą (papildomas argumentas - asmens kodas) 
```
Komanda: 
```
java uzduotis 1
```
Išspausdina:
```
Jonas
Tomas
Tadas
```
Komanda:
```
Java uzduotis 2 39102110000 
```
Išspausdina:
```
Jonas
```
