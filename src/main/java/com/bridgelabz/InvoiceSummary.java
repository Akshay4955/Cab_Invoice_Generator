package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    public double averageFare;
    public int noOfRides;
    public double totalFare;

    public InvoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.averageFare, averageFare) == 0 && noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFare, noOfRides, totalFare);
    }
}
