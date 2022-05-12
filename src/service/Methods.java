package service;

import model.Employee;
import model.Sale;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Methods {

    private Double getSalary(Employee employee, LocalDate date){
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
            String officeName = employee.getOffice().getName();
            double salary = this.getSalary(employee, date);

            if(officeName.equals("Secretário")){
                double benefit = salary * employee.getOffice().getBenefit();
                totalPaymentBenefit += salary + benefit;

            } else if(officeName.equals(("Vendedor"))){
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
            totalPayment += this.getSalary(employee, date);
        }

        return totalPayment;
    }

    public Double totalBenefitMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Double totalBenefit = 0.0;

        for (Employee employee: employeeList) {
            String officeName = employee.getOffice().getName();

            if(officeName.equals("Secretário")){
                double benefit = this.getSalary(employee, date) * employee.getOffice().getBenefit();
                totalBenefit += benefit;

            } else if(officeName.equals(("Vendedor"))){
                double benefit = getSaleAmountMonth(employee, date) * employee.getOffice().getBenefit();
                totalBenefit += benefit;

            }
        }

        return totalBenefit;
    }

    public String higherPaymentMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Employee higherEmployee = employeeList.get(0);

        for (Employee employee : employeeList) {
           if(this.getSalary(employee, date) > this.getSalary(higherEmployee, date)){
               higherEmployee = employee;
           }
        }

        return higherEmployee.getName();
    }

    public String higherBenefitMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Employee higherEmployee = employeeList.get(0);
        Double higherBenefit = 0.0;

        for (Employee employee: employeeList) {
            Double employeeBenefit = 0.0;
            String officeName = employee.getOffice().getName();

            if(officeName.equals("Secretário")){
                employeeBenefit = getSalary(employee, date) * employee.getOffice().getBenefit();
            } else if(officeName.equals("Vendedor")){
                employeeBenefit = getSaleAmountMonth(employee, date) * employee.getOffice().getBenefit();
            }

            if(employeeBenefit > higherBenefit) {
                higherEmployee = employee;
                higherBenefit = employeeBenefit;
            }
        }

        return higherEmployee.getName();
    }

    public String higherSellerMonth(List<Employee> employeeList, int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        Employee higherEmployee = employeeList.get(0);
        Double higherSale = 0.0;

        for (Employee employee: employeeList){
            Double saleAmountMonth = 0.0;
            String officeName = employee.getOffice().getName();

            if(officeName.equals("Vendedor")){
                saleAmountMonth = getSaleAmountMonth(employee, date);
            }

            if(saleAmountMonth > higherSale){
                higherEmployee = employee;
                higherSale = saleAmountMonth;
            }
        }

        return higherEmployee.getName();
    }
}
