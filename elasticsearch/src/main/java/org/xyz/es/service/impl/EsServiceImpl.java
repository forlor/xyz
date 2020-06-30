package org.xyz.es.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.xyz.es.service.EsService;

/**
 * @ClassName EsServiceImpl
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/25 11:15
 * @Version 1.0
 **/
public class EsServiceImpl implements EsService {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;
}
