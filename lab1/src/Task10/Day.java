package Task10;

public class Day {
    private final String day;
    private final Weather weather;
    private static final String[] todayIsDay = new String[]{"Понеділок", "Вівторок", "Середа", "Четвер", "ПятницЯ", "Субота", "Неділя"};

    public Day(final int day) {
        this.day = this.todayIsDay[day];
        this.weather = new Weather();
    }

    public Day(final String day, final Weather weather) {
        this.day = day;
        this.weather = weather;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        final Day that = (Day) o;
        return this.day.equals(that.day);
    }

    @Override
    public int hashCode() {
        int result = day.hashCode();
        result = 31 * result + todayIsDay.hashCode();
        return result;
    }

    public String getDay() {
        return this.day;
    }

    public String toString() {
        return "Weather of day { " + getDay() + " rain=" + weather.isRain()
                + ", sun=" + weather.isSun() + ", maxTemp=" + weather.getMaxTemp()
                + ", minTemp=" + weather.getMinTemp() + " }";
    }
}

