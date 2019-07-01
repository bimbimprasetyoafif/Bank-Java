package Database;
/**
 *
 * @author Bimo Prasetyo Afif
 */
public class Transaksi {
    protected short kode;
    protected String kredit;
    protected String debit;
    protected String saldo;

    public Transaksi(short kode, String kredit, String debit, String saldo) {
        this.kode = kode;
        this.kredit = kredit;
        this.debit = debit;
        this.saldo = saldo;
    }
    
    public String getAll(){
        return this.kode+"\t"+this.debit+"\t"+this.kredit+"\t"+this.saldo+"\n";
    }
}
