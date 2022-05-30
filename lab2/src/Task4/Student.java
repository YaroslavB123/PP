package Task4;

import java.util.ArrayList;
import java.util.List;

public class Student {
    static long idStatic = 0;
    private long id;
    private String name;
    private String surName;
    private List<Subject> subject;
    private List<Mark> marks;

    public Student(final String name, final String surName) {
        this.name = name;
        this.surName = surName;
        this.marks = setMarkSubject();
        this.id = Student.idStatic++;
    }

    public Student(final String name, final String surName, final List<Subject> subject) {
        this.name = name;
        this.surName = surName;
        this.subject = subject;
        this.marks = setMarkSubject();
        this.id = Student.idStatic++;
    }
    public static long getIdStatic() {
        return idStatic;
    }

    public static void setIdStatic(final long idStatic) {
        Student.idStatic = idStatic;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Mark> getMarks() {
        return marks;
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

    public void addMark(final int value, final String nameSubject) {
        for (int i = 0; i < subject.size(); i++) {
            if (subject.get(i).getNameSubject() == nameSubject) {
                if (value > 12 || value < 0)
                    marks.get(i).getMark().add(12);
                else
                    marks.get(i).getMark().add(value);
            }
        }
    }

    public List<Mark> setMarkSubject() {
        final List<Mark> marks = new ArrayList<>();

        for (int i = 0; i < subject.size(); i++) {
            marks.add(new Mark());
        }
        return marks;
    }

    @Override
    public String toString() {
        return "ID = " + this.getId() +
                " Name = " + this.getName() +
                " Surname = " + this.getSurName();
    }
}
