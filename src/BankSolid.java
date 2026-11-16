// Catatan: Commit ketiga finalisasi
public class BankSolid {
    public static void main(String[] args) {
        // Data rekening awal
        Tabungan r1 = new Tabungan(101, "Ani", 1000000, 2.5);
        Tabungan r2 = new Tabungan(102, "Citra", 300000, 2.0);
        Giro r3 = new Giro(201, "Budi", 200000, 500000);
        Deposito r4 = new Deposito(301, "Dewi", 5000000, 4.0);

        Rekening[] semuaRekening = {r1, r2, r3, r4};
        BerBunga[] rekeningBerbunga = {r1, r2, r4};

        LaporanBank laporan = new LaporanBank();
        ProsesAkhirBulan proses = new ProsesAkhirBulan();

        laporan.cetakDaftar("REKENING AWAL", semuaRekening);

        System.out.println("\n========== AKHIR BULAN ==========");
        proses.potongBiayaAdmin(semuaRekening);
        proses.tambahBunga(rekeningBerbunga);
        proses.autodebet(semuaRekening, 50000);

        System.out.println();
        laporan.cetakDaftar("REKENING AKHIR", semuaRekening);
        laporan.cetakTotal(semuaRekening);
    }
}