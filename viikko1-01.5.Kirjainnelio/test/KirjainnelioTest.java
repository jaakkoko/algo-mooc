import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.5")
public class KirjainnelioTest {
    ByteArrayOutputStream tulostus;

    @Before
    public void setup() {
        tulostus = new ByteArrayOutputStream();
        System.setOut( new PrintStream(tulostus) );
    }

    @Test
    public void yksiEriKirjain(){
        String odotettu = "A\n";

        Kirjainnelio.tulostaKirjainnelio(1);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void kaksiEriKirjainta(){
        String odotettu = "AAA\n" +
                          "ABA\n" +
                          "AAA\n";

        Kirjainnelio.tulostaKirjainnelio(2);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void kolmeEriKirjainta(){
        String odotettu = "AAAAA\n" +
                          "ABBBA\n" +
                          "ABCBA\n" +
                          "ABBBA\n" +
                          "AAAAA\n";

        Kirjainnelio.tulostaKirjainnelio(3);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void neljaEriKirjainta(){
        String odotettu = "AAAAAAA\n" +
                          "ABBBBBA\n" +
                          "ABCCCBA\n" +
                          "ABCDCBA\n" +
                          "ABCCCBA\n" +
                          "ABBBBBA\n" +
                          "AAAAAAA\n";

        Kirjainnelio.tulostaKirjainnelio(4);

        assertEquals( odotettu, poistaKenoR( tulostus.toString() ) );
    }

    // apumetodi

    private String poistaKenoR(String mj) {
        mj = mj.replace("\r", "");
        return mj;
    }
}