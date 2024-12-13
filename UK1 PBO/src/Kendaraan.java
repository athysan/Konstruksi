public class Kendaraan {
    // Encapsulation: data private
    private String nama;
    private int kecepatan;

    // Constructor overloading
    public Kendaraan() {
        this.nama = "Tidak Diketahui";
        this.kecepatan = 0;
    }

    public Kendaraan(String nama, int kecepatan) {
        this.nama = nama;
        this.kecepatan = kecepatan;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    // Polymorphism: Method yang akan di-override oleh subclass
    public void berjalan() {
        System.out.println(nama + " berjalan dengan kecepatan " + kecepatan + " km/jam.");
    }
}
