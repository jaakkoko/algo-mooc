import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.1")
public class KertomaTest {

    @Test
    public void nollanKertoma() {
        assertEquals( 1, Kertoma.kertoma(0) );
    }

    @Test
    public void yhdenKertoma() {
        assertEquals( 1, Kertoma.kertoma(1) );
    }

    @Test
    public void kahdenKertoma() {
        assertEquals( 2, Kertoma.kertoma(2) );
    }

    @Test
    public void viidenKertoma() {
        assertEquals( 120, Kertoma.kertoma(5) );
    }

}