
import java.util.Scanner;

public class Palindromi {
    static Scanner lukija = new Scanner(System.in);

    static boolean palindromi(String sana) {
        // tee koodi tänne
        String temp = "";
        for (int i = sana.length()-1; i>=0; i--){
            temp += sana.charAt(i);
        }
        
        return temp.equals(sana);
    }

    public static void main(String[] args) {
        System.out.print("Anna sana: ");
        String sana = lukija.nextLine();
        
        if ( palindromi(sana) )
            System.out.print("Sana on palindromi.");
        else
            System.out.print("Sana ei ole palindromi.");
    }
}
