package com.mseptember.tubefav.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Video {

    @PrimaryKey(autoGenerate = true)

    private int id;
    private String name;
    private String description;
    private String type;
    private String url;

    public Video(int id, String name, String description, String type, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.url = url;
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

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
