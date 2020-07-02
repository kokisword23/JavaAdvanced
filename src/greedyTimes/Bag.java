package greedyTimes;

import java.util.*;

public class Bag {
    private Gold gold;
    private List<Gem> gems;
    private List<Cash> cash;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Cash> getCash() {
        return cash;
    }

    public void setCash(List<Cash> cash) {
        this.cash = cash;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void decreaseCapacity(long amount) {
        this.setCapacity(this.getCapacity() - amount);
    }

    private void print() {
        //:TODO
//        Map<String,Long> mapToSort = new LinkedHashMap<>();
        //put....
        //sort value    -> name ->
//
//       sortedMap =  mapToSort.keySet().stream().sorted()
//        for (Map<Entry<K,V>> pair : sortedMap.entrySet) {
//            if (pair.getKey() == "Gold") {
//
//            } else if ("Cash") {
//
//            } else if ("Gem") {
//
//            }
//        }
    }


}
