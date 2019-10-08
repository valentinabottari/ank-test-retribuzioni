package model;

import java.util.Arrays;

public enum EmployeeType {
    CEO("Amministratore delegato"),
    MANAGER("Manager"),
    ENGINEER("Tecnico"),
    SALESMAN("Venditore");

    private String roleName;

    EmployeeType(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static EmployeeType getEmployeeTypeFromRoleName(String roleName) {
        return Arrays.asList(EmployeeType.values()).stream()
                .filter(v -> v.getRoleName().equals(roleName))
                .findFirst().get();
    }

}
