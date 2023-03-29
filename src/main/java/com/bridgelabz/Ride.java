package com.bridgelabz;

public class Ride implements InvoiceService {
    public double distance;
    public int time;
    public RideCategory category;

    public Ride() {
    }

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(RideCategory category, double distance, int time) {
        this.category = category;
        this.distance = distance;
        this.time = time;
    }

    @Override
    public double calculateCategoryFare(RideCategory category, double distance, int time) {
        double totalFare = distance * category.ratePerKM + time * category.ratePerMinute;
        return Math.max(totalFare, category.minFare);
    }
}
