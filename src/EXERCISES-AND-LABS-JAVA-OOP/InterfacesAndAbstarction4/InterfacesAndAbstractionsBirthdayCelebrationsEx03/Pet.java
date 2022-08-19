package InterfacesAndAbstractionsBirthdayCelebrationsEx03;

public class Pet implements Birthable, Creature {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.setName(name);
        this. setBirthDate(birthDate);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
