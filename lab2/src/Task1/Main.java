package Task1;

public class Main {
    public static void main(final String[] args) {
        final Client client = new Client("Ivan",100);
        final Employee employee = new Employee("Vasyl","RAPApam");
        System.out.println(client.getName() + "   " +client.getSum());
        System.out.println(employee.getName() + "  " + employee.getNameCompany());
    }
}
