# Kolekcijų karkasas (Collections framework)
„Java“ kolekcijų karkasas yra klasių ir sąsajų (interface) rinkinys, įgyvendinamas per panaudojamas kolekcijų duomenų struktūras. Kolekcija yra objektas, turintis nuorodą į objektų grupę ir pateikiantis rinkinį metodų jiems valdyti. Kolekcijos yra panašios į masyvus, tačiau, skirtingai nei masyvai, jos nėra fiksuoto dydžio. Jų talpa automatiškai keičiasi, pridėjus ar pašalinus objektus.

 Kolekcijų karkasas susideda iš:
- **Sąsajų (interfaces)** - abstrakčiųjų duomenų tipų, atspindinčių skirtingas kolekcijas ir pateikiančių vieningą metodų rinkinį, kuris leidžia manipuliuoti kolekcijose talpinamais objektais, nepriklausomai naudojamos kolekcijos tipo.
-	**Įgyvendinimų (Implementations)** - konkrečių abstrakčių kolekcijų sąsajų įgyvendinimų.
-	 **Pagalbinių funkcijų**  - statinių metodų, atliekančių naudingas funkcijas su kolekcijomis, pvz. kolekcijos objektų rūšiavimas.

`java.util.Collection`yra viena pagrindinių kolekcijų sąsajų. Beveik visi kolekcijos objektai paveldi šią sąsają. Esminiai šios sąsajos palikuonys:
-	Sąrašas (List)
-	Komplektas (Set)
-	Eilė (Queue)

Kita reikšminga sąsaja yra `java.util.Map`. Šį sąsaja nėra tikra kolekcija, nes ji neįgyvendina java.util.Collection sąsajos. Tačiau ji pateikia metodus, kurie grąžina sąsajos turinį kolekcijos objektuose. Tai leidžia java.util.Map sąsaja manipuliuoti kaip kolekcija.

#### Pagrindiniai `java.util.Collection` sąsajos metodai
```
add(E e)
```
Skirtas pridėti E tipo elementui į kolekciją
```
addAll(Collection<? extends E> c)
``` 
Prideda visus nurodytos kolekcijos elementus į šią kolekciją
```
clear()
```
Pašalina visus elementus, esančius šioje kolekcijoje
```
contains(Object o)
```
Grąžina `true`, jei ši kolekcija talpina nurodyta elementą
```
isEmpty()
```
Grąžina `true` jei ši kolekcija neturi jokių elementų
```
size()
```
Grąžina elementų, esančių kolekcijoje, skaičių
```
remove(Object o)
```
Jei toks elementas egzistuoja, pašalina jį iš kolekcijos 
### Pagrindiniai kolekcijų tipai

### Sąrašas (List) 
Sąrašas - vienas dažniausiai naudojamų kolekcijų tipų. Sąrašo kolekcijos objektai įgyvendina `java.util.List` sąsają. Sąrašas vaizduoja surikiuotą elementų seką. Kadangi sąraše svarbi elementų tvarka, naudotojas gali pasiekti saugomus elementus pagal indeksą arba ieškoti specifinio elemento sąraše. Sąrašo ideologija nedraudžia jam turėti pasikartojančių elementų bei `null` reikšmių, tačiau nėra garantuota, kad kažkas neįgyvendins sąrašo, draudžiančio dublikatus. Sąrašai, kaip ir masyvai, prasideda nuo 0 indekso.

#### `java.util.List` sąsają papildo `java.util.Collection` šiais metodais: 
```
get(int index)
```
Grąžina elementą esantį nurodytame indekse
```
set(int index, E element)
```
Pakeičia nurodytame indekse esantį elementą duotuoju
```
add(int index, E element)
```
Įdeda elementą į nurodytą indeksą ir pastumia visus po jo išsidėsčiusius elementus per vieną poziciją
```
remove(int index)
```
Pašalina nurodytame indekse esantį elementą

#### `java.util.List` įgyvendinimai
Dažniausiai naudojamos klasės, įgyvendinančios sąrašą yra `java.utils.ArrayList` ir `java.utils.LinkedList`. 

