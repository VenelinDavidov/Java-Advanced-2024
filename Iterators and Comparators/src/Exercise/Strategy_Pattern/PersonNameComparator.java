package Exercise.Strategy_Pattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {

        if (first.getName().length() == second.getName().length()) {

            char lettersOfFirstPerson = first.getName().toLowerCase().charAt(0);
            char lettersOfSecondPerson = second.getName().toLowerCase().charAt(0);
            return Character.compare(lettersOfFirstPerson, lettersOfSecondPerson);
        }

        return first.getName().length() - second.getName().length();
    }
}
