package Task11;

public class Order {
    private TaxiCar taxiCar;
    private Passenger passengers;
    private int amountPassengers = 1;

    public Order(final TaxiCar taxiCar, final String name,final String numb, final int amountPassengers ) {
        this.taxiCar = taxiCar;
        this.passengers = new Passenger(name,numb);
        this.setAmountPassengers(amountPassengers);
    }

    public Order(final TaxiCar taxiCar, final Passenger passengers, final int amountPassengers) {
        this.taxiCar = taxiCar;
        this.passengers = passengers;
        this.setAmountPassengers(amountPassengers);
    }

    public int getAmountPassengers() {
        return amountPassengers;
    }

    public void setAmountPassengers(final int amountPassengers) {
        if (taxiCar.getMaxSeats() >= amountPassengers && amountPassengers >= 1) {
            this.amountPassengers = amountPassengers;

        }
        else throw new RuntimeException ("Кількість пасажирів більша ніж можливо !!!");
    }

    public TaxiCar getTaxiCar() { //дізнаємось яке таксі
        return taxiCar;
    }

    public void setTaxiCar(final TaxiCar taxiCar) { // встaновлюємо таксі
        this.taxiCar = taxiCar;
    }

    public Passenger getPassengers() {
        return passengers;
    }

    public void setPassengers(final Passenger passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Order : " +
                "numberTaxiCar = " + taxiCar.getNumbCar() +
                ", namePassenger = " + passengers.getNamePassenger() +
                ", numberPassenger = " + passengers.getNumberPhone() +
                ", amountPassengers = " + getAmountPassengers();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        final Order order = (Order) o;
        return getAmountPassengers() == order.getAmountPassengers()
                && this.getTaxiCar() == order.getTaxiCar()
                && this.getPassengers() == order.getPassengers();
    }

    @Override
    public int hashCode() {
        return getTaxiCar().hashCode() + getPassengers().hashCode() + getAmountPassengers();
    }
}
