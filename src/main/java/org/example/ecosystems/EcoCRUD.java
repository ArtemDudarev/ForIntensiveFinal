package org.example.ecosystems;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EcoCRUD {

    private static final Path ECO_FILE = Paths.get("ecosystems.txt");
    private static List<Ecosystem> ecosystems = new ArrayList<>();

    public static Ecosystem findEcoByName(String name){
        for(Ecosystem ecosystem : ecosystems){
            if(ecosystem.getName().equals(name)){
                return ecosystem;
            }
        }
        return null;
    }

    public static List<Ecosystem> loadEcosystems(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ECO_FILE.toFile()))) {
            ecosystems = (List<Ecosystem>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
        return ecosystems;
    }

    private static void saveEcosystemsInFile(){
        try(ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream(ECO_FILE.toFile()))){
            objectInputStream.writeObject(ecosystems);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void saveEcosystem(Ecosystem ecosystem){
        ecosystems.add(ecosystem);
        saveEcosystemsInFile();
    }

    public  static void updateEco(Ecosystem ecosystem){
        Ecosystem updatedEcosystem = findEcoByName(ecosystem.getName());
        if(updatedEcosystem != null){

            // Чтобы не дублировать экосистему с таким же именем, но с обновлёнными данными,
            // необходимо найти обновляемую экосистему по интексу и вставить в то же места новую экосистему
            int index = ecosystems.indexOf(updatedEcosystem);
            ecosystems.set(index, ecosystem);
            saveEcosystemsInFile();
        }
        else {
            System.out.println("Ecosystems with this name not found");
        }
    }

    public static void deleteEco(Ecosystem ecosystem){
        Ecosystem deletedEcosystem = findEcoByName(ecosystem.getName());
        if(deletedEcosystem != null){
            ecosystems.remove(deletedEcosystem);
            saveEcosystemsInFile();
            System.out.println("Ecosystem is deleted");
        }
        else {
            System.out.println("Ecosystems with this name not found");
        }
    }
}
