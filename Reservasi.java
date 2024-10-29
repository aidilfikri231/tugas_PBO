class Reservasi {
    private Tamu tamu;
    private Kamar kamar;
    private int jumlahMalam;
    private Fasilitas fasilitas;

    // Constructor overloading
    public Reservasi(Tamu tamu, Kamar kamar, int jumlahMalam) {
        this(tamu, kamar, jumlahMalam, null);
    }

    public Reservasi(Tamu tamu, Kamar kamar, int jumlahMalam, Fasilitas fasilitas) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.jumlahMalam = jumlahMalam;
        this.fasilitas = fasilitas;
    }

    public double hitungTotalBiaya() {
        double biayaKamar = kamar.hitungBiaya(jumlahMalam);
        double biayaFasilitas = (fasilitas != null) ? fasilitas.getBiayaFasilitas() : 0;
        return biayaKamar + biayaFasilitas;
    }

    public void tampilkanInfoReservasi() {
        System.out.println("\n--- Informasi Reservasi ---");
        System.out.println("Nama Tamu: " + tamu.getNama());
        System.out.println("Nomor Telepon: " + tamu.getNoTelepon());
        System.out.println("Nomor Kamar: " + kamar.getNomorKamar());
        System.out.println("Jumlah Malam: " + jumlahMalam);
        System.out.println("Total Biaya: Rp " + hitungTotalBiaya());

        if (fasilitas != null) {
            System.out.println("Fasilitas Tambahan: " + fasilitas.getNamaFasilitas() + " (Rp " + fasilitas.getBiayaFasilitas() + ")");
        }
    }
}