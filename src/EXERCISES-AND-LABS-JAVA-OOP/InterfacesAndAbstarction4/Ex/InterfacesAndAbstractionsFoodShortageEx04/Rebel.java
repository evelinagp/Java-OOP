package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsFoodShortageEx04;

//    Rebel
public class Rebel implements Buyer, Person {
    //name: String
//age: int
//group: String
//food: int
    private static final int INCREASE_FOOD_WITH_FIVE = 5;
    private String name;
    private int age;
    private String group;
    private int food;

    //+Rebel(Stirng, int, String)
    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    //+getName() : String
    @Override
    public String getName() {
        return name;
    }

    //+getAge() : int
    @Override
    public int getAge() {
        return age;
    }
//+getGroup() : String

    public String getGroup() {
        return group;
    }

    //+buyFood() : void
    @Override
    public void buyFood() {
        this.increaseFoodWith(INCREASE_FOOD_WITH_FIVE);
    }
    private void increaseFoodWith(int quantity) {
        this.food += quantity;
    }
    //+getFood() : int
    @Override
    public int getFood() {
        return food;
    }
}
