package Tuple;

public class Tuple<F, S> {

    private F first;
    private S second;

    // Create Constructor
    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    // getter and setter
    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    // to String
    @Override
    public String toString() {
        return String.format("%s -> %s",first,second);
    }
}
