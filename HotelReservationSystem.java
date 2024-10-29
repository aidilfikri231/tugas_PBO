import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private static List<Kamar> kamarList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menambahkan beberapa kamar secara manual
        kamarList.add(new KamarStandar(101, 300000));
        kamarList.add(new KamarSuite(201, 500000));

        // Proses reservasi secara dinamis
        System.out.print("Masukkan nama tamu: ");
        String namaTamu = scanner.nextLine();
        System.out.print("Masukkan nomor telepon tamu: ");
        String noTelepon = scanner.nextLine();
        Tamu tamu = new Tamu(namaTamu, noTelepon);

        // Menampilkan daftar kamar
        tampilkanKamar();

        System.out.print("Pilih nomor kamar yang tersedia: ");
        int nomorKamar = scanner.nextInt();
        Kamar kamar = pilihKamar(nomorKamar);

        if (kamar == null) {
            System.out.println("Kamar tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan jumlah malam menginap: ");
        int jumlahMalam = scanner.nextInt();

        System.out.print("Apakah Anda ingin fasilitas tambahan? (ya/tidak): ");
        scanner.nextLine();  // Membersihkan newline
        String fasilitasInput = scanner.nextLine();

        Fasilitas fasilitas = null;
        if (fasilitasInput.equalsIgnoreCase("ya")) {
            System.out.print("Masukkan nama fasilitas: ");
            String namaFasilitas = scanner.nextLine();
            System.out.print("Masukkan biaya fasilitas: ");
            double biayaFasilitas = scanner.nextDouble();
            fasilitas = new Fasilitas(namaFasilitas, biayaFasilitas);
        }

        // Membuat reservasi
        Reservasi reservasi = new Reservasi(tamu, kamar, jumlahMalam, fasilitas);

        // Menampilkan informasi reservasi
        reservasi.tampilkanInfoReservasi();
    }

    // Menampilkan daftar kamar
    private static void tampilkanKamar() {
        System.out.println("Daftar Kamar yang Tersedia:");
        for (Kamar kamar : kamarList) {
            System.out.println("Nomor Kamar: " + kamar.getNomorKamar() +
                    ", Harga per Malam: Rp " + kamar.hargaPerMalam +
                    ", Tipe: " + kamar.getClass().getSimpleName());
        }
    }

    // Memilih kamar berdasarkan nomor kamar
    private static Kamar pilihKamar(int nomorKamar) {
        for (Kamar kamar : kamarList) {
            if (kamar.getNomorKamar() == nomorKamar) {
                return kamar;
            }
        }
        return null;
    }
}