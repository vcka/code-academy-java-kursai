# Užduotys su failais
	
1.	Atsisiųskite failus [people](people) ir [payments](payments). People failo struktūra yra kableliais išskirtos reikšmės -  *id, vardas, pavardė*. Payments failo struktūra yra kableliais išskirtos reikšmės - *mokėjimo id, suma, gavėjo id, siuntėjo id*
2.	Sukurkite klasę, atspindinčią žmonių (people) failo įrašų struktūrą, pavadinimu `Person`
3.	Sukurkite  `Map<Person>` tipo objektą, užpildykite jį `Person` tipo objektais, sukurtais iš žmonių failo įrašų (people)
4.	Pridėkite `Person` klasei du naujus laukus: `receivedMoney` ir `sentMoney`
5.	Skaitykite pavedimų failą (payments). Failas yra didelis, dėl to skaitykite jį pasinaudodami srautu. Iš nuskaitytų duomenų atnaujinkite laukus `receivedMoney` ir `sentMoney` tinkamiems asmenims
6.	Sukurkite naują failą, kuriame mažėjimo tvarka bus surašyti žmonės, gavę daugiausiai pinigų 
7.	Sukurkite naują failą, kuriame mažėjimo tvarka bus surašyti žmonės, išsiuntę daugiausiai pinigų
