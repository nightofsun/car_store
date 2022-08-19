package com.service.api.domain;

public class LogAction extends BaseDomain {
    private String id;
    private String carId;
    private String actionType;
    private String before;
    private String after;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogAction{id=").append(id);
        sb.append(", carId=").append(carId);
        sb.append(", actionType=").append(actionType);
        sb.append(", before=").append(before);
        sb.append(", after").append(after);
        sb.append("}");
        return sb.toString();
    }
}
