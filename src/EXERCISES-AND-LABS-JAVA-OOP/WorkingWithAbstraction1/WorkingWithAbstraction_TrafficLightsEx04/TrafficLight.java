package WorkingWithAbstraction_TrafficLightsEx04;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void update() {
        //    red -> green
//    green -> yellow
//    yellow -> red
        switch (color){
            case RED:
              this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;

        }
    }

    public Color getColor() {
        return this.color;
    }
}
