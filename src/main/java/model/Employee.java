package model;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private EmployeeType type;
    private BigDecimal monthlyBaseSalary;
    private BigDecimal monthlyTotalSalary;

    protected Employee() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public BigDecimal getMonthlyBaseSalary() {
        return monthlyBaseSalary;
    }

    public void setMonthlyBaseSalary(BigDecimal monthlyBaseSalary) {
        this.monthlyBaseSalary = monthlyBaseSalary;
    }

    public BigDecimal getMonthlyTotalSalary() {
        return monthlyTotalSalary;
    }

    public void setMonthlyTotalSalary(BigDecimal monthlyTotalSalary) {
        this.monthlyTotalSalary = monthlyTotalSalary;
    }

}
