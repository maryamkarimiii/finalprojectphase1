package ir.maktab.data.enums;

public enum OrderStatus {
    WAITING_FOR_EXPERT_RECOMMENDATION(),
    WAITING_FOR_CUSTOMER_CHOICE(),
    WAITING_FOR_EXPERT_COME(),
    START_WORKING(),
    FINISH_WORKING(),
    PAID();
}
