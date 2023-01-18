package ir.maktab.data.enums;

import java.util.Date;

public enum OrderStatus {
    WAITING_FOR_EXPERT_RECOMMENDATION(new Date()),
    WAITING_FOR_CUSTOMER_CHOICE(new Date()),
    WAITING_FOR_EXPERT_COME(new Date()),
    START_WORKING(new Date()),
    FINISH_WORKING(new Date()),
    PAID(new Date());

    OrderStatus(Date startTime) {
        this.startTime = startTime;
    }

    private Date startTime;

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }
}
