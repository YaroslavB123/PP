package Task1;

public class Main {
    public static void main(final String[] args) {
        final Address address = new Address("Lviv");

        try {
            final User user = new User("De n", "K KK", -19, Sex.MALE, address);
        }
        catch (final MyException e){
            System.out.println(e.getMessage() + '\n' + e.getHttpCode());
        }
    }
}
