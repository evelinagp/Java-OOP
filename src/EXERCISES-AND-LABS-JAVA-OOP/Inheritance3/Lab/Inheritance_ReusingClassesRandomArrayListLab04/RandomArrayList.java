package Inheritance3.Lab.Inheritance_ReusingClassesRandomArrayListLab04;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList<Object> {
    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.get(index);
    }
    public Object removeRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.remove(index);
    }
}
