package org.example.model;

public class JsonOutput {
    private String banner = "B00955686";
    private String result = "";
    private String arn = "";
    private String action = "";
    private String value = "";

    public JsonOutput() {
    }
//    public JsonOutput(String result, String arn, String action, String value) {
//        this.result = result;
//        this.arn = arn;
//        this.action = action;
//        this.value = value;
//    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
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

    @Override
    public String toString() {
        return "{" +
                "\"banner\": \"" + banner + "\"," +
                "\"result\": \"" + result + "\"," +
                "\"arn\": \"" + arn + "\"," +
                "\"action\": \"" + action + "\"," +
                "\"value\": \"" + value + "\"" +
                "}";
    }

}

