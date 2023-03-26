package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsFoodShortageEx04;

public class Citizen implements Identifiable, Birthable, Buyer, Person {
    //name: String
//age: int
//id: String
//birthDate: String
    private static final int INCREASE_FOOD_WITH_TEN = 10;
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

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

    @Override
    public String getName() {
        return name;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void buyFood() {
        this.increaseFoodWith(INCREASE_FOOD_WITH_TEN);
    }
    private void increaseFoodWith(int quantity) {
        this.food += quantity;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}


//getName(): String
//getAge(): int
//getId(): String
//getBirthDate(): String
//toString(): String