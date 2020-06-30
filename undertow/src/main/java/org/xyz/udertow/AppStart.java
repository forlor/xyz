package org.xyz.udertow;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 * @ClassName AppStart
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/29 16:58
 * @Version 1.0
 **/
public class AppStart {
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addAjpListener(10051, "localhost").setHandler(
                httpServerExchange -> {
                    httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    httpServerExchange.getResponseSender().send("Hello World");
                }
        ).build();

        server.start();
        System.out.println("成功");
    }
}
