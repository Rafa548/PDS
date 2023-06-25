package Ex3;

public class Person {
    private final String name;
    private final String birthDate;
    private final String birthPlace;
    private final String deathDate;
    private final String deathPlace;

    public Person(
        final String personName,
        final String personBirthDate,
        final String personBirthPlace,
        final String personDeathDate,
        final String personDeathPlace) {
            this.name = personName;
            this.birthDate = personBirthDate;
            this.birthPlace = personBirthPlace;
            this.deathDate = personDeathDate;
            this.deathPlace = personDeathPlace;
    }

}
