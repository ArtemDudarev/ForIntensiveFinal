package org.example;

import org.example.ecosystems.EcoCRUD;
import org.example.ecosystems.Ecosystem;
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

    // Создание всех растений и животных
    private static Plant grass = new Plant("grass", 0, Arrays.asList("nitrogen"), 10, 30, 20, 60);
    private static Plant carrot = new Plant("carrot", 0, Arrays.asList("nitrogen", "potassium"), 20, 30, 15, 40);
    private static Plant corn = new Plant("corn", 0, Arrays.asList("nitrogen", "sulfur"), 22, 30, 15, 55);
    private static Plant tree = new Plant("tree", 0, Arrays.asList("magnesium"), 15, 30, 20, 43);
    private static Plant berries = new Plant("berries", 0, Arrays.asList("nitrogen"), 16, 30, 20, 30);

    private static Animal grasshopper = new Herbivore("grasshopper", 0, Arrays.asList(grass), 23, 20);
    private static Animal rabbit = new Herbivore("rabbit", 0, Arrays.asList(carrot), 21, 28);
    private static Animal mouse = new Herbivore("mouse", 0, Arrays.asList(carrot, corn), 23, 20);
    private static Animal worm = new Herbivore("worm", 0, Arrays.asList(grass, carrot, corn, tree), 25, 40);
    private static Animal lizard = new Herbivore("lizard", 0, Arrays.asList(grass, berries), 25, 40);
    private static Animal deer = new Herbivore("deer", 0, Arrays.asList(grass, berries), 15, 20);
    private static Animal elk = new Herbivore("elk", 0, Arrays.asList(grass, tree), 15, 20);

    private static Animal lynx = new Carnivore("lynx", 0, Arrays.asList(rabbit, deer), 15, 20);
    private static Animal fox = new Carnivore("fox", 0, Arrays.asList(rabbit, mouse), 15, 20);
    private static Animal wolf = new Carnivore("wolf", 0, Arrays.asList(rabbit, deer, elk), 15, 20);
    private static Animal bear = new Carnivore("bear", 0, Arrays.asList(deer, elk), 15, 20);
    private static Animal frog = new Carnivore("frog", 0, Arrays.asList(grasshopper, worm), 15, 20);
    private static Animal snake = new Carnivore("snake", 0, Arrays.asList(mouse, lizard, frog), 15, 20);
    private static Animal owl = new Carnivore("owl", 0, Arrays.asList(rabbit, mouse, lizard, snake), 15, 20);

    private static void printMainMenu(){
        System.out.println(" ===============Menu===============");
        System.out.println("|                                  |");
        System.out.println("| Enter menu number                |");
        System.out.println("|1. " + GREEN.getColor() + "Create new ecosystem " + NORMAL.getColor() + "          |");
        System.out.println("|2. " + YELLOW.getColor() + "Upload ecosystem " + NORMAL.getColor() + "              |");
        System.out.println("|3. " + BLUE.getColor() + "Information " + NORMAL.getColor() + "                   |");
        System.out.println("|4." + RED.getColor() + " Quit " + NORMAL.getColor() + "                          |");
        System.out.println("|                                  |");
        System.out.println(" ==================================");
    }

    private static List<String> addResources(Scanner scanner) {
        List<String> resources = new ArrayList<>();
        System.out.println("Enter the resources that will be in the ecosystem");
        int choiceRes = 0;
        while (choiceRes != 2) {
            System.out.println("1. Add new resource");
            System.out.println("2. Don't add and continue");
            choiceRes = scanner.nextInt();
            if (choiceRes != 2) {
                resources.addAll(selectResources(scanner));
            }
        }
        return resources;
    }

    private static List<String> selectResources(Scanner scanner) {
        List<String> selectedResources = new ArrayList<>();
        System.out.println("Please, select resource");
        System.out.println("1. nitrogen");
        System.out.println("2. potassium");
        System.out.println("3. sulfur");
        System.out.println("4. magnesium");
        System.out.println("5. phosphorus");

        int res = scanner.nextInt();
        switch (res) {
            case 1 -> selectedResources.add("nitrogen");
            case 2 -> selectedResources.add("potassium");
            case 3 -> selectedResources.add("sulfur");
            case 4 -> selectedResources.add("magnesium");
            case 5 -> selectedResources.add("phosphorus");
            default -> System.out.println("Invalid choice. Please try again.");
        }
        return selectedResources;
    }

    private static List<Plant> addPlants(Scanner scanner) {
        List<Plant> plants = new ArrayList<>();
        System.out.println("Enter the plants that will be in the ecosystem");
        int choiceRes = 0;
        while (choiceRes != 2) {
            System.out.println("1. Add new plant");
            System.out.println("2. Don't add and continue");
            choiceRes = scanner.nextInt();
            if (choiceRes != 2) {
                plants.addAll(selectPlants(scanner));
            }
        }
        return plants;
    }

    private static List<Plant> selectPlants(Scanner scanner) {
        List<Plant> selectedPlants = new ArrayList<>();
        System.out.println("Select the plant you want to add");
        System.out.println("1. grass");
        System.out.println("2. carrot");
        System.out.println("3. corn");
        System.out.println("4. tree");
        System.out.println("5. berries");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter plant population");
                grass.setPopulation(scanner.nextInt());
                selectedPlants.add(grass);
                break;
            case 2:
                System.out.println("Enter plant population");
                carrot.setPopulation(scanner.nextInt());
                selectedPlants.add(carrot);
                break;
            case 3:
                System.out.println("Enter plant population");
                corn.setPopulation(scanner.nextInt());
                selectedPlants.add(corn);
                break;
            case 4:
                System.out.println("Enter plant population");
                tree.setPopulation(scanner.nextInt());
                selectedPlants.add(tree);
                break;
            case 5:
                System.out.println("Enter plant population");
                berries.setPopulation(scanner.nextInt());
                selectedPlants.add(berries);
                break;
            default:
                System.out.println("Please, enter correct value");
        }
        return selectedPlants;
    }

    // Метод для добавления животных
    private static List<Animal> addAnimals(Scanner scanner) {
        List<Animal> animals = new ArrayList<>();
        System.out.println("Enter the animals that will be in the ecosystem");
        int choiceRes = 0;
        while (choiceRes != 2) {
            System.out.println("1. Add new animal");
            System.out.println("2. Don't add and continue");
            choiceRes = scanner.nextInt();
            if (choiceRes != 2) {
                animals.addAll(selectAnimals(scanner));
            }
        }
        return animals;
    }

    // Метод для выбора животных
    private static List<Animal> selectAnimals(Scanner scanner) {
        List<Animal> selectedAnimals = new ArrayList<>();
        System.out.println("Select the animal you want to add");

        // Вывод списка животных с цветами для травоядных и плотоядных
        List<String> herbivores = Arrays.asList("===Herbivore===", "1. grasshopper", "2. rabbit", "3. mouse", "4. worm", "5. lizard", "6. deer", "7. elk");
        List<String> carnivores = Arrays.asList("===Carnivore===", "8. lynx", "9. fox", "10. wolf", "11. bear", "12. frog", "13. snake", "14. owl");
        int maxLength = Math.max(herbivores.size(), carnivores.size());
        for (int i = 0; i < maxLength; i++) {
            if (i < herbivores.size()) {
                System.out.printf("%-20s", GREEN.getColor() + herbivores.get(i));
            } else {
                System.out.printf("%-20s", "");
            }
            if (i < carnivores.size()) {
                System.out.printf("%s%n", RED.getColor() + carnivores.get(i) + NORMAL.getColor());
            } else {
                System.out.printf("%n");
            }
        }
        // Ввод выбора животного и популяции
        int choice = scanner.nextInt();
        System.out.println("Enter animal population");
        int population = scanner.nextInt();

        // Создание объекта животного и добавление его в список
        switch (choice) {
            // Травоядные
            case 1 -> {
                grasshopper.setPopulation(population);
                selectedAnimals.add(grasshopper);
            }
            case 2 -> {
                rabbit.setPopulation(population);
                selectedAnimals.add(rabbit);
            }
            case 3 -> {
                mouse.setPopulation(population);
                selectedAnimals.add(mouse);
            }
            case 4 -> {
                worm.setPopulation(population);
                selectedAnimals.add(worm);
            }
            case 5 -> {
                lizard.setPopulation(population);
                selectedAnimals.add(lizard);
            }

            case 6 -> {
                deer.setPopulation(population);
                selectedAnimals.add(deer);
            }
            case 7 -> {
                elk.setPopulation(population);
                selectedAnimals.add(elk);
            }
            // Плотоядные
            case 8 -> {
                lynx.setPopulation(population);
                selectedAnimals.add(lynx);
            }
            case 9 -> {
                fox.setPopulation(population);
                selectedAnimals.add(fox);
            }
            case 10 -> {
                wolf.setPopulation(population);
                selectedAnimals.add(wolf);
            }
            case 11 -> {
                bear.setPopulation(population);
                selectedAnimals.add(bear);
            }
            case 12 -> {
                frog.setPopulation(population);
                selectedAnimals.add(frog);
            }
            case 13 -> {
                snake.setPopulation(population);
                selectedAnimals.add(snake);
            }

            case 14 -> {
                owl.setPopulation(population);
                selectedAnimals.add(owl);
            }
            default -> System.out.println("Please, enter correct value");
        }
        return selectedAnimals;
    }

    // Выводит список экосистем и возвращает выбранную
    private static Ecosystem showEcosystem(Scanner scanner) {

        System.out.println("Choose ecosystem: ");

        // Создание списка для выбора экосистемы
        List<Ecosystem> ecosystems = EcoCRUD.loadEcosystems();
        int i = 0;
        for (Ecosystem ecosystem : ecosystems) {
            i += 1;
            System.out.println(i + ". " + ecosystem.getName());
        }

        // Выведение последнего пункта в меню, который сможет вернуть в главное меню
        i += 1;
        System.out.println(i + ". Back to main menu");

        int choiceEco = scanner.nextInt();
        scanner.nextLine();

        if (choiceEco <= ecosystems.size() && choiceEco > 0) {
            Ecosystem selectedEcosystem = ecosystems.get(choiceEco - 1);
            selectedEcosystem.getInfo();

            selectChanges(selectedEcosystem, scanner);

            return selectedEcosystem;
        } else if (choiceEco == i) {
            // Вернуться к главному меню
            return null;
        } else {
            System.out.println("Invalid ecosystem choice. Please try again.");
            return null;
        }
    }

    private static void addResourcesPlantsAnimals(Ecosystem selectedEcosystem,Scanner scanner){
        int choiceSubMenu = 0;
        while (choiceSubMenu != 4) {
            System.out.println("What do you want to add to ecosystem " + selectedEcosystem.getName() + "?");
            System.out.println("1. Add resources");
            System.out.println("2. Add plants");
            System.out.println("3. Add animals");
            System.out.println("4. Back");
            choiceSubMenu = scanner.nextInt();
            scanner.nextLine();

            switch (choiceSubMenu) {
                case 1 -> {
                    selectedEcosystem.getResources().addAll(addResources(scanner));
                    EcoCRUD.updateEco(selectedEcosystem);
                }

                case 2 -> {
                    selectedEcosystem.getPlants().addAll(addPlants(scanner));
                    EcoCRUD.updateEco(selectedEcosystem);
                }
                case 3 -> {
                    selectedEcosystem.getAnimals().addAll(addAnimals(scanner));
                    EcoCRUD.updateEco(selectedEcosystem);
                }
                case 4 -> selectChanges(selectedEcosystem,scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void deleteResourcesPlantsAnimals(Ecosystem selectedEcosystem, Scanner scanner) {
        int choiceSubMenu = 0;
        while (choiceSubMenu != 4) {
            System.out.println("What do you want to delete from ecosystem " + selectedEcosystem.getName() + "?");
            System.out.println("1. Delete resources");
            System.out.println("2. Delete plants");
            System.out.println("3. Delete animals");
            System.out.println("4. Back");
            choiceSubMenu = scanner.nextInt();
            scanner.nextLine();

            switch (choiceSubMenu) {
                case 1 -> {
                    deleteResources(selectedEcosystem, scanner);
                    EcoCRUD.updateEco(selectedEcosystem);
                }
                case 2 -> {
                    deletePlants(selectedEcosystem, scanner);
                    EcoCRUD.updateEco(selectedEcosystem);
                }
                case 3 -> {
                    deleteAnimals(selectedEcosystem, scanner);
                    EcoCRUD.updateEco(selectedEcosystem);
                }
                case 4 -> selectChanges(selectedEcosystem,scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Метод для удаления ресурсов
    private static void deleteResources(Ecosystem ecosystem, Scanner scanner) {
        List<String> resources = ecosystem.getResources();
        if (resources.isEmpty()) {
            System.out.println("Ecosystem has not resources");
            return;
        }

        System.out.println("Current resources: " + resources);

        // Вывод списка ресурсов для выбора
        System.out.println("Select resource to delete:");
        int i = 0;
        for (String resource : resources) {
            i += 1;
            System.out.println(i + ". " + resource);
        }

        // Выбор ресурса
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice <= resources.size() && choice > 0) {
            String resourceToDelete = resources.get(choice - 1);
            ecosystem.getResources().remove(resourceToDelete);
            System.out.println("Resource " + resourceToDelete + " deleted successfully.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Метод для удаления растений
    private static void deletePlants(Ecosystem ecosystem, Scanner scanner) {
        List<Plant> plants = ecosystem.getPlants();
        if (plants.isEmpty()) {
            System.out.println("There are no plants in this ecosystem.");
            return;
        }

        // Вывод списка растений
        System.out.println("Current plants: ");
        int i = 0;
        for (Plant plant : plants) {
            i += 1;
            System.out.println(i + ". " + plant.getName() + " | population: " + plant.getPopulation());
        }

        // Вывод списка растений для выбора
        System.out.println("Select plant to delete:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice <= plants.size() && choice > 0) {
            Plant plantToDelete = plants.get(choice - 1);
            ecosystem.getPlants().remove(plantToDelete);
            System.out.println("Plant " + plantToDelete.getName() + " deleted successfully.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Метод для удаления животных
    private static void deleteAnimals(Ecosystem ecosystem, Scanner scanner) {
        List<Animal> animals = ecosystem.getAnimals();
        if (animals.isEmpty()) {
            System.out.println("There are no animals in this ecosystem.");
            return;
        }

        // Вывод списка животных
        System.out.println("Current animals: ");
        int i = 0;
        for (Animal animal : animals) {
            i += 1;
            System.out.println(i + ". " + animal.getName());
        }

        // Выбор животного
        System.out.println("Select animal to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (choice <= animals.size() && choice > 0) {
            Animal animalToDelete = animals.get(choice - 1);
            ecosystem.getAnimals().remove(animalToDelete);
            System.out.println("Animal " + animalToDelete.getName() + " deleted successfully.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Удаление экосистемы
    private static void deleteSelectedEcosystem(Ecosystem ecosystem, Scanner scanner){
        EcoCRUD.deleteEco(ecosystem);
        System.out.println(RED.getColor() + "Ecosystem " + ecosystem.getName() + " is deleted" + NORMAL.getColor());
        showEcosystem(scanner);
    }

    private static void specifyQuantityIteration(Ecosystem selectedEcosystem, Scanner scanner){
            System.out.println("Enter the desired number of iterations: ");
            int iterations = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            for (int i = 0; i < iterations; i++) {
                System.out.println("\nIteration " + (i + 1) + ":");
                selectedEcosystem.startIteration();
                EcoCRUD.updateEco(selectedEcosystem);
            }
    }
    private static void selectChanges(Ecosystem selectedEcosystem, Scanner scanner) {

        // Подменю для выбранной экосистемы
        int choiceSubMenu = 0;
        while (choiceSubMenu != 5) {
            System.out.println("Choose action for ecosystem " + selectedEcosystem.getName() + ":");
            System.out.println("1. Start iterations");
            System.out.println("2. Add resources, plants or animals");
            System.out.println("3. Delete resources, plants or animals");
            System.out.println("4. Delete the ecosystem");
            System.out.println("5. Back");
            choiceSubMenu = scanner.nextInt();
            scanner.nextLine();

            switch (choiceSubMenu) {
                case 1 -> specifyQuantityIteration(selectedEcosystem, scanner);
                case 2 -> addResourcesPlantsAnimals(selectedEcosystem, scanner);
                case 3 -> deleteResourcesPlantsAnimals(selectedEcosystem, scanner);
                case 4 -> deleteSelectedEcosystem(selectedEcosystem, scanner);
                case 5 -> showEcosystem(scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {

            // Создание меню
            printMainMenu();

            Scanner scanner = new Scanner(System.in);
            int firstChoice = scanner.nextInt();

            switch (firstChoice) {
                case 1 -> {

                    // После того, как пользователь вводит имя экосистемы, создаётся пустая экосистема,
                    // а к этой экосистеме применяются методв add
                    List<Plant> newP = new ArrayList<>();
                    List<Animal> newA = new ArrayList<>();
                    List<String> newR = new ArrayList<>();

                    System.out.println("Enter the ecosystem name");
                    scanner.nextLine();
                    String nameEco = scanner.nextLine();

                    // Добавление ресурсов в экосистему
                    newR.addAll(addResources(scanner));

                    // Добавление растений в экосистему

                    // Пользователь выбирает растение и указывает популящию.
                    // У растения меняется популяция на ту, которую указал пользователь.
                    // И растение добавляется в коллекцию, которая потом попадёт в экосистему.
                    newP.addAll(addPlants(scanner));

                    // Добавление животных в экосистему

                    // Пользователь выбирает животное и указывает популящию.
                    // У животных меняется популяция на ту, которую указал пользователь.
                    // И животное добавляется в коллекцию, которая потом попадёт в экосистему.

                    newA.addAll(addAnimals(scanner));


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
                    break;
                }
                case 2 -> {
                    Ecosystem selectedEcosystem = showEcosystem(scanner);

                    if (selectedEcosystem != null) {
                        selectChanges(selectedEcosystem,scanner);
                    }
                    // рботает немного не корректно
//                    if (selectedEcosystem != null) {
//                        selectChanges(showEcosystem(scanner),scanner);
//                    }
                    //selectChanges(showEcosystem(scanner),scanner);
                    // 1. Предложить дополнить выбранную экосистему ресурсами, растениями или животными
                    // 2. Предложить удалить ресурсы, растения или животных из выбранной экосистемы
                    // 3. Предложить удалить выбранную экосистему экосистему
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