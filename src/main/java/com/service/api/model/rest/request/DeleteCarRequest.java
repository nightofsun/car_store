package com.service.api.model.rest.request;

public class DeleteCarRequest {
    private String carID;

    public String getCarID() {
        return carID;
    }

    public void setCarId(String carId) {
        this.carID = carId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeleteCarRequest{carId=").append(carID);
        sb.append("}");
        return sb.toString();
    }
}
