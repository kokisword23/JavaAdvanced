package app.interfaces;

import app.Mission;

import java.util.Collection;

public interface Commando {

    void addMission(Mission mission);

    Collection<Mission> getMissions();
}
