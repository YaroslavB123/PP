package Task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        final Subject english = new Subject("English");
        final Subject physic = new Subject("Physic");
        final Subject math = new Subject("Math");

        final List<Subject> subjects = new ArrayList<>();
        subjects.add(english);
        subjects.add(physic);
        subjects.add(math);

        final Student stud1 = new Student("Name1", "Surname1", subjects);
        final Student stud2 = new Student("Name2", "Surname2", subjects);
        final Student stud3 = new Student("Name3", "Surname3", subjects);

        final List<Student> students = new ArrayList<>();
        students.add(stud1);
        students.add(stud2);
        students.add(stud3);

        students.get(0).addMark(4, "English");
        students.get(0).addMark(4, "English");
        students.get(0).addMark(4, "English");

        students.get(1).addMark(2, "English");
        students.get(2).addMark(3, "English");


        students.get(0).addMark(4, "Physic");
        students.get(1).addMark(2, "Physic");
        students.get(2).addMark(3, "Physic");

        students.get(0).addMark(4, "Math");
        students.get(1).addMark(2, "Math");
        students.get(2).addMark(3, "Math");
        students.get(0).addMark(12, "Math");

        final Group group = new Group(students);
        group.addSubject(subjects,"IT");
        System.out.println(group.bestStudent());

        students.get(0).addMark(1, "IT");
        students.get(1).addMark(2, "IT");
        students.get(2).addMark(3, "IT");

        group.printMap(english);

    }
}

