package com.alevel.hometask.collections;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one animal: Cat, Dog, Hamster ? ");
        String k = null;
        while (k == null) {
            k = scanner.nextLine().trim().toLowerCase();
            switch (k) {
                case "cat":
                    House<Cat> catHouse = new House<Cat>();
                    addCat(catHouse.getDwellers());
                    catHouse.getDwellers().print();
                    break;
                case "dog":
                    House<Dog> dogHouse = new House<Dog>();
                    addDog(dogHouse.getDwellers());
                    dogHouse.getDwellers().print();
                    break;
                case "hamster":
                    House<Hamster> hamsterHouse = new House<Hamster>();
                    addHamster(hamsterHouse.getDwellers());
                    hamsterHouse.getDwellers().print();
                    break;
            }
        }
    }

    private static void addCat(PetList<Cat> cats) {
        cats.add(new Cat(3, "Katya", "red"));
        cats.add(new Cat(7, "Lisa", "blue"));
    }

    private static void addDog(PetList<Dog> dogs) {
        dogs.add(new Dog(6, "Bony", "orange"));
        dogs.add(new Dog(5, "Sheldon", "black"));
    }

    private static void addHamster(PetList<Hamster> hamsters) {
        hamsters.add(new Hamster(2, "Snoop", "white"));
        hamsters.add(new Hamster(3, "Scooby", "white"));
    }

}

