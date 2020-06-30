package org.xyz.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName HibernateStart
 * @Description TODO
 * @Author xyz
 * @Date 2020/6/4 20:33
 * @Version 1.0
 **/
@SpringBootApplication
public class HibernateStart {
    public static void main(String[] args) {
        SpringApplication.run(HibernateStart.class,args);
        System.out.println(1);
    }
}
