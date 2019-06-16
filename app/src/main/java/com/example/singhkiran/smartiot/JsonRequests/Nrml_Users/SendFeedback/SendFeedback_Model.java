package com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.SendFeedback;

public class SendFeedback_Model {
    private String userId;
    private String feedback;
    private String message;
    private String platform;

    public SendFeedback_Model(String userId, String feedback, String platform) {
        this.userId = userId;
        this.feedback = feedback;
        this.platform = platform;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platfrom) {
        this.platform = platfrom;
    }
}
