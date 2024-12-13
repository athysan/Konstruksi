abstract class Proyek {
    private String idProyek;
    private String namaProyek;
    private String lokasi;
    private int anggaran;
    private String status;

    public Proyek(String idProyek, String namaProyek, String lokasi, int anggaran, String status) {
        this.idProyek = idProyek;
        this.namaProyek = namaProyek;
        this.lokasi = lokasi;
        this.anggaran = anggaran;
        this.status = status;
    }

    public abstract void changeStatus(String status);

    public int totalBudget() {
        return anggaran;
    }

    public void setLocation(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getStatus() {
        return status;
    }

    public void displayProject() {
        System.out.println("Proyek: " + namaProyek + ", Lokasi: " + lokasi + ", Anggaran: " + anggaran + ", Status: " + status);
    }
}