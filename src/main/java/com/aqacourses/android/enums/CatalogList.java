package com.aqacourses.android.enums;

/**
 * Created by Marina on 30.03.2019.
 */
public enum CatalogList {
    //  These are values
    LaptopCategory("Ноутбуки и компьютеры");

    private String name;

    /**
     * Constructor
     *
     * @param name
     */
    CatalogList(String name) {
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
