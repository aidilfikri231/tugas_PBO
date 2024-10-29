class KamarStandar extends Kamar {
    public KamarStandar(int nomorKamar, double hargaPerMalam) {
        super(nomorKamar, hargaPerMalam);
    }

    @Override
    public double hitungBiaya(int jumlahMalam) {
        return hargaPerMalam * jumlahMalam;
    }
}