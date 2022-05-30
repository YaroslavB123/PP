package Task11;

public class Passenger {
    private String namePassenger;
    private String numberPhone;
    private Order order;

    public Passenger(final String namePass, final String numberPhone) {
        this.namePassenger = namePass;
        this.numberPhone = numberPhone;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(final String namePass) {
        this.namePassenger = namePass;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getOrder() {
        return order.toString();
    }

    public void setNumberPhone(final String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        final Passenger passenger = (Passenger) o;
        return getNamePassenger() == passenger.getNamePassenger()
                && this.getNumberPhone() == passenger.getNumberPhone();
    }

    @Override
    public int hashCode() {
        return getNamePassenger().hashCode() + getNumberPhone().hashCode();
    }
}
