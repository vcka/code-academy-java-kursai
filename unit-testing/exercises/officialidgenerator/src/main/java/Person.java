import java.time.LocalDate;

public class Person {

    private String officialId;
    private String name;
    private LocalDate birthDate;
    private Gender gender;

    public Person(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

    public String getOfficialId() {
        return officialId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
