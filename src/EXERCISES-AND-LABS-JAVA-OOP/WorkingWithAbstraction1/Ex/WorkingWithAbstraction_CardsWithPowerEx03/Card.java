package WorkingWithAbstraction1.Ex.WorkingWithAbstraction_CardsWithPowerEx03;

public class Card {
    //    10 < 3
    private CardsRanks number;
    private CardsSuits colour;
    private int power;

    public Card(CardsRanks number, CardsSuits colour) {
        this.number = number;
        this.colour = colour;
//        сила на картата = сила на номера + сила на боята;
        this.power = number.getPower() + colour.getPower();
    }
    @Override
    public String toString() {
        String cardName = this.number + " of " + this.colour;
        return String.format("Card name: %s; Card power: %d", cardName, this.power);
    }
}
