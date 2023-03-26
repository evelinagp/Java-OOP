package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsBirthdayCelebrationsEx03;

public class Citizen implements Creature, Birthable, Identifiable {
    //name: String
//age: int
//id: String
//birthDate: String
    private String name;
    private int age;
    private String id;
    private String birthDate;

    //Citizen(String, int, String, String)


    public Citizen(String name, int age, String id, String birthDate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDate(birthDate);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
//    @Override
//    public String toString() {
//        return "Citizen{}";
//    }
}
