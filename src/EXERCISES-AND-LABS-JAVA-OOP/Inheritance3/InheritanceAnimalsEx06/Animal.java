package InheritanceAnimalsEx06;

public class Animal {
    //    name, an age and a gender
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setGender(String  gender) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setName(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return this.gender;
    }

    public String produceSound() {
        return " ";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator()).append(name + " " + age + " " + gender);
        sb.append(System.lineSeparator()).append(produceSound()).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
