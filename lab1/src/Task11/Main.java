package Task11;

public class Main {

    public static void main(final String[] args) {

        try {
            final Driver[] drivers = new Driver[1];

            drivers[0] = new Driver("Ostap",23);

            final TaxiCar taxiCars = new TaxiCar("132",drivers[0]);
            final Order order = new Order(taxiCars,"name","+380987654321",3);

            System.out.println(order.toString());
        }
        catch (final RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
