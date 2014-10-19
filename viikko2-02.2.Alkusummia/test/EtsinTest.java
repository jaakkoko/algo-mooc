import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.Random;
import fi.helsinki.cs.tmc.edutestutils.timing.CpuStopwatch;

@Points("2.2")
public class EtsinTest {

    Random r = new Random();

    @Test
    public void testaaEsimerkki1() {
        Etsin e = new Etsin(new int[] {1,2,3});

        assertEquals("Luvut {1,2,3}, kysely 1:",0,e.etsi(1));
        assertEquals("Luvut {1,2,3}, kysely 3:",1,e.etsi(3));
        assertEquals("Luvut {1,2,3}, kysely 6:",2,e.etsi(6));
        assertEquals("Luvut {1,2,3}, kysely 5:",-1,e.etsi(5));
    }

    @Test
    public void testaaEsimerkki2() {
        int [] luvut = new int[] {10,20,4,7,7,5,7,7,10,1};
        String s = Arrays.toString(luvut);
        Etsin e = new Etsin(luvut);

        assertEquals("Luvut "+s+" kysely 48:",4,e.etsi(48));
        assertEquals("Luvut "+s+" kysely 53:",5,e.etsi(53));
        assertEquals("Luvut "+s+" kysely 55:",-1,e.etsi(55));
    }

    public int[] satunnainenTaulukko(int KOKO) {
        int[] luvut = new int[KOKO];

        for (int i=0; i<KOKO; i++) {
            luvut[i] = r.nextInt(20)+1;
        }

        return luvut;
    }

    public void satunnainenTesti(int N, int KOKO) {
        for (int krt = 0; krt<N; krt++) {
            int[] luvut = satunnainenTaulukko(KOKO);

            int ind = r.nextInt(KOKO);
            int s = 0;
            for (int i=0; i<=ind; i++) {
                s+=luvut[i];
            }

            Etsin e = new Etsin(luvut);

            assertEquals("Luvut: "+Arrays.toString(luvut)+" kysely "
                         +s+":",ind,e.etsi(s));
        }
    }

    @Test public void pieniSatunnainenTesti() {
        satunnainenTesti(10,20);
    }

    @Test public void suuriSatunnainenTesti() {
        satunnainenTesti(20,200);
    }

    public void aikaTesti() {

        int KOKO=100000;
        int maxSumma=20*100000;

        int luvut[] = satunnainenTaulukko(KOKO);

        Etsin e = new Etsin(luvut);

        int N=10000;
        long maxAika=0;
        CpuStopwatch csw = new CpuStopwatch(CpuStopwatch.Mode.USER);
        for (int i=0; i<N; i++) {
            int x = r.nextInt(maxSumma);
            e.etsi(x);
        }
        double aika = csw.getElapsedTime();
        long millisekunnit = (long) (aika*1000);
        System.err.println("koko: "+KOKO+" kyselyjä: "+N+" aika (ms): "
                           +millisekunnit);
					//Mun koneella 2ms optimaalilla 20ms palvelimella
        assertTrue("Käytit aikaa "+millisekunnit+"ms, joka on yli 40ms.",millisekunnit<=40/*110*/);

    }

    @Test public void testaaAika() {
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
        aikaTesti();
    }
}