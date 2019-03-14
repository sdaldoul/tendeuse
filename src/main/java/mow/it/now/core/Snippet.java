package mow.it.now.core;

import java.util.Arrays;
import java.util.List;

public class Snippet {
    public static void main(String[] args) {
        
        OrientationPivot A = OrientationPivot.A;
        OrientationPivot D = OrientationPivot.D;
        OrientationPivot G = OrientationPivot.G;
        
        System.out.println("######################################");
        System.out.println("First test (1 2 N) (5,5)");
        System.out.println("######################################");
        // 5 5
        // IN : 1 2 N
        // OUT : 1 3 N
        
        TendeusePoint tendeusePoint1 = new TendeusePoint(1, 2, OrientationDirection.N);
        TendeuseService tendeuseService = new TendeuseServiceImpl(5, 5);
        
        List<OrientationPivot> orientationPivots = Arrays.asList(G, A, G, A, G, A, G, A, A);
        tendeuseService.avancePoint(tendeusePoint1, orientationPivots);
        
        System.out.println(tendeusePoint1);
        
        System.out.println("######################################");
        System.out.println("Second test (3 3 E) (5,5)");
        System.out.println("######################################");
        
        // 5 5
        // IN : 3 3 E
        // OUT : 5 1 E
        
        TendeusePoint tendeusePoint2 = new TendeusePoint(3, 3, OrientationDirection.E);
        TendeuseService tendeuseService2 = new TendeuseServiceImpl(5, 5);
        
        List<OrientationPivot> orientationPivots2 = Arrays.asList(A, A, D, A, A, D, A, D, D, A);
        tendeuseService2.avancePoint(tendeusePoint2, orientationPivots2);
        
        System.out.println(tendeusePoint2);
        
    }
}
