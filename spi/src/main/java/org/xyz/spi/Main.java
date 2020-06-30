package org.xyz.spi;

import java.util.ServiceLoader;

/**
 * @ClassName Main
 * @Description TODO
 * @Author xyz
 * @Date 2020/6/9 20:21
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        ServiceLoader<MySpi> load = ServiceLoader.load(MySpi.class);
        load.forEach(mySpi -> {
            mySpi.testSpi("maomao");
        });
    }
}
