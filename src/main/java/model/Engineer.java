package model;

public class Engineer extends Employee {

    @Override
    public String toString() {
        return "Engineer{} " +
                " Employee{" +
                "name='" + super.getName()+ '\'' +
                ", type=" + super.getType() +
                ", monthlyBaseSalary=" + super.getMonthlyBaseSalary() +
                ", monthlyTotalSalary=" + super.getMonthlyTotalSalary() +
                '}';
    }
}
