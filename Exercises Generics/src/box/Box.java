package box;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    List<T> values;

    //Constructor
    public Box() {
        this.values = new ArrayList<>();
    }
    // Method
    public void add(T element){
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : values) {
            builder.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return builder.toString();
    }
}
