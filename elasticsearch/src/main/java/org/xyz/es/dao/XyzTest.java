package org.xyz.es.dao;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName XyzTest
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/26 10:15
 * @Version 1.0
 **/
@Document(indexName = "xyz_spark_test")
public class XyzTest {
   private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
