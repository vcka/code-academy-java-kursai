# *Comparator*

## Pavyzdys

Turime klasę `Employee`:

```java
import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private LocalDate joiningDate;

    public Employee(int id, String name, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

}
```

Norime turėti galimybę surūšiuoti `Employee` tipo elementus saugantį sąrašą. Kad tą galėtume daryti, mūsų klasė turi implemntuoti interfeisą `Comparable`, per *generics* nurodant, kad tipas bus `Employee`:
```java
public class Employee implements Comparable<Employee> {
    /* ... */
}
```

Tada turime implementuoti interfeiso `Comparable` metodą `compareTo`.
Jei norime rūšiavimui naudoti tik klasės atributą `id`, tada `compareTo` metodas atrodo taip:
```java
@Override
public int compareTo(Employee anotherEmployee) {
    return this.getId() - anotherEmployee.getId();
}
```
Jei norime rūšiuoti pagal du klasės `Employee` atributus `id` ir `name`, tada `compareTo` metodas atrodo taip:
```java
@Override
public int compareTo(Employee anotherEmployee) {
    int i = this.getId() - anotherEmployee.getId();
    if (i != 0) {
        return i;
    }
    return this.getName().compareTo(anotherEmployee.getName());
}
```

Po modifikacijų, mūsų `Emplayee` klasė atrodo taip:
```java
import java.time.LocalDate;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    private LocalDate joiningDate;

    public Employee(int id, String name, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public int compareTo(Employee anotherEmployee) {
        int i = this.getId() - anotherEmployee.getId();
        if (i != 0) {
            return i;
        }
        return this.getName().compareTo(anotherEmployee.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
```

Kitoje klasėje šalia metodo `main` turime kitą metodą, kuris spausdina informaciją apie sąrašo elementus:
```java
private static void printEmployees(List<Employee> employees, String message) {
    System.out.println(message);
    for (Employee employee : employees) {
        System.out.println(employee);
    }
}
```

Susikurkime sąrašą su `Employee` elementais:

```java
List<Employee> employees = new ArrayList<>();

employees.add(new Employee(1010, "Rajeev", 100.00, LocalDate.of(2010, 7, 10)));
employees.add(new Employee(1004, "Chris", 900.50, LocalDate.of(2017, 3, 19)));
employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
```

Tada atpausdinus sąrašą:
```java
printEmployees(employees, "Unsorted list:");
```
gausime nesurūšuotą sąrašą:
```
Unsorted list:
Employee{id=1010, name='Rajeev', salary=100.0, joiningDate=2010-07-10}
Employee{id=1004, name='Chris', salary=900.5, joiningDate=2017-03-19}
Employee{id=1015, name='David', salary=134000.0, joiningDate=2017-09-28}
```
Surušiuojame sąrašo elementus:
```java
Collections.sort(employees);

printEmployees(employees, "Sorted list:");
```
gausime 
```
Sorted list:
Employee{id=1004, name='Chris', salary=900.5, joiningDate=2017-03-19}
Employee{id=1010, name='Rajeev', salary=100.0, joiningDate=2010-07-10}
Employee{id=1015, name='David', salary=134000.0, joiningDate=2017-09-28}
```

Jei norime turėti pasirinkimą pagal ką rūšiuoti tada susikurikime keletą klasių, kurios implementuoja `Comparator` interfeisą ir įgyvendina `comapare` metodą.

```java
import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}
```

```java
import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
```
Tada galime rūšiuoti pagal `id`:
```java
Collections.sort(employees, new IdComparator());

printEmployees(employees, "Sorted list by ID:");
```
```
Sorted list by ID:
Employee{id=1004, name='Chris', salary=900.5, joiningDate=2017-03-19}
Employee{id=1010, name='Rajeev', salary=100.0, joiningDate=2010-07-10}
Employee{id=1015, name='David', salary=134000.0, joiningDate=2017-09-28}
```
arba pagal `salary`:
```java
Collections.sort(employees, new SalaryComparator());

printEmployees(employees, "Sorted list by salary:");
```
```
Sorted list by salary:
Employee{id=1010, name='Rajeev', salary=100.0, joiningDate=2010-07-10}
Employee{id=1004, name='Chris', salary=900.5, joiningDate=2017-03-19}
Employee{id=1015, name='David', salary=134000.0, joiningDate=2017-09-28}
```
Norint surūšiuoti atvirkšine tvarka, turime naudoti `Collections.reverseOrder`:
```java
Collections.sort(employees, Collections.reverseOrder(new SalaryComparator()));

printEmployees(employees, "Sorted list by salary reversed:");
```
```
Sorted list by salary reversed:
Employee{id=1015, name='David', salary=134000.0, joiningDate=2017-09-28}
Employee{id=1004, name='Chris', salary=900.5, joiningDate=2017-03-19}
Employee{id=1010, name='Rajeev', salary=100.0, joiningDate=2010-07-10}
```


## Tolesniam skaitymui
- https://www.callicoder.com/java-comparable-comparator/
- https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html

## Užduotys
- [Užduotys](exercises/readme.md)
