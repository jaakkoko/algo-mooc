
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Test;
import static org.junit.Assert.*;

@Points("2.6")
public class ToinenKertolaskuTest {

    public ToinenKertolaskuTest() {
    }

    @Test
    public void kertolasku2OnMyosToteutettuRekursiollaPaljonKauniimpiTesti() {
        MockKertolasku m = new MockKertolasku();
        m.kertolasku2(10, 10);
        assertTrue("kertolasku2(10,10); tulee ratkaista rekusiolla.\n"
                + "Metodin tulee kutsua itseään 5 kertaa!\n"
                + "Kutsuit " + m.getCtr() + " kertaa.", m.getCtr() == 5);

        m.kertolasku2(10, 100);
        assertTrue("kertolasku2(10,100); tulee ratkaista rekusiolla.\n"
                + "Metodin tulee kutsua itseään 13 kertaa!\n"
                + "Kutsuit " + m.getCtr() + " kertaa.", m.getCtr() == 13);


        m.kertolasku2(100, 100);
        assertTrue("kertolasku2(100,100); tulee ratkaista rekusiolla.\n"
                + "Metodin tulee kutsua itseään 21 kertaa!\n"
                + "Kutsuit " + m.getCtr() + " kertaa.", m.getCtr() == 21);

    }

}

class MockKertolasku extends Kertolasku {

    private int ctr = 0;

    public int getCtr() {
        return this.ctr;
    }

    @Override
    public long kertolasku2(long x, long y) {
        ctr++;
        return super.kertolasku2(x, y);
    }
}
