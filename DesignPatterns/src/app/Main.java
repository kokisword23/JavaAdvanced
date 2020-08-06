package app;

import app.entities.BaseHero;
import app.entities.Item;
import app.entities.Rogue;
import app.factories.HeroFactoryImpl;
import app.skills.Invoker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HeroFactoryImpl factory = new HeroFactoryImpl();
        Rogue rogue = (Rogue) factory.createHero("Rogue", "Pesho", 100);
        rogue.defence();

        Invoker invoker = new Invoker();
        invoker.castSpell("rogue");
        invoker.castSpell("mage");

        Item dagger = Item.builder() //ItemBuilder
                .name("Fel dagger")
                .attack(2500)
                .create();   //ItemBuilder ->  Item

        dagger = Item.builder(dagger) //ItemBuilder -> name,attack
                .attack(1250)
                .cost(1)
                .create();

    }
}
