
## Užduotys: *Access modifiers*

## Nr. 1

### Užduotis

Sukurkite klasę `A` viename pakete ir klases `B`, `C` ir `D` kitame pakete. 
Klasėje `B` yra metodai `x`, `y`, `w` ir `z`. Metodą `x` turime galėti iškviesti tik toje pačioje klasėje. Metodą `y` turime galėti iškviesti tame pačiame pakete esančiose klasėse. Metodą `w` turime galėti iškviesti klasę `B` paveldeinčiose klasėse. Metodą `z` turime galėti iškviesti ir kituose paketuose esančiose klasėse. Iškvieskite aprašytus metodus visur, kur juos galima iškviesti.

## Nr. 2

### Užduotis

Lietuvos PVM mokėtojo kodas sudaromas naudojant tam tikras taisykles. Parašykite metodą `tikrintiPVMkoda`, kuris tikrina vartotojo įvestą numerį ir parodo ar įvestas numeris yra validus ar ne. Nuskaityti vartotojo įvestą skaičių, jo skaitmenis įdėti į masyvą ir dirbti su masyvu.

Kodo formatas: 
```
[C1 C2 C3 C4 C5 C6 C7 C8 C9]
```
Visi simboliai yra skaitmenys. `C8` - visada `1`. `C9` apskaičiuojamas pagal tokią taisyklę. Taisyklės pseudo kodas:
```
A1 = 1*C1 + 2*C2 + 3*C3 + 4*C4 + 5*C5 + 6*C6 + 7*C7 + 8*C8
R1 = A1 modulo 11
If R1 != 10 
    C9 = R1
Else
    A2 = 3*C1 + 4*C2 + 5*C3 + 6*C4 + 7*C5 + 8*C6 + 9*C7 + 1*C8
    R2 = A2 modulo 11
    If R2 == 10
        C9 = 0
    Else 
        C9 = R2

```
Validaus numerio pavyzdys - `213179412`, nevalidaus - `213179422`. Pavyzdys: programai davus kodą `213179412`, jei `C9` gauname `2`, tada kodas yra validus.

Sukurti klasę `PvmValidatorius`, kuri turi anksčiau minėtą metodą `tikrintiPVMkoda`. Sukurti klasę `PakeistasPvmValidatorius` ir overridinti metodą `tikrintiPVMkoda`, kad validuotų kaip nors kitaip (naudotų kitą algoritmą).

```java
PvmValidatorius validator = new PakeistasPvmValidatorius();
validator.tikrintiPVMkoda(...);
```

Vėliau apsaugoti `PvmValidatorius` klasės metodą `tikrintiPVMkoda`, kad jo veikimo logikos negalėtų pakeisti paveldinčios klasės.

[Šaltinis](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=14&ved=2ahUKEwixyoqIzdPfAhVCjSwKHYxdCPQQFjANegQIBBAC&url=http%3A%2F%2F85.81.229.78%2Fsystems%2FDKVIES%2F-%2520Arkiv%2FAlgoritme%25E6ndringer%2FVIES-VAT%2520Validation%2520Routines-v15.0.doc&usg=AOvVaw2mVLkFoVBQrUnVUfRafihp&fbclid=IwAR3k9SQy7HuSO_HSM9xfbqStjjfR90tbaDK-SRzr1PeTSUp9TfIKJcxpOxg)

