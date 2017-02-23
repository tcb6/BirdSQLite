package com.example.thomasberkey.birdsqlite;

/**
 * Created by Thomas on 2/21/2017.
 */

public class Bird {
    private int id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Bird(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Bird(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bird() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
