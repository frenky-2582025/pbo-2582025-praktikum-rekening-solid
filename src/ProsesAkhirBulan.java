public class ProsesAkhirBulan {

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int biaya = 0;
            if (r instanceof Tabungan) {
                if (r.getNomor() == 102) biaya = 5000; // contoh aturan biaya admin
            } else if (r instanceof Giro) {
                if (r.getNomor() == 201) biaya = 15000;
            }
            // Deposito bebas biaya admin (0)

            r.tarik(biaya);
            System.out.println(r.getNomor() + " biaya admin : " + Rekening.formatRupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            Rekening r = (Rekening) b;
            int bunga = (int) (r.getSaldo() * (b.getBungaPersen() / 100.0));
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