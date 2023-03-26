package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_StudentSystemLab03;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String comment;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.setComment();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setComment() {
        if (getGrade() >= 5.00) {
            comment = "Excellent student.";
        }else if (getGrade() >= 3.50){
            comment = "Average student.";
        }
        else{
            comment = "Very nice person.";
        }
    }

    public String getInfo() {
        return String.format("%s is %d years old. %s", name, age, comment);
    }
}
