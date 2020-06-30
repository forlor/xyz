package org.xyz.springmvc.service.impl;

import org.springframework.stereotype.Service;
import org.xyz.springmvc.service.IndexService;

import java.util.UUID;

/**
 * @ClassName IndexServiceImpl
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/14 10:16
 * @Version 1.0
 **/
@Service

public class IndexServiceImpl implements IndexService {

    @Override
    public String getUUID() {
        return UUID.randomUUID().toString();
    }

}
