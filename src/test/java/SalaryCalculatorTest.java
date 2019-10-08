import management.SalaryCalculator;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalaryCalculatorTest {

    private SalaryCalculator salaryCalculator;
    private List<Employee> employees;

    private Manager manager1;
    private Manager manager2;
    private Manager manager3;

    private Salesman salesman1;
    private Salesman salesman2;
    private Salesman salesman3;

    private Engineer engineer1;
    private Engineer engineer2;
    private Engineer engineer3;

    @Test
    public void calculateEmployeeSalaryTest() {

        salaryCalculator.calculateEmployeeSalary(salesman1);
        Assert.assertEquals(new BigDecimal("2000.00"), salesman1.getMonthlyTotalSalary());
        System.out.println(salesman1.toString());
        salaryCalculator.calculateEmployeeSalary(salesman2);
        salaryCalculator.calculateEmployeeSalary(salesman3);

        salaryCalculator.calculateEmployeeSalary(engineer1);
        System.out.println(engineer1.toString());
        Assert.assertEquals(new BigDecimal("1400.00"), engineer1.getMonthlyTotalSalary());
        salaryCalculator.calculateEmployeeSalary(engineer2);
        salaryCalculator.calculateEmployeeSalary(engineer3);

        //add up subordinates salary before calculating manager's
        BigDecimal manager3SubordinatesSalary = new BigDecimal("0.00");
        for (Employee subordinate : manager3.getSubordinates()) {
            manager3SubordinatesSalary = manager3SubordinatesSalary.add(subordinate.getMonthlyTotalSalary());
            if (subordinate instanceof Manager)
                manager3SubordinatesSalary = manager3SubordinatesSalary.add(((Manager) subordinate).getTotalSubordinatesSalary());
        }
        manager3.setTotalSubordinatesSalary(manager3SubordinatesSalary);
        salaryCalculator.calculateEmployeeSalary(manager3);
        System.out.println(manager3.toString());
        Assert.assertEquals(new BigDecimal("1640.00"), manager3.getMonthlyTotalSalary());

        BigDecimal manager2SubordinatesSalary = new BigDecimal("0.00");
        for (Employee subordinate : manager2.getSubordinates()) {
            manager2SubordinatesSalary = manager2SubordinatesSalary.add(subordinate.getMonthlyTotalSalary());
            if (subordinate instanceof Manager)
                manager2SubordinatesSalary = manager2SubordinatesSalary.add(((Manager) subordinate).getTotalSubordinatesSalary());
        }
        manager2.setTotalSubordinatesSalary(manager2SubordinatesSalary);
        salaryCalculator.calculateEmployeeSalary(manager2);
        System.out.println(manager2.toString());
        Assert.assertEquals(new BigDecimal("2022.00"), manager2.getMonthlyTotalSalary());

        BigDecimal manager1SubordinatesSalary = new BigDecimal("0.00");
        for (Employee subordinate : manager1.getSubordinates()) {
            manager1SubordinatesSalary = manager1SubordinatesSalary.add(subordinate.getMonthlyTotalSalary());
            if (subordinate instanceof Manager)
                manager1SubordinatesSalary = manager1SubordinatesSalary.add(((Manager) subordinate).getTotalSubordinatesSalary());
        }
        manager1.setTotalSubordinatesSalary(manager1SubordinatesSalary);
        salaryCalculator.calculateEmployeeSalary(manager1);
        System.out.println(manager1.toString());
        Assert.assertEquals(new BigDecimal("2193.10"), manager1.getMonthlyTotalSalary());
   }

   @Test
   public void calculateTotalSalariesTest() {
        Assert.assertEquals(new BigDecimal("16055.10"), salaryCalculator.calculateTotalSalaries(employees));
   }

   @Before
    public void setUp() {

        manager1 = new Manager();
        manager1.setSubordinates(new ArrayList<Employee>());
        manager1.setName("Manager One");
        manager1.setType(EmployeeType.CEO);

        manager2 = new Manager();
        manager2.setSubordinates(new ArrayList<Employee>());
        manager2.setName("Manager Two");
        manager2.setType(EmployeeType.MANAGER);

        manager3 = new Manager();
        manager3.setSubordinates(new ArrayList<Employee>());
        manager3.setName("Manager Three");
        manager3.setType(EmployeeType.MANAGER);

        salesman1 = new Salesman();
        salesman1.setCurrentMonthSales(new BigDecimal("15000.00"));
        salesman1.setName("Salesman One");
        salesman1.setType(EmployeeType.SALESMAN);

        salesman2 = new Salesman();
        salesman2.setCurrentMonthSales(new BigDecimal("15000.00"));
        salesman2.setName("Salesman Two");
        salesman2.setType(EmployeeType.SALESMAN);

        salesman3 = new Salesman();
        salesman3.setCurrentMonthSales(new BigDecimal("15000.00"));
        salesman3.setName("Salesman Three");
        salesman3.setType(EmployeeType.SALESMAN);

        engineer1 = new Engineer();
        engineer1.setName("Engineer One");
        engineer1.setType(EmployeeType.ENGINEER);

        engineer2 = new Engineer();
        engineer2.setName("Engineer Two");
        engineer2.setType(EmployeeType.ENGINEER);

        engineer3 = new Engineer();
        engineer3.setName("Engineer Three");
        engineer3.setType(EmployeeType.ENGINEER);

        manager1.getSubordinates().addAll(new ArrayList<Employee>(Arrays.asList(manager2, engineer1)));
        manager2.getSubordinates().addAll(new ArrayList<Employee>(Arrays.asList(manager3, salesman1, salesman2, salesman3)));
        manager3.getSubordinates().addAll(new ArrayList<Employee>(Arrays.asList(engineer2, engineer3)));

        employees = new ArrayList<Employee>(Arrays.asList(
               manager1, manager2, manager3, salesman1, salesman2, salesman3, engineer1, engineer2, engineer3
        ));

        salaryCalculator = new SalaryCalculator();
   }

}
