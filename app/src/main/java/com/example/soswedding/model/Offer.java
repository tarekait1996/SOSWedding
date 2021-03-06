package com.example.soswedding.model;

import java.io.Serializable;

public class Offer implements Serializable {

    private long id;
    private double amount;
    private String message;
    private String status;
    private String providerUuid;
    private String coupleUuid;
    private long requestId;
    private String companyName;
    private String requestTitle;

    public Offer(long id, double amount, String message, String status, String providerUuid, String coupleUuid, long requestId, String companyName, String requestTitle) {
        this.id = id;
        this.amount = amount;
        this.message = message;
        this.status = status;
        this.providerUuid = providerUuid;
        this.coupleUuid = coupleUuid;
        this.requestId = requestId;
        this.companyName = companyName;
        this.requestTitle = requestTitle;
    }
    public Offer(){

    }

    public Offer(double amount, String message, String status, String providerUuid, String coupleUuid, long requestId, String companyName, String requestTitle) {
        this.amount = amount;
        this.message = message;
        this.status = status;
        this.providerUuid = providerUuid;
        this.coupleUuid = coupleUuid;
        this.requestId = requestId;
        this.companyName = companyName;
        this.requestTitle = requestTitle;
    }

    public Offer(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProviderUuid() {
        return providerUuid;
    }

    public void setProviderUuid(String providerUuid) {
        this.providerUuid = providerUuid;
    }

    public String getCoupleUuid() {
        return coupleUuid;
    }

    public void setCoupleUuid(String coupleUuid) {
        this.coupleUuid = coupleUuid;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


}
