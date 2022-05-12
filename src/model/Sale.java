package model;

import java.time.LocalDate;

public class Sale {
    private LocalDate date;
    private Double amount;

    public Sale(LocalDate date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Sale() {
        super();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
