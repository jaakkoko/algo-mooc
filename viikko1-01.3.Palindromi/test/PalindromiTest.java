import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.3")
public class PalindromiTest {

    @Test
    public void tyhjaOn() {
        assertTrue(Palindromi.palindromi(""));
    }

    @Test
    public void yhdenMittainenOn() {
        assertTrue(Palindromi.palindromi("a"));
    }

    @Test
    public void kaksiEriKirjaintaEi() {
        assertFalse(Palindromi.palindromi("ax"));
    }

    @Test
    public void ekaJaVikaSama() {
        assertFalse(Palindromi.palindromi("axda"));
    }

    @Test
    public void abcEiOle() {
        assertFalse(Palindromi.palindromi("abc"));
    }

    @Test
    public void abaOn() {
        assertTrue(Palindromi.palindromi("aba"));
    }

    @Test
    public void parillisenPituinenJokaOn() {
        assertTrue(Palindromi.palindromi("abccba"));
    }

    @Test
    public void parillisenPituinenJokaEiOle() {
        assertFalse(Palindromi.palindromi("abcc"));
    }

    @Test
    public void toinenParillisenPituinenJokaEiOle() {
        assertFalse(Palindromi.palindromi("abca"));
    }

    @Test
    public void saippuakauppiasOn() {
        assertTrue(Palindromi.palindromi("saippuakauppias"));
    }
}