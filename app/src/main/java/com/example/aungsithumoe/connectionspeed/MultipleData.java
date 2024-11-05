package com.example.aungsithumoe.connectionspeed;

/**
 * Created by aungsithumoe on 1/8/18.
 */

public class MultipleData {
    String name;
    boolean isSelected;

    public MultipleData(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
