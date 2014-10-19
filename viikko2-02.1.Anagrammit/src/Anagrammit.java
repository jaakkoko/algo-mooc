import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Anagrammit {
    public static Scanner lukija = new Scanner(System.in);

    public static boolean anagrammit(String sana1, String sana2) {
        // kirjoita koodi tanne

        return true;


    }

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
              
            SecureRandom random = new SecureRandom();
            System.out.println(new BigInteger(130, random).toString(32));
  

        }
//        System.out.print("Anna 1. sana: ");
//        String sana1 = lukija.nextLine();
//        System.out.print("Anna 2. sana: ");
//        String sana2 = lukija.nextLine();
//
//        if ( anagrammit(sana1, sana2) )
//            System.out.print("Annoit anagrammit.");
//        else
//            System.out.println("Et antanut anagrammeja.");
    }
}
