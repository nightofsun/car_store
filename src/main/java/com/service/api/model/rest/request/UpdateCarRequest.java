package com.service.api.model.rest.request;

public class UpdateCarRequest {
    private String carId;
    private String brand;
    private String name;
    private String driveSystem;
    private String gearType;
    private Integer year;
    private String engine;
    private Integer price;
    private String carType;
    private String oilType;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriveSystem() {
        return driveSystem;
    }

    public void setDriveSystem(String driveSystem) {
        this.driveSystem = driveSystem;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateNewCarRequest{carId=").append(carId);
        sb.append(", brand=").append(brand);
        sb.append(", name=").append(name);
        sb.append(", driveSystem=").append(driveSystem);
        sb.append(", gearType=").append(gearType);
        sb.append(", year=").append(year);
        sb.append(", engine=").append(engine);
        sb.append(", price=").append(price);
        sb.append(", carType=").append(carType);
        sb.append(", oilType=").append(oilType);
        sb.append("}");
        return sb.toString();
    }
}