**`ArrayList`** implementacija naudoja masyvą elementų saugojimui. `ArrayList` objekto inicializacijos metu sukuriamas fiksuoto dydžio masyvas. Iškvietus `add` metodą su nauju elementu, elementas išsaugomas sukurtame masyve. Pasibaigus laisvai vietai masyve, `ArrayList` objektas automatiškai sukurs naują, pusantro karto didesnį masyvą, nukopijuos į jį seno masyvo elementus ir pridės naują elementą. 

Kita populiari sąrašo implementacija yra **`LinkedList`**. Tai [Linked List](https://en.wikipedia.org/wiki/Linked_list) duomenų struktūros įgyvendinimas „Java“ kalboje. Kiekvienas `LinkedList` elementas turi sekančio elemento adresą, taip kartu jie sudaro elementų seką. Pridėjus naują elementą į `LinkedList` kolekciją,  paskutinis kolekcijos elementas  gauna nuorodą į naująjį elementą.
Vizualiai tai atrodo taip:
```
[elementas1]-->[elementas2]-->null

[elementas1]-->[elementas2]-->[elementas3]-->null
```
`ArrayList` kolekcija daug efektyvesnė norint pasiekti kolekcijos elementus. Masyvo elementai kompiuterio atmintyje yra saugomi vienas šalia kito, todėl ši kolekcija yra daug efektyvesnė skaitant visus kolekcijos elementus. Taip pat `ArrayList` kolekcija yra daug greitesnė norint gauti specifinio indekso elementą. `LinkedList` kolekcijoje norint gauti *n* indekso elementą, einama per visus elementus kol pasiekiamas norimas elementas. `ArrayList` kolekcijoje tai vyksta daug greičiau – tiesiog paimamas  *n* indekso elementas iš masyvo. Dauguma atvejų yra naudojama `ArrayList` sąrašo implementacija. `LinkedList` kolekcija naudojama labai retais atvejais - kai svarbus našumas įterpiant, pašalinant elementus iš sąrašo. `LinkedList` atveju norint įterpti elementą į sąrašo *n* poziciją, elementas pozicijoje *n-1* pradeda rodyti į naują elementą, o naujasis elementas pradeda rodyti į elementą, buvusį *n* pozicijoje.
Vizualiai įterpimas atrodo taip:  
```
                   [naujas elementas]-->null
 [elementas N-1]-->[elementas N]-->null
 
 [elementas N-1]-->[naujas elementas]-->null  
                   [elementas N]-->null
           
 [elementas N-1]-->[naujas elementas]-->[elementas N]-->null
```
Norint pašalinti elementą indeksu *n*,  elementas *n-1**  nustoja rodyti į jį ir pradeda rodyti į elementą *n+1*
```
 [elementas N-1]-->[elementas N]-->[elementas N+1]-->null
 
                   [elementas N]-->null 
 [elementas N-1]-->[elementas N+1]-->null
```
`ArrayList` kolekcijoje tai vyksta daug sudėtingiau. Tiek įterpimo, tiek pašalinimo atveju yra sukuriamas naujas masyvas ir nukopijuojami visi elementai bei nauja reikšmė arba elementai be pašalintos reikšmės. 

**Dauguma atvejų reikėtų naudoti `ArrayList` kolekciją. `LinkedList` įgyvendinimas naudojamas tik išskirtiniais atvejais, kai yra svarbus objektų įterpimo į vidurį arba pašalinimo greitis.** 

### Žemėlapis (Map)
Žemėlapio tipo kolekcijos įgyvendina `java.util.Map` sąsają. Žemėlapio kolekcijos saugo reikšmes pagal paduotą raktą. Raktas yra naudojamas pridedant ir pasiimant reikšmes. Žemėlapis negali turėti pasikartojančių raktų, kiekvienas raktas gali rodyti tik į vieną reikšmę.

Nors `java.util.Map` sąsaja neįgyvendina `java.util.Collection` sąsajos, žemėlapis yra laikomas kolekcijų karkaso dalimi, nes visi `java.util.Map` įgyvendinimai pateikia 3 metodus, grąžinančius žemėlapio turinį kaip kolekcijas:
-	Metodas grąžinantis visas žemėlapio reikšmes kaip komplektą (set)
-	Metodas grąžinantis žemėlapio reikšmių kolekciją
-	Metodas grąžinantis žemėlapio raktų ir reikšmių porų kolekciją

Žemėlapio sąsaja yra naudojama norint efektyviai gauti  specifinį elementą. Žemėlapio sąsaja pateikia metodus leidžiančius ieškoti reikiamo elemento pagal duotą raktą. Todėl, jei dirbama ne su visais kolekcijos elementais iš karto, o norima pasiekti specifinį elementą, jį naudoti yra efektyviau. Tikrinimui, ar toks raktas jau egzistuoja, žemėlapio kolekcija naudoja `hashCode()` ir `equals()` metodus, todėl objektai, naudojami kaip raktas, turėtų perrašyti šiuos metodus.

#### Žemėlapio sąsajai būdingi metodai
```
containsKey(Object key)
```
Grąžina `true` jei toks raktas egsizstuoja kolekcijoje	
```
containsValue(Object value)
```
Grąžina `true` jei nors vienas raktas rodo į nurodytą elementą
```
put(K key, V value)
```
Susieja nurodytą raktą su duota reikšme šiame žemėlapyje
```
get(Object key)
```
Grąžina nurodyto rakto elementą
```
remove(Object key)
```
Pašalina reikšmę, susietą su nurodytu raktu
```
keySet()
```
Grąžina žemėlapio raktų kolekciją
```
values()
```
Grąžina žemėlapio reikšmių kolekciją
```
entrySet()
```
Grąžina žemėlapio raktų ir reikšmių porų kolekciją

Yra du pagrindiniai žemėlapio įgyvendinimai: `java.util.HashMap` ir `java.util.TreeMap`.

#### `java.util.HashMap`
`HashMap` įgyvendinimas yra paremtas [*hash* lentele](https://en.wikipedia.org/wiki/Hash_table). Dauguma šio įgyvendinimo operacijų yra labai greitos, tačiau šis įgyvendinimas neužtikrina nekintančios saugojamų elementų tvarkos
#### `java.util.TreeMap`
`Tree map` įgyvendinimas yra paremtas [Raudono-Juodo medžio]( https://en.wikipedia.org/wiki/Red%E2%80%93black_tree) duomenų struktūra. Šio įgyvendinimo metodai nėra tokie greiti kaip `HashMap` įgyvendinimo, tačiau saugojami elementai yra surikiuoti ir jų tvarka nekinta. Taip pat šis įgyvendinimas negali turėti rakto su `null` reikšme. 

### Komplektas (Set)
Komplektas yra kolekcija, įgyvendinanti `java.util.Set` sąsają, neturinčią vienodų elementų. Tiksliau, komplektas neturi elementų porų *e1* ir *e2* kur *e1 = e2* ir daugiausiai vieną `null` reikšmę. Kaip matoma iš pavadinimo, komplektas yra [matematinio komplekto](https://en.wikipedia.org/wiki/Set_(mathematics)) įgyvendinimas „Java“ programavimo kalboje.

Komplektai paprastai naudojami vietoje sąrašų, norint užtikrinti, kad kolekcijoje nebus pasikartojančių elementų. Užtikrinti, kad komplekte dar nėra tokio elemento, naudojamas `equals()` metodas, todėl norint užtikrinti, kad komplektas veikia taip kaip norima, komplekte saugomų objektų `equals()` ir `hashCode()` metodai turėtų būti teisingai perrašyti (overriden).

Vienas iš komplekto naudojimo atvejų – norint pašalinti pasikartojančias reikšmes iš kolekcijos:
```
public static List<String> removeDuplicateNames(List<String> namesWithDuplicates) {
        final Set<String> uniqueNames = new HashSet<>(namesWithDuplicates);
        return new ArrayList<>(uniqueNames);
}
```

Komplekto įgyvendinimai, į kuriuos reikėtų atkreipti dėmesį yra `HashSet` ir `TreeSet`. 

 - **Įgyvendinimas `java.util.HashSet`** naudoja *hash* lentelę (tiksliau `HashMap` kolekciją) elementų unikalumui užtikrinti. Kaip ir `HashMap` kolekcijos, šio įgyvendinimo metodai yra greiti, tačiau ši kolekcija neužtikrina griežtos elementų tvarkos. 

- **Įgyvendinimas `java.util.TreeSet`** naudoja `TreeMap` kolekciją elementų unikalumui užtikrinti. Todėl jis nėra toks greitas kaip `HashSet` įgyvendinimas, tačiau užtikrina surikiuotus kolekcijos elementus.

### Pagalbinės funkcijos
Kolekcijų karkasas pateikia rinkinį statinių funkcijų, kurios manipuliuoja arba grąžina kolekcijas. Šį rinkinį sudaro:
- Funkcijos, kurios grąžina naują kolekciją paremtą nurodyta kolekcija
- Funkcijos, keičiančios kolekcijos sekos tvarką (pvz. rūšiuoja elementus didėjimo tvarka) 
- Funkcijos, grąžinančios specifinius kolekcijos elementus (pvz. grąžina didžiausią sąrašo skaičių)

Šios pagalbinės funkcijos yra klasėse `java.util.Collections` bei `java.util.Arrays`.

#### `java.util.Collections`
Klasė `java.util.Collections` pateikia tokias funkcijas:
```
emptyList()
emptyMap()
emptySet()
```
Grąžinančias tuščią nurodytą kolekciją
```
fill(List<? super T> list, T obj)  
```
Pakeičia visus sąrašo elementus, nurodytu elementu
```
max(Collection<? extends T> coll)
```
Grąžina didžiausią kolekcijos elementą (visi kolekcijos elementai turi įgyvendinti `Comparable` sąsają)
```
copy(List<? super T> dest, List<? extends T> src) 
```
Nukopijuoja sąrašo *src* elementus į *dest* sąrašą

`Collections` klasė turi dar daug kitų naudingų funkcijų, kurias vertėtų panagrinėti.

#### `java.util.Arrays`
Klasė `java.util.Arrays` pateikia funkcijas, skirtas dirbti su masyvais, tokias kaip masyvo elementų rūšiavimas arba reikiamo elemento paieška. Tačiau ši klasė turi naudingą ir dažnai naudojamą funkciją dirbant su sąrašais:
```
asList(T... a)
```
Kuri leidžia masyvus konvertuoti į sąrašus arba greitai sukurti sąrašą su nurodytais elementais.
```
String[] raidziuMasyvas = {"a", "b", "c"};
List<String> raidziuSarasas = Arrays.asList(raidziuMasyvas);
raidziuSarasas = Arrays.asList("A", "B", "C");
```

### Patobulintas *for* ciklas (*foreach loop*)
Patobulintas *for* ciklas leidžia pereiti per kiekvieną masyvo/kolekcijos elementą be poreikio nurodyti *for* ciklo salygą.

Paprasto ciklo pavyzdys: 
```
char[] vowels = {'a', 'e', 'i', 'o', 'u'};
for (int i = 0; i < vowels.length; ++ i) {
         System.out.println(vowels[i]);
}
```
Patobulinto ciklo pavyzdys:
```
char[] vowels = {'a', 'e', 'i', 'o', 'u'};
for (char item: vowels) {
         System.out.println(item);
}
```
Abejų ciklų rezultatas bus toks pats:
```
a
e
i
o
u
```
Patobulinto ciklo sintaksė yra lengviau suprantama ir greičiau parašoma, todėl, kai nėra svarbus iteracijos indeksas, vertėtų naudoti patobulintą *for* ciklą.
#### *foreach* ciklo sintaksė
```
for(KolekcijosDuomenųTipas elementas : kolekcija) {
    ...
}
```
Sintaksėje aukščiau:
-	`kolekcija` yra kolekcijos arba masyvo objektas, per kurio elementus bus einamas ciklas
-	`elementas` yra vienas kolekcijos elementas
-	`KolekcijosDuomenųTipas` yra elementų, saugomų kolekcijoje, tipas

### Užduotys
- [Užduotys su kolekcijomis](exercises)

### Šaltiniai
- https://en.wikipedia.org/wiki/Java_collections_framework
- https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
