
## Užduotys: Serializacija ir JSON

## Nr. 1

### Užduotis

1. Sukurkite klases `Sender` ir `Receiver`, kurios paveldi klasę `Asmuo`. 
2. Sukurkite klasę `Payment` kuri turi klasės atributus `sender` ir `receiver`.
3. Sukurkite ir užpildykite `Payment` objektą duomenimis.
4. Serializuokite sukurtą objektą į failą.
5. Deserializuokite iš failo į `Payment` objektą ir patikrinkite ar nepraradote duomenų.

## Nr. 2

### Užduotis

1. Naudoti ankstesnės užduoties sąlygas, tik serializuoti į JSON failą.
2. Deserializuoti iš JSON failo atgal į `Payment` Java objektą.
3. Konvertuokite `Payment` objektą į JSON formato String eilutę.

## Nr. 3

### Užduotis

1. Sukurkite klasę `Imone`, kuri tokius duomenis kaip įmonės pavadinimas, įmonės kodas, darbuotojų skaičius, vidutinis atlyginimas ir panašiai.
2. Sukurkite sąrašą, į kurį galėtume įdėti klasės `Imone` tipo objektus.
3. Sukurkite 100 įmonės objektų. Duomenis reikalingus įmonei generuokite. Galite naudoti [java-faker](https://github.com/DiUS/java-faker).
4. Sąrašą serializuokite į JSON failą pavadinimu `imoniu_sarasas.json`
