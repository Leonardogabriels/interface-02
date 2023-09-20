package model.services;

public interface OnlinePaymentService {

    double paymentFee(double amout);
    double interest(double amout, int months);
    
}
