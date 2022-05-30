package Task11;

public class Driver {
    private String nameDriver;
    private int age;

    public Driver(final String nameDriver, final int age) {
        this.nameDriver = nameDriver;
        setAge(age);
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(final String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        if (age >= 18)
            this.age = age;
    }
}

