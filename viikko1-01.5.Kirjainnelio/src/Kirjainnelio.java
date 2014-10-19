
import java.util.Scanner;

public class Kirjainnelio {

    public static Scanner lukija = new Scanner(System.in);

    public static void tulostaKirjainnelio(int eriKirjaimia) {
        // tänne koodi joka tulostaa kirjainneliön
       
        int width = eriKirjaimia * 2 - 1;
        char ch = 'a';
        
        for(int row=1; row<=eriKirjaimia; row++){
            for(int left=1; left<eriKirjaimia; left++){
                printChar(ch);
                if(left<row)ch++;
            }
            for(int right=eriKirjaimia; right>0; right--){
                printChar(ch);
                if(right<=row)ch--;
            }
            System.out.println();
            ch='a';
        }
        
        for(int row=eriKirjaimia-1; row>0; row--){
            for(int left=1; left<eriKirjaimia; left++){
                printChar(ch);
                if(left<row)ch++;
            }
            for(int right=eriKirjaimia; right>0; right--){
                printChar(ch);
                if(right<=row)ch--;
            }
            System.out.println();
            ch='a';
        }
    }
    
    
    public static void printChar(char ch){
        System.out.print(Character.toUpperCase(ch));
    }
    
    public static void main(String[] args) {
        System.out.print("Anna koko: ");
        int eriKirjaimia = lukija.nextInt();
        tulostaKirjainnelio(eriKirjaimia);
        // huom: oletetaan että myös viimeisen rivin jälkeen on rivinvaihto
    }

}