package com.service.api.model.rest;

import java.util.Date;

public class BaseRequest {
    private String requestURI;
    private Date requestDate;
    private String bodyData;

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getBodyData() {
        return bodyData;
    }

    public void setBodyData(String bodyData) {
        this.bodyData = bodyData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseRequest{requestUR=").append(requestURI);
        sb.append(", requestDate").append(requestDate);
        sb.append(", bodyData").append(bodyData);
        sb.append("}");
        return sb.toString();
    }
}
