package org.xyz.quartz.service;

import org.quartz.SchedulerException;

/**
 * @ClassName QuartzService
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 10:55
 * @Version 1.0
 **/
public interface QuartzService {
    /**
     * 创建定时任务
     *
     * @param key
     * @param cronExpression
     */
    void create(String key, String cronExpression) throws SchedulerException;

    /**
     * 通过key删除任务
     *
     * @param key
     */
    void delete(String key);

    /**
     * 更新任务定时计划
     *
     * @param key
     * @param cronExpression
     */
    void update(String key, String cronExpression);

    /**
     * 暂停所有任务
     */
    void pauseAll();

    /**
     * 通过key,暂停任务
     *
     * @param key
     */
    void pause(String key);

    /**
     * 恢复所有任务
     */
    void resumeAll();

    /**
     * 通过key,恢复任务
     *
     * @param key
     */
    void resume(String key);
}
