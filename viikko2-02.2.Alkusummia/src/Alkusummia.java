import java.util.Scanner;

// Älä koske tähän luokkaan, vaan luokkaan Etsin.

public class Alkusummia {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Montako lukua?");
        int n = Integer.parseInt(s.nextLine());
        int[] luvut = new int[n];

        System.out.println("Anna luvut:");
        for (int i = 0; i<n; i++) {
            int luku = Integer.parseInt(s.nextLine());
            luvut[i] = luku;
        }

        Etsin e = new Etsin(luvut);

        while (true) {
            System.out.println("Mikä summa?");
            int x = Integer.parseInt(s.nextLine());
            System.out.println("Indeksi: "+e.etsi(x));
        }
        
    }

}