package service;

import model.Employee;

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
