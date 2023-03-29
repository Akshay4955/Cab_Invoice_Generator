package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private static final double RATE_PER_KILOMETER = 10.0;
    private static final int RATE_PER_TIME = 1;
    private static final double MIN_FARE = 5;
    Map<String, Ride[]> userRides = new HashMap<>();

    public InvoiceSummary getInvoiceSummary(String userID) {
        Ride[] rides = userRides.get(userID);
        InvoiceSummary invoiceSummary = new InvoiceGenerator().calculateFare(rides);
        return invoiceSummary;
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * RATE_PER_KILOMETER + time * RATE_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userID, Ride[] rides) {
        userRides.put(userID, rides);
    }

    public InvoiceSummary getInvoiceSummaryPremium(String userID) {
        Ride[] rides = userRides.get(userID);
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.calculateCategoryFare(ride.category, ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

}
