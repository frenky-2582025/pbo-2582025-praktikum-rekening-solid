public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(int nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public double getBungaPersen() {
        return bungaPersen;
    }

    @Override
    public int getBiayaAdmin() {
        return nomor == 102 ? 5000 : 0;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public String keterangan() {
        return "Tabungan, bunga " + bungaPersen + "% per bulan";
    }
}