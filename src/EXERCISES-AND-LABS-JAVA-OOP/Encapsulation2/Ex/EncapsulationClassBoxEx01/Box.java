package Encapsulation2.Ex.EncapsulationClassBoxEx01;

public class Box {

    private double length;
    private double width;
    private double height;

    //+ 	Box (double length, double width, double height)
    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setHeight(height);
        this.setWidth(width);
    }

    //-	setLength(double): void
    private void setLength(double length) {
        if (isItPositiveOrBiggerThanZero(length)) {
            this.length = length;
        }
    }

    //-	setWidth(double): void
    private void setWidth(double width) {
        if (isItPositiveOrBiggerThanZero(width)) {
            this.width = width;
        }
    }

    //-	setHeight(double): void
    private void setHeight(double height) {
        if (isItPositiveOrBiggerThanZero(height)) {
            this.height = height;
        }
    }

    private boolean isItPositiveOrBiggerThanZero(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
       System.out.println("Surface Area - " + calculateSurfaceArea());
        System.out.println(" Lateral Surface Area - " + calculateLateralSurfaceArea());
        System.out.println("Volume – " + calculateVolume());
        return true;
    }

    //Surface Area = 2lw + 2lh + 2wh
    //+	calculateSurfaceArea (): double
    public double calculateSurfaceArea() {
        double surfaceArea = 2 * length * width + 2 * length * height + 2 * width * height;
        return surfaceArea;
    }

    //Lateral Surface Area = 2lh + 2wh
//+	calculateLateralSurfaceArea (): double
    public double calculateLateralSurfaceArea() {
        double surfaceSurfaceArea = 2 * length * height + 2 * width * height;
        return surfaceSurfaceArea;
    }

    //    Volume = lwh
//+	calculateVolume (): double
    public double calculateVolume() {
        double volume = length * width * height;
        return volume;
    }
}

