package Task2;

import Task1.MyException;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person implements Closeable {
    private String name;

    public Person(final String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
        validate();
    }
    public void validate() {

        if (name.matches(".*\\d+.*") || name.matches(".*\\s+.*") || !name.matches(".+")) {
            throw new MyException("Incorrectly name");
        }
    }

    @Override
    public void close() throws IOException {

    }
}
