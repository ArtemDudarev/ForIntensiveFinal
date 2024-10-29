package org.example.plants;

import java.io.Serializable;
import java.util.List;

public class Plant implements Growable, Serializable {
    private String name;
    private int population;
    private List<String> food;
    private double optimalTemp;
    private double optimalHumidity; // от 0% до 100%
    private double optimalWater; // от 0% до 100%
    private double optimalLight; // от 0% до 100%

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public Plant(String name, int population, List<String> food, double optimalTemp, double optimalHumidity, double optimalWater, double optimalLight) {
        this.name = name;
        this.population = population;
        this.food = food;
        this.optimalTemp = optimalTemp;
        this.optimalHumidity = optimalHumidity;
        this.optimalWater = optimalWater;
        this.optimalLight = optimalLight;
    }

    @Override
    public boolean isGrowing(double tempEcosystem, double humidityEcosystem, double waterEcosystem, double lightEcosystem, List<String> allResEcosystem) {

        // У растения есть оптимальные значения для выживания, однако,
        // если некоторые значения в окружающей среде будут немного отличатся, то растение все равно выживет
        // Для этого добавим определённый промежуток выживания

        // Проверка на возможность расти в определённой среде
        if (tempEcosystem <= optimalTemp + 10
                && tempEcosystem >= optimalTemp - 10
                && humidityEcosystem <= optimalHumidity + 20
                && humidityEcosystem >= optimalHumidity - 20
                && waterEcosystem <= optimalWater + 15
                && waterEcosystem >= optimalWater - 15
                && waterEcosystem >= 1
                && lightEcosystem <= optimalLight + 25
                && lightEcosystem >= optimalLight - 25
                && lightEcosystem >= 1
                && food.stream().anyMatch(allResEcosystem::contains)

        ){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Plant: " + name + " | population: " + population;
    }
}
