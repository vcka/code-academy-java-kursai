# Programų versijų valdymo pagrindai įrankiu Git

### Kas yra versijų valdymo sistemos?
Versijų valdymo sistema (version control system arba VCS) seka bendrų projektų, kuriamų grupės žmonių, pokyčių istoriją. Sistema palaiko projektų vientisumą, padeda sujungti kelių žmonių paraleliai  atliktus pakeitimus ir užtikrina, kad bet kokia projekto versija būtų atkurta neprarandant informacijos.
Versijų valdymo sistema saugo visų projekto pakeitimų istoriją. Tokią informaciją programuotojai naudoja norėdami sužinoti, kokie  pakeitimai buvo padaryti, kas už juos atsakingas, kada jie buvo padaryti, ir kodėl jie buvo reikalingi.
### Paskirstytos versijų valdymo sistemos
Paskirstytojo versijos valdymo sistema (Distributed version control system arba DVCS)  sudaryta iš nuotolinio serverio, identifikuojamo kaip centrinė saugykla (central repository). Nuotolinis serveris klientams teikia visą saugyklos turinį, su prieiga prie kiekvieno projekto failo, atšakos ir visų pakeitimų istorijos. Centrinėje saugykloje yra pagrindinė projekto versija, kiekvienas vartotojas įvykdytus pakeitimus sinchronizuoja būtent su ja. DVCS nereikalauja nuolatinio ryšio su centrine saugykla - skirtingų klientų padaryti pakeitimai sinchronizuojami esant poreikiui. Jei nuotolinis serveris miršta, centrinė saugykla gali būti atkurta iš bet kurio kliento saugyklos, nes klientams pateikiamas visas  centrinės saugyklos turinys.
### Git
Git yra viena iš paskirstytų versijų valdymo sistemų, sukurta 2005 metais Linus Torvalds siekiant palengvinti „Linux“ branduolio kūrimą. Tai populiariausia versijų valdymo sistema ir pagal *Stack Overflow Developers* [apklausą] (https://insights.stackoverflow.com/survey/2018#work-version-control) 2018 m. ją naudojo 88 proc. programuotojų.

#### Git duomenų saugojimas

Git saugo duomenis kaip momentinius atvaizdus (Snapshot). Momentinis atvaizdas yra projekto failų turinys tam tikru momentu. Kaskart, kai išsaugosite projekto pokyčius, Git sukuria naują momentinį atvaizdą ir išsaugo nuorodą į jį. Git įrankis yra efektyvus, nes nesaugo identiškų failų. Jei naujame momentiniame atvaizde failas išlieka nepakeistas, jis pakartotinai neįrašomas ir naudojamas buvusiame atvaizde esantis failas.

#### Git Struktūra
Git projekto struktūra sudaro 3 sritys - „medžiai“:

- **Darbinė sritis** (Working directory) - kurioje saugome realūs projekto failai, kuriais yra dirbama
- **Režisavimo sritis** (Staging area) – failas, kuriame saugoma informacija apie pakeitimus, kurie bus įtraukti į kitą *commitą*. Režisavimo sritis taip pat gali būti vadinama indeksu (index)
- **Git sritis** (Git directory) – svarbiausia Git dalis, kurioje yra saugomi momentiniai atvaizdai bei visa meta informacija apie projektą ir įvykdytus pakeitimus. Viena pagrindinių git srities dalių yra galva (head), kuri rodo į paskutinį atliktą *commitą*. Ši sritis yra nukopijuojama kai Git repozitorija yra klonuojama iš kito kompiuterio

Git repozitorijoje esantys failai gali būti vienos iš šių būsenų:
- **Commited** - reiškia, kad failo pakeitimas yra išsaugotas Git srityje
- **Modified** - reiškia, jog failo turinys yra pakeistas, bet pakeitimas dar nėra išsaugotas Git srityje
- **Staged** - reiškia, jog failas yra pažymėtas ir jo pakeitimai bus išsaugoti sakančio *commito* metu 

Standartinė darbo Git eiga atrodo taip:
- Darbinėje srityje esantys failai yra modifikuojami
- Pasirenkami modifikuoti failai, kurie turėtų būti įtraukti į sekantį *commitą*. Informacija apie įvykdytus pakeitimus yra perduodama į režisavimo sritį
- Įvykdomas *commitas*, kurio metu yra sukuriamas naujas momentinis atvaizdas su pakeitimais, esančiais režisavimo srityje. *Commitas* su nuoroda į sukurtą atvaizdą yra išsaugomas Git srityje, o galva yra pastumiama, kad rodytų į paskutinį *commitą*  
#### Atšakos (Branches)
Įvykdžius *commitą*, Git išsaugo *commito* objektą, rodantį į:
 - Naujai sukurtą momentinį atvaizdą su pakeitimais iš režisavimo srities
 - *Commitus* įvykusius anksčiau: vieną tėvinį *commitą*, jei tai buvo paprastas *commitas*, kelis tėvinius *commitus*, jei *commitas* buvo kelių atšakų apjungimas, arba nulį tėvinių, jei tai yra pirmas *commitas*

Atšaka yra nuoroda į *commitą*. Kadangi *commitai* turi nuorodas į ankstesnius *commitus*, atšaka tarsi sudaro grandinę su projekto pakeitimų istorija. Sukūrus naują atšaką, ji rodo į tą patį *commitą*, kaip ir originali atšaka, tačiau nauji vienoje atšakoje sukurti *commitai* nebus matomi kitoje atšakoje. Darbo eigoje abiejų atšakų turinys išsiskirs ir abi atšakos turės skirtingas įvykusių *commitų* grandines. Esant poreikiui, skirtingos atšakos gali būti sujungtos ir *commitai* įvykę skirtingose atšakose vėl sugrąžinami į bendrą grandinę. 

Atšakos leidžia programuotojams dirbti ties skirtingomis funkcijomis, izoliuotiems vienas nuo kito. Komandos nariams baigus darbą, jie gali sujungti skirtingus *commitus* iš įvairių atšakų. 
**Atšakų vizualizacija**:

Atšaka `feature1` su keliais komitais:
```
       "feature1"
           |
commit1-commit2
```
Iš pradinės atšakos sukuriama nauja atšaka pavadinimu `feature2` ir padaromi keli nauji komitai:
```
               "feature1"  
                   |
commit1-commit2-commit5
               \
                commit3-commit4
                          |
                      "feature2"    
```
Pakeitimai iš atšakos `feature2` yra pridedami prie `feature1` atšakos:
```
                              "feature1"  
                                  |
commit1-commit2-commit5--------commit6
               \                /
                commit3-commit4
                           |
                       "feature2"  
```

Sukūrus naują repozitoriją, atšaka pavadinimu `master` sukuriama pagal nutylėjimą. Galva taip pat rodo į dabartinę atšaką. Pakeitus atšaką, galvos rodyklė pastumiama į nurodytos atšakos rodyklę. Keičiant atšakas galima matyti *commitus*, egzistuojančius tik toje atšakoje.

### Git komandos
```
git init
```
Darbinėje direktorijoje sukuria tuščią git repozitoriją 
```
git clone /path/to/repository
```
Klonuoja egzistuojančią repozitoriją iš nurodyto kelio į direktoriją. Ji gali būti lokali arba nuotoliniame serveryje
```
git add <failo pavadinimas>
git add * (visiems modifikuotiems failams)
```
Prideda pasirinktus failus į režisavimo sritį
```
git commit -m "žinutė"
```
Padaromas naujas projekto momentinis atvaizdas su pakeitimais, esančiais režisavimo srityje. Sukuriamas *commito* objektas rodantis į minėtą atvaizdą. *Commitas* pridedamas prie galvos lokalioje git srityje, tačiau pakeitimai dar nėra nusiunčiami į nuotolini serverį. 
```
git status
```
Parodomi visi modifikuoti darbinės srities failai, bei failai esantys režisavimo srityje
```
git push origin <atšakos pavadinimas centrinėje repozitorijoje>
```
Dabartinės atšakos pakeitimai, išsaugoti lokalioje repozitorijoje, perduodami į centrinę repozitoriją, kur jie tampa matomi kitiems komandos nariams
```
git pull
```
Atsiunčiami dabartinės atšakos pakeitimai, išsaugoti nuotolinėje repozitorijoje
```
git checkout <atšakos pavadinimas>
```
Pakeičia dabartinę atšaką į nurodytą atšaką
```
git checkout -b <naujos atšakos pavadinimas>
```
Sukuria naują atšaką nurodytu pavadinimu
```
git branch -d <atšakos pavadinimas>
```
Ištrina nurodytą atšaką
```
git merge <atšakos pavadinimas>
```
Prijungia nurodytos atšakos pakeitimus prie dabartinės atšakos
```
git log
```
Parodo *commitų* istoriją, kurioje matoma kiekvieno *commito* id numeris,  žinutė, bei autorius
``` 
git reset <failo pavadinimas>
```
Pašalina failą iš režisavimo srities, tačiau atlikti pakeitimai išlieka
```
git checkout -- <failo pavadinimas>
```
Pašalina modifikuoto failo pakeitimus
```
git reset -–soft <comito id>
```
Grąžina galvą į nurodytą *commitą*, tačiau visi pakeitimai padaryti tolesniuose *commituose* išlieka režisavimo srityje

```
git reset --mixed <commito id>
arba
git reset <commito id>
```
Grąžina galvą į nurodytą *commitą*, tačiau visi pakeitimai padaryti tolesniuose *commituose* išlieka kaip modifikuoti failai darbinėje srityje
```
git reset -–hard <commito id>
```
Grąžina projekto stadiją į nurodytą *commitą* ir ištrina veliau padarytus pakeitimus

### Užduotys:
- [Bazinės Git užduotys](exercises/exercises.md)

### Tolesniam skaitymui
- https://services.github.com/on-demand/downloads/github-git-cheat-sheet/
- http://rogerdudler.github.io/git-guide/

### Šaltiniai
- https://guides.github.com/introduction/git-handbook/#version-control
- https://git-scm.com/book/en/v2
- https://insights.stackoverflow.com/survey/2018


