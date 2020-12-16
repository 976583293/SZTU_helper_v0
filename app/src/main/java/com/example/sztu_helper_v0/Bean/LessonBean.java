package com.example.sztu_helper_v0.Bean;

import com.zhuangfei.timetable.model.Schedule;
import com.zhuangfei.timetable.model.ScheduleEnable;

import java.util.List;

public class LessonBean implements ScheduleEnable {
    private int id = 0;

    private String name;//课程名

    private String time;//无用数据

    private String room;//教室

    private String teacher;//教师

    private List<Integer> weekList;//第几周至第几周上

    private int start;//开始上课的节次

    private int last_num;//上课节数

    private int day;//周几上

    private String term;//学期

    private int colorRandom = 0;//一个随机数，用于对应课程的颜色

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public LessonBean() {
        // TODO Auto-generated constructor stub
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public LessonBean(String term, String name, String room, String teacher, List<Integer> weekList, int start, int step, int day, int colorRandom, String time) {
        super();
        this.term = term;
        this.name = name;
        this.room = room;
        this.teacher = teacher;
        this.weekList = weekList;
        this.start = start;
        this.last_num = step;
        this.day = day;
        this.colorRandom = colorRandom;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setWeekList(List<Integer> weekList) {
        this.weekList = weekList;
    }

    public List<Integer> getWeekList() {
        return weekList;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStep() {
        return last_num;
    }

    public void setStep(int step) {
        this.last_num = step;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getColorRandom() {
        return colorRandom;
    }

    public void setColorRandom(int colorRandom) {
        this.colorRandom = colorRandom;
    }

    @Override
    public Schedule getSchedule() {
        Schedule schedule = new Schedule();
        schedule.setDay(getDay());
        schedule.setName(getName());
        schedule.setRoom(getRoom());
        schedule.setStart(getStart());
        schedule.setStep(getStep());
        schedule.setTeacher(getTeacher());
        schedule.setWeekList(getWeekList());
        schedule.setColorRandom(2);
        return schedule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
