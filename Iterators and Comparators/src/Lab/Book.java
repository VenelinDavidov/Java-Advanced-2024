package Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    // Generate constructor
    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    //getter and setter
    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
        // Arrays.asList(authors)
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }


    // Implements method compareTo (interface Comparable)
    @Override
    public int compareTo(Book other) {

        int result = this.title.compareTo(other.title);
        if (result == 0) {
            result = Integer.compare(this.year, other.year);
        }
        return result;
    }



    // Compare by Author-> instrument
    public static class BookComparatorByAuthorsCount implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return Integer.compare(first.getAuthors().size(), second.getAuthors().size());
        }
    }

}
