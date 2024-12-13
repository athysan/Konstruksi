public class Drink extends Menu {
    private String anget;
    private String es;

    public Drink(String nama, double harga, String anget, String es) {
        super(nama, harga);
        this.anget = anget;
        this.es = es;
    }

    @Override
    public void displayMenu() {
        super.displayMenu();
        System.out.println("Pilih minuman: Anget " + anget + " atau Es " + es);
    }
}
