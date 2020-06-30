package org.xyz.spi.impl;

import org.xyz.spi.MySpi;

/**
 * @ClassName MySpiImpl2
 * @Description TODO
 * @Author xyz
 * @Date 2020/6/9 20:18
 * @Version 1.0
 **/
public class MySpiImpl2 implements MySpi {
    @Override
    public void testSpi(String str) {
        System.out.println("xyz"+str);
    }
}
