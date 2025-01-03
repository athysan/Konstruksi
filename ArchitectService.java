class ArchitectService implements Service {
    private String NamaTenagaAhli;
    private double TarifPerDesain;

    public ArchitectService(String NamaTenagaAhli, double TarifPerDesain) {
        this.NamaTenagaAhli = NamaTenagaAhli;
        this.TarifPerDesain = TarifPerDesain;
    }

    @Override
    public void serviceTambahan() {
        System.out.println("Service Tambahan untuk Layanan Arsitek.");
    }

    public void totalCost(int jumlahDesain) {
        double total = jumlahDesain * TarifPerDesain;
        System.out.println("Total Biaya: " + total);
    }

    @Override
    public void displayService() {
        System.out.println("Nama Tenaga Ahli: " + NamaTenagaAhli);
        System.out.println("Tarif Per Desain: " + TarifPerDesain);
    }
}