package com.service.api.model.rest.response;

import com.service.api.model.rest.BaseResponse;

import java.util.List;

public class GetCarListResponse extends BaseResponse {
    private List<CarAttribute> carList;
    private Integer carCount;
    private Integer totalPage;
    private Integer startAt;
    private Integer endAt;

    public List<CarAttribute> getCarList() {
        return carList;
    }

    public void setCarList(List<CarAttribute> carList) {
        this.carList = carList;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getEndAt() {
        return endAt;
    }

    public void setEndAt(Integer endAt) {
        this.endAt = endAt;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetCarListResponse{carList=").append(carList);
        sb.append(", carCount=").append(carCount);
        sb.append(", totalPage=").append(totalPage);
        sb.append(", startAt=").append(startAt);
        sb.append(", endAt=").append(endAt);
        sb.append("}");
        return sb.toString();
    }
}
