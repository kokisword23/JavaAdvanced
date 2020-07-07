package greedyTimes.services;

import greedyTimes.Cash;

public interface CashService<Entity> {

    boolean containsCash(String name);

    long totalCash();

    Cash findCashByName(String name);
}
