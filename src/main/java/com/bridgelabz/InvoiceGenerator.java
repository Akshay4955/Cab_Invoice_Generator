package com.bridgelabz;

public class InvoiceGenerator {
    private static final double RATE_PER_KILOMETER = 10.0;
    private static final int RATE_PER_TIME = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * RATE_PER_KILOMETER + time * RATE_PER_TIME;
        if (totalFare < MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }
}
