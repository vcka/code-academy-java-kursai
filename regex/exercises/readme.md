
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

