package Task2;

import java.io.IOException;

public class Main {

    public static void main(final String[] args) {
        try (final Person person = new Person("N ame")) {
            System.out.println(person.getName());
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
