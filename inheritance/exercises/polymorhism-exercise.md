# Polimorfizmo užduotys
1.	Sukurkite abstrakčią klasę `Person` su laukais `personalID`, `name`, `gender`
2.	Sukurkite abstrakčią klasę `PrivatePerson` kurį paveldėtų klasę `Person`, ir turėtų abstrakčius metodus, `getEmploymentStatus();`
3.	Sukurkite klases `EmployedPerson` ir `UnemployedPerson` kurios pavaldėtų `PrivatePerson` klasę ir įgyvendintų abstrakčius metodus
4.	Pridėkite `PrivatePerson` statinį metodą, kuris pagal nurodytus parametrus sukurtų `EmployedPerson` arba `UnemployedPerson`
5.	Sukurkite klasę `LegalPerson ` kuri paveldėtų  `Person` klasę. Kviečiant metodą `getGender()` turėtų būti metama `UnsupportedOperationException`, kadangi juridiniai asmenys neturi lyties.
6.	Sukurkite klasę `PersonRepository`, kuri turėtų šį statinį metodą:  `List<Person> getPersons()`. Šis metodas turėtų grąžinti visų potipių `Person` objektų pavyzdžius.
7.	 Sukurkite klasę `PersonFacade` kuri turėtų šiuos metodus: `List<PrivatePerson > getPrivatePersons()`, `List<LegalPerson> getLegalPersons()`. Šie metodai turėtų kviesti ` getPersons` metodą, filtruoti gautus duomenis pagal reikalingus potipius ir grąžinti rezultatą. 
8.	Sukurkite sąsają `Employee`, kuri turėtų metodus `int getSalary()` ir `String getEmployerName()`
9.	`EmployedPerson` turėtų įgyvendinti `Employee` sąsają
10.	Sukurkite sąsają `Employer`, kuri turėtų metodus `int getRevenue()` ir `List<Employee` getEmployees()` 
11.	`LegalPerson` klasė turėtų įgyvendinti sąsają `Employer`
12.	Sukurkite sąsają `WorkplaceService` su šiais metodais: `List<Employer> getEmployers()`, `List<Employee> getEmployees()`
13.	Tegul `PersonFacade` įgyvendina `WorkplaceService` sąsają. Įgyvendinimui panaudokite jau esamus `PersonFacade` metodus.
14.	Sukurkite klasę ` EmployersStatisticsService `, kurios konstruktorius priimtų parametrą `WorkplaceService`
15.	`EmployersStatisticsService` klasė turėtų pateikti šiuos metodus: `List<Employer> getProfitableOrganizations()` ir `List<Employer> getUnprofitableOrganizations()`
16.	Sukurkite sąsają `PersonEmploymentService` kuri turėtų metodus `List<UnemployedPerson> unemployedPersons()` ir `List<EmployedPerson> employedPersons()`
17.	`PersonFacade` turėtų įgyvendinti `PersonEmploymentService`
18.	Sukurkite klasę `UnemploymentStatisticsService` kuri priimtų kaip parametrą  ` PersonEmploymentService` klasę ir turėtų šiuos metodus: `int employedPersons()`. `int unEmployedPersons()`
19.	`PersonFacade` klasė tapo atsakinga už labai daug funkcijų. Pabandykite pagal biznio logiką išskaidyti `PersonFacade` funkcijas į skirtingas klases, kurios įgyvendintų reikalingas sąsajas ir naudotų `PersonFacade` reikalingiems dėmenims gauti.
20.	Sukurkite statinį metodą `printPerson`, kuriam paduodamas `Person` objektas ir jo reikšmės yra išspausdinamos konsolėje. Metodas turėtų dinamiškai prisitaikyti prie objekto potipių ir atitinkamai spausdinti potipiui būdingus laukus. Naudokite šį metodą rezultatams išvesti.
21.	Padarykite programą efektyvesnę, įgyvendindami talpyklą (cache) `PersonFacade` klasėje.  Talpykla veiktų taip, kad ` PersonFacade ` metodų rezultatai kurį laiką būtų saugomi `PersonFacade` klasėje ir skaičiavimai vyktų tik praėjus tam tikram laiko tarpui, kai saugomi įrašai tampa nebeaktualūs.	
