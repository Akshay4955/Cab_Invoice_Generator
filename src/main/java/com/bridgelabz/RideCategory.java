package com.bridgelabz;


public enum RideCategory {
    NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

    public double ratePerKM;
    public int ratePerMinute;
    public double minFare;

    RideCategory(double ratePerKM, int ratePerMinute, double minFare) {
        this.ratePerKM = ratePerKM;
        this.ratePerMinute = ratePerMinute;
        this.minFare = minFare;
    }

}
