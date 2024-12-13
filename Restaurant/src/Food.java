public class Food extends Menu {
    private String nasi;
    private String mie;

    public Food(String nama, double harga, String nasi, String mie) {
        super(nama, harga);
        this.nasi = nasi;
        this.mie = mie;
    }

    @Override
    public void displayMenu() {
        super.displayMenu();
        System.out.println("Pilih variant: Mie " + mie + " atau Nasi " + nasi);
    }
}
