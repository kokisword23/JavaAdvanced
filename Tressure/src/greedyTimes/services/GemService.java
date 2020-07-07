package greedyTimes.services;

import greedyTimes.Gem;

public interface GemService {

    boolean containsGem(String name);

    long totalGems();

    Gem findGemByName(String name);
}
