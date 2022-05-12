package model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private String name;
    private Office office;
    private LocalDate startDate;

    private List<Sale> sales;

    public Employee(String name, Office office, LocalDate startDate, List<Sale> sales) {
        this.name = name;
        this.office = office;
        this.startDate = startDate;
        this.sales = sales;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
