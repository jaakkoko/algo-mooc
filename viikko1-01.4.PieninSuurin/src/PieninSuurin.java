
import java.util.Scanner;

public class PieninSuurin {
    public static Scanner lukija = new Scanner(System.in);

    public static void pieninSuurin(int lukuja) {
        // tee koodisi tänne
        int pienin = 0;
        int suurin = 0;
        
        for(int i=0; i<lukuja; i++){
            int input = lukija.nextInt();
            if (i==0)suurin=input; pienin = input;
            if (input>suurin) suurin = input;
            if (input<pienin) pienin = input;
        }
        
        System.out.println("Pienin: " + pienin);
        System.out.print("Suurin: " + suurin);
    }

    public static void main(String[] args) {
        System.out.print("Kuinka monta? ");
        int lukuja = lukija.nextInt();
        System.out.println("Anna luvut:");
        pieninSuurin( lukuja );
    }
}
