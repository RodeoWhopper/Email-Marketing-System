package com.service.model.category.conc;

import com.service.model.category.Category;

public class MarketingCategory implements Category {

    private int id;
    private String name;

    public MarketingCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
