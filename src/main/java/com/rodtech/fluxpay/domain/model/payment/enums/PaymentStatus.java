package com.rodtech.fluxpay.domain.model.payment.enums;

public enum PaymentStatus {
    PENDING("Pending"),
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
