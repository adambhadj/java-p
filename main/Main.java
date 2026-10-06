package main;

import entities.Animal;
import entities.Zoo;

public class Main {

    public static void main(String[] args) {

        Zoo zoo1 = new Zoo("Zoo de Tunis", "Tunis");
        Zoo zoo2 = new Zoo("Zoo de Sousse", "Sousse");

        Animal lion = new Animal("Félidé", "Simba", 5, true);
        Animal tiger = new Animal("Félidé", "Tigrou", 4, true);
        Animal elephant = new Animal("Éléphantidé", "Dumbo", 10, true);
        Animal snake = new Animal("Reptile", "Kaa", 3, false);
        Animal monkey = new Animal("Primate", "George", 6, true);

        System.out.println(zoo1.addAnimal(lion));
        System.out.println(zoo1.addAnimal(tiger));
        System.out.println(zoo1.addAnimal(elephant));

        System.out.println(zoo2.addAnimal(snake));
        System.out.println(zoo2.addAnimal(monkey));

        System.out.println("----- Zoo 1 -----");
        zoo1.displayZoo();

        System.out.println("----- Animaux Zoo 1 -----");
        zoo1.displayAnimals();

        System.out.println("----- Recherche -----");
        System.out.println(zoo1.searchAnimal("Simba"));
        System.out.println(zoo1.searchAnimal("Kaa"));

        Animal lion2 = new Animal("Félidé", "Simba", 5, true);

        System.out.println("----- Ajout d'un animal identique -----");
        System.out.println(zoo1.addAnimal(lion2));

        System.out.println("----- Suppression -----");
        System.out.println(zoo1.removeAnimal(tiger));

        System.out.println("----- Animaux après suppression -----");
        zoo1.displayAnimals();

        System.out.println("----- Zoo plein ? -----");
        System.out.println(zoo1.isZooFull());

        System.out.println("----- Comparaison des zoos -----");
        Zoo zooMax = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println(zooMax);

        System.out.println("----- Test âge négatif -----");
        Animal testAnimal = new Animal("Test", "Test", -5, true);
        System.out.println(testAnimal);

        System.out.println("----- Test nom Zoo vide -----");
        Zoo testZoo = new Zoo("", "Tunis");
        System.out.println(testZoo);
    }
}