public class Customer {
    private String namaPelanggan;
    private String kontak;

    public Customer(String namaPelanggan, String kontak) {
        this.namaPelanggan = namaPelanggan;
        this.kontak = kontak;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getKontak() {
        return kontak;
    }
}
