package org.xyz.quartz.common;

/**
 * @ClassName CronEntity
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/13 13:41
 * @Version 1.0
 **/
public class CronDate {
    private Integer seconds;
    private Integer minute;
    private Integer hour;
    private Integer dayOfMonth;
    private Integer month;
    private Integer dayOfWeek;
    private Integer year;

    public CronDate() {
    }

    public CronDate(Integer seconds, Integer minute, Integer hour, Integer dayOfMonth, Integer month, Integer year) {
        this.seconds = seconds;
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
    }

    public CronDate(Integer seconds, Integer minute, Integer hour, Integer dayOfMonth, Integer month, Integer dayOfWeek, Integer year) {
        this.seconds = seconds;
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.year = year;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
