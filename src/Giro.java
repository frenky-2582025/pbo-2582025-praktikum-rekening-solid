public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(int nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int getBiayaAdmin() {
        return 15000;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && (saldo + batasOverdraft) >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public String keterangan() {
        return "Giro, batas overdraft " + formatRupiah(batasOverdraft);
    }
}