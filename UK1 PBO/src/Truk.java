public class Truk extends Kendaraan {
    private int kapasitas;

    public Truk(String nama, int kecepatan, int kapasitas) {
        super(nama, kecepatan);
        this.kapasitas = kapasitas;
    }

    // Getter dan Setter
    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    // Overriding method berjalan
    @Override
    public void berjalan() {
        System.out.println(getNama() + " (truk) berjalan dengan kecepatan " + getKecepatan() + " km/jam, dengan kapasitas " + kapasitas + " ton.");
    }
}
