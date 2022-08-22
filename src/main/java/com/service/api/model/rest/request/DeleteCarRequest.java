package com.service.api.model.rest.request;

public class DeleteCarRequest {
    private String carId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeleteCarRequest{carId=").append(carId);
        sb.append("}");
        return sb.toString();
    }
}
