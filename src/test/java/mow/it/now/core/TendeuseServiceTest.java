/*
 * Copyright 2017-2018 by Wordline, an Atos Compagny. All rights reserved. This software is the
 * confidential and proprietary information of Atos ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Atos. En référence à l’article 17.2 du CCAP du marché
 * n°2016-05, passé entre l’ASIP Santé et la société Worldine et relatif aux Prestations de
 * construction, d’hébergement, d’exploitation des infrastructures téléphoniques, de déploiement
 * technique de la solution SI-Samu et de services téléphoniques, les droits de propriété
 * intellectuelle de Worldline sur ce programme seront cédés à l’ASIP Santé à l’issue du marché,
 * notifié le 5 mai 2017 pour une durée initiale de 5 ans et reconductible une fois pour une période
 * d’un an.
 */
/**
 * 
 */
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
