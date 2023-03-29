package com.bridgelabz;


import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2, 5),
                new Ride(0.1, 1),
                new Ride(2.2, 8)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        String userID = "Akshay_Shedge";
        Ride[] rides = {new Ride(2, 5),
                new Ride(0.1, 1),
                new Ride(2.2, 8)
        };
        invoiceGenerator.addRides(userID, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userID);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
