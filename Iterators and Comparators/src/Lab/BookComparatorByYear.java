package Lab;

import java.util.Comparator;

public class BookComparatorByYear implements Comparator<Book> {


    @Override
    public int compare(Book first, Book second) {
        return Integer.compare(first.getYear(), second.getYear());
    }
}
