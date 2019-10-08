package model;

import java.math.BigDecimal;

public class Salesman extends Employee {

    private BigDecimal currentMonthSales;

    public BigDecimal getCurrentMonthSales() {
        return currentMonthSales;
    }

    public void setCurrentMonthSales(BigDecimal currentMonthSales) {
        this.currentMonthSales = currentMonthSales;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "currentMonthSales=" + currentMonthSales +
                '}' +
                " Employee{" +
                "name='" + super.getName()+ '\'' +
                ", type=" + super.getType() +
                ", monthlyBaseSalary=" + super.getMonthlyBaseSalary() +
                ", monthlyTotalSalary=" + super.getMonthlyTotalSalary() +
                '}';
    }
}
