package main.functional.methods;

public interface PaymentService {
    double retrieveDefaultFees();

    default double send(double value) {
        System.out.println("Sending the value: " + value);

        return value;
    }

    static double getValueWithVAT(double value) {
        return value + value*0.2;
    }
}
