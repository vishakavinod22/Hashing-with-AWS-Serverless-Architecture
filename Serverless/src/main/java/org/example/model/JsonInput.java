package org.example.model;

public class JsonInput {
    private String course_uri;
    private String action;
    private String value;

    public JsonInput() {
    }

    public JsonInput(String course_uri, String action, String value) {
        this.course_uri = course_uri;
        this.action = action;
        this.value = value;
    }

    public String getCourse_uri() {
        return course_uri;
    }

    public void setCourse_uri(String course_uri) {
        this.course_uri = course_uri;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

