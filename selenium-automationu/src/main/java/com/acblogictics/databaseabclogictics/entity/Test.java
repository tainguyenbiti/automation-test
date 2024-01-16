package com.acblogictics.databaseabclogictics.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private String uid;
    private String parentId;
    private String parentName;
    private String name;
    private String status;
    private long duration;
    private long start;
    private long stop;

    // getters and setters

    // constructor
    public Test(
            @JsonProperty("uid") String uid,
            @JsonProperty("parentUid") String parentId,
            String parentName,
            @JsonProperty("name") String name,
            @JsonProperty("status") String status,
            @JsonProperty("duration") long duration,
            @JsonProperty("start") long start,
            @JsonProperty("stop") long stop) {
        this.uid = uid;
        this.parentId = parentId;
        this.parentName = parentName;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.start = start;
        this.stop = stop;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }
}
