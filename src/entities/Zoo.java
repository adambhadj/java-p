package entities;

public class Zoo {
    public static final int MAX_CAGES = 25;
    public static final int MAX_AQUATIC_ANIMALS = 10;

    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount;
    private int aquaticCount;

    public Zoo() {
        this("My Zoo", "Tunis");
    }

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.nbrCages = MAX_CAGES;
        this.animals = new Animal[MAX_CAGES];
        this.aquaticAnimals = new Aquatic[MAX_AQUATIC_ANIMALS];
        this.animalCount = 0;
        this.aquaticCount = 0;
    }

    public Animal[] getAnimals() {
        return animals.clone();
    }

    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide.");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getAquaticCount() {
        return aquaticCount;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre maximal de cages : " + nbrCages);
        System.out.println("Nombre d'animaux : " + animalCount);
        System.out.println("Nombre d'animaux aquatiques : " + aquaticCount);
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null || isZooFull()) {
            return false;
        }

        if (searchAnimal(animal.getName()) != -1) {
            return false;
        }

        animals[animalCount++] = animal;
        return true;
    }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Le zoo ne contient aucun animal.");
            return;
        }

        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(String animalName) {
        if (animalName == null) return -1;

        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(animalName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        if (animal == null) return false;

        int index = searchAnimal(animal.getName());
        if (index == -1) return false;

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[--animalCount] = null;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo compareZoo(Zoo zoo1, Zoo zoo2) {
        if (zoo1 == null) return zoo2;
        if (zoo2 == null) return zoo1;
        return zoo1.animalCount >= zoo2.animalCount ? zoo1 : zoo2;
    }

    // Prosit 6 — Instruction 25
    public boolean addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null || aquaticCount >= MAX_AQUATIC_ANIMALS) {
            return false;
        }
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i].equals(aquatic)) {
                return false;
            }
        }
        aquaticAnimals[aquaticCount++] = aquatic;
        return true;
    }

    // Prosit 6 — Instruction 26
    public void displaySwimForAquaticAnimals() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // Prosit 6 — Instruction 27
    public float getMaxPenguinSwimmingDepth() {
        float maxDepth = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    // Prosit 6 — Instruction 28
    public void displayAquaticAnimalCounts() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) dolphinCount++;
            if (aquaticAnimals[i] instanceof Penguin) penguinCount++;
        }

        System.out.println("Nombre de dauphins : " + dolphinCount);
        System.out.println("Nombre de pingouins : " + penguinCount);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\\'' +
                ", city='" + city + '\\'' +
                ", nbrCages=" + nbrCages +
                ", animalCount=" + animalCount +
                ", aquaticCount=" + aquaticCount +
                '}';
    }
}
