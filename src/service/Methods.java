package service;

import model.Employee;
import model.Sale;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Methods {

    private Double calculateSalary(Employee employee, LocalDate date){
        int diffYears = Period.between(employee.getStartDate(), date).getYears();

        if(diffYears >= 0){
            return employee.getOffice().getSalary() + (employee.getOffice().getExtra() * diffYears);
        } else {
            return 0.0;
        }
    }

    private Double getSaleAmountMonth(Employee employee, LocalDate date){
        Double amount = 0.0;

        for (Sale sale : employee.getSales()) {
            if (sale.getDate().equals(date)){
                amount = sale.getAmount();
            }
        }

        return amount;
    }

    public Double totalPaymentsBenefitMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Double totalPaymentBenefit = 0.0;

        for (Employee employee: employeeList) {
            double salary = this.calculateSalary(employee, date);

            if(employee.getOffice().getName().equals("Secretário")){
                double benefit = salary * employee.getOffice().getBenefit();
                totalPaymentBenefit += salary + benefit;

            } else if(employee.getOffice().getName().equals(("Vendedor"))){
                double benefit = getSaleAmountMonth(employee, date) * employee.getOffice().getBenefit();
                totalPaymentBenefit += salary + benefit;

            } else {
                totalPaymentBenefit += salary;
            }
        }

        return  totalPaymentBenefit;
    }

    public Double totalPaymentsMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Double totalPayment = 0.0;

        for (Employee employee : employeeList) {
            totalPayment += this.calculateSalary(employee, date);
        }

        return totalPayment;
    }

    public String higherPaymentMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Employee higherEmployee = employeeList.get(0);

        for (Employee employee : employeeList) {
           if(this.calculateSalary(employee, date) > this.calculateSalary(higherEmployee, date)){
               higherEmployee = employee;
           }
        }

        return higherEmployee.getName();
    }
}
