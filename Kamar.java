abstract class Kamar {
    protected int nomorKamar;
    protected double hargaPerMalam;

    public Kamar(int nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
    }

    public abstract double hitungBiaya(int jumlahMalam);

    public int getNomorKamar() {
        return nomorKamar;
    }
}