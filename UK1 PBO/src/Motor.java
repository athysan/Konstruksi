public class Motor extends Kendaraan {
    private String jenisMotor;

    public Motor(String nama, int kecepatan, String jenisMotor) {
        super(nama, kecepatan);
        this.jenisMotor = jenisMotor;
    }

    // Getter dan Setter
    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    // Overriding method berjalan
    @Override
    public void berjalan() {
        System.out.println(getNama() + " (motor) jenis " + jenisMotor + " berjalan dengan kecepatan " + getKecepatan() + " km/jam.");
    }
}
