import java.util.Scanner;

public class SuurinSumma {
    public static Scanner lukija = new Scanner(System.in);

    public static int suurinSumma(int[] luvut) {
        // tee koodisi tanne
        
        return -1;


    }

    public static void main(String[] args) {
        System.out.print("Kuinka monta? ");
        int lukuja = lukija.nextInt();
        int luvut[] = new int[lukuja];
        System.out.println("Anna luvut: ");
        for( int i=0; i<lukuja; i++) {
            luvut[i] = lukija.nextInt();
        }

        System.out.println("Suurin summa: "+ suurinSumma(luvut) );
    }
}
