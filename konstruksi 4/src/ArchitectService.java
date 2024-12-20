class ArchitectService implements Service {
    private String namaTenagaAhli;
    private double tarifPerDesain;

    public ArchitectService(String namaTenagaAhli, double tarifPerDesain) {
        this.namaTenagaAhli = namaTenagaAhli;
        this.tarifPerDesain = tarifPerDesain;
    }

    public String getNamaTenagaAhli() {
        return namaTenagaAhli;
    }

    public double getTarifPerDesain() {
        return tarifPerDesain;
    }

    @Override
    public void serviceTambahan() {
        System.out.println("Service Tambahan untuk Layanan Arsitek.");
    }

    @Override
    public void displayService() {
        System.out.println("Nama Tenaga Ahli: " + namaTenagaAhli);
        System.out.println("Tarif Per Desain: " + tarifPerDesain);
    }
}