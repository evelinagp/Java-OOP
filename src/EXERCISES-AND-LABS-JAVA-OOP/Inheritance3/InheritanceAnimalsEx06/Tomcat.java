package InheritanceAnimalsEx06;

public class Tomcat extends Cat {
    protected final static String TOMCAT_GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
