package Task3;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surName;
    private List<Subject> subject;
    private List<Mark> marks;

    public Student(final List<Mark> marks) {
        this.marks = marks;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(final List<Mark> marks) {
        this.marks = marks;
    }

    public Student(final String name, final String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Student(final String name, final String surName, final List<Subject> subject) {
        this.name = name;
        this.surName = surName;
        this.subject = subject;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(final List<Subject> subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(final String surName) {
        this.surName = surName;
    }
    @Override
    public String toString() {
        return " Name = " + this.getName() +
                " Surname = " + this.getSurName();
    }
}
