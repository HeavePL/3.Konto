public class KontoBankowe {
    private int numerKonta;
    private float saldo;
    private Klient owner;
    public KontoBankowe(Klient owner,int numerKonta, float saldo){
        setOwner(owner);
        setNumerKonta(numerKonta);
        setSaldo(saldo);
    }

    public void wplacanie(float kwota){
        setSaldo(getSaldo()+kwota);
    }

    public void wyplacanie(float kwota){
        if (kwota < 0 ){
            System.out.println("Błąd, podaj poprawną kwotę");
        }else if(getSaldo()<kwota){
            System.out.println("Brak pieniędzy na koncie");
        } else {
            setSaldo(getSaldo()-kwota);
            System.out.println("Wypłacono: "+kwota);
        }
    }

    public void wyswietlSaldo(){
        System.out.println("Aktualne saldo: "+getSaldo());;
    }

    public void wyswietlInformacje(){
        System.out.println("ID: "+ getNumerKonta());
        System.out.println("Właściciel: "+ getOwner().getId() + " " + getOwner().getNazwa() + " " + getOwner().getAdres());
        wyswietlSaldo();
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Klient getOwner() {
        return owner;
    }

    public void setOwner(Klient owner) {
        this.owner = owner;
    }

    public int getNumerKonta() {
        return numerKonta;
    }

    public void setNumerKonta(int numerKonta) {
        this.numerKonta = numerKonta;
    }
}
