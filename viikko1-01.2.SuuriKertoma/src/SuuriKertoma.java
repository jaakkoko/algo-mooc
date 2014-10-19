import java.math.BigInteger;
import java.util.Scanner;

public class SuuriKertoma {

    public static BigInteger suuriKertoma(int luku) {
        // kirjoita koodi tänne
        
        BigInteger kertoma = BigInteger.valueOf(1);
        for(int i=1; i<luku; i++){
            kertoma = kertoma.add(kertoma.multiply(BigInteger.valueOf(i)));
        }
        

        return kertoma;
    }

    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.print("Anna luku: ");
//        int luku = Integer.parseInt( lukija.nextLine() );
//
//        BigInteger vastaus = suuriKertoma( luku );
//
//        System.out.println("Kertoma: " + vastaus);
        Scanner lukija = new Scanner("1 4 6\n 7    \n 8");
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        
        
        lukija = new Scanner("1 4 6\n 7    \n 8");
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextInt());
        System.out.println(lukija.nextLine());
        System.out.println(lukija.nextInt());
        
        
    }
}
