package Encapsulation2.Ex.EncapsulationAnimalFarmEx02;

//    Chicken
public class Chicken {
    //-	name: String
//-	age: int
    private String name;
    private int age;
    //+	Chicken(String, int)
//-	setName(String) : void
//-	setAge (int): void

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    //•	First 6 years it produces 2 eggs per day [0 - 5]
//•	Next 6 years it produces 1 egg per day [6 - 11]
//•	And after that it produces 0.75 eggs per day
    //+	productPerDay (): double
    public double productPerDay() {
        return this.calculateProductPerDay();
    }
    //-	calculateProductPerDay() : double
    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2.0;
        } else if (this.age < 12) {
            return 1.0;
        } else {
            return 0.75;
        }
    }
    //+	toString(): Override
    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }
}





