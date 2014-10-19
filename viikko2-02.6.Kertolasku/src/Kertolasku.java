
import java.util.Scanner;

public class Kertolasku {

    public long kertolasku(long x, long y) {
        return -1;
    }

    public long kertolasku2(long x, long y) {
        return -1;
    }

    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        Kertolasku k = new Kertolasku();
        System.out.print("x: ");
        long x = Long.parseLong(lukija.nextLine());
        System.out.print("y: ");
        long y = Long.parseLong((lukija.nextLine()));
        System.out.println("Kertolasku(x,y): " + k.kertolasku(x, y));
        System.out.println("Kertolasku2(x,y): " + k.kertolasku2(x, y));
    }
}
