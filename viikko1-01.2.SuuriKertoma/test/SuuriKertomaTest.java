import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.2")
public class SuuriKertomaTest {

    @Test
    public void nollanKertoma() {
        assertEquals( value("1"), SuuriKertoma.suuriKertoma(0) );
    }

    @Test
    public void yhdenKertoma() {
        assertEquals( value("1"), SuuriKertoma.suuriKertoma(1) );
    }

    @Test
    public void viidenKertoma() {
        assertEquals( value("120"), SuuriKertoma.suuriKertoma(5) );
    }

    @Test
    public void kymmenenKertoma() {
        assertEquals( value("3628800"), SuuriKertoma.suuriKertoma(10) );
    }

    @Test
    public void kahdenkymmenenviidenKertoma() {
        assertEquals( value("15511210043330985984000000"), SuuriKertoma.suuriKertoma(25) );
    }

    BigInteger value(String val){
        return new BigInteger(val);
    }

}