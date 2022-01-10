package MojNovcanik;

import java.util.Scanner;

public class Racun {

    private String ime, email, pin;
    private double stanjeDin, stanjeDev;
    ArithmeticException e = new ArithmeticException("Nemate dovoljno sredstva na racunu.");

    Scanner sc = new Scanner(System.in);

    //default konstruktor
    public Racun() {
    }

    //metoda za kreiranje novog naloga
    public void napraviRacun(){

        System.out.println("Ime i prezime: ");
        ime = sc.nextLine();
        System.out.println("Email: ");
        email = sc.next();
        while(!email.contains("@") || !email.endsWith(".com")){
            System.out.println("Nevazeci email.");
            System.out.println("Email: ");
            email = sc.next();
        }
        System.out.println("Kreirajte svoj PIN: ");
        pin = sc.next();
        while(!pin.matches("[0-9]{4}")){
            System.out.println("PIN mora da ima 4 broja.");
            System.out.println("Kreirajte svoj PIN: ");
            pin = sc.next();
        }
        while(true){
            System.out.println("Ponovite PIN: ");
            String pin2 = sc.next();
            if(!pin2.equals(pin)){
                System.out.println("PIN se ne podudara.");
            }else
                break;
        }
        System.out.println("Unesite pocetno stanje na dinarskom racunu: ");
        stanjeDin = sc.nextDouble();
        System.out.println("Unesite pocetno stanje na deviznom racunu: ");
        stanjeDev = sc.nextDouble();

        System.out.println("Uspesno ste otvorili nalog.");

    }

    //metoda za login
    public void ulogujSe(){

            System.out.println("PIN: ");
            String logPin = sc.next();
            while(!logPin.equals(pin)){
                System.out.println("Pogresan PIN.");
                System.out.println("PIN: ");
                logPin = sc.next();
            }

    }


    //metoda za placanje
    public void placanje() throws ArithmeticException{

        System.out.println("1.Racuni\n" + "2.Hrana\n"+ "3.Odeca\n" + "4.Zabava");
        System.out.println("Svrha placanja: ");
        int k = sc.nextInt();
        while(k<1 || k>4){
            System.out.println("Nevalidan unos.");
            System.out.println("Svrha placanja: ");
            k = sc.nextInt();
        }

        System.out.println("Unesite iznos za placanje: ");
        double iznos = sc.nextDouble();
        if(iznos > stanjeDin){
           throw e;
        }
        stanjeDin -= iznos;
        System.out.println("Placanje uspesno.\nRasploziva sredstva: " + stanjeDin);

    }

    //metoda za prenos sredstava sa jednog racuna na drugi
    public void prenos() throws ArithmeticException{

        System.out.println("Racun sa koga prenosite: ");
        System.out.println("1.Dinarski\n" + "2.Devizni");
        int racun = sc.nextInt();
        System.out.println("Unesite iznos za uplatu: ");
        double iznos = sc.nextDouble();
        if(racun==1) {
            if(iznos > stanjeDin){
                throw e;
            }
            stanjeDev += (iznos / 117.6);
            stanjeDin -= iznos;
        }else{
            if(iznos > stanjeDev){
                throw e;
            }
            stanjeDin += (iznos * 117.6);
            stanjeDev -= iznos;
        }
        System.out.println("Uspesno.\n" + "Raspoloziva sredstva: ");
        System.out.println("Dinarski racun: " + stanjeDin);
        System.out.println("Devizni racun: " + stanjeDev);
    }

    //metoda za ispis stanja na racunima
    public void stanjeNaRacunu(){

        System.out.println("1.Dinarski racun\n" + "2.Devizni racun");
        System.out.println("Izaberite opciju: ");
        int opcija = sc.nextInt();
        if(opcija==1) {
            System.out.println("Stanje na racunu: " + stanjeDin);
        }else{
            System.out.println("Stanje na racunu: " + stanjeDev);
        }
    }


}
