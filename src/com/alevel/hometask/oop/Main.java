package com.alevel.hometask.oop;

public class Main {

    public static void main(String[] args) {
        Student[] students = {
                new Student("anton", 19),
                new Student("toxa", 20),
                new ContractStudent("Monkey", 66, 6595)
        };
        Group ob1 = new Group(students);
        ob1.printContractorData();
    }
}




