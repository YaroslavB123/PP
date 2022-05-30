package Task11;

public class TaxiCar {
    private String numbCar;
    private Driver driver;
    private int maxSeats = 4;

    public TaxiCar(final String numbCar, final Driver driver) {
        this.numbCar = numbCar;
        this.driver = driver;
    }

    public String getNumbCar() {
        return numbCar;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(final int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public void setNumbCar(final String numbCar) {
        this.numbCar = numbCar;
    }

    public Driver getDriver() { // можна дізнатися хто водій машини
        return driver;
    }

    public void setDriver(final Driver driver) {//можна вставити водія
        this.driver = driver;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxiCar)) return false;
        final TaxiCar taxiCar = (TaxiCar) o;
        return maxSeats == taxiCar.maxSeats && this.numbCar == taxiCar.numbCar && this.driver == taxiCar.driver;
    }

    @Override
    public int hashCode() {
        return numbCar.hashCode() + driver.hashCode() + maxSeats;
    }
}
