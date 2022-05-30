package Task1;

class Client extends Person{

    private int sum;
    static String bank;

    public int getSum() {
        return sum;
    }

    public void setSum(final int sum) {
        this.sum = sum;
    }

    public static String getBank() {
        return bank;
    }

    public static void setBank(final String bank) {
        Client.bank = bank;
    }

    public Client(final String name, final int sum) {

        super(name);
        this.sum=sum;
    }
    static {
        bank = "Mono";
    }
}