package utcb.sda8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Oferta {
    int investitie;
    int beneficiu;

    Oferta(int investitie, int beneficiu) {
        this.investitie = investitie;
        this.beneficiu = beneficiu;
    }

    @Override
    public String toString() {
        return String.format("Inv: %d, Ben: %d", this.investitie, this.beneficiu);
    }
}

class SortByOutput implements Comparator<Oferta> {
    public int compare(Oferta a, Oferta b) {
        return b.beneficiu - a.beneficiu;
    }
}

public class Intreprinzator {
    public static void resolve() {
        Oferta[] oferte = {
            new Oferta(100, 10),
                new Oferta(100, 20),
                new Oferta(10, 10),
                new Oferta(10, 8),
                new Oferta(20, 12),
                new Oferta(30, 9),
                new Oferta(50, 16),
                new Oferta(40, 14),
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceti capitalul: ");
        int capital = sc.nextInt();

        Arrays.sort(oferte, new SortByOutput());
        System.out.printf("Oferte: %s\n", Arrays.toString(oferte));

        for (Oferta oferta : oferte) {
            if (capital < oferta.investitie) {
                continue;
            }

            if (oferta.investitie > oferta.beneficiu) {
                continue;
            }

            capital -= oferta.investitie;
            System.out.printf("Se investeste in oferta: %s\nRamanem cu capitalul: %d\n", oferta, capital);
        }
        sc.close();
    }
}
