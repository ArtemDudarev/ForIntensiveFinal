package org.example.animals;

import org.example.plants.Plant;

import java.util.Collections;
import java.util.List;

public class Herbivore extends Animal<Plant>{


    public Herbivore(String name, int population, List<Plant> food, double optimalTemp, double optimalWater) {
        super(name, population, food, optimalTemp, optimalWater);
    }

    @Override
    public boolean isEating(double tempEcosystem, double waterEcosystem, List<Plant> allPlantsEcosystem) {
        if (tempEcosystem <= optimalTemp + 20
                && tempEcosystem >= optimalTemp - 20
                && waterEcosystem <= optimalWater + 20
                && waterEcosystem >= optimalWater - 20
                && waterEcosystem >= 1
                && food.stream().anyMatch(allPlantsEcosystem::contains)

        ){
            return true;
        }
        else return false;
    }
}
