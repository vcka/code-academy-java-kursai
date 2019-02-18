
## Užduotys: Regex

## Nr. 1

### Užduotis

Tekstas:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
```

- Visus žodžius, kurie prasideda raide `L` arba `l` pakeiskite tekstu `******`.
    <details><summary>Išskleisti</summary>
    <p>

    ```
    ****** ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut ****** et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco ****** nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est ******.
    ```

    </p>
    </details>
- Pakeiskit eilutę taip, kad ją atspausdinus kiekvienoje eilutėje būtų tik vienas žodis.
    <details><summary>Išskleisti</summary>
    <p>

    ```
    Lorem
    ipsum
    dolor
    sit
    amet,
    consectetur
    adipiscing
    elit,
    sed
    do
    eiusmod
    tempor
    incididunt
    ut
    labore
    et
    dolore
    magna
    aliqua.
    Ut
    enim
    ad
    minim
    veniam,
    quis
    nostrud
    exercitation
    ullamco
    laboris
    nisi
    ut
    aliquip
    ex
    ea
    commodo
    consequat.
    Duis
    aute
    irure
    dolor
    in
    reprehenderit
    in
    voluptate
    velit
    esse
    cillum
    dolore
    eu
    fugiat
    nulla
    pariatur.
    Excepteur
    sint
    occaecat
    cupidatat
    non
    proident,
    sunt
    in
    culpa
    qui
    officia
    deserunt
    mollit
    anim
    id
    est
    laborum.
    ```

    </p>
    </details>

- Pakeisti eilutę taip, kad kalblelis ir taškas būtų paskutiniai kiekvienos eilutės simboliai.

    <details><summary>Išskleisti</summary>
    <p>

    ```
    Lorem ipsum dolor sit amet,
    consectetur adipiscing elit,
    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
    Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident,
    sunt in culpa qui officia deserunt mollit anim id est laborum.
    ```

    </p>
    </details>

\* užduoties sąlygos yra viena su kita nesusijusios.

## Nr. 2

### Užduotis

Sukurkite validatorių, kuris patikrina email adresą, pvz. `vardas@codeacademy.lt` turi būti validus, o `vardas@codea@cademy.lt` - nevalidus.

## Nr. 3

### Užduotis

Tekstas:
```
tN6WgkPg
eX9qZRwr
nQfMQjJz
eAEwVSfh
vLCnbwXK
HUTCjjfs
bRATtkPw
VxGSzR8y
qYhWYquL
Kk3GajkG
VZ3s2U9v
QGJXQxHc
AA6WZVpA
Cws4xyXz
QeY8p4aX
```

Visi šie slaptažodžiai turi būti vienoje eilutėje ir atskirti tik kableliu, o išorėje - laužtiniai skliaustai.

<details><summary>Išskleisti</summary>
<p>

```
[tN6WgkPg,eX9qZRwr,nQfMQjJz,eAEwVSfh,vLCnbwXK,HUTCjjfs,bRATtkPw,VxGSzR8y,qYhWYquL,Kk3GajkG,VZ3s2U9v,QGJXQxHc,AA6WZVpA,Cws4xyXz,QeY8p4aX]
```

</p>
</details>

## Nr. 4

### Užduotis

Sąrašas slaptažodžių:
```
7YeSYKrPMLd4rSAW
ah4uDJAWxBkX
720477471992
FJU8Phr7KAcd
en8wdFtunqDkmpAL
kkcnf95pyt99sjyz
2tvy5t6qj5z6htt7
ldxorybgheyx
0021673575111166
48esda7dd9wn9rg9
3QmgwjfKPMEL
kQe366B6X5KcXM9G
NsBRaeX2vDRmjfU2
JCWNY54NJLVA
5ggqS2uQgZ59Tqct
xibrjbktsbew
```

Naudojant srautus ir regex sugrupuoti šiuos šlaptažodžius į grupes:
- STIPRUS - jei slaptažodžio ilgis yra bent 16 smbolių ir jame yra bent dvi mažosios raidės, bent dvi didžiosios raidės ir bent du skaitmenys.
- VIDUTINIS - jei jame yra bent dvi mažosios raidės, bent dvi didžiosios raidės ir bent du skaitmenys.
- SILPNAS - visais kitais atvejais.

Pavyzdys:
```
{VIDUTINIS=[FJU8Phr7KAcd], SILPNAS=[ah4uDJAWxBkX, 720477471992, en8wdFtunqDkmpAL, kkcnf95pyt99sjyz, 2tvy5t6qj5z6htt7, ldxorybgheyx, 0021673575111166, 48esda7dd9wn9rg9, 3QmgwjfKPMEL, JCWNY54NJLVA, xibrjbktsbew], STIPRUS=[7YeSYKrPMLd4rSAW, kQe366B6X5KcXM9G, NsBRaeX2vDRmjfU2, 5ggqS2uQgZ59Tqct]}
```

