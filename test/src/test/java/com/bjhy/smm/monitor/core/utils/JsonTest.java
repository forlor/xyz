package com.bjhy.smm.monitor.core.utils;


import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @ClassName JsonTest
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/18 16:54
 * @Version 1.0
 **/
public class JsonTest {
  static   String json = "{\n" +
            "    \"employees\": [\n" +
            "        {\n" +
            "            \"firstName\": \"Bill\",\n" +
            "            \"lastName\": \"Gates\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"firstName\": \"George\",\n" +
            "            \"lastName\": \"Bush\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"firstName\": \"Thomas\",\n" +
            "            \"lastName\": \"Carter\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public  void test(){

    }

    public static void main(String[] args) {
        Map<String, Object> map =
                GsonUtil.jsonToMap(json);

        System.out.println(map);
    }
}
