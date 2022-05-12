import model.Employee;
import model.Office;
import model.Sale;
import service.Methods;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Office secretary = new Office("Secretário", 7000.00, 0.2, 1000.00);
        Office seller = new Office("Vendedor", 12000.00, 0.3, 1800.00);
        Office manager = new Office("Gerente", 20000.00, 0.0, 3000.00);

        List<Sale> salesAnaSilva = Arrays.asList(
                new Sale(LocalDate.of(2021, 12, 1), 5200.00),
                new Sale(LocalDate.of(2022, 1, 1), 4000.00),
                new Sale(LocalDate.of(2022, 2, 1), 4200.00),
                new Sale(LocalDate.of(2022, 3, 1), 5850.00),
                new Sale(LocalDate.of(2022, 4, 1), 7000.00)
        );

        List<Sale> salesJoaoMendes = Arrays.asList(
                new Sale(LocalDate.of(2021, 12, 1), 3400.00),
                new Sale(LocalDate.of(2022, 1, 1), 7700.00),
                new Sale(LocalDate.of(2022, 2, 1), 5000.00),
                new Sale(LocalDate.of(2022, 3, 1), 5900.00),
                new Sale(LocalDate.of(2022, 4, 1), 6500.00)
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Jorge Carvalho", secretary, LocalDate.of(2018, 1, 1)),
                new Employee("Maria Souza", secretary, LocalDate.of(2015, 12, 1)),
                new Employee("Ana Silva", seller, LocalDate.of(2021, 12, 1), salesAnaSilva),
                new Employee("João Mendes", seller, LocalDate.of(2021, 12, 1), salesJoaoMendes),
                new Employee("Juliana Alves", manager, LocalDate.of(2017, 7, 1)),
                new Employee("Bento Albino", manager, LocalDate.of(2014, 3, 1))
        );

        Methods methods = new Methods();

        //System.out.println(methods.totalPaymentsBenefitMonth(employees, 12, 2021));
        //System.out.println(methods.totalPaymentsMonth(employees, 2, 2022));
        //System.out.println(methods.higherBenefitMonth(employees, 3, 2022));
        //System.out.println(methods.higherPaymentMonth(employees, 4,2022));
        //System.out.println(methods.higherBenefitMonth(employees, 1, 2022));
        //System.out.println(methods.higherSellerMonth(employees, 1, 2022));
    }
}
