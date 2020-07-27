package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {

    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        setName(name);
        setCanParticipate();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name,5));
        }
        this.name = name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(MotorcycleImpl motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }


    public void setCanParticipate() {
        this.canParticipate = this.motorcycle != null;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            throw new NullPointerException(ExceptionMessages.MOTORCYCLE_INVALID);
        }

        this.motorcycle = motorcycle;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }
}
