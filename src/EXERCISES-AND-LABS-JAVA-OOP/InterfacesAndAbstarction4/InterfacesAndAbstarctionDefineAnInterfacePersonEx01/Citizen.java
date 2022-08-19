package InterfacesAndAbstarctionDefineAnInterfacePersonEx01;

public class Citizen implements Person {
        private String name;
        private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int getAge() {
        return age;
    }
}
