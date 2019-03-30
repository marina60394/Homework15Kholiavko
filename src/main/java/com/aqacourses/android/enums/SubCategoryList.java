package com.aqacourses.android.enums;

/**
 * Created by Marina on 30.03.2019.
 */
public enum SubCategoryList {
    //  These are values
    LaptopSubCategory("Ноутбуки");

    private String name;

    /**
     * Constructor
     *
     * @param name
     */
    SubCategoryList(String name) {
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
