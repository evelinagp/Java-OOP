package InterfacesAndAbstarction4.Lab.InterfacesAndAbstarctionSayHelloExtendedLab04;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
