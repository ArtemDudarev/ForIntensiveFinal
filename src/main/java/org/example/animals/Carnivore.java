package org.example.animals;

import java.util.List;

public class Carnivore extends Animal<Animal> {
    public Carnivore(String name, int population, List<Animal> food, double optimalTemp, double optimalWater) {
        super(name, population, food, optimalTemp, optimalWater);
    }

    @Override
    public boolean isEating(double tempEcosystem, double waterEcosystem, List<Animal> allHerbivoreEcosystem) {
        if (tempEcosystem <= optimalTemp + 20
                && tempEcosystem >= optimalTemp - 20
                && waterEcosystem <= optimalWater + 20
                && waterEcosystem >= optimalWater - 20
                && waterEcosystem >= 1
                && food.stream().anyMatch(allHerbivoreEcosystem::contains)

        ){
            return true;
        }
        else return false;
    }
}
