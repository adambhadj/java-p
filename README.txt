PROSIT JAVA 1 À 6 — VERSION CONSOLIDÉE

Structure:
src/
  entities/
    Animal.java
    Zoo.java
    Aquatic.java
    Terrestrial.java
    Dolphin.java
    Penguin.java
  main/
    ZooManagement.java

Packages: entities et main.
Point d'entrée: main.ZooManagement.

Prosit 1: Scanner, saisie et validation du nom du zoo.
Prosit 2: classes Animal et Zoo, constructeurs et toString().
Prosit 3: ajout, affichage, recherche, suppression, capacité et comparaison.
Prosit 4: encapsulation, validation et packages.
Prosit 5: héritage Aquatic/Terrestrial, Dolphin/Penguin, polymorphisme et swim().
Prosit 6:
- tableau Aquatic[] de capacité 10 et méthode addAquaticAnimal()
- appel polymorphique de swim() pour les animaux aquatiques
- Aquatic est abstract et swim() est abstract : les classes filles doivent redéfinir swim()
- profondeur maximale des pingouins
- comptage des dauphins et pingouins
- equals() dans Aquatic : même name, age et habitat

Note: le tableau général du zoo peut contenir 25 animaux. Le tableau des animaux aquatiques
est séparé et peut contenir jusqu'à 10 animaux, conformément au Prosit 6.
