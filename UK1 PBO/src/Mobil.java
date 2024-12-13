public class Mobil extends Kendaraan {
    private int jumlahPenumpang;

    // Constructor overloading
    public Mobil() {
        super(); // Memanggil constructor dari kelas induk
        this.jumlahPenumpang = 4;
    }

    public Mobil(String nama, int kecepatan, int jumlahPenumpang) {
        super(nama, kecepatan); // Memanggil constructor dari kelas induk
        this.jumlahPenumpang = jumlahPenumpang;
    }

    // Getter dan Setter
    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    // Overriding method berjalan
    @Override
    public void berjalan() {
        System.out.println(getNama() + " (mobil) berjalan dengan kecepatan " + getKecepatan() + " km/jam, membawa " + jumlahPenumpang + " penumpang.");
    }
}
