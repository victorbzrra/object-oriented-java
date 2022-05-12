package model;

public class Office {
    private String name;
    private Double salary;
    private Double benefit;
    private Double extra;

    public Office(String name, Double salary, Double benefit, Double extra) {
        this.name = name;
        this.salary = salary;
        this.benefit = benefit;
        this.extra = extra;
    }

    public Office() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }
}
