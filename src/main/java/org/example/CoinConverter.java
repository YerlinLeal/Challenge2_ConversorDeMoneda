package org.example;

public class CoinConverter {

    private double dollarValue;

    public CoinConverter (double dollarValue) {
        this.dollarValue = dollarValue;
    }
    public double colonToDolar (int number) {
        return number / this.dollarValue;
    }

    public double dolarToColon (int number) {
        return number * this.dollarValue;
    }
}
