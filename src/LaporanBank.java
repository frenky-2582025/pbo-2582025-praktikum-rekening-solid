public class LaporanBank {

    public void cetakDaftar(String judul, Rekening[] semua) {
        System.out.println("========== " + judul + " ==========");
        for (Rekening r : semua) {
            System.out.println(r.getNomor() + " | " + r.getPemilik() + " | " + Rekening.formatRupiah(r.getSaldo()));
            System.out.println("\t" + r.keterangan());
        }
        System.out.println("-------------------------------------");
    }

    public void cetakTotal(Rekening[] semua) {
        int totalDana = 0;
        for (Rekening r : semua) {
            totalDana += r.getSaldo();
        }
        System.out.println("Total dana bank : " + Rekening.formatRupiah(totalDana));
    }
}