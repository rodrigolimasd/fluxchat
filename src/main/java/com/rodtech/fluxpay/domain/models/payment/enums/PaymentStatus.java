package com.rodtech.fluxpay.domain.models.payment.enums;

public enum PaymentStatus {
    PENDING("Pending"),
    PROCESSING("processing"),
    SUCCESSFUL("Successful"),
    FAILED("Failed");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
