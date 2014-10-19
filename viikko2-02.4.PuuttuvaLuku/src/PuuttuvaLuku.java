import java.util.Scanner;

public class PuuttuvaLuku {
    public static Scanner lukija = new Scanner(System.in);

    public static int puuttuvaLuku(int[] luvut) {
        // tee koodisi tanne
        
        return -1;


    }

    public static void main(String[] args) {
        System.out.print("Suurin luku? ");
        int suurin = lukija.nextInt();
        int luvut[] = new int[suurin-1];

        System.out.println("Anna luvut:");

        for ( int i=0; i<suurin-1; i++ )
            luvut[i] = lukija.nextInt();
        
        int puuttuva = puuttuvaLuku( luvut );

        System.out.println("Puuttuva luku: "+ puuttuva );
    }
}
