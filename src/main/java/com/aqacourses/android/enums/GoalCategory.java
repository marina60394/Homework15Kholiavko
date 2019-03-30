package com.aqacourses.android.enums;

/**
 * Created by Marina on 30.03.2019.
 */
public enum GoalCategory {
    //  These are values
    NotHardTasks("Для несложных задач");

    private String name;

    /**
     * Constructor
     *
     * @param name
     */
    GoalCategory(String name) {
        this.name = name;
    }

    /**
     * Getter of Category
     *
     * @return string category
     */
    public String getName() {
        return name;
    }

}
