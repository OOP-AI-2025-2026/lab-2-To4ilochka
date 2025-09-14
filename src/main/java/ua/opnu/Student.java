package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static final int TUITION_FEE_FOR_YEAR = 20_000;
    private static final int MIN_YEAR = 1;
    private static final int MAX_YEAR = 4;

    private String name;
    private int year;
    //    Я вмiю користуватися колекцiями, так як проходив курси EPAM
    private List<String> course;

    public Student(String name, int year) {
        if (!inRange(year, MIN_YEAR, MAX_YEAR)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.year = year;
        this.course = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            throw new IllegalArgumentException();
        }
        course.add(courseName);
    }

    public void dropAll() {
        course.clear();
    }

    public int getCourseCount() {
        return course.size();
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return year * TUITION_FEE_FOR_YEAR;
    }

    public int getYear() {
        return year;
    }

    private static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
