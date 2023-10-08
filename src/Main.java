import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int opcja;
        ArrayList<Klient> klienci = new ArrayList<Klient>();
        ArrayList<KontoBankowe> konta = new ArrayList<KontoBankowe>();

        do {
        System.out.println("Konto bankowe");
        System.out.println("1. Utwórz nowego użytkownika");
        System.out.println("2. Wyświetl wszystkich użytkowników");
        System.out.println("3. Wyswietl dane dla 1 uzytkownika");
        System.out.println("4. Utwórz nowe konto");
        System.out.println("5. Otwórz istniejące konto ");
        System.out.println("6. Zakończ");

        opcja = skan.nextInt();

            switch (opcja) {
                case 1:
                    klienci.add(utworzKlienta());
                    break;
                case 2:
                    AtomicInteger i = new AtomicInteger();
                    i.set(1);
                    klienci.forEach(nazwa->{
                        System.out.println(i+". "+nazwa.getNazwa());
                        i.set(i.get() + 1);
                    });
                    break;
                case 3:
                    System.out.println("Podaj numer użytkownika (Pobrany z listy użytkowników)");
                    klienci.get(skan.nextInt() - 1).wyswietlInformacje();

                    break;
                case 4:
                    konta.add(utworzKonto(klienci));
                    break;
                case 5:
                    boolean ist = false;
                    System.out.println("Podaj numer konta");
                    int numer = skan.nextInt();
                    for (int j =0 ; j<konta.size(); j++){
                        if(konta.get(j).getNumerKonta()==numer){
                            ist = true;
                            int opcja2;
                            System.out.println("Konto istnieje");
                            do {
                                System.out.println("Zarządzenie kotenm numer "+konta.get(j).getNumerKonta());
                                System.out.println("1. Wyświetl Saldo konta ");
                                System.out.println("2. Wypłać pieniądze ");
                                System.out.println("3. Wpłać pieniądze ");
                                System.out.println("4. Wyswietl informacje o koncie");
                                System.out.println("5. Zakończ ");
                                opcja2 = skan.nextInt();
                                switch (opcja2){
                                    case 1:
                                        konta.get(j).wyswietlSaldo();
                                        break;
                                    case 2:
                                        System.out.println("Podaj kwotę");
                                        konta.get(j).wyplacanie(skan.nextFloat());
                                        break;
                                    case 3:
                                        System.out.println("Podaj kwotę");
                                        konta.get(j).wplacanie(skan.nextFloat());
                                        break;
                                    case 4:
                                        konta.get(j).wyswietlInformacje();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Zła opcja");
                                }

                            }while(opcja2 != 5);
                        }
                    }
                    if (ist = false){
                        System.out.println("Konto nie istnieje");
                    }
                    break;
                case 6:
                    break;

                default:
                    System.out.println("Zła opcja");


            }
        }while (opcja != 6);
    }
    static public Klient utworzKlienta(){
        Scanner skan = new Scanner(System.in);
        String nazwa;
        int id;
        String adres;
        System.out.println("Podaj nazwę konta");
        nazwa = skan.next();
        System.out.println("Podaj id konta");
        id = skan.nextInt();
        skan.nextLine();
        System.out.println("Podaj adres");
        adres = skan.nextLine();
        Klient klient = new Klient(nazwa,id,adres);
        return klient;
    }

    public static KontoBankowe utworzKonto(ArrayList<Klient> klienci){
        Scanner skan = new Scanner(System.in);
        int numer;
        Klient user;
        System.out.println("Podaj numer konta");
        numer = skan.nextInt();;
        System.out.println("Podaj numer użytkownika");
        user = klienci.get(skan.nextInt() - 1);

        KontoBankowe konto = new KontoBankowe(user, numer, 0);
        System.out.println("Utworzono konto");
        return konto;

    }
    public static void OtworzKonto(ArrayList<KontoBankowe> konta){

    }
}
