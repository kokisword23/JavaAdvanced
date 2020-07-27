package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.List;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private List<Rider> riders;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.riders = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, laps));
        }
        this.laps = laps;
    }

    @Override
    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

    @Override
    public void addRider(Rider rider) {
        boolean hasRiderInRace = this.getRiders()
                .stream()
                .map(Rider::getName)
                .anyMatch(targetName -> rider.getName().equals(targetName));
        if (rider == null) {
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        } else if (rider.getMotorcycle() == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        } else if (hasRiderInRace) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), this.getName()));
        }

        this.riders.add(rider);
    }
}
