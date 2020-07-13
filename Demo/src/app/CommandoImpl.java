package app;


import app.interfaces.Commando;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
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
                .append("Missions:");
        if (missions.size() > 0) {
            sb.append(System.lineSeparator());
        }
        for (Mission mission : missions) {
            sb
                    .append(mission)
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
