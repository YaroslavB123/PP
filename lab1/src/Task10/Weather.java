package Task10;

public class Weather {
    private boolean rain = false;
    private boolean sun = true;
    private int maxTemp = 0;
    private int minTemp = 0;

    public Weather() {
        this.randomRainSun();
        this.randomTemp();
    }

    public Weather(final boolean rain, final boolean sun, final int maxTemp, final int minTemp) {
        this.rain = rain;
        this.sun = sun;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public boolean isRain() {
        return this.rain;
    }

    public void setRain(final boolean rain) {
        this.rain = rain;
    }

    public boolean isSun() {
        return this.sun;
    }

    public void setSun(final boolean sun) {
        this.sun = sun;
    }

    public int getMaxTemp() {
        return this.maxTemp;
    }

    public void setMaxTemp(final int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return this.minTemp;
    }

    public void setMinTemp(final int minTemp) {
        this.minTemp = minTemp;
    }

    public void randomTemp() {
        while (this.maxTemp <= this.minTemp) {
            while (this.maxTemp - this.minTemp >= 11 || this.maxTemp - this.minTemp <= 1) {
                this.setMaxTemp((int) (Math.random() * 100.0D - 50.0D));
                this.setMinTemp((int) (Math.random() * 100.0D - 50.0D));
            }
        }
    }

    public void randomRainSun() {
        this.setRain(Math.random() < 0.5D);
        this.setSun(Math.random() < 0.5D);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        final Weather that = (Weather) o;
        return this.rain == that.rain && this.sun == that.sun
                && this.maxTemp == that.maxTemp && this.minTemp == that.minTemp;
    }

    @Override
    public int hashCode() {
        return 31 * Boolean.hashCode(rain) + Boolean.hashCode(sun) + maxTemp + minTemp;
    }
}

