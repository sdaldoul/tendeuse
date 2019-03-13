package mow.it.now.core;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author A672668
 */
public class TendeuseServiceTest {
    
    OrientationPivot A = OrientationPivot.A;
    OrientationPivot D = OrientationPivot.D;
    OrientationPivot G = OrientationPivot.G;
    
    private TendeusePoint tendeusePointActual;
    
    @Test
    public void testOrientationOneOk() {
        System.out.println("######################################");
        System.out.println("First test (1 2 N) (5,5)");
        System.out.println("######################################");
        // 5 5
        // IN : 1 2 N
        // OUT : 1 3 N
        
        tendeusePointActual = new TendeusePoint(1, 2, OrientationDirection.N);
        TendeusePoint tendeusePointExpected = new TendeusePoint(1, 3, OrientationDirection.N);
        
        TendeuseService tendeuseService = new TendeuseServiceImpl(5, 5);
        
        List<OrientationPivot> orientationPivots = Arrays.asList(G, A, G, A, G, A, G, A, A);
        tendeuseService.AvancePoint(tendeusePointActual, orientationPivots);
        Assert.assertEquals(tendeusePointExpected, tendeusePointActual);
        System.out.println(tendeusePointActual);
    }
    
    @Test
    public void testOrientationTwoOk() {
        System.out.println("######################################");
        System.out.println("Second test (3 3 E) (5,5)");
        System.out.println("######################################");
        
        // 5 5
        // IN : 3 3 E
        // OUT : 5 1 E
        
        tendeusePointActual = new TendeusePoint(3, 3, OrientationDirection.E);
        TendeusePoint tendeusePointExpected = new TendeusePoint(5, 1, OrientationDirection.E);
        
        TendeuseService tendeuseService2 = new TendeuseServiceImpl(5, 5);
        
        List<OrientationPivot> orientationPivots2 = Arrays.asList(A, A, D, A, A, D, A, D, D, A);
        tendeuseService2.AvancePoint(tendeusePointActual, orientationPivots2);
        Assert.assertEquals(tendeusePointExpected, tendeusePointActual);
        
        System.out.println(tendeusePointActual);
    }
    
}
