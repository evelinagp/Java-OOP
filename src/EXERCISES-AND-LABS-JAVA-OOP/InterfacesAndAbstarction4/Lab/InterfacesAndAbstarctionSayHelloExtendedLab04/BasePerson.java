package InterfacesAndAbstarction4.Lab.InterfacesAndAbstarctionSayHelloExtendedLab04;

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
   public String sayHello() {
        return "Hello";
    }
}
