package Model;

import java.io.Serializable;

public class Category implements Serializable {

    private String name;
    private String description;
    private String iconPath;   //path to icon

    public Category(String name, String description, String iconPath) {
        this.name = name;
        this.description = description;
        this.iconPath = iconPath;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
