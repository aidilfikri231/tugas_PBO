class KamarSuite extends Kamar {
    public KamarSuite(int nomorKamar, double hargaPerMalam) {
        super(nomorKamar, hargaPerMalam);
    }

    @Override
    public double hitungBiaya(int jumlahMalam) {
        return (hargaPerMalam * jumlahMalam) * 1.2; // Tambahan biaya untuk suite
    }

}