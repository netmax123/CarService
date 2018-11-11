package com.dvinasystems.carservice;


public class OrdersList {

    private String id;
    private String startCity;
    private String startAddres;
    private String endCity;
    private String endAddress;
    private String amount;
    private String currency;
    private String orderTime;
    private String regNumber;
    private String modelName;
    private String photo;
    private String driverName;


    public OrdersList() {
    }


    public OrdersList(String id, String startCity, String startAddres, String endCity,
                      String endAddress, String amount, String currency, String orderTime,
                      String regNumber, String modelName, String photo, String driverName) {
        this.id = id;
        this.startCity = startCity;
        this.startAddres = startAddres;
        this.endCity = endCity;
        this.endAddress = endAddress;
        this.amount = amount;
        this.currency = currency;
        this.orderTime = orderTime;
        this.regNumber = regNumber;
        this.modelName = modelName;
        this.photo = photo;
        this.driverName = driverName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartAddres() {
        return startAddres;
    }

    public void setStartAddres(String startAddres) {
        this.startAddres = startAddres;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


}
