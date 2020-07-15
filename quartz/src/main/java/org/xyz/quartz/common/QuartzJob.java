package org.xyz.quartz.common;

import java.io.Serializable;

/**
 * @ClassName QuartzJob
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/14 20:34
 * @Version 1.0
 **/
public interface QuartzJob extends Serializable {
    /**
     * 定时执行方法
     *
     * @param bId
     */
    void execute(String bId);
}
