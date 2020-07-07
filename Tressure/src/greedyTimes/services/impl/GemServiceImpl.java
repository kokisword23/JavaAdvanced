package greedyTimes.services.impl;

import greedyTimes.Gem;
import greedyTimes.services.GemService;

import java.util.List;


public class GemServiceImpl implements GemService {

    private final List<Gem> gems;

    public GemServiceImpl(List<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public boolean containsGem(String name) {
        for (Gem current : this.gems) {
            if (current.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long totalGems() {
        return this.gems.stream()
                .mapToLong(Gem::getValue)
                .sum();
    }

    @Override
    public Gem findGemByName(String name) {
        Gem gem = null;

        for (Gem current : this.gems) {
            if (current.getName().equals(name)) {
                gem = current;
            }
        }

        return gem;
    }
}
