package management;

import model.*;

import java.math.BigDecimal;
import java.util.List;

public class SalaryCalculator {

    /**
     * The program assumes that a list of Employees will always contain one Manager of EmployeeType=CEO,
     * and that every other Employee has one and only one manager.
     * @param employees
     * @return BigDecimal total salaries
     */
    public BigDecimal calculateTotalSalaries(List<Employee> employees) {

        Manager ceo = (Manager) employees.stream().filter(e -> e.getType().equals(EmployeeType.CEO)).findFirst().get();
        return addUpAllSalariesStartingFromCEO(ceo);
    }


    private BigDecimal addUpAllSalariesStartingFromCEO(Manager manager) {

        BigDecimal totalSalaries = new BigDecimal("0.00");

        if (manager.getSubordinates() != null && !manager.getSubordinates().isEmpty()) {
            for (Employee subordinate : manager.getSubordinates()) {
                if (subordinate instanceof Manager) {
                    totalSalaries = totalSalaries.add(addUpAllSalariesStartingFromCEO((Manager) subordinate));
                }
                totalSalaries = totalSalaries.add(calculateEmployeeSalary(subordinate));
            }
            manager.setTotalSubordinatesSalary(totalSalaries);
            if (manager.getType().equals(EmployeeType.CEO)) {
                calculateEmployeeSalary(manager);
                totalSalaries = totalSalaries.add(manager.getMonthlyTotalSalary());
            }
        }
        return totalSalaries;
    }


    public BigDecimal calculateEmployeeSalary(Employee employee) {

        if (employee instanceof Salesman) {
            employee.setMonthlyBaseSalary(SalaryValues.SALESMAN_BASE_SALARY);
            employee.setMonthlyTotalSalary(
                    employee.getMonthlyBaseSalary().add(
                            ((Salesman) employee).getCurrentMonthSales()
                                    .multiply(BigDecimal.valueOf(SalaryValues.SALESMANS_PERCENTAGE_ON_SALES))
                                    .divide(new BigDecimal("100"))
                    )
            );
        } else if (employee instanceof Engineer) {
            employee.setMonthlyBaseSalary(SalaryValues.ENGINEER_BASE_SALARY);
            employee.setMonthlyTotalSalary(SalaryValues.ENGINEER_BASE_SALARY);
        } else if (employee instanceof Manager) {
            employee.setMonthlyBaseSalary(SalaryValues.MANAGER_BASE_SALARY);
            employee.setMonthlyTotalSalary(
                    employee.getMonthlyBaseSalary().add(
                            ((Manager) employee).getTotalSubordinatesSalary()
                            .multiply(BigDecimal.valueOf(SalaryValues.MANAGERS_PERCENTAGE_ON_SUBORDINATES))
                            .divide(new BigDecimal("100"))
                    )
            );
        }

        System.out.println(employee.getName() + "'s total salary: " + employee.getMonthlyTotalSalary());
        return employee.getMonthlyTotalSalary();
    }

}
