package Exercise.listIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;

    private int currentIndex;

    //Create Peter George
    // HasNext
    // Print
    // Move
    // Print
    // END

    //Constructor
    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size();
    }
    public boolean move(){
        if (hasNext()){
            currentIndex++;
            return true;
        }
        return false;
    }
    public void print(){
        if (elements.isEmpty()){
            throw new IllegalStateException("Invalid Operations!");
        }else {
            System.out.println(elements.get(currentIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            private int internalIndex;
            @Override
            public boolean hasNext() {
                return internalIndex < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }

    public void printAll(){
        String result = String.join(" ", elements);
        System.out.printf("%s%n", result);
    }



}
