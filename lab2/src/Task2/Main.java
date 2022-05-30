package Task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final ListStack<String> list = new ListStack<>();

        for (int i = 0; i < 4; i++) {
            list.add("" + i);
        }
        for (final String text :list) {
            System.out.print(text + "  ");
        }

        list.delete();
        System.out.print('\n'+"Delete: ");
        list.print();
        list.clean();
        System.out.println('\n'+"Clean: ");
        list.print();
    }
}
