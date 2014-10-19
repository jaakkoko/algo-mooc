
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.lolcatz.profiler.ComplexityAnalysis;
import fi.lolcatz.profiler.Output;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

@Points("2.3")
public class VIKA_FibonacciProfilerTest {

    public VIKA_FibonacciProfilerTest() {
    }
    IntegerImpl impl;
    ComplexityAnalysis framework;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void testSetup() {
        impl = new IntegerImpl();
        impl.setClassName("Fibonacci");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void fibonacciProfilerTest() throws Exception {
        try {
            impl.setMethodName("fibonacci");
            Output<Integer> o = impl.runMethod(Arrays.asList(2, 500, 66, 400, 5,6,7,8,8,99));
            List<Integer> input = o.getInput();
            List<Integer> size = o.getSize();
            List<Long> time = o.getTime();
            System.out.println(input);
            System.out.println(size);
            System.out.println(time);
            assertTrue(framework.isLinear(o));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
}
