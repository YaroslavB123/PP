package Task10;

public class Main {
    public static void main(final String[] args) {
        final Day[] days = new Day[7];

        for (int i = 0; i < days.length; ++i) {
            days[i] = new Day(i);
            System.out.println(days[i].toString());
        }
    }
}
