
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.4")
public class PieninSuurinTest {
    ByteArrayOutputStream tulostus;

    @Before 
    public void setup() {
        tulostus = new ByteArrayOutputStream();
        System.setOut( new PrintStream(tulostus) );
    }

    @Test 
    public void yksiLuku(){
        String syote = generoiSyote( 55 );
        String odotettu = generoiOdotettuTulos( 55, 55 );

        suoritaSovellus(syote);

        assertEquals( odotettu,  poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void kaksiLukua(){
        String syote    = generoiSyote( 10, 5);
        String odotettu = generoiOdotettuTulos(5, 10);

        suoritaSovellus(syote);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void vaanNegatiivisia(){
        String syote    = generoiSyote( -1, -5 );
        String odotettu = generoiOdotettuTulos(-5, -1);

        suoritaSovellus(syote);

        assertEquals( odotettu,  poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void montaLukua(){
        String syote    = generoiSyote( 3, 99, -2, 3, 47, -235 );
        String odotettu = generoiOdotettuTulos( -235, 99 );

        suoritaSovellus(syote);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    // apumetodit

    private String poistaKenoR(String mj) {
        mj = mj.replace("\r", "");
        return mj.trim();
    }

    private String generoiOdotettuTulos( int p, int s) {
        return ("Pienin: " + p +  "\nSuurin: "+ s + "\n").trim();
    }

    private String generoiSyote(int... luvut) {
        String syote = "" + luvut.length + "\n";
        for ( int luku : luvut ){
            syote += luku + "\n";
        }

        return syote;
    }

    private Scanner teeTestisyotteestaScanner(String syote) {
        return new Scanner(new ByteArrayInputStream(syote.getBytes()));
    }

    private void suoritaSovellus(String syote) {
        PieninSuurin.lukija = teeTestisyotteestaScanner(syote);
        int lukuja = PieninSuurin.lukija.nextInt();
        PieninSuurin.pieninSuurin(lukuja);
    }
}