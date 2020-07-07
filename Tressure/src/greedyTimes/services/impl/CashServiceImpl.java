package greedyTimes.services.impl;

import greedyTimes.Cash;
import greedyTimes.Gem;
import greedyTimes.services.CashService;

import java.util.List;

public class CashServiceImpl implements CashService {

    private final List<Cash> cash;

    public CashServiceImpl(List<Cash> cash) {
        this.cash = cash;
    }

    @Override
    public boolean containsCash(String name) {
        for (Cash current : cash) {
            if (current.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public long totalCash() {
        return this.cash.stream()
                .mapToLong(Cash::getValue)
                .sum();
    }

    @Override
    public Cash findCashByName(String name) {
        Cash cash = null;

        for (Cash current : this.cash) {
            if (current.getName().equals(name)) {
                cash = current;
            }
        }

        return cash;
    }
}
