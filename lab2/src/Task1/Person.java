package Task1;

public class Person {
    private String name;
    static int hand;

    public Person(final String name) {
        this.name = name;
    }

    static {
        hand = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static int getHand() {
        return hand;
    }

    public static void setHand(final int hand) {
        Person.hand = hand;
    }
}
