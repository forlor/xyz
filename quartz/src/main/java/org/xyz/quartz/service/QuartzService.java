package org.xyz.quartz.service;

import com.bjhy.smm.maintenance.core.quartz.common.QuartzJob;

import java.io.Serializable;

/**
 * @ClassName QuartzService
 * @Description 定时任务service
 * @Author xyz
 * @Date 2020/7/13 10:55
 * @Version 1.0
 **/
public interface QuartzService extends Serializable {


    /**
     * 新增定时任务
     * @param bId
     * @param cronExpression
     * @param quartzJob      实现了{@link QuartzJob}接口的spring bean,
     *                       请勿使用匿名内部类进行对象实例化，否则会产生运行时异常。
     *                       将会持久化bean name属性，所以创建定时任务后，bean name发生改变会导致任务找不到
     */
    void create(String bId, String cronExpression, QuartzJob quartzJob);

    /**
     * 通过key删除任务
     *
     * @param bId
     */
    void delete(String bId);

    /**
     * 更新任务定时计划
     *
     * @param bId
     * @param cronExpression
     * @param quartzJob      实现了{@link QuartzJob}接口的spring bean,
     *                       请勿使用匿名内部类进行对象实例化，否则会产生运行时异常
     */
    void update(String bId, String cronExpression, QuartzJob quartzJob);

    /**
     * 暂停所有任务
     */
    void pauseAll();

    /**
     * 通过key,暂停任务
     *
     * @param bId
     */
    void pause(String bId);

    /**
     * 恢复所有任务
     */
    void resumeAll();

    /**
     * 通过key,恢复任务
     *
     * @param bId
     */
    void resume(String bId);
}
