package org.xyz.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xyz.springmvc.service.IndexService;

import java.util.UUID;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/14 10:08
 * @Version 1.0
 **/
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/say")
    @ResponseBody
    public String success() {
        return indexService.getUUID();
    }
}
