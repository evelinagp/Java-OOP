package WorkingWithAbstraction1.Lab.WorkingWithAbstraction_RhombusOfStarsLab01;

public enum DayOfWeekExample {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayNumber;


    DayOfWeekExample(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
