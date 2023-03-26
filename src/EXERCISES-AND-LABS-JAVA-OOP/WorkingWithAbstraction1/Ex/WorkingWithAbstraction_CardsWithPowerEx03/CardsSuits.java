package WorkingWithAbstraction1.Ex.WorkingWithAbstraction_CardsWithPowerEx03;

public enum CardsSuits {
//    Suit powers are as follows: (CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39).

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int power;

    CardsSuits(int power) {
        this.power = power;
}
    public int getPower() {
        return this.power;
    }
}