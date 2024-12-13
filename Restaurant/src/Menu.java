public class Menu {
    private String namaMenu;
    private double harga;

    public Menu(String nama, double harga) {
        this.namaMenu = nama;
        this.harga = harga;
    }

    public String getNama() {
        return namaMenu;
    }

    public void setNama(String nama) {
        this.namaMenu = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void displayMenu() {
        System.out.println("Menu Item: " + namaMenu + ", Harga: " + harga);
    }
}
