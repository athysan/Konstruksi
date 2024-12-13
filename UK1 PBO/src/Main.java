public class Main {
    public static void main(String[] args) {
        // Polymorphism: objek-objek dengan tipe Kendaraan dapat mengacu ke subclass
        Kendaraan mobil = new Mobil("Toyota", 100, 5);
        Kendaraan motor = new Motor("Yamaha", 80, "Sport");
        Kendaraan truk = new Truk("Hino", 60, 10);

        // Menampilkan output dengan method yang di-override
        mobil.berjalan();
        motor.berjalan();
        truk.berjalan();

        // Menggunakan setter dan getter
        Mobil mobilBaru = new Mobil();
        mobilBaru.setNama("Honda");
        mobilBaru.setKecepatan(120);
        mobilBaru.setJumlahPenumpang(4);

        System.out.println("Mobil baru: " + mobilBaru.getNama() + " berjalan dengan kecepatan " + mobilBaru.getKecepatan() + " km/jam, membawa " + mobilBaru.getJumlahPenumpang() + " penumpang.");
    }
}
