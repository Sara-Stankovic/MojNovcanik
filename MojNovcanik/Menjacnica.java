package MojNovcanik;

import java.util.Scanner;

public class Menjacnica {

    int valuta;
    double  iznos;

    Scanner sc = new Scanner(System.in);

    //default konstruktor
    public Menjacnica() {
    }

    //metoda za konvertovanje valuta
    public void menjacnica(){
        System.out.println("1.Evro");
        System.out.println("2.Dolar");
        System.out.println("3.Franak");
        System.out.println("Izaberite valutu: ");
        valuta = sc.nextInt();
        System.out.println("Unesite iznos: ");
        iznos = sc.nextDouble();
        double iznosKonv = 0;
        switch(valuta) {
            case 1:
                iznosKonv = iznos/117.6;
                System.out.println(iznos + " dinara u evrima iznosi " + iznosKonv);
                break;

            case 2:
                iznosKonv = iznos/103.6;
                System.out.println(iznos + " dinara u dolarima iznosi " + iznosKonv);
                break;


            case 3:
                iznosKonv = iznos/112.9;
                System.out.println(iznos + " dinara u francima iznosi " + iznosKonv);
                break;

              }

             }

        }





