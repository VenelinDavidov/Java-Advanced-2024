package Exercises_DefiningClasses.CatLady09;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", getName(), furLength);
    }
}