package Inheritance3.Lab.Inheritance_ReusingClassesStackOfStringsLab05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    //•	Public method: pop(): String
    public String pop() {
        if (data.isEmpty()) {
            return null;
        }
        return data.remove(data.size() - 1);
    }

    //•	Public method: peek(): String
    public String peek() {
        if (data.isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    //•	Public method: isEmpty(): boolean
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
