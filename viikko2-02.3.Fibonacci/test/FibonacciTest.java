import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.3")
public class FibonacciTest {
    @Test public void nollanFibonacci(){
        assertEquals( 0, Fibonacci.fibonacci(0) );
    }

    @Test public void ykkosenFibonacci(){
        assertEquals( 1, Fibonacci.fibonacci(1) );
    }

    @Test public void kuutosenFibonacci(){
        assertEquals( 8, Fibonacci.fibonacci(6) );
    }

    @Test public void kahdenkymmenenFibonacci(){
        assertEquals( 6765, Fibonacci.fibonacci(20) );
    }

    @Test public void eiKaiRekursiivinen(){
        long alku = System.currentTimeMillis();
        Fibonacci.fibonacci(60);
        long loppu = System.currentTimeMillis();
        long aika = loppu-alku;
        assertTrue("Fibonaccisi vei hurjan pajon aikaa! Aika: " +aika+"ms",aika<2/*10*/);
        assertEquals("Fibonaccisi vei hiukan liikaa aikaa!",0, aika);
    }
}