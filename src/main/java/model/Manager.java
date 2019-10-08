package model;

import java.math.BigDecimal;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> subordinates;
    private BigDecimal totalSubordinatesSalary;

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public BigDecimal getTotalSubordinatesSalary() {
        return totalSubordinatesSalary;
    }

    public void setTotalSubordinatesSalary(BigDecimal totalSubordinatesSalary) {
        this.totalSubordinatesSalary = totalSubordinatesSalary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "subordinates=" + subordinates.size() +
                " totalSubordinatesSalary=" + totalSubordinatesSalary +
                '}' +
                " Employee{" +
                "name='" + super.getName()+ '\'' +
                ", type=" + super.getType() +
                ", monthlyBaseSalary=" + super.getMonthlyBaseSalary() +
                ", monthlyTotalSalary=" + super.getMonthlyTotalSalary() +
                '}';
    }
}
