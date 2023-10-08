public class Klient {
    private String nazwa;
    private int id;
    private String adres;

    public Klient(String nazwa, int id, String adres) {
        setNazwa(nazwa);
        setId(id);
        setAdres(adres);
    }

    public void wyswietlInformacje(){
        System.out.println("Id: "+getId());
        System.out.println("Nazwa: "+getNazwa());
        System.out.println("Adres: "+getAdres());
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
