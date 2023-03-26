package Inheritance3.Ex.InheritancePlayersAndMonstersEx03;

// Create a class Hero. It should contain the following members:
public class Hero {
    //•	The following fields:
//o	username - String
//o	level – int
    private String username;
    private int level;

    //•	A public constructor, which accepts:
//o	username – String
//o	level – int
    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    //•	Getters for username and level
    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    //•	toString() method
//Hint: Override toString() of the base class in the following way:
    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
