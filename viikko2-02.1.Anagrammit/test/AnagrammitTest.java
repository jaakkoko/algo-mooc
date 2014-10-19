
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;


@Points("2.1")
public class AnagrammitTest {

    @Test
    public void yksikirjaiminenOnAnagrammi() {
        assertTrue( Anagrammit.anagrammit("a", "a") );
    }

    @Test
    public void yksikirjaiminenEiAnagrammi() {
        assertFalse( Anagrammit.anagrammit("a", "b") );
    }

    @Test
    public void normaaliJokaOnAnagrammi() {
        assertTrue( Anagrammit.anagrammit("talo", "lato") );
    }

    @Test
    public void normaaliJokaEiAnagrammi() {
        assertFalse( Anagrammit.anagrammit("talo", "altto") );
    }

    @Test
    public void kaikkiaKirjaimiaEiKaytettySanaLiianLyhyt() {
        assertFalse( Anagrammit.anagrammit("talo", "lat") );
    }

    @Test
    public void kaikkiaKirjaimiaEiKaytetty() {
        assertFalse( Anagrammit.anagrammit("talo", "latt") );
    }

    @Test
    public void samatKirjaimetMuttaEriMaara() {
        assertFalse( Anagrammit.anagrammit("aba", "bab") );
    }

    
    @Test
    public void coolEpicTest(){
        
        
    }
}