package org.example.ecosystems;

import org.example.animals.Animal;
import org.example.animals.Herbivore;
import org.example.plants.Plant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.example.enums.Colors.*;

public class Ecosystem implements Serializable {
    private String name;
    private List<Plant> plants;
    private List<Animal> animals;
    private List<String> resources;
    private double temperature;
    private double humidity;
    private double water;
    private double light;

    private static final Long serialVersionUID = 1L;

    public Ecosystem(String name, List<Plant> plants, List<Animal> animals, List<String> resources, double temperature, double humidity, double water, double light) {
        this.name = name;
        this.plants = plants;
        this.animals = animals;
        this.resources = resources;
        this.temperature = temperature;
        this.humidity = humidity;
        this.water = water;
        this.light = light;
    }

    public String getName() {
        return name;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<String> getResources() {
        return resources;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWater() {
        return water;
    }

    public double getLight() {
        return light;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public void setLight(double light) {
        this.light = light;
    }

    public void getInfo(){
        System.out.println("\n=====Information about ecosystem=====");
        System.out.println("Ecosystem name: " + name);
        System.out.println("Ecosystem temperature: " + temperature + " C\u00B0");
        System.out.println("Ecosystem humidity: " + humidity + " %");
        System.out.println("Ecosystem water: " + water + " %");
        System.out.println("Ecosystem light: " + light + " %");
        System.out.println("Ecosystem resources: ");
        resources.stream().forEach(x-> System.out.println("    " + x));
        System.out.println("Ecosystem plants: ");
        plants.stream().forEach(x -> System.out.println("    " + x));
        System.out.println("Ecosystem animals: ");
        animals.stream().forEach(x -> System.out.println("    " + x));
        System.out.println("=====================================\n");
    }
//    public void getStatus(){
//        System.out.println("\n The state of all plants in the ecosystem: ");
//        plants.stream().forEach(x-> System.out.println( "The plant " + x.getName()+ " is " + (x.isGrowing(temperature, humidity, water, light, resources) ? "survived" : "died")));
//        System.out.println("\n The state of all animals in the ecosystem: ");
//
//        // Если растение не выжило, то его необходимо удалить из списка, чтобы животные, которые зависят от него, тоже вымерли
//
//        animals.stream().forEach(x ->  {
//            String result = (x instanceof Herbivore ? x.isEating(temperature, water, plants) : x.isEating(temperature, water, animals)) ? "survived" : "died";
//            System.out.println("The animal " + x.getName()+ " is " + result);
//        });
//    }

    public void startIteration(){
        List<Plant> forRemovingPlants = new ArrayList<>();
        List<Animal> forRemovingAnimals = new ArrayList<>();

        System.out.println("\n=====Plant=====");

        for (Plant x : plants) {
            // Проверка на возможность расти популяции
            if(x.isGrowing(temperature, humidity, water, light, resources)){
                x.setPopulation(x.getPopulation() + 50);
                System.out.println(x.getName() + " population " + GREEN.getColor() + "is increasing" + NORMAL.getColor());
            }
            else {
                x.setPopulation(x.getPopulation() - 50);
                if(x.getPopulation() <= 0){
                    forRemovingPlants.add(x);
                    System.out.println(x.getName() + RED.getColor() + " died" + NORMAL.getColor());
                }
                else {
                    System.out.println(x.getName() + " population " + YELLOW.getColor() + "is declining" + NORMAL.getColor());
                }
            }
        }

        plants.removeAll(forRemovingPlants);

        System.out.println("================\n");
        System.out.println("\n=====Animal=====");

        for (Animal x : animals){
            if (x.isEating(temperature,water,x instanceof Herbivore ? plants : animals)){
                x.setPopulation(x.getPopulation() + 50);
                System.out.println(x.getName()  + " population " + GREEN.getColor() + "is increasing" + NORMAL.getColor());
            }
            else {
                x.setPopulation(x.getPopulation() - 50);
                if(x.getPopulation() <= 0){
                    forRemovingAnimals.add(x);
                    System.out.println(x.getName() + RED.getColor() + " died" + NORMAL.getColor());
                }
                else {
                    System.out.println(x.getName() + " population " + YELLOW.getColor() + "is declining" + NORMAL.getColor());
                }
            }
        }

        animals.removeAll(forRemovingAnimals);

        System.out.println("================\n");
    }
    public void predictPopulationChange(Plant plant) {
        // Прогнозирует изменение популяции растения
    }

    public void predictPopulationChange(Animal animal) {
        // Прогнозирует изменение популяции животного
    }

    public void updateEcosystem() {
        // Обновляет состояние экосистемы (рост растений, охота животных,
        // изменение климатических условий)
    }
}
