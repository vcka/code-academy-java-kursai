# Lygiagretus programavimas (*Concurrency*)
Kompiuterių naudotojams savaime suprantama, kad jų sistemos gali daryti daug dalykų vienu metu. Jie tikisi, kad galės naršyti internete, kol kitos programėlės siunčia failus, groja muziką, spausdina dokumentus. Net ir paprastos programėlės paprastai daro skirtingus dalykus tuo pačiu metu – pavyzdžiui teksto redaktorius reaguoja į klaviatūros bei pelės judesius tuo pat metu redaguodamas tekstą ir atnaujindamas vaizdą. Programinė įranga, galinti daryti daug dalykų vienų metu vadinama *concurrent software* arba lygiagrečia.

Java programavimo kalba sukurta taip, kad galėtų palaikyti lygiagretų programavimą `java.util.concurrent` pakete.

Lygiagrečiame programavime yra du svarbūs vykdymo vienetai – procesai (*processes*) ir gijos (*threads*)

Sistema paprastai turi kelis aktyvius procesus bei gijas, tačiau procesorius, turintis tik vieną vykdymo branduolį, vienu metu gali vykdyti tik vieną giją. Norint pasiekti lygiagretumą, vieno branduolio procesoriuje procesoriaus vykdymo laikas paskirstomas per visas gijas bei procesus. Tokia operacinės sistemos funkcija vadinama *slicing*. 


Procesoriai su keliais branduoliais pagerina lygiagrečių procesų vykdymą, nes kiekvienas branduolys gali vykdyti procesus vienu metu, paraleliai. 

### Procesai
Procesas yra vykdymo aplinka, turinti privačius resursus. Kiekvienas procesas turi sau išskirtą vietą atmintyje. Java programėlė yra operacinės sistemos procesas.

### Gijos
Gijos, kaip ir procesai, sukuria vykdymo aplinką, tačiau jos neturi privačių resursų. Gijos egzistuoja procesuose ir naudoja proceso resursus. Kiekvienas procesas turi bent vieną arba daugiau gijų.

> Java programėlė, kuri po vieną skaito sistemos failus ir apdoroja jų turinį, yra procesas iš vienos gijos. Java internetinis puslapis yra *Multi threaded* procesas, sukuriantis naują giją, kiekvienai naudotojo užklausai.

### Gijų sukūrimas
Gijos sukuriamos naudojant klasę `Thread`. Į klasės konstruktorių reikia paduoti sąsajos `Runnable` įgyvendinimą. `Runnable` klasė turi vieną metodą `public void run()`, kuris yra vykdomas naujoje gijoje, iškvietus `Thread` klasės metodą `start`.
### Thread metodai
`Thread` klasės metodas `sleep` sustabdo klasės veikimą milisekundėmis nurodytam laiko tarpui. 
`sleep` metodas grąžina `InterruptedException`, kuris turi būti suvaldytas, jei gijos veikimas yra sustabdytas iš kitos gijos.

`interrupt` metodas gali būti iškviestas iš kitos gijos, norint nurodyti, kad dabartinis gijos veiksmas turi būti nutrauktas.

`Thread` klasė turi metodą `join` kuris liepia dabartinei gijai palaukti, kol nurodyta gija baigs darbą. Įvykdžius `join` funkciją visi pakeitimai, įvykdyti nurodytoje gijoje, tampa matomi tai gijai, kuri iškvietė minėtą metodą. 

Iki tol veiksmai, vykdomi skirtingose gijose, nėra matomi viena kitai. 

### Sinchronizavimas 
Jei kelios gijos vienu metu dirba su tos pačios klasės laukais, galima tikėtis nenumatytų klaidų. Norint to išvengti naudojama sinchronizacija. Metodai gali būti paženklinti `synchronized` raktažodžiu. Jis nurodo, kad metodas negali būti iškviestas tol, kol jis yra vykdomas kitos gijos. Taip pat, veiksmai, įvykdyti šiuo raktažodžiu pažymėtuose metoduose yra matomi visose gijose. 


### Instrict Locks
Sinchronizacija yra įgyvendinta naudojant užraktą vadinamą *instrict lock* arba *monitor lock*. Kiekvienas objektas turi užraktą, gija, norėdama pasiekti objekto *synchronized* metodus, pirma turi gauti jo užraktą ir grąžinti jį, kai darbas su laukais yra baigtas. Kol gija turi užraktą, jokia kita gija negali dirbti su objekto laukais. Kai gija kviečia objekto *synchronized* metodą, ji automatiškai gauna jo užraktą, kuri grąžina, kai metodas yra įvykdomas.

### Užduotis
Sukurkite klasę `ProgressBar` kuris turėtų *int* lauką `progress`. Jūsų programėles *main* metodas turėtų sukurti `ProgressBar` tipo objektą ir vykdyti ciklą, kuris didintų `progress` lauko reikšmę vienetu kas sekundę, tol, kol reikšmė pasiekia 100. Sukurkite kitą giją, kuri kas 3 sekundes į konsolę išvestų `ProgressBar` objekto, `progress` lauko reikšmę, tol, kol programa veikia. 

### Šaltiniai
-	https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
