import java.util.Scanner;

public class Kertoma {
    public static int kertoma(int luku) {
        // kirjoita koodi tänne
        int kertoma = 1;
        for(int i=1; i<luku+1; i++){
            kertoma = kertoma * i;
        }
        return kertoma;
    }
    
    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt( lukija.nextLine() );

        int vastaus = kertoma( luku );

        System.out.println("Kertoma: " + vastaus);
       
    }
}


