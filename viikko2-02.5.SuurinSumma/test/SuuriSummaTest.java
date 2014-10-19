import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.5")
public class SuuriSummaTest {
    ByteArrayOutputStream tulostus;

    @Before
    public void setup() {
        tulostus = new ByteArrayOutputStream();
        System.setOut( new PrintStream(tulostus) );
    }

    @Test
    public void testi1(){
        int[] syote = generoiSyote(1, -2, 5, 2, -1);
        String odotettu = generoiOdotettuTulos(7);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu ), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void testi2(){
        int[] syote = generoiSyote(4, -2, 5, 2, -1);
        String odotettu = generoiOdotettuTulos(9);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu ), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void testi3(){
        int[] syote = generoiSyote(2, -1, 7, 3, -5, 3, 4, 9, -100, 3);
        String odotettu = generoiOdotettuTulos(22);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu ), poistaKenoR( tulostus.toString() ) );
    }

    /*
    @Test
    public void testiNegatiivinen() {
        int[] syote = new int[] {-1,-1,-1,-1,-1,-1,-1};
        int ulos = SuurinSumma.suurinSumma(syote);
        assertEquals("Virheellinen tuloste syötteellä {-1,-1,-1,-1,-1,-1,-1}.",-1,ulos);
    }
    */

    @Test
    public void testaaKiva() {
        int[] syote = new int[] {-100000,100,100,100,-1,100,100,100};
        int ulos = SuurinSumma.suurinSumma(syote);
        assertEquals("Virheellinen tuloste syötteellä {-100000,100,100,100,-1,100,100,100}.",599,ulos);
    }

    @Test
    public void eihanAikaaKuluLiikaa() {
        int[] syote3 = generoiIsoSyote(16000);
        int[] syote2 = generoiIsoSyote(8000);
        int[] syote1 = generoiIsoSyote(4000);

        long aika3 = mittaaAikaa(syote3);
        long aika1 = mittaaAikaa(syote1);
        long aika2 = mittaaAikaa(syote2);
		//fail("aika1: "+ aika1 + " aika2: "+ aika2 + " aika3: " + aika3);
        long ero1 = aika2-aika1;
        long ero2 = aika3-aika2;

		//Palvelimella ja paikallisesti vain muutamia sekunteja
        assertTrue("Aikaa kului liikaa!", ero1<8/*50*/ || 2*ero1 > ero2 );
    }

    // 
    
    private void suoritaSovellus(int[] syote) {
        int puuttuva = SuurinSumma.suurinSumma(syote);
        System.out.println("Suurin summa: "+ puuttuva );
    }

    private int[] generoiSyote(int... luvut) {
        int[] syote = new int[luvut.length];
        for ( int i=0; i<luvut.length; i++ )
            syote[i] = luvut[i];

        return syote;
    }

    private int[] generoiIsoSyote(int lkm) {
        Random r = new Random();
        int[] taulukko = new int[lkm];
        for ( int i=0; i<lkm; i++ )
            taulukko[i] = r.nextInt(lkm)-(lkm/4);

        return taulukko;
    }

    private String poistaKenoR(String mj) {
        return mj.replace("\r", "");
    }

    private String generoiOdotettuTulos(int p) {
        return "Suurin summa: "+ p + "\n";
    }

    private long mittaaAikaa(int[] luvut) {
        long alku = System.currentTimeMillis();
        SuurinSumma.suurinSumma(luvut);
        long loppu = System.currentTimeMillis();
        return loppu-alku;
    }
}