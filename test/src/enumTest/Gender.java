package enumTest;

public enum Gender {
    MALE("man"), FEMALE("woman");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
