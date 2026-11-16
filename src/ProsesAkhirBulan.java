public class ProsesAkhirBulan {

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int biaya = r.getBiayaAdmin();

            r.tarik(biaya);
            System.out.println(r.getNomor() + " biaya admin : " + Rekening.formatRupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            Rekening r = (Rekening) b;
            int saldoSebelumBiayaAdmin = r.getSaldo() + r.getBiayaAdmin();
            int bunga = (int) (saldoSebelumBiayaAdmin * (b.getBungaPersen() / 100.0));
            r.setor(bunga);
            System.out.println(r.getNomor() + " bunga       : " + Rekening.formatRupiah(bunga));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            boolean status = r.tarik(jumlah);
            if (status) {
                System.out.println(r.getNomor() + " autodebet   : " + Rekening.formatRupiah(jumlah));
            } else {
                System.out.println(r.getNomor() + " autodebet   : gagal");
            }
        }
    }
}