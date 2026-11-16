
// Catatan: Commit kedua untuk OCP Depositopublic class Deposito extends Rekening implements BerBunga {
    private double bungaPersen;

    public Deposito(int nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public double getBungaPersen() {
        return bungaPersen;
    }

    @Override
    public boolean tarik(int jumlah) {
        // Deposito tidak bisa ditarik sebelum jatuh tempo (mematuhi kontrak Rekening.tarik dengan mengembalikan false)
        return false;
    }

    @Override
    public String keterangan() {
        return "Deposito, bunga " + bungaPersen + "% per bulan";
    }
}