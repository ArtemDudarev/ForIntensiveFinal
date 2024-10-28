package org.example;

import org.example.Ecosystems.EcoCRUD;
import org.example.Ecosystems.Ecosystem;
import org.example.animals.Animal;
import org.example.animals.Carnivore;
import org.example.animals.Herbivore;
import org.example.plants.Plant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.example.enums.Colors.BLUE;
import static org.example.enums.Colors.GREEN;
import static org.example.enums.Colors.NORMAL;
import static org.example.enums.Colors.RED;
import static org.example.enums.Colors.YELLOW;

public class Main {

    public static void addPlant(List<Plant> listPlant, Plant plant){

        System.out.println("Enter plant population");

        Scanner scPlant = new Scanner(System.in);
        int population = scPlant.nextInt();
        plant.setPopulation(population);
        listPlant.add(plant);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Plant plant0 = new Plant("grass", 1500, Arrays.asList("rock"), 15, 50, 15, 70);
        Plant plant1 = new Plant("grass1", 1500, Arrays.asList("rock", "aaa"), 15, 50, 15, 70);
        Plant plant2 = new Plant("grass2", 1500, Arrays.asList("rock"), 15, 50, 15, 70);
        Plant plant3 = new Plant("grass3", 1500, Arrays.asList("rock", "ddd"), 15, 50, 15, 70);

        List<String> resources = Arrays.asList("aaa", "ddd", "rock");

        Herbivore deer0 = new Herbivore("deer", 100, Arrays.asList(plant0, plant1), 20, 15);
        Herbivore cow = new Herbivore("cow", 80, Arrays.asList(plant2, plant3), 20, 15);

        List<Plant> plants = Arrays.asList(plant0, plant1, plant2, plant3);

        List<Animal> animals = Arrays.asList(deer0, cow);

        Ecosystem ecosystem0 = new Ecosystem("Test", plants, animals, resources, 15, 45, 20, 78);

        ecosystem0.getStatus();


        // Создание всех растений и животных
        Plant grass = new Plant("grass", 0, Arrays.asList("nitrogen"), 10, 30, 20, 60);
        Plant carrot = new Plant("carrot", 0, Arrays.asList("nitrogen", "potassium"), 20, 30, 15, 40);
        Plant corn = new Plant("corn", 0, Arrays.asList("nitrogen", "sulfur"), 22, 30, 15, 55);
        Plant tree = new Plant("tree", 0, Arrays.asList("magnesium"), 15, 30, 20, 43);
        Plant berries = new Plant("berries", 0, Arrays.asList("nitrogen"), 16, 30, 20, 30);

        Animal grasshopper = new Herbivore("grasshopper", 0, Arrays.asList(grass), 23, 20);
        Animal rabbit = new Herbivore("rabbit", 0, Arrays.asList(carrot), 21, 28);
        Animal mouse = new Herbivore("mouse", 0, Arrays.asList(carrot, corn), 23, 20);
        Animal worm = new Herbivore("worm", 0, Arrays.asList(grass, carrot, corn, tree), 25, 40);
        Animal lizard = new Herbivore("lizard", 0, Arrays.asList(grass, berries), 25, 40);
        Animal deer = new Herbivore("deer", 0, Arrays.asList(grass, berries), 15, 20);
        Animal elk = new Herbivore("elk", 0, Arrays.asList(grass, tree), 15, 20);

        Animal lynx = new Carnivore("lynx", 0, Arrays.asList(rabbit, deer), 15, 20);
        Animal fox = new Carnivore("fox", 0, Arrays.asList(rabbit, mouse), 15, 20);
        Animal wolf = new Carnivore("wolf", 0, Arrays.asList(rabbit, deer, elk), 15, 20);
        Animal bear = new Carnivore("bear", 0, Arrays.asList(deer, elk), 15, 20);
        Animal frog = new Carnivore("frog", 0, Arrays.asList(grasshopper, worm), 15, 20);
        Animal snake = new Carnivore("snake", 0, Arrays.asList(mouse, lizard, frog), 15, 20);
        Animal owl = new Carnivore("owl", 0, Arrays.asList(rabbit, mouse, lizard, snake), 15, 20);

        while (true) {


            // Создание меню
            System.out.println(" ===============Menu===============");
            System.out.println("|                                  |");
            System.out.println("| Enter menu number                |");
            System.out.println("|1. " + GREEN.getColor() + "Create new ecosystem " + NORMAL.getColor() + "          |");
            System.out.println("|2. " + YELLOW.getColor() + "Upload ecosystem " + NORMAL.getColor() + "              |");
            System.out.println("|3. " + BLUE.getColor() + "Information " + NORMAL.getColor() + "                   |");
            System.out.println("|4." + RED.getColor() + " Quit " + NORMAL.getColor() + "                          |");
            System.out.println("|                                  |");
            System.out.println(" ==================================");

            Scanner scanner = new Scanner(System.in);
            int firstChoice = scanner.nextInt();

            switch (firstChoice) {
                case 1 -> {
                    List<Plant> newP = new ArrayList<>();
                    List<Animal> newA = new ArrayList<>();
                    List<String> newR = new ArrayList<>();

                    System.out.println("Enter the ecosystem name");
                    scanner.nextLine();
                    String nameEco = scanner.nextLine();

                    // Добавление ресурсов в экосистему
                    System.out.println("Enter the resources that will be in the ecosystem");
                    int choiceRes = 0;
                    while (choiceRes != 2) {

                        System.out.println("1. Add new resource");
                        System.out.println("2. Don't add and continue");
                        choiceRes = scanner.nextInt();
                        if (choiceRes != 2) {
                            System.out.println("Please, select resource");
                            System.out.println("1. nitrogen");
                            System.out.println("2. potassium");
                            System.out.println("3. sulfur");
                            System.out.println("4. magnesium");
                            System.out.println("5. phosphorus");

                            Scanner scanResource = new Scanner(System.in);
                            int res = scanResource.nextInt();
                            switch (res) {
                                case 1 -> newR.add("nitrogen");
                                case 2 -> newR.add("potassium");
                                case 3 -> newR.add("sulfur");
                                case 4 -> newR.add("magnesium");
                                case 5 -> newR.add("phosphorus");
                            }
                        }
                    }

                    // Добавление растений в экосистему

                    // Пользователь выбирает растение и указывает популящию.
                    // У растения меняется популяция на ту, которую указал пользователь.
                    // И растение добавляется в коллекцию, которая потом попадёт в экосистему.

                    System.out.println("Enter the plant that will be in the ecosystem");
                    choiceRes = 0;
                    while (choiceRes != 2) {

                        System.out.println("1. Add new plant");
                        System.out.println("2. Don't add and continue");
                        choiceRes = scanner.nextInt();
                        if (choiceRes != 2) {

                            Scanner scanPlant = new Scanner(System.in);

                            System.out.println("Select the plant you want to add");
                            System.out.println("1. grass");
                            System.out.println("2. carrot");
                            System.out.println("3. corn");
                            System.out.println("4. tree");
                            System.out.println("5. berries");

                            int choice = scanPlant.nextInt();

                            // Выбор растений
                            switch (choice) {
                                //создание травы
                                case 1 -> addPlant(newP,grass);
                                //создание моркови
                                case 2 -> addPlant(newP,carrot);
                                //создание кукурузы
                                case 3 -> addPlant(newP,corn);
                                //создание дерева
                                case 4 -> addPlant(newP,tree);
                                //создание ягод
                                case 5 -> addPlant(newP,berries);
                                default ->
                                        System.out.println(RED.getColor() + "Please, enter correct value" + NORMAL.getColor());

                            }
                        }
                    }

                    // Добавление животных в экосистему

                    // Пользователь выбирает животное и указывает популящию.
                    // У животных меняется популяция на ту, которую указал пользователь.
                    // И животное добавляется в коллекцию, которая потом попадёт в экосистему.

                    System.out.println("Enter the animal that will be in the ecosystem");
                    choiceRes = 0;
                    while (choiceRes != 2) {

                        System.out.println("1. Add new animal");
                        System.out.println("2. Don't add and continue");
                        choiceRes = scanner.nextInt();
                        if (choiceRes != 2) {

                            System.out.println("Select the animal you want to add");

                            List<String> h = Arrays.asList("===Herbivore===", "1. grasshopper", "2. rabbit", "3. mouse", "4. worm", "5. lizard", "6. deer", "7. elk");
                            List<String> c = Arrays.asList("===Carnivore===", "8. lynx", "9. fox", "10. wolf", "11. bear", "12. frog", "13. snake", "14. owl");

                            int maxLength = Math.max(h.size(), c.size());

                            for (int i = 0; i < maxLength; i++) {
                                if (i < h.size()) {
                                    System.out.printf("%-20s", "\u001B[32m" + h.get(i));
                                } else {
                                    System.out.printf("%-20s", "");
                                }

                                if (i < c.size()) {
                                    System.out.printf("%s%n", "\u001B[31m" + c.get(i) + "\u001B[0m");
                                } else {
                                    System.out.printf("%n");
                                }
                            }

                            Scanner scanAnimal = new Scanner(System.in);
                            int choice = scanAnimal.nextInt();

                            System.out.println("Enter animal population");

                            int population = scanAnimal.nextInt();

                            // Выбор животного
                            switch (choice) {
                                // Травоядные
                                case 1 -> {
                                    grasshopper.setPopulation(population);
                                    newA.add(grasshopper);
                                    break;
                                }
                                case 2 -> {
                                    rabbit.setPopulation(population);
                                    newA.add(rabbit);
                                    break;
                                }
                                case 3 -> {
                                    mouse.setPopulation(population);
                                    newA.add(mouse);
                                    break;
                                }
                                case 4 -> {
                                    worm.setPopulation(population);
                                    newA.add(worm);
                                    break;
                                }
                                case 5 -> {
                                    lizard.setPopulation(population);
                                    newA.add(lizard);
                                    break;
                                }
                                case 6 -> {
                                    deer.setPopulation(population);
                                    newA.add(deer);
                                    break;
                                }
                                case 7 -> {
                                    elk.setPopulation(population);
                                    newA.add(elk);
                                    break;
                                }

                                // Плотоядные
                                case 8 -> {
                                    lynx.setPopulation(population);
                                    newA.add(lynx);
                                    break;
                                }
                                case 9 -> {
                                    fox.setPopulation(population);
                                    newA.add(fox);
                                    break;
                                }
                                case 10 -> {
                                    wolf.setPopulation(population);
                                    newA.add(wolf);
                                    break;
                                }
                                case 11 -> {
                                    bear.setPopulation(population);
                                    newA.add(bear);
                                    break;
                                }
                                case 12 -> {
                                    frog.setPopulation(population);
                                    newA.add(frog);
                                    break;
                                }
                                case 13 -> {
                                    snake.setPopulation(population);
                                    newA.add(snake);
                                    break;
                                }
                                case 14 -> {
                                    owl.setPopulation(population);
                                    newA.add(owl);
                                    break;
                                }
                                default ->
                                        System.out.println("\u001B[31m" + "Please, enter correct value" + "\u001B[0m");
                            }
                        }
                    }

                    // Добавление темепратуры экосистемы
                    System.out.println("Enter the ecosystem temperature");
                    Scanner scanEcoValue = new Scanner(System.in);
                    double temp = scanEcoValue.nextDouble();

                    // Добавление влажности экосистемы
                    System.out.println("Enter the ecosystem humidity");
                    double humidity = scanEcoValue.nextDouble();

                    // Добавление воды экосистемы
                    System.out.println("Enter the ecosystem water");
                    double water = scanEcoValue.nextDouble();

                    // Добавление солнечного света экосистемы
                    System.out.println("Enter the ecosystem light");
                    double light = scanEcoValue.nextDouble();

                    Ecosystem ecosystem = new Ecosystem(nameEco, newP, newA, newR, temp, humidity, water, light);
                    EcoCRUD.saveEcosystem(ecosystem);

                    ecosystem.getInfo();
                    ecosystem.startIteration();
                    ecosystem.startIteration();
                    ecosystem.getInfo();

                    break;
                }
                case 2 -> {

                    System.out.println("Choose ecosystem: ");

                    // Созданиие списка для выботра экосистемы
                    List<Ecosystem> ecosystems = EcoCRUD.loadEcosystems();
                    int i = 0;
                    for(Ecosystem ecosystem : ecosystems){
                        i += 1;
                        System.out.println(i + ". " + ecosystem.getName());
                    }

                    int choiceEco = scanner.nextInt();
                    // Проверить корректность вводимых данных
                    Ecosystem selectedEcosystem = EcoCRUD.findEcoByName(ecosystems.get(choiceEco -1).getName());
                    selectedEcosystem.getInfo();

                    // Предложить дополнить чем-то в экосистемы
                    // Предложить удалить что-то в экосистемы
                    // Предложить удалить экосистему
                    break;
                }
                case 3 -> {
                    // информация о работе с программой
                }
                case 4 -> {
                    System.exit(0);
                    break;
                }
                default -> {
                    System.out.println(RED.getColor() + "Please, enter correct value" + NORMAL.getColor());

                }
            }

        }
    }
}