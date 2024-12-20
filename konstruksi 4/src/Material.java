class Material {
    private String namaMaterial;
    private int stok;
    private int harga;

    public Material(String namaMaterial, int stok, int harga) {
        this.namaMaterial = namaMaterial;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNamaMaterial() {
        return namaMaterial;
    }

    public int getStok() {
        return stok;
    }

    public int getHarga() {
        return harga;
    }
}
