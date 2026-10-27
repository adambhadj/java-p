package main;

import entities.Animal;
import entities.Dolphin;
import entities.Penguin;
import entities.Terrestrial;
import entities.Zoo;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String zooName;
        do {
            System.out.print("Entrez le nom du zoo : ");
            zooName = scanner.nextLine().trim();
            if (zooName.isEmpty()) {
                System.out.println("Le nom ne doit pas être vide.");
            }
        } while (zooName.isEmpty());

        Zoo zoo = new Zoo(zooName, "Tunis");

        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Tigrou", 4, true);
        zoo.addAnimal(lion);
        zoo.addAnimal(tiger);

        System.out.println("\\n--- Informations du zoo ---");
        zoo.displayZoo();
        System.out.println("\\n--- Animaux terrestres/généraux ---");
        zoo.displayAnimals();
        System.out.println("Indice de Simba : " + zoo.searchAnimal("Simba"));
        System.out.println("Suppression de Tigrou : " + zoo.removeAnimal(tiger));

        Dolphin dolphin1 = new Dolphin("Delphinidae", "Dolly", 7, true, "Ocean", 30.5f);
        Dolphin dolphin2 = new Dolphin("Delphinidae", "Flipper", 5, true, "Mer", 25.0f);
        Penguin penguin1 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 20.0f);
        Penguin penguin2 = new Penguin("Spheniscidae", "Tux", 4, false, "Antarctica", 35.0f);

        zoo.addAquaticAnimal(dolphin1);
        zoo.addAquaticAnimal(dolphin2);
        zoo.addAquaticAnimal(penguin1);
        zoo.addAquaticAnimal(penguin2);

        System.out.println("\\n--- Prosit 5 : héritage et polymorphisme ---");
        System.out.println(dolphin1);
        System.out.println(penguin1);

        System.out.println("\\n--- Prosit 6 : Instruction 26 — swim() ---");
        zoo.displaySwimForAquaticAnimals();

        System.out.println("\\n--- Prosit 6 : Instruction 27 — profondeur maximale ---");
        System.out.println("Profondeur maximale des pingouins : "
                + zoo.getMaxPenguinSwimmingDepth());

        System.out.println("\\n--- Prosit 6 : Instruction 28 — nombre par type ---");
        zoo.displayAquaticAnimalCounts();

        System.out.println("\\n--- Prosit 6 : Instruction 31 — equals() ---");
        Penguin samePenguin = new Penguin("OtherFamily", "Pingu", 3, false, "Antarctica", 99.0f);
        System.out.println("Pingu est égal à samePenguin ? " + penguin1.equals(samePenguin));

        Zoo anotherZoo = new Zoo("Safari", "Sousse");
        anotherZoo.addAnimal(new Animal("Canidae", "Rex", 4, true));
        Zoo largest = Zoo.compareZoo(zoo, anotherZoo);
        System.out.println("\\nLe zoo qui contient le plus d'animaux : " + largest.getName());

        scanner.close();
    }
}
