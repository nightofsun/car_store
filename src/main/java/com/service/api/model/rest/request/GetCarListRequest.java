package com.service.api.model.rest.request;

public class GetCarListRequest {
    private String name;
    private String gearType;
    private String carType;
    private String brand;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer sortType;
    private Integer page;

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

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
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
