/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamo
 */

@Points("2.6")
public class KertolaskuTest {

    public KertolaskuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public Kertolasku k;
    @Before
    public void setUp() {
        k = new Kertolasku();
    }

    @After
    public void tearDown() {
    }

    private void testaaKertolasku(long x, long y, long est) {
        assertEquals("kertolasku(" + x + ", " + y + "); tulisi palauttaa " + est, est, k.kertolasku(x, y));
    }
    
    private void testaaKertolasku2(long x, long y, long est) {
        assertEquals("kertolasku2(" + x + ", " + y + "); tulisi palauttaa " + est, est, k.kertolasku2(x, y));
    }
    
    @Test
    public void tesKertolaskuPienilla() {
        testaaKertolasku(1, 1, 1);
        testaaKertolasku(2, 1, 2);
        testaaKertolasku(2, 2, 4);
        testaaKertolasku(5, 1, 5);
        testaaKertolasku(11, 11, 121);
        testaaKertolasku(131, 11, 1441);
    }

    @Test
    public void testKertolaskuIsommilla() {

        testaaKertolasku(300, 11, 3300);
        testaaKertolasku(320, 21, 6720);
        testaaKertolasku(234, 432, 101088);
        testaaKertolasku(234, 1432, 335088);
        testaaKertolasku(335088, 30, 10052640);
    }

    
    @Test
    public void tesKertolaskuPienilla2() {
        testaaKertolasku2(1, 1, 1);
        testaaKertolasku2(2, 1, 2);
        testaaKertolasku2(2, 2, 4);
        testaaKertolasku2(5, 1, 5);
        testaaKertolasku2(11, 11, 121);
        testaaKertolasku2(131, 11, 1441);
    }

    @Test
    public void testKertolaskuIsommilla2() {
        
        testaaKertolasku2(300, 11, 3300);
        testaaKertolasku2(320, 21, 6720);
        testaaKertolasku2(234, 432, 101088);
        testaaKertolasku2(234, 1432, 335088);
        testaaKertolasku2(335088, 30, 10052640);
    }


    
    
    
    
    @Test
    public void testOnToteutettuRekursiolla() {
        boolean success = true;
        try {
            testaaKertolasku(1000, 10000, 10000000);
            success = false;
        } catch (StackOverflowError r) {

        }
        assertTrue("Ohjelma tulee ratkaista rekursiolla", success);
    }
}
