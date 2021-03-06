package org.xyz.quartz.common;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.expression.FieldExpression;

import static com.cronutils.model.CronType.QUARTZ;
import static com.cronutils.model.field.expression.FieldExpressionFactory.always;
import static com.cronutils.model.field.expression.FieldExpressionFactory.on;
import static com.cronutils.model.field.expression.FieldExpressionFactory.questionMark;

/**
 * @ClassName QuartzUtil
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/14 18:27
 * @Version 1.0
 **/
public class QuartzUtil {

    /**
     * 根据日期生成cron表达式
     *
     * @param cronDate
     * @return
     */
    public static String cron(CronDate cronDate) {

        if (cronDate.getDayOfMonth() != null && cronDate.getDayOfWeek() != null) {
            throw new IllegalArgumentException("dayOfWeek and dayOfMonth can't exist at the same time");
        }
        CronBuilder cronBuilder = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ));
        cronBuilder.withYear(getFieldExpression(cronDate.getYear()))
                .withMonth(getFieldExpression(cronDate.getMonth()));
        if (cronDate.getDayOfWeek() != null) {
            cronBuilder.withDoM(questionMark())
                    .withDoW(getFieldExpression(cronDate.getDayOfWeek()));
        } else {
            cronBuilder.withDoM(getFieldExpression(cronDate.getDayOfMonth()))
                    .withDoW(questionMark());
        }
        cronBuilder.withHour(getFieldExpression(cronDate.getHour()))
                .withMinute(getFieldExpression(cronDate.getMinute()))
                .withSecond(on(cronDate.getSeconds() == null ? 0 : cronDate.getSeconds()));
        return cronBuilder.instance().asString();
    }


    /**
     * @param field
     * @return
     */
    private static FieldExpression getFieldExpression(Integer field) {
        if (field == null) {
            return always();
        }
        return on(field);
    }
}
