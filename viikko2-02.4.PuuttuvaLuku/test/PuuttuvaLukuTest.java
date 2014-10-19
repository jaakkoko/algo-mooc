import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Random;

@Points("2.4")
public class PuuttuvaLukuTest {
    ByteArrayOutputStream tulostus;

    @Before
    public void setup() {
        tulostus = new ByteArrayOutputStream();
        System.setOut( new PrintStream(tulostus) );
    }

    @Test
    public void testi1(){
        int[] syote = generoiSyote(1, 2, 3);
        String odotettu = generoiOdotettuTulos(4);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void testi2(){
        int[] syote    = generoiSyote(6, 4, 5, 1, 2);
        String odotettu = generoiOdotettuTulos(3);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void testi3(){
        int[] syote    = generoiSyote(9, 1, 8, 2, 3, 7, 4, 5);
        String odotettu = generoiOdotettuTulos(6);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void toimiikoIsollaSyotteella(){
        int[] syote    = new int[50000];

        for ( int i=0; i<syote.length/2; i++){
            syote[i] = i+1;
        }

        for ( int i=syote.length/2; i<syote.length; i++){
            syote[i] = i+2;
        }

        String odotettu = generoiOdotettuTulos( syote.length/2+1);

        suoritaSovellus(syote);

        assertEquals( poistaKenoR( odotettu), poistaKenoR( tulostus.toString() ) );
    }

    @Test
    public void eihanAikaaKuluLiikaa(){
        int[] syote3 = generoiIsoSyote(80000);
        int[] syote2 = generoiIsoSyote(40000);
        int[] syote1 = generoiIsoSyote(20000);

        long aika3 = mittaaAikaa(syote3);
        long aika1 = mittaaAikaa(syote1);
        long aika2 = mittaaAikaa(syote2);

        long ero1 = aika2-aika1;
        long ero2 = aika3-aika2;
		//fail("ero1: "+ero1+" ero2: "+ero2);
		//Palvelimella malliratkaisu muutamia sekunteja
        assertTrue("Aikaa kului liikaa!", ero1<10/*50*/ || 2*ero1 > ero2 );
    }

    // apumetodit

    private long mittaaAikaa(int[] luvut) {
        long alku = System.currentTimeMillis();
        int luku = PuuttuvaLuku.puuttuvaLuku(luvut);        
        long loppu = System.currentTimeMillis();
        return loppu-alku;
    }

    private int[] generoiSyote(int... luvut) {
        int[] syote = new int[luvut.length];
        for ( int i=0; i<luvut.length; i++ )
            syote[i] = luvut[i];

        return syote;
    }

    private int[] generoiIsoSyote(int lkm) {
        int[] taulukko = new int[lkm];
        for ( int i=0; i<lkm; i++ )
            taulukko[i] = i+1;

        Random r = new Random();

        for (int i = 0; i<lkm; i++) {
            int tmp = taulukko[i];
            int j = r.nextInt(taulukko.length);
            taulukko[i] = taulukko[j];
            taulukko[j] = tmp;
        }

        return taulukko;
    }

    private String generoiOdotettuTulos( int p) {
        return "Puuttuva luku: "+ p + "\n";
    }

    private void suoritaSovellus(int[] syote) {
        int puuttuva = PuuttuvaLuku.puuttuvaLuku(syote);
        System.out.println("Puuttuva luku: "+ puuttuva );
    }

    private String poistaKenoR(String mj) {
        return mj.replace("\r", "");
    }
}