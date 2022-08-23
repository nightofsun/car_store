package com.service.api.model.rest.request;

public class GetCarListRequest {
    private String name;
    private String gearType;
    private String carType;
    private String brand;
    private String minPrice;
    private String maxPrice;
    private String sortType;
    private String page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetCarListRequest{name=").append(name);
        sb.append(", gearType=").append(gearType);
        sb.append(", carType=").append(carType);
        sb.append(", brand=").append(brand);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", sortType=").append(sortType);
        sb.append(", page=").append(page);
        sb.append("}");
        return sb.toString();
    }
}
