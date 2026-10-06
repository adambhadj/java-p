package entities;
public class Zoo {

    private static final int MAX_CAGES = 25;

    private entities.Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int nbrAnimals;

    public Zoo(String name, String city) {
        this.animals = new entities.Animal[MAX_CAGES];
        setName(name);
        this.city = city;
        this.nbrCages = MAX_CAGES;
        this.nbrAnimals = 0;
    }

    public entities.Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
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

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public boolean addAnimal(entities.Animal animal) {
        if (isZooFull()) {
            return false;
        }

        if (animal == null) {
            return false;
        }

        if (searchAnimal(animal.getName()) != -1) {
            return false;
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;

        return true;
    }

    public void displayAnimals() {
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(String name) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public boolean removeAnimal(entities.Animal animal) {
        if (animal == null) {
            return false;
        }

        int index = searchAnimal(animal.getName());

        if (index == -1) {
            return false;
        }

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }

        animals[nbrAnimals - 1] = null;
        nbrAnimals--;

        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }

        return z2;
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d'animaux : " + nbrAnimals);
    }

    @Override
    public String toString() {
        return "Nom du zoo : " + name +
                ", Ville : " + city +
                ", Nombre de cages : " + nbrCages +
                ", Nombre d'animaux : " + nbrAnimals;
    }
}