package Solid6.SolidLab.p03_LiskovSubstitution.p01_Square;

public class Square extends Rectangle {

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }

    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }
}
