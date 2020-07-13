package app;

import app.interfaces.Engineer;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s",
                        super.getFirstName(),
                        super.getLastName(),
                        super.getId(),
                        super.getSalary(),
                        this.getCorp().getName()))
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());

        for (Repair repair : repairs) {
            sb.append("  ").append(repair).append(System.lineSeparator());

        }
        return sb.toString();
    }
}
