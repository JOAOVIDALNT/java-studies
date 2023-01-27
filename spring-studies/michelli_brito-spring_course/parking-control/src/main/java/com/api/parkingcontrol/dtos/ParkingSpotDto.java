package com.api.parkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParkingSpotDto {

    /*
    utilizamos anotações do pacote validation
    - é possivel criar constraints personalizadas
    */

    @NotBlank
    private String parkingNumberSpot;
    @NotBlank
    @Size(max = 7)
    private String licensePlate;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String color;
    @NotBlank
    private String owner;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;


    public String getParkingNumberSpot() {
        return parkingNumberSpot;
    }

    public void setParkingNumberSpot(String parkingNumberSpot) {
        this.parkingNumberSpot = parkingNumberSpot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
