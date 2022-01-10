package MojNovcanik;

import java.util.Scanner;

    public class MojNovcanik {

        public static void main(String[] args) {

            Racun r = new Racun();
            Menjacnica m = new Menjacnica();
            Scanner sc = new Scanner(System.in);

            System.out.println("MOJ NOVCANIK\n" + "DOBRODOSLI\n");

            while (true) {
                    glavniMeni();
                    int opcija = sc.nextInt();

                    switch (opcija) {
                        case 1:
                            r.napraviRacun();
                            break;

                        case 2:
                            r.ulogujSe();

                            int o = 0;
                            while (o != 5) {
                                logInMeni();
                                o = sc.nextInt();
                                switch (o) {
                                    case 1:
                                        r.stanjeNaRacunu();
                                        break;
                                    case 2:
                                        try {
                                            r.placanje();
                                        }
                                        catch(ArithmeticException e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        try {
                                            r.prenos();
                                        }
                                        catch(ArithmeticException e){
                                            System.out.println(e.getMessage());
                                    }
                                        break;
                                    case 4:
                                        m.menjacnica();
                                        break;
                                    case 5:
                                        break;
                                }

                            }

                            if (o == 5) {
                                break;
                            }
                        case 3:
                            kontakt();
                            break;
                        case 4:
                            System.out.println("DOVIDJENJA");
                            System.exit(0);
                        default:
                            System.out.println("GRESKA");

                    }
        }

        }
        public static void glavniMeni() {
            System.out.println("1.Novi nalog");
            System.out.println("2.Uloguj se");
            System.out.println("3.Kontakt");
            System.out.println("4.Izadji");
            System.out.println("Izaberi opciju: ");
        }

        public static void logInMeni() {
            System.out.println("1.Stanje na racunu");
            System.out.println("2.Novo placanje");
            System.out.println("3.Prenos sredstava");
            System.out.println("4.Konvertor valuta");
            System.out.println("5.Nazad");
            System.out.println("Izaberite opciju: ");
        }


        public static void kontakt() {
            System.out.println("MojNovcanik Banka\n" + "Vuka Karadzica 1\n" + "011 987 6543\n");
        }

    }

