package com.demo.smartshop.dao.enums;

public enum OrderStatus {
    IN_PROCESS(1, "In process"),
    ORDERED(2, "Ordered"),
    SENT(3, "Sent"),
    RETURNED(4, "Returned");

    final int orderedStatusId;
    final String orderedStatusName;

    private OrderStatus(int orderedStatusId, String orderedStatusName) {
        this.orderedStatusId = orderedStatusId;
        this.orderedStatusName = orderedStatusName;
    }

    public int getOrderedStatusId() {
        return orderedStatusId;
    }

    public String getOrderedStatusName() {
        return orderedStatusName;
    }

    @Override
    public String toString() {
        return "OrderStatus{" + "orderedStatusId=" + orderedStatusId
                + ", orderedStatusName=" + orderedStatusName + '}';
    }
}

