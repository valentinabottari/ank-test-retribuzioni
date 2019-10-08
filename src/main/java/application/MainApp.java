package application;

import management.SalaryCalculator;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        //Vittorio è un venditore, ha venduto per 15.000 €.
        Salesman vittorio = new Salesman();
        vittorio.setName("Vittorio");
        vittorio.setType(EmployeeType.getEmployeeTypeFromRoleName("Venditore"));
        vittorio.setCurrentMonthSales(new BigDecimal("15000.00"));
        employees.add(vittorio);

        //Teresa è un tecnico.
        Engineer teresa = new Engineer();
        teresa.setName("Teresa");
        teresa.setType(EmployeeType.getEmployeeTypeFromRoleName("Tecnico"));
        employees.add(teresa);

        //Mario è il manager di Vittorio e Teresa.
        Manager mario = new Manager();
        mario.setName("Mario");
        mario.setType(EmployeeType.getEmployeeTypeFromRoleName("Manager"));
        mario.setSubordinates(new ArrayList<>(Arrays.asList(vittorio, teresa)));
        employees.add(mario);

        //Virna è un venditore, ha venduto per 17.000 €
        Salesman virna = new Salesman();
        virna.setName("Virna");
        virna.setType(EmployeeType.getEmployeeTypeFromRoleName("Venditore"));
        virna.setCurrentMonthSales(new BigDecimal("17000.00"));
        employees.add(virna);

        //Maria è l’amministratore delegato, manager di Mario e Virna.
        Manager maria = new Manager();
        maria.setName("Maria");
        maria.setType(EmployeeType.getEmployeeTypeFromRoleName("Amministratore delegato"));
        maria.setSubordinates(new ArrayList<>(Arrays.asList(mario, virna)));
        employees.add(maria);

        SalaryCalculator calculator = new SalaryCalculator();
        BigDecimal totalSalaries = calculator.calculateTotalSalaries(employees);

        System.out.println("Total salaries: " + totalSalaries);
    }
}
