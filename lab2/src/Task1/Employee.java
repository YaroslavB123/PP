package Task1;

public class Employee extends Person {
    private String nameCompany;
    private static String sphere;

    public Employee(final String name, final String nameCompany) {
        super(name);
        this.nameCompany = nameCompany;
    }
    static {
        sphere = "Finance";

    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(final String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public static String getSphere() {
        return sphere;
    }

    public static void setSphere(final String sphere) {
        Employee.sphere = sphere;
    }
}
