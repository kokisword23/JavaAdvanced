package greedyTimes;

import greedyTimes.services.CashService;
import greedyTimes.services.GemService;
import greedyTimes.services.impl.CashServiceImpl;
import greedyTimes.services.impl.GemServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] treasure = scanner.nextLine().split("\\s+");

        //Bag {
        //  Gold      setGold(getGold.value + money)   -> setCapacity(getCapacity - money)
        // List<Gems> setGems(getGems.add(gem)    ->
        // List<Cash>
        // capacity
        Bag bag = new Bag(capacity);


        for (int i = 0; i < treasure.length; i += 2) {
            GemService gemService = new GemServiceImpl(bag.getGems());
            CashService cashService = new CashServiceImpl(bag.getCash());

            String item = treasure[i];
            long quantity = Long.parseLong(treasure[i + 1]);

            String name = "";

            if (item.length() == 3) {
                name = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                name = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                name = "Gold";
            }

            if (name.equals("")) {
                continue;
                //10345 < quanity
            } else if (bag.getCapacity() < quantity) {
                continue;
            }
            //Gem -> List<Gem>
            switch (name) {
                case "Gem":

                    //false -> true
                    if (!gemService.containsGem(name)) {
                        if (bag.getGold() != null) {
                            if (quantity > bag.getGold().getValue()) {
                                continue;
                            }

                            //Gem for firstTime
                            bag.getGems().add(new Gem(item,quantity));
                            bag.decreaseCapacity(quantity);
                        } else {
                            continue;
                        }
                    } else if (gemService.totalGems() + quantity > bag.getGold().getValue()) {
                        continue;
                    } else {
                        Gem gem = gemService.findGemByName(item);
                        gem.setValue(gem.getValue() + quantity);
                        bag.decreaseCapacity(quantity);
                    }
                    break;
                case "Cash":
                    if (!cashService.containsCash(name)) {
                        if (bag.getGems().size() > 0) {
                            if (cashService.totalCash() + quantity > gemService.totalGems()) {
                                continue;
                            }

                            bag.getCash().add(new Cash(item,quantity));
                            bag.decreaseCapacity(quantity);
                        } else {
                            continue;
                        }
                    } else if (cashService.totalCash() + quantity > gemService.totalGems()) {
                        continue;
                    } else {
                        Cash cash = cashService.findCashByName(item);
                        cash.setValue(cash.getValue() + quantity);
                        bag.decreaseCapacity(quantity);
                    }
                    break;
                case "Gold":
                    if (bag.getGold() == null) {
                        bag.setGold(new Gold(quantity));
                    } else {
                        Gold gold = bag.getGold();
                        gold.setValue(gold.getValue() + quantity);
                        bag.decreaseCapacity(quantity);
                    }
                    break;
            }
        }

        System.out.println();
    }
}