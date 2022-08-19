package InterfacesAndAbstarctionSayHelloExtendedLab04;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
