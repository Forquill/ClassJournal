package sg.edu.rp.c346.classjournal;

import java.io.Serializable;

public class Data implements Serializable {
    public String week;
    public String grade;

    public Data(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Week: " + week;
    }
}
